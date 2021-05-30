package constructorAST_descendente_manual;

import java.io.IOException;
import java.io.Reader;
import analizadorSintactico.AnalizadorSintacticoTiny.*;
import errores.GestionErroresTiny;
import semops.SemOps;


public class ConstructorAST {
   private UnidadLexica anticipo;
   private AnalizadorLexicoTiny alex;
   private GestionErroresTiny errores;
   private SemOps sem;
   
   public ConstructorAST (Reader input) throws IOException {
      errores = new GestionErroresTiny();
      alex = new AnalizadorLexicoTiny(input, errores);
      sigToken();
      sem = new SemOps();
   }

   public Programa init() {
		Programa programa = Programa();
		empareja(ClaseLexica.EOF);
		return programa;
	}

	private Programa Programa() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			LDecs decs = PDeclaraciones();
			empareja(ClaseLexica.SEPARADOR);
			LIns ins = PInstrucciones();
			return sem.programa(decs, ins);  
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
			return null;
		}
	}

	private LDecs PDeclaraciones() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			return LDecs();
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
			return null;
		}
	}

	private LDecs LDecs() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			Dec dec1 = Dec();
			return RLDecs(sem.decs_1(dec1));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
			return null;
		}
	}

	private LDecs RLDecs(LDecs LDecsh) {
		switch (anticipo.clase()) {
		case PUNTOYCOMA:
			empareja(ClaseLexica.PUNTOYCOMA);
			Dec dec1 = Dec();
			return RLDecs(sem.decs_muchas(LDecsh, dec1));
		case SEPARADOR:
			return LDecsh;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOYCOMA, ClaseLexica.SEPARADOR);
			return null;
		}
	}

	private Dec Dec() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			Tipo tipo1 = Tipo();
			UnidadLexica token = anticipo.clonar();
			empareja(ClaseLexica.VARIABLE);
			return sem.dec(tipo1, sem.str(token.lexema(), token.fila(), token.columna()));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
			return null;
		}
	}

	private Tipo Tipo() {
		switch (anticipo.clase()) {
		case INT: 
			empareja(ClaseLexica.INT); 
			return sem.tipo_int();
		case REAL: 
			empareja(ClaseLexica.REAL); 
			return sem.tipo_real();
		case BOOL: 
			empareja(ClaseLexica.BOOL); 
			return sem.tipo_bool();
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
			return null;
		}
	}

	private LIns PInstrucciones() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			return LIns();
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE);
			return null;
		}
	}

	private LIns LIns() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			Ins ins1 = Ins(); 
			return RLIns(sem.lins_1(ins1));
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE);
			return null;
		}
	}

	private LIns RLIns(LIns LInsh) {
		switch (anticipo.clase()) {
		case PUNTOYCOMA: 
			empareja(ClaseLexica.PUNTOYCOMA); 
			Ins ins1 = Ins();
			return RLIns(sem.lins_muchas(LInsh, ins1));
		case EOF: return LInsh;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOYCOMA, ClaseLexica.EOF);
			return null;
		}
	}

	private Ins Ins() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			UnidadLexica token = anticipo.clonar();
			empareja(ClaseLexica.VARIABLE);
			empareja(ClaseLexica.IGUAL);
			Exp exp1 = E0();
			return sem.ins(sem.str(token.lexema(), token.fila(), token.columna()), exp1);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE);
			return null;
		}
	}
	
	private Exp E0() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			Exp exp1 = E1();
			return RE0(exp1);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
			return null;
		}
	}

	private Exp RE0(Exp exph) {
		switch (anticipo.clase()) {
		case MAS: 
			empareja(ClaseLexica.MAS);
			Exp exp1 = E0();
			return sem.exp("+", exph, exp1);
		case MENOS: 
			empareja(ClaseLexica.MENOS);
			Exp exp2 = E1();
			return sem.exp("-", exph, exp2);
		case PCIERRE:
		case PUNTOYCOMA:
		case EOF: return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.MAS);
			return null;
		}
	}

	private Exp E1() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			Exp exp1 = E2();
			return RE1(exp1);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
			return null;
		}
	}

	private Exp RE1(Exp exph) {
		switch (anticipo.clase()) {
		case AND:
		case OR: 
			String op = OpN1();
			Exp exp1 = E2();
			return RE1(sem.exp(op, exph, exp1));
		case PCIERRE:
		case PUNTOYCOMA:
		case MAS:
		case MENOS:
		case EOF: return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, 
					ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS);
			return null;
		}
	}

	private Exp E2() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			Exp exp1 = E3();
			return RE2(exp1);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
			return null;
		}
	}

	private Exp RE2(Exp exph) {
		switch (anticipo.clase()) {
		case MENOR:
		case MAYOR:
		case MENORIGUAL:
		case MAYORIGUAL:
		case IGUALDAD:
		case DISTINTO:
			String op = OpN2();
			Exp exp1 = E3();
			return RE2(sem.exp(op, exph, exp1));
		case PCIERRE:
		case AND:
		case OR:
		case MAS:
		case MENOS:
		case PUNTOYCOMA:
		case EOF: return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MAYOR, ClaseLexica.MENORIGUAL, 
					ClaseLexica.MAYORIGUAL, ClaseLexica.IGUALDAD, ClaseLexica.DISTINTO,ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS);
			return null;
		}
	}

	private Exp E3() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			Exp exp1 = E4();
			return RE3(exp1);
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
			return null;
		}
	}

	private Exp RE3(Exp exph) {
		switch (anticipo.clase()) {
		case POR:
		case DIV:
			String op = OpN3();
			Exp exp1 = E4();
			return sem.exp(op, exph, exp1);
		case MENOR:
		case MAYOR:
		case MENORIGUAL:
		case MAYORIGUAL:
		case IGUALDAD:
		case DISTINTO:
		case PCIERRE:
		case AND:
		case OR:
		case MAS:
		case MENOS:
		case PUNTOYCOMA:
		case EOF: 
			return exph;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.POR, 
					ClaseLexica.DIV, ClaseLexica.MENOR, ClaseLexica.MAYOR, ClaseLexica.MENORIGUAL, ClaseLexica.MAYORIGUAL,
					ClaseLexica.IGUALDAD, ClaseLexica.DISTINTO, ClaseLexica.AND, ClaseLexica.OR, ClaseLexica.MAS, ClaseLexica.MENOS);
			return null;
		}
	}

	private Exp E4() {
		switch (anticipo.clase()) {
		case MENOS: 
			empareja(ClaseLexica.MENOS);
			return sem.menos(E5());
		case NOT: 
			empareja(ClaseLexica.NOT);
			return sem.not(E4());
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			return E5();
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
			return null;
		}
		
	}

	private Exp E5() {
		UnidadLexica token = anticipo;
		switch (anticipo.clase()) {
		case VARIABLE: 
			empareja(ClaseLexica.VARIABLE); 
            return sem.identificador(sem.str(token.lexema(), token.fila(), token.columna()));
		case ENT: 
			empareja(ClaseLexica.ENT); 
			return sem.numEnt(sem.str(token.lexema(), token.fila(), token.columna()));
		case NUMREAL: 
			empareja(ClaseLexica.NUMREAL); 
			return sem.numReal(sem.str(token.lexema(), token.fila(), token.columna()));
		case TRUE: 
			empareja(ClaseLexica.TRUE); 
			return sem.true_p();
		case FALSE: 
			empareja(ClaseLexica.FALSE); 
			return sem.false_p();
		case PAPERTURA: 
			empareja(ClaseLexica.PAPERTURA);
			Exp exp = E0();
			empareja(ClaseLexica.PCIERRE);
			return exp;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
			return null;
		}
	}

	private String OpN1() {
		switch (anticipo.clase()) {
		case AND: 
			empareja(ClaseLexica.AND); return "and";
		case OR: 
			empareja(ClaseLexica.OR); return "or";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, ClaseLexica.OR);
			return null;
		}
	}

	private String OpN2() {
		switch (anticipo.clase()) {
		case MENOR: 
			empareja(ClaseLexica.MENOR); return "<";
		case MAYOR: 
			empareja(ClaseLexica.MAYOR); return ">";
		case MENORIGUAL: 
			empareja(ClaseLexica.MENORIGUAL); return "<=";
		case MAYORIGUAL: 
			empareja(ClaseLexica.MAYORIGUAL); return ">=";
		case IGUALDAD: 
			empareja(ClaseLexica.IGUALDAD); return "==";
		case DISTINTO: 
			empareja(ClaseLexica.DISTINTO); return "!=";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MAYOR,
					ClaseLexica.MENORIGUAL, ClaseLexica.MAYORIGUAL, ClaseLexica.IGUALDAD, ClaseLexica.DISTINTO);
			return null;
		}
	}

	private String OpN3() {
		switch (anticipo.clase()) {
		case POR: 
			empareja(ClaseLexica.POR); return "*";
		case DIV: 
			empareja(ClaseLexica.DIV); return "/";
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.POR, ClaseLexica.DIV);
			return null;
		}
	}

	private void empareja(ClaseLexica claseEsperada) {
		if (anticipo.clase() == claseEsperada)
			sigToken();
		else
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), claseEsperada);
	}

	private void sigToken() {
		try {
			anticipo = alex.sigToken();
		} catch (IOException e) {
			errores.errorFatal(e);
		}
	}

}