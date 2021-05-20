package procesamientos;

import analizadorSintactico.ProcesamientoPorDefecto;
import analizadorSintactico.AnalizadorSintacticoTiny1.AccessRegFlecha;
import analizadorSintactico.AnalizadorSintacticoTiny1.AccessRegPunto;
import analizadorSintactico.AnalizadorSintacticoTiny1.And;
import analizadorSintactico.AnalizadorSintacticoTiny1.Cadena;
import analizadorSintactico.AnalizadorSintacticoTiny1.Campo;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecProc;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecType;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecVar;
import analizadorSintactico.AnalizadorSintacticoTiny1.Distinto;
import analizadorSintactico.AnalizadorSintacticoTiny1.Div;
import analizadorSintactico.AnalizadorSintacticoTiny1.Exp;
import analizadorSintactico.AnalizadorSintacticoTiny1.False;
import analizadorSintactico.AnalizadorSintacticoTiny1.Identificador;
import analizadorSintactico.AnalizadorSintacticoTiny1.Igualdad;
import analizadorSintactico.AnalizadorSintacticoTiny1.Index;
import analizadorSintactico.AnalizadorSintacticoTiny1.Indireccion;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsAsignacion;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsBloque;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsCall;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsDelete;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsIf;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsIfElse;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsNL;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsNew;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsRead;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsWhile;
import analizadorSintactico.AnalizadorSintacticoTiny1.InsWrite;
import analizadorSintactico.AnalizadorSintacticoTiny1.LCampos_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LCampos_muchos;
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LInsV_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LInsV_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LIns_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LIns_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParamsReales_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParamsReales_muchos;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParams_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParams_muchos;
import analizadorSintactico.AnalizadorSintacticoTiny1.Mayor;
import analizadorSintactico.AnalizadorSintacticoTiny1.Mayor_igual;
import analizadorSintactico.AnalizadorSintacticoTiny1.Menor;
import analizadorSintactico.AnalizadorSintacticoTiny1.Menor_igual;
import analizadorSintactico.AnalizadorSintacticoTiny1.Menos;
import analizadorSintactico.AnalizadorSintacticoTiny1.Mod;
import analizadorSintactico.AnalizadorSintacticoTiny1.Mul;
import analizadorSintactico.AnalizadorSintacticoTiny1.Not;
import analizadorSintactico.AnalizadorSintacticoTiny1.Null;
import analizadorSintactico.AnalizadorSintacticoTiny1.NumEnt;
import analizadorSintactico.AnalizadorSintacticoTiny1.NumReal;
import analizadorSintactico.AnalizadorSintacticoTiny1.Or;
import analizadorSintactico.AnalizadorSintacticoTiny1.Param;
import analizadorSintactico.AnalizadorSintacticoTiny1.Programa;
import analizadorSintactico.AnalizadorSintacticoTiny1.Referencia;
import analizadorSintactico.AnalizadorSintacticoTiny1.Resta;
import analizadorSintactico.AnalizadorSintacticoTiny1.Suma;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_array;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_bool;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_id;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_int;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_pointer;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_real;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_record;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_string;
import analizadorSintactico.AnalizadorSintacticoTiny1.True;

public class Impresion extends ProcesamientoPorDefecto {

	public void procesa(InsCall insCall) {
		System.out.print("call " + insCall.id() + "(");
		if(insCall.lparamsreales() != null) insCall.lparamsreales().procesa(this);
		System.out.print(")");
	}

	public void procesa(Suma suma) {
		imprime_arg(suma.arg0(), 1);
		System.out.print(" + ");
		imprime_arg(suma.arg1(), 0);
	}

	public void procesa(Resta resta) {
		imprime_arg(resta.arg0(), 1);
		System.out.print(" - ");
		imprime_arg(resta.arg1(), 1);
	}

	public void procesa(And and) {
		imprime_arg(and.arg0(), 1);
		System.out.print(" and ");
		imprime_arg(and.arg1(), 2);
	}

	public void procesa(Or or) {
		imprime_arg(or.arg0(), 1);
		System.out.print(" or ");
		imprime_arg(or.arg1(), 2);
	}

	public void procesa(Menor menor) {
		imprime_arg(menor.arg0(), 2);
		System.out.print(" < ");
		imprime_arg(menor.arg1(), 3);
	}

	public void procesa(Mayor mayor) {
		imprime_arg(mayor.arg0(), 2);
		System.out.print(" > ");
		imprime_arg(mayor.arg1(), 3);
	}

