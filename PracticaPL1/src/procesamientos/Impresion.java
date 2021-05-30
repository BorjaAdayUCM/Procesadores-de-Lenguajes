package procesamientos;

import analizadorSintactico.ProcesamientoPorDefecto;
import analizadorSintactico.AnalizadorSintacticoTiny.And;
import analizadorSintactico.AnalizadorSintacticoTiny.Dec;
import analizadorSintactico.AnalizadorSintacticoTiny.Distinto;
import analizadorSintactico.AnalizadorSintacticoTiny.Div;
import analizadorSintactico.AnalizadorSintacticoTiny.Exp;
import analizadorSintactico.AnalizadorSintacticoTiny.False;
import analizadorSintactico.AnalizadorSintacticoTiny.Identificador;
import analizadorSintactico.AnalizadorSintacticoTiny.Igualdad;
import analizadorSintactico.AnalizadorSintacticoTiny.Ins;
import analizadorSintactico.AnalizadorSintacticoTiny.LDecs_1;
import analizadorSintactico.AnalizadorSintacticoTiny.LDecs_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny.LIns_1;
import analizadorSintactico.AnalizadorSintacticoTiny.LIns_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny.Mayor;
import analizadorSintactico.AnalizadorSintacticoTiny.Mayor_igual;
import analizadorSintactico.AnalizadorSintacticoTiny.Menor;
import analizadorSintactico.AnalizadorSintacticoTiny.Menor_igual;
import analizadorSintactico.AnalizadorSintacticoTiny.Menos;
import analizadorSintactico.AnalizadorSintacticoTiny.Mul;
import analizadorSintactico.AnalizadorSintacticoTiny.Not;
import analizadorSintactico.AnalizadorSintacticoTiny.NumEnt;
import analizadorSintactico.AnalizadorSintacticoTiny.NumReal;
import analizadorSintactico.AnalizadorSintacticoTiny.Or;
import analizadorSintactico.AnalizadorSintacticoTiny.Programa;
import analizadorSintactico.AnalizadorSintacticoTiny.Resta;
import analizadorSintactico.AnalizadorSintacticoTiny.Suma;
import analizadorSintactico.AnalizadorSintacticoTiny.Tipo_bool;
import analizadorSintactico.AnalizadorSintacticoTiny.Tipo_int;
import analizadorSintactico.AnalizadorSintacticoTiny.Tipo_real;
import analizadorSintactico.AnalizadorSintacticoTiny.True;

public class Impresion extends ProcesamientoPorDefecto {
	public Impresion() {

	}

	public void procesa(Programa programa) {
		programa.ldecs().procesa(this);
		System.out.println();
		System.out.println("&&");
		programa.lins().procesa(this);
	}

	public void procesa(LDecs_1 ldecs) {
		ldecs.dec().procesa(this);
	}

	public void procesa(LDecs_muchas ldecs) {
		ldecs.ldecs().procesa(this);
		System.out.println(";");
		ldecs.dec().procesa(this);
	}

	public void procesa(Tipo_int int_p) {
		System.out.print(int_p.lexema() + " ");
	}

	public void procesa(Tipo_bool bool_p) {
		System.out.print(bool_p.lexema() + " ");
	}

	public void procesa(Tipo_real real_p) {
		System.out.print(real_p.lexema() + " ");
	}

	public void procesa(Dec dec) {
		dec.tipo().procesa(this);
		System.out.print(dec.id());
	}

	public void procesa(LIns_1 lins) {
		lins.ins().procesa(this);
	}

	public void procesa(LIns_muchas lins) {
		lins.lins().procesa(this);
		System.out.println(";");
		lins.ins().procesa(this);
	}

	public void procesa(Ins ins) {
		System.out.print(ins.id() + " = ");
		ins.exp().procesa(this);
	}

	public void procesa(Suma exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" + ");
		imprime_arg(exp.arg1(), 0);
	}

	public void procesa(Resta exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" - ");
		imprime_arg(exp.arg1(), 1);
	}

	public void procesa(Mul exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" * ");
		imprime_arg(exp.arg1(), 4);
	}

	public void procesa(Div exp) {
		imprime_arg(exp.arg0(), 4);
		System.out.print(" / ");
		imprime_arg(exp.arg1(), 4);
	}

	public void procesa(And exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" and ");
		imprime_arg(exp.arg1(), 2);
	}

	public void procesa(Or exp) {
		imprime_arg(exp.arg0(), 1);
		System.out.print(" or ");
		imprime_arg(exp.arg1(), 2);
	}

	public void procesa(Menor exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" < ");
		imprime_arg(exp.arg1(), 3);
	}

	public void procesa(Mayor exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" > ");
		imprime_arg(exp.arg1(), 3);
	}

	public void procesa(Menor_igual exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" <= ");
		imprime_arg(exp.arg1(), 3);
	}

	public void procesa(Mayor_igual exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" >= ");
		imprime_arg(exp.arg1(), 3);
	}

	public void procesa(Igualdad exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" == ");
		imprime_arg(exp.arg1(), 3);
	}

	public void procesa(Distinto exp) {
		imprime_arg(exp.arg0(), 2);
		System.out.print(" != ");
		imprime_arg(exp.arg1(), 3);
	}

	public void procesa(Menos exp) {
		System.out.print("-");
		imprime_arg(exp.arg0(), 5);
	
	}

	public void procesa(Not exp) {
		System.out.print("not");
		imprime_arg(exp.arg0(), 4);
	}

	public void procesa(Identificador exp) {
		System.out.print(exp.id());
	}

	public void procesa(NumEnt exp) {
		System.out.print(exp.num());
	}

	public void procesa(NumReal exp) {
		System.out.print(exp.num());
	}

	public void procesa(True true_p) {
		System.out.print(true_p.lexema());
	}

	public void procesa(False false_p) {
		System.out.print(false_p.lexema());
	}
	
	private void imprime_arg(Exp arg, int p) {
	       if (arg.prioridad() < p) {
	           System.out.print("(");
	           arg.procesa(this);
	           System.out.print(")");
	       }
	       else {
	           arg.procesa(this);
	       }
	   }

}
