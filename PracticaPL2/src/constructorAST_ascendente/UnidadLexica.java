package constructorAST_ascendente;

import analizadorSintactico.AnalizadorSintacticoTiny1.StringLocalizado;
import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol {
	public UnidadLexica(int fila, int col, int clase, String lexema) {
		super(clase, null);
		value = new StringLocalizado(lexema, fila, col);
	}

	public int clase() {
		return sym;
	}

	public StringLocalizado lexema() {
		return (StringLocalizado) value;
	}

	public String toString() {
		StringLocalizado lexema = (StringLocalizado) value;
		return "[clase=" + clase2string(sym) + ",lexema=" + lexema + ",fila=" + lexema.fila() + ",col=" + lexema.col()
				+ "]";
	}

	private String clase2string(int clase) {
		switch (clase) {
		case ClaseLexica.INT:
			return "INT";
		case ClaseLexica.REAL:
			return "REAL";
		case ClaseLexica.BOOL:
			return "BOOL";
		case ClaseLexica.STRING:
			return "STRING";
		case ClaseLexica.AND:
			return "AND";
		case ClaseLexica.OR:
			return "OR";
		case ClaseLexica.NOT:
			return "NOT";
		case ClaseLexica.NULL:
			return "NULL";
		case ClaseLexica.TRUE:
			return "TRUE";
		case ClaseLexica.FALSE:
			return "FALSE";
		case ClaseLexica.PROC:
			return "PROC";
		case ClaseLexica.IF:
			return "IF";
		case ClaseLexica.THEN:
			return "THEN";
		case ClaseLexica.ELSE:
			return "ELSE";
		case ClaseLexica.ENDIF:
			return "ENDIF";
		case ClaseLexica.WHILE:
			return "WHILE";
		case ClaseLexica.DO:
			return "DO";
		case ClaseLexica.ENDWHILE:
			return "ENDWHILE";
		case ClaseLexica.CALL:
			return "CALL";
		case ClaseLexica.RECORD:
			return "RECORD";
		case ClaseLexica.ARRAY:
			return "ARRAY";
		case ClaseLexica.OF:
			return "OF";
		case ClaseLexica.POINTER:
			return "POINTER";
		case ClaseLexica.NEW:
			return "NEW";
		case ClaseLexica.DELETE:
			return "DELETE";
		case ClaseLexica.READ:
			return "READ";
		case ClaseLexica.WRITE:
			return "WRITE";
		case ClaseLexica.NL:
			return "NL";
		case ClaseLexica.VAR:
			return "VAR";
		case ClaseLexica.TYPE:
			return "TYPE";
		case ClaseLexica.IDEN:
			return "IDEN";
		case ClaseLexica.NUMENT:
			return "NUMENT";
		case ClaseLexica.NUMREAL:
			return "NUMREAL";
		case ClaseLexica.CADENA:
			return "CADENA";
		case ClaseLexica.MAS:
			return "MAS";
		case ClaseLexica.MENOS:
			return "MENOS";
		case ClaseLexica.POR:
			return "POR";
		case ClaseLexica.DIV:
			return "DIV";
		case ClaseLexica.PAPER:
			return "PAPER";
		case ClaseLexica.PCIERRE:
			return "PCIERRE";
		case ClaseLexica.IGUAL:
			return "IGUAL";
		case ClaseLexica.COMA:
			return "COMA";
		case ClaseLexica.SEP:
			return "SEP";
		case ClaseLexica.MOD:
			return "MOD";
		case ClaseLexica.MENOR:
			return "MENOR";
		case ClaseLexica.MAYOR:
			return "MAYOR";
		case ClaseLexica.MENORIGUAL:
			return "MENORIGUAL";
		case ClaseLexica.MAYORIGUAL:
			return "MAYORIGUAL";
		case ClaseLexica.IGUALDAD:
			return "IGUALDAD";
		case ClaseLexica.DISTINTO:
			return "DISTINTO";
		case ClaseLexica.PYC:
			return "PYC";
		case ClaseLexica.CORAPER:
			return "CORAPER";
		case ClaseLexica.CORCIERRE:
			return "CORCIERRE";
		case ClaseLexica.LLAVEAPER:
			return "LLAVEAPER";
		case ClaseLexica.LLAVECIERRE:
			return "LLAVECIERRE";
		case ClaseLexica.PUNTO:
			return "PUNTO";
		case ClaseLexica.FLECHA:
			return "FLECHA";
		case ClaseLexica.AMPERSAND:
			return "AMPERSAND";
		default:
			return "?";
		}
	}
}
