package semops;

import analizadorSintactico.AnalizadorSintacticoTiny;

public class SemOps extends AnalizadorSintacticoTiny {

	public Exp exp(String op, Exp arg0, Exp arg1) {
		switch (op) {
		case "+": 
			return suma(arg0, arg1);
		case "-": 
			return resta(arg0, arg1);
		case "and":
			return and(arg0, arg1);
		case "or":
			return or(arg0, arg1);
		case "<":
			return menor(arg0, arg1);
		case ">":
			return mayor(arg0, arg1);
		case "<=":
			return menor_igual(arg0, arg1);
		case ">=":
			return mayor_igual(arg0, arg1);
		case "==":
			return igualdad(arg0, arg1);
		case "!=":
			return distinto(arg0, arg1);
		case "*":
			return mul(arg0, arg1);
		case "/":
			return div(arg0, arg1);
		}
		throw new UnsupportedOperationException("exp " + op);
	}

}
