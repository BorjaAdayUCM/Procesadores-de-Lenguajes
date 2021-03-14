import java.io.Reader;
import java.io.IOException;

public class AnalizadorLexicoTiny {

	private Reader input;
	private StringBuffer lex;
	private int sigCar;
	private int filaInicio;
	private int columnaInicio;
	private int filaActual;
	private int columnaActual;
	private static String NL = System.getProperty("line.separator");

	private static enum Estado {
		INICIO, REC_PARA, REC_PARC, REC_EOF, REC_IDIS, REC_DIS, REC_IGUAL, REC_IGUALDAD, REC_ISEP, REC_SEP,
		REC_PyC, REC_DIV, REC_POR, REC_MENOR, REC_MENORIGUAL, REC_MAYOR, REC_MAYORIGUAL, REC_VARIABLE,
		REC_MAS, REC_MENOS, REC_ENT, REC_0, REC_IDEC, REC_IDEC10, REC_IDEC20, REC_DEC, REC_IEXPL, REC_IEXPS, REC_EXP0, REC_EXP
	}

	private Estado estado;

	public AnalizadorLexicoTiny(Reader input) throws IOException {
		this.input = input;
		lex = new StringBuffer();
		sigCar = input.read();
		filaActual=1;
		columnaActual=1;
	}

	public UnidadLexica sigToken() throws IOException {
		estado = Estado.INICIO;
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		lex.delete(0,lex.length());
		while(true) {
			switch(estado) {
			case INICIO: 
				if(hayLetra())  transita(Estado.REC_VARIABLE);
				else if (hayMas()) transita(Estado.REC_MAS);
				else if (hayMenos()) transita(Estado.REC_MENOS);
				else if (hayPor()) transita(Estado.REC_POR);
				else if (hayDiv()) transita(Estado.REC_DIV);
				else if (hayCero()) transita(Estado.REC_0);
				else if (hayPAp()) transita(Estado.REC_PARA);
				else if (hayPCierre()) transita(Estado.REC_PARC);
				else if (hayPyC()) transita(Estado.REC_PyC);
				else if (hayMenor()) transita(Estado.REC_MENOR);
				else if (hayMayor()) transita(Estado.REC_MAYOR);
				else if (hayAndpersand()) transita(Estado.REC_ISEP);
				else if (hayIgual()) transita(Estado.REC_IGUAL);
				else if (hayExc()) transita(Estado.REC_IDIS);
				else if (hayEOF()) transita(Estado.REC_EOF);
				else if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if (haySep()) transitaIgnorando(Estado.INICIO);
				else error();
				break;
			case REC_VARIABLE: 
				if (hayLetra() || hayDigito() || hay_()) transita(Estado.REC_VARIABLE);
				else return unidadVariable();            
				break;
			case REC_ENT:
				if (hayDigito()) transita(Estado.REC_ENT);
				else if (hayPunto()) transita(Estado.REC_IDEC);
				else if (hayExp()) transita(Estado.REC_IEXPL);
				else return unidadEnt();
				break;
			case REC_0:
				if (hayPunto()) transita(Estado.REC_IDEC);
				else return unidadEnt();
				break;
			case REC_MAS:
				if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if(hayCero()) transita(Estado.REC_0);
				else return unidadMas();
				break;
			case REC_MENOS: 
				if (hayDigitoPos()) transita(Estado.REC_ENT);
				else if(hayCero()) transita(Estado.REC_0);
				else return unidadMenos();
				break;
			case REC_MENOR: 
				if (hayIgual()) transita(Estado.REC_MENORIGUAL);
				else return unidadMenor();
				break;
			case REC_MAYOR: 
				if (hayIgual()) transita(Estado.REC_MAYORIGUAL);
				else return unidadMayor();
				break;
			case REC_MENORIGUAL: return unidadMenorIgual();
			case REC_MAYORIGUAL: return unidadMayorIgual();
			case REC_ISEP:
				if(hayAndpersand()) transita(Estado.REC_SEP);
				else error();
				break;
			case REC_SEP: return unidadSeparador();
			case REC_IDIS:
				if(hayIgual()) transita(Estado.REC_DIS);
				else error();
				break;
			case REC_DIS: return unidadDistinto();
			case REC_POR: return unidadPor();
			case REC_DIV: return unidadDiv();              
			case REC_PARA: return unidadPAp();
			case REC_PARC: return unidadPCierre();
			case REC_IGUAL: 
				if(hayIgual()) transita(Estado.REC_IGUALDAD);
				else return unidadIgual();
				break;
			case REC_IGUALDAD: return unidadIgualdad();
			case REC_PyC: return unidadPyC();
			case REC_EOF: return unidadEof();
			case REC_IDEC:
				if (hayDigitoPos()) transita(Estado.REC_DEC);
				else if (hayCero()) transita(Estado.REC_IDEC10);
				else error();
				break;
			case REC_IDEC10:
				if (hayDigitoPos()) transita(Estado.REC_DEC);
				else if (hayCero()) transita(Estado.REC_IDEC20);
				else if (hayExp()) transita(Estado.REC_IEXPL);
				else return unidadReal();
				break;
			case REC_IDEC20:
				if (hayDigitoPos()) transita(Estado.REC_DEC);
				else if(hayCero()) transita(Estado.REC_IDEC20);
				else error();
				break;
			case REC_DEC: 
				if (hayDigitoPos()) transita(Estado.REC_DEC);
				else if (hayCero()) transita(Estado.REC_IDEC20);
				else if (hayExp()) transita(Estado.REC_IEXPL);
				else return unidadReal();
				break;
			case REC_IEXPL:
				if(hayMas() || hayMenos()) transita(Estado.REC_IEXPS);
				else if(hayDigitoPos()) transita(Estado.REC_EXP);
				else if(hayCero()) transita(Estado.REC_EXP0);
				else error();
				break;
			case REC_IEXPS:
				if(hayCero()) transita(Estado.REC_EXP0);
				else if (hayDigitoPos()) transita(Estado.REC_EXP);
				else error();
				break;
			case REC_EXP0: return unidadReal();
			case REC_EXP:
				if(hayDigito()) transita(Estado.REC_EXP);
				else return unidadReal();
				break;
			}
		}    
	}
	private void transita(Estado sig) throws IOException {
		lex.append((char)sigCar);
		sigCar();         
		estado = sig;
	}
	private void transitaIgnorando(Estado sig) throws IOException {
		sigCar();         
		filaInicio = filaActual;
		columnaInicio = columnaActual;
		estado = sig;
	}
	private void sigCar() throws IOException {
		sigCar = input.read();
		if (sigCar == NL.charAt(0)) saltaFinDeLinea();
		if (sigCar == '\n') {
			filaActual++;
			columnaActual=0;
		}
		else {
			columnaActual++;  
		}
	}
	private void saltaFinDeLinea() throws IOException {
		for (int i=1; i < NL.length(); i++) {
			sigCar = input.read();
			if (sigCar != NL.charAt(i)) error();
		}
		sigCar = '\n';
	}

