/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorSintactico;

import analizadorLexico.UnidadLexica;
import analizadorLexico.AnalizadorLexicoTiny;
import analizadorLexico.ClaseLexica;
import errores.GestionErroresTiny;
import java.io.IOException;
import java.io.Reader;

public class AnalizadorSintacticoTiny {

	private UnidadLexica anticipo;

	private AnalizadorLexicoTiny alex;

	private GestionErroresTiny errores;

	public AnalizadorSintacticoTiny(Reader input) throws IOException {
		errores = new GestionErroresTiny();
		alex = new AnalizadorLexicoTiny(input);
		alex.fijaGestionErrores(errores);
		sigToken();
	}

	public void init() {
		Programa();
		empareja(ClaseLexica.EOF);
	}

	private void Programa() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			PDeclaraciones();
			empareja(ClaseLexica.SEPARADOR);
			PInstrucciones();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
		}
	}

	private void PDeclaraciones() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			LDecs();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
		}
	}

	private void LDecs() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			Dec();
			RLDecs();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
		}
	}

	private void RLDecs() {
		switch (anticipo.clase()) {
		case PUNTOYCOMA:
			empareja(ClaseLexica.PUNTOYCOMA);
			Dec();
			RLDecs();
			break;
		case SEPARADOR:
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOYCOMA, ClaseLexica.SEPARADOR); //ERRORES
		}
	}

	private void Dec() {
		switch (anticipo.clase()) {
		case INT:
		case REAL:
		case BOOL:
			Tipo();
			empareja(ClaseLexica.VARIABLE);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
		}
	}

	private void Tipo() {
		switch (anticipo.clase()) {
		case INT: 
			empareja(ClaseLexica.INT); 
			break;
		case REAL: 
			empareja(ClaseLexica.REAL); 
			break;
		case BOOL: 
			empareja(ClaseLexica.BOOL); 
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.INT,
					ClaseLexica.REAL, ClaseLexica.BOOL);
		}
	}

	private void PInstrucciones() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			LIns(); 
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE);
		}
	}

	private void LIns() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			Ins(); 
			RLIns(); 
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE);
		}
	}

	private void RLIns() {
		switch (anticipo.clase()) {
		case PUNTOYCOMA: 
			empareja(ClaseLexica.PUNTOYCOMA); 
			Ins();
			RLIns();
			break;
		case EOF: break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.PUNTOYCOMA); //ERRORES
		}
	}

	private void Ins() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			empareja(ClaseLexica.VARIABLE);
			empareja(ClaseLexica.IGUAL);
			E0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE);
		}
	}
	
	private void E0() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			E1();
			RE0();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
		}
	}

	private void RE0() {
		switch (anticipo.clase()) {
		case MAS: 
			empareja(ClaseLexica.MAS);
			E0();
			break;
		case MENOS: 
			empareja(ClaseLexica.MENOS);
			E1();
			break;
		case PCIERRE:
		case PUNTOYCOMA:
		case EOF: break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.MAS); //ERRORES
		}
	}

	private void E1() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			E2();
			RE1();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
		}
	}

	private void RE1() {
		switch (anticipo.clase()) {
		case AND:
		case OR: 
			OpN1();
			E2();
			RE1();
			break;
		case PCIERRE:
		case PUNTOYCOMA:
		case MAS:
		case MENOS:
		case EOF: break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, 
					ClaseLexica.OR); //ERRORES
		}
	}

	private void E2() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			E3();
			RE2();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
		}
	}

	private void RE2() {
		switch (anticipo.clase()) {
		case MENOR:
		case MAYOR:
		case MENORIGUAL:
		case MAYORIGUAL:
		case IGUALDAD:
		case DISTINTO:
			OpN2();
			E3();
			RE2();
			break;
		case PCIERRE:
		case AND:
		case OR:
		case MAS:
		case MENOS:
		case PUNTOYCOMA:
		case EOF: break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, 
					ClaseLexica.OR); //ERRORES
		}
	}

	private void E3() {
		switch (anticipo.clase()) {
		case MENOS: 
		case NOT: 
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			E4();
			RE3();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
		}
	}

	private void RE3() {
		switch (anticipo.clase()) {
		case POR:
		case DIV:
			OpN3();
			E4();
			break;
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
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.POR, 
					ClaseLexica.DIV); //ERRORES
		}
	}

	private void E4() {
		switch (anticipo.clase()) {
		case MENOS: 
			empareja(ClaseLexica.MENOS);
			E5();
			break;
		case NOT: 
			empareja(ClaseLexica.NOT);
			E4();
			break;
		case VARIABLE: 
		case ENT: 
		case NUMREAL: 
		case TRUE: 
		case FALSE: 
		case PAPERTURA: 
			E5();
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOS, 
					ClaseLexica.NOT, ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
		}
	}

	private void E5() {
		switch (anticipo.clase()) {
		case VARIABLE: 
			empareja(ClaseLexica.VARIABLE); 
			break;
		case ENT: empareja(ClaseLexica.ENT); 
			break;
		case NUMREAL: 
			empareja(ClaseLexica.NUMREAL); 
			break;
		case TRUE: 
			empareja(ClaseLexica.TRUE); 
			break;
		case FALSE: 
			empareja(ClaseLexica.FALSE); 
			break;
		case PAPERTURA: 
			empareja(ClaseLexica.PAPERTURA);
			E0();
			empareja(ClaseLexica.PCIERRE);
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.VARIABLE, ClaseLexica.ENT, ClaseLexica.NUMREAL, ClaseLexica.TRUE, ClaseLexica.FALSE,
					ClaseLexica.PAPERTURA);
		}
	}

	private void OpN1() {
		switch (anticipo.clase()) {
		case AND: 
			empareja(ClaseLexica.AND); 
			break;
		case OR: 
			empareja(ClaseLexica.OR); 
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.AND, ClaseLexica.OR);
		}
	}

	private void OpN2() {
		switch (anticipo.clase()) {
		case MENOR: 
			empareja(ClaseLexica.MENOR); 
			break;
		case MAYOR: 
			empareja(ClaseLexica.MAYOR); 
			break;
		case MENORIGUAL: 
			empareja(ClaseLexica.MENORIGUAL); 
			break;
		case MAYORIGUAL: 
			empareja(ClaseLexica.MAYORIGUAL); 
			break;
		case IGUALDAD: 
			empareja(ClaseLexica.IGUALDAD); 
			break;
		case DISTINTO: 
			empareja(ClaseLexica.DISTINTO); 
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.MENOR, ClaseLexica.MAYOR,
					ClaseLexica.MENORIGUAL, ClaseLexica.MAYORIGUAL, ClaseLexica.IGUALDAD, ClaseLexica.DISTINTO);
		}
	}

	private void OpN3() {
		switch (anticipo.clase()) {
		case POR: 
			empareja(ClaseLexica.POR); 
			break;
		case DIV: 
			empareja(ClaseLexica.DIV); 
			break;
		default:
			errores.errorSintactico(anticipo.fila(), anticipo.columna(), anticipo.clase(), ClaseLexica.POR, ClaseLexica.DIV);
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