	public void procesa(Menor_igual menor_igual) {
		imprime_arg(menor_igual.arg0(), 2);
		System.out.print(" <= ");
		imprime_arg(menor_igual.arg1(), 3);
	}

	public void procesa(Mayor_igual mayor_igual) {
		imprime_arg(mayor_igual.arg0(), 2);
		System.out.print(" >= ");
		imprime_arg(mayor_igual.arg1(), 3);
	}

	public void procesa(Igualdad igualdad) {
		imprime_arg(igualdad.arg0(), 2);
		System.out.print(" == ");
		imprime_arg(igualdad.arg1(), 3);
	}

	public void procesa(Distinto distinto) {
		imprime_arg(distinto.arg0(), 2);
		System.out.print(" != ");
		imprime_arg(distinto.arg1(), 3);
	}

	public void procesa(Mul mul) {
		imprime_arg(mul.arg0(), 4);
		System.out.print(" * ");
		imprime_arg(mul.arg1(), 4);
	}

	public void procesa(Div div) {
		imprime_arg(div.arg0(), 4);
		System.out.print(" / ");
		imprime_arg(div.arg1(), 4);
	}

	public void procesa(Mod mod) {
		imprime_arg(mod.arg0(), 4);
		System.out.print(" % ");
		imprime_arg(mod.arg1(), 4);
	}

	public void procesa(Menos menos) {
		System.out.print("-");
		imprime_arg(menos.arg0(), 5);
	}

	public void procesa(Not not) {
		System.out.print("not ");
		imprime_arg(not.arg0(), 4);
	}

	public void procesa(NumEnt numEnt) {
		System.out.print(numEnt.num());
	}

	public void procesa(NumReal numReal) {
		System.out.print(numReal.num());
	}

	public void procesa(Identificador identificador) {
		System.out.print(identificador.id());
	}

	public void procesa(True true1) {
		System.out.print(true1.lexema());
	}

	public void procesa(False false1) {
		System.out.print(false1.lexema());
	}

	public void procesa(Tipo_int tipo_int) {
		System.out.print(tipo_int.lexema() + " ");
	}

	public void procesa(Tipo_bool tipo_bool) {
		System.out.print(tipo_bool.lexema() + " ");
	}

	public void procesa(Tipo_real tipo_real) {
		System.out.print(tipo_real.lexema() + " ");
	}

	public void procesa(DecVar decVar) {
		System.out.print("var ");
		decVar.tipo().procesa(this);
		System.out.print(decVar.id());
	}

	public void procesa(DecType decType) {
		System.out.print("type ");
		decType.tipo().procesa(this);
		System.out.print(decType.id());
	}

	public void procesa(DecProc decProc) {
		System.out.print("proc " + decProc.id() +  "(");
		if(decProc.lparams() != null) decProc.lparams().procesa(this);
		System.out.println(") {");
		if(decProc.bloque().programa() != null) {
			decProc.bloque().programa().procesa(this);
			System.out.print("\n}");
		} else {
			System.out.print("}");
		}
		
	}

	public void procesa(LDecs_1 lDecs_1) {
		lDecs_1.dec().procesa(this);
	}

	public void procesa(LDecs_muchas lDecs_muchas) {
		lDecs_muchas.ldecs().procesa(this);
		System.out.print(";\n");
		lDecs_muchas.dec().procesa(this);
	}

	public void procesa(LIns_1 lIns_1) {
		lIns_1.ins().procesa(this);
	}

	public void procesa(LIns_muchas lIns_muchas) {
		lIns_muchas.lins().procesa(this);
		System.out.print(";\n");
		lIns_muchas.ins().procesa(this);
	}

	public void procesa(LInsV_1 lInsV_1) {
		lInsV_1.ins().procesa(this);
	}

	public void procesa(LInsV_muchas lInsV_muchas) {
		lInsV_muchas.linsv().procesa(this);
		System.out.print(";\n");
		lInsV_muchas.ins().procesa(this);
	}

	public void procesa(InsAsignacion insAsignacion) {
		insAsignacion.exp1().procesa(this);
		System.out.print(" = ");
		insAsignacion.exp2().procesa(this);
	}

	public void procesa(InsRead insRead) {
		System.out.print("read ");
		insRead.exp1().procesa(this);
	}

	public void procesa(InsWrite insWrite) {
		System.out.print("write ");
		insWrite.exp1().procesa(this);
	}