	private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' || sigCar >= 'A' && sigCar <= 'z';}
	private boolean hay_() {return sigCar == '_';}
	private boolean hayDigito() {return hayDigitoPos() || hayCero();}
	private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
	private boolean hayCero() {return sigCar == '0';}
	private boolean hayPAp() {return sigCar == '(';}
	private boolean hayPCierre() {return sigCar == ')';}
	private boolean hayMas() {return sigCar == '+';}
	private boolean hayMenos() {return sigCar == '-';}
	private boolean hayPor() {return sigCar == '*';}
	private boolean hayDiv() {return sigCar == '/';}
	private boolean hayIgual() {return sigCar == '=';}
	private boolean hayExc() {return sigCar == '!';}
	private boolean hayAndpersand() {return sigCar == '&';}
	private boolean hayPunto() {return sigCar == '.';}
	private boolean hayEOF() {return sigCar == -1;}
	private boolean hayExp() {return sigCar == 'E' || sigCar == 'e';}
	private boolean hayMenor() {return sigCar == '<';}
	private boolean hayMayor() {return sigCar == '>';}
	private boolean hayPyC() {return sigCar == ';';}
	
	
	private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n' || sigCar == '\r' || sigCar == '\b';}
	//private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
	

	private UnidadLexica unidadVariable() {
		switch(lex.toString()) {
		case "int":  
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.INT);
		case "real":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.REAL);
		case "bool":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL);
		case "and":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
		case "or":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
		case "not":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);
		case "true":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
		case "false":    
			return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
		default:    
			return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.VARIABLE,lex.toString());     
		}
	}  

	private UnidadLexica unidadEnt() {
		return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.ENT,lex.toString());     
	}    

	private UnidadLexica unidadReal() {
		return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.NUMREAL,lex.toString());     
	}

	private UnidadLexica unidadSeparador() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.SEPARADOR);
	}

	private UnidadLexica unidadPyC() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PUNTOYCOMA);     
	}

	private UnidadLexica unidadMas() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
	}    

	private UnidadLexica unidadMenos() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
	}    

	private UnidadLexica unidadPor() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.POR);     
	}    

	private UnidadLexica unidadDiv() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
	}    

	private UnidadLexica unidadIgual() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUAL);     
	} 

	private UnidadLexica unidadMenor() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOR);     
	}

	private UnidadLexica unidadMayor() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYOR);     
	} 

	private UnidadLexica unidadMenorIgual() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENORIGUAL);     
	} 

	private UnidadLexica unidadMayorIgual() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYORIGUAL);     
	}

	private UnidadLexica unidadIgualdad() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUALDAD);     
	}  

	private UnidadLexica unidadDistinto() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DISTINTO);     
	}  

	private UnidadLexica unidadPAp() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAPERTURA);     
	}    

	private UnidadLexica unidadPCierre() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);     
	}    

	private UnidadLexica unidadEof() {
		return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
	}    

	public void error() {
		System.err.println("Fila: " + this.filaActual + ", Columna: " + this.columnaActual + ", " + "Caracter inexperado.");
		System.exit(1);
	}
}