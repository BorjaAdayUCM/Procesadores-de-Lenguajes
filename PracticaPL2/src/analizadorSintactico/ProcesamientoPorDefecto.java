package analizadorSintactico;

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

public class ProcesamientoPorDefecto implements Procesamiento {

	@Override
	public void procesa(InsCall insCall) {}

	@Override
	public void procesa(Suma suma) {}

	@Override
	public void procesa(Resta resta) {}

	@Override
	public void procesa(And and) {}

	@Override
	public void procesa(Or or) {}

	@Override
	public void procesa(Menor menor) {}

	@Override
	public void procesa(Mayor mayor) {}

	@Override
	public void procesa(Menor_igual menor_igual) {}

	@Override
	public void procesa(Mayor_igual mayor_igual) {}

	@Override
	public void procesa(Igualdad igualdad) {}

	@Override
	public void procesa(Distinto distinto) {}

	@Override
	public void procesa(Mul mul) {}

	@Override
	public void procesa(Div div) {}

	@Override
	public void procesa(Mod mod) {}

	@Override
	public void procesa(Menos menos) {}

	@Override
	public void procesa(Not not) {}

	@Override
	public void procesa(NumEnt numEnt) {}

	@Override
	public void procesa(NumReal numReal) {}

	@Override
	public void procesa(Identificador identificador) {}

	@Override
	public void procesa(True true1) {}

	@Override
	public void procesa(False false1) {}

	@Override
	public void procesa(Tipo_int tipo_int) {}

	@Override
	public void procesa(Tipo_bool tipo_bool) {}

	@Override
	public void procesa(Tipo_real tipo_real) {}

	@Override
	public void procesa(DecVar decVar) {}

	@Override
	public void procesa(DecType decType) {}

	@Override
	public void procesa(DecProc decProc) {}

	@Override
	public void procesa(LDecs_1 lDecs_1) {}

	@Override
	public void procesa(LDecs_muchas lDecs_muchas) {}

	@Override
	public void procesa(LIns_1 lIns_1) {}

	@Override
	public void procesa(LIns_muchas lIns_muchas) {}

	@Override
	public void procesa(LInsV_1 lInsV_1) {}

	@Override
	public void procesa(LInsV_muchas lInsV_muchas) {}

	@Override
	public void procesa(InsAsignacion insAsignacion) {}

	@Override
	public void procesa(InsRead insRead) {}

	@Override
	public void procesa(InsWrite insWrite) {}

	@Override
	public void procesa(InsNew insNew) {}

	@Override
	public void procesa(InsDelete insDelete) {}

	@Override
	public void procesa(InsNL insNL) {}

	@Override
	public void procesa(InsBloque insBloque) {}

	@Override
	public void procesa(InsIf insIf) {}

	@Override
	public void procesa(InsIfElse insIfElse) {}

	@Override
	public void procesa(InsWhile insWhile) {}

	@Override
	public void procesa(LParams_1 lParams_1) {}

	@Override
	public void procesa(LParams_muchos lParams_muchos) {}

	@Override
	public void procesa(Param param) {}

	@Override
	public void procesa(LParamsReales_1 lParamsReales_1) {}

	@Override
	public void procesa(LParamsReales_muchos lParamsReales_muchos) {}

	@Override
	public void procesa(Referencia referencia) {}

	@Override
	public void procesa(Programa programa) {}

	@Override
	public void procesa(Index index) {}

	@Override
	public void procesa(AccessRegPunto accessRegPunto) {}

	@Override
	public void procesa(AccessRegFlecha accessRegFlecha) {}

	@Override
	public void procesa(Indireccion indireccion) {}

	@Override
	public void procesa(Cadena cadena) {}

	@Override
	public void procesa(Null null1) {}

	@Override
	public void procesa(Tipo_string tipo_string) {}

	@Override
	public void procesa(Tipo_id tipo_id) {}

	@Override
	public void procesa(Tipo_array tipo_array) {}

	@Override
	public void procesa(Tipo_pointer tipo_pointer) {}

	@Override
	public void procesa(Campo campo) {}

	@Override
	public void procesa(LCampos_1 lCampos_1) {}

	@Override
	public void procesa(LCampos_muchos lCampos_muchos) {}

	@Override
	public void procesa(Tipo_record tipo_record) {}

}