	public void procesa(InsNew insNew) {
		System.out.print("new ");
		insNew.exp1().procesa(this);
	}

	public void procesa(InsDelete insDelete) {
		System.out.print("delete ");
		insDelete.exp1().procesa(this);
	}

	public void procesa(InsNL insNL) {
		System.out.print(insNL.lexema());
	}

	public void procesa(InsBloque insBloque) {
		System.out.println("{");
		if(insBloque.bloque().programa() != null) insBloque.bloque().programa().procesa(this);
		System.out.print("\n}");
	}

	public void procesa(InsIf insIf) {
		System.out.print("if ");
		insIf.exp1().procesa(this);
		System.out.println(" then");
		insIf.linsv().procesa(this);
		System.out.print("\nendif");
	}

	public void procesa(InsIfElse insIfElse) {
		System.out.print("if ");
		insIfElse.exp1().procesa(this);
		System.out.println(" then");
		insIfElse.linsv1().procesa(this);
		System.out.println("\nelse");
		insIfElse.linsv2().procesa(this);
		System.out.print("\nendif");
	}

	public void procesa(InsWhile insWhile) {
		System.out.print("while ");
		insWhile.exp1().procesa(this);
		System.out.println(" do");
		insWhile.linsv().procesa(this);
		System.out.print("\nendwhile");
	}

	public void procesa(LParams_1 lParams_1) {
		lParams_1.param().procesa(this);
	}

	public void procesa(LParams_muchos lParams_muchos) {
		lParams_muchos.lparams().procesa(this);
		System.out.print(", ");
		lParams_muchos.param().procesa(this);
	}

	public void procesa(Param param) {
		param.tipo().procesa(this);
		if(param.ref() != null) param.ref().procesa(this);
		System.out.print(param.id());
	}

	public void procesa(LParamsReales_1 lParamsReales_1) {
		lParamsReales_1.exp1().procesa(this);
	}

	public void procesa(LParamsReales_muchos lParamsReales_muchos) {
		lParamsReales_muchos.lparamsreales().procesa(this);
		System.out.print(", ");
		lParamsReales_muchos.exp1().procesa(this);
	}

	public void procesa(Referencia referencia) {
		if (referencia != null) System.out.print("& ");
	}

	public void procesa(Programa programa) {
		if (programa.ldecs() == null) {
			programa.lins().procesa(this);
		}
		else {
			programa.ldecs().procesa(this);
			System.out.println("\n&&");
			programa.lins().procesa(this);
		}
	}

	public void procesa(Index index) {
		index.exp1().procesa(this);
		System.out.print("[");
		index.exp2().procesa(this);
		System.out.print("]");
	}

	public void procesa(AccessRegPunto accessRegPunto) {
		accessRegPunto.exp1().procesa(this);
		System.out.print(".");
		System.out.print(accessRegPunto.id());
	}

	public void procesa(AccessRegFlecha accessRegFlecha) {
		accessRegFlecha.exp1().procesa(this);
		System.out.print("->");
		System.out.print(accessRegFlecha.id());
	}

	public void procesa(Indireccion indireccion) {
		System.out.print("*");
		indireccion.exp1().procesa(this);
	}

	public void procesa(Cadena cadena) {
		System.out.print(cadena.cadena());
	}

	public void procesa(Null null1) {
		System.out.print(null1.lexema());
	}

	public void procesa(Tipo_string tipo_string) {
		System.out.print(tipo_string.lexema() + " ");
	}

	public void procesa(Tipo_id tipo_id) {
		System.out.print(tipo_id.id() + " ");
	}

	public void procesa(Tipo_array tipo_array) {
		System.out.print("array [" + tipo_array.id() + "] of ");
		tipo_array.tipo().procesa(this);
	}

	public void procesa(Tipo_pointer tipo_pointer) {
		System.out.print("pointer ");
		tipo_pointer.tipo().procesa(this);
	}

	public void procesa(Campo campo) {
		campo.tipo().procesa(this);
		System.out.print(campo.id());
	}

	public void procesa(LCampos_1 lCampos_1) {
		lCampos_1.campo().procesa(this);
	}

	public void procesa(LCampos_muchos lCampos_muchos) {
		lCampos_muchos.lcampos().procesa(this);
		System.out.println(";");
		lCampos_muchos.campo().procesa(this);
	}

	public void procesa(Tipo_record tipo_record) {
		System.out.println("record {");
		tipo_record.lcampos().procesa(this);
		System.out.print("\n} ");
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
