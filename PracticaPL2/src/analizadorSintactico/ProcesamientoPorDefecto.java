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
	public void procesa(InsCall insCall) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Suma suma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Resta resta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(And and) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Or or) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Menor menor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Mayor mayor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Menor_igual menor_igual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Mayor_igual mayor_igual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Igualdad igualdad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Distinto distinto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Mul mul) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Div div) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Mod mod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Menos menos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Not not) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(NumEnt numEnt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(NumReal numReal) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Identificador identificador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(True true1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(False false1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_int tipo_int) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_bool tipo_bool) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_real tipo_real) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(DecVar decVar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(DecType decType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(DecProc decProc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LDecs_1 lDecs_1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LDecs_muchas lDecs_muchas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LIns_1 lIns_1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LIns_muchas lIns_muchas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LInsV_1 lInsV_1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LInsV_muchas lInsV_muchas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsAsignacion insAsignacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsRead insRead) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsWrite insWrite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsNew insNew) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsDelete insDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsNL insNL) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsBloque insBloque) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsIf insIf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsIfElse insIfElse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(InsWhile insWhile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LParams_1 lParams_1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LParams_muchos lParams_muchos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Param param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LParamsReales_1 lParamsReales_1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LParamsReales_muchos lParamsReales_muchos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Referencia referencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Programa programa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Index index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(AccessRegPunto accessRegPunto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(AccessRegFlecha accessRegFlecha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Indireccion indireccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Cadena cadena) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Null null1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_string tipo_string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_id tipo_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_array tipo_array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_pointer tipo_pointer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Campo campo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LCampos_1 lCampos_1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(LCampos_muchos lCampos_muchos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesa(Tipo_record tipo_record) {
		// TODO Auto-generated method stub
		
	}
	
}
