package semops;

import analizadorSintactico.AnalizadorSintacticoTiny1;

public class SemOps extends AnalizadorSintacticoTiny1 {

	public Exp exp(String op, Exp arg0, Exp arg1) {
		switch (op) {
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
		case "%":
			return mod(arg0, arg1);
		}
		throw new UnsupportedOperationException("exp "+ op);
	}

	public Dec dec_proc(StringLocalizado id, LParams lparams, Bloque bloque) {
		if (lparams == null)
			return dec_proc_sin_pf(id, bloque);
		else
			return dec_proc_con_pf(id, lparams, bloque);
	}

	public Param param(Tipo tipo, Referencia ref, StringLocalizado id) {
		if (ref == null)
			return param_sin_referencia(tipo, id);
		else
			return param_con_referencia(tipo, ref, id);
	}

	public Ins ins_if(Exp exp, LInsV linsv) {
		if (linsv == null)
			return ins_if_sin_ins(exp);
		else
			return ins_if_con_ins(exp, linsv);
	}

	public Ins ins_if_else(Exp exp, LInsV linsv1, LInsV linsv2) {
		   if (linsv1 == null && linsv2 == null) return ins_if_else_sin_ins(exp);
		   else if (linsv1 != null && linsv2 != null) return ins_if_else_con_ins(exp, linsv1, linsv2);
		   else if (linsv1 != null) return ins_if_else_insarg0(exp, linsv1);
		   else return ins_if_else_insarg1(exp, linsv2);
		}

	public Ins ins_while(Exp exp, LInsV linsv) {
		if (linsv == null)
			return ins_while_sin_ins(exp);
		else
			return ins_while_con_ins(exp, linsv);
	}

	public Ins ins_call(StringLocalizado id, LParamsReales lparamsreales) {
		if (lparamsreales == null)
			return ins_call_sin_params(id);
		else
			return ins_call_con_params(id, lparamsreales);
	}

	public Bloque bloque(Programa programa) {
		if (programa == null)
			return bloque_sin_programa();
		else
			return bloque_con_programa(programa);
	}
}
