package procesamientos;

import java.util.HashMap;
import java.util.Stack;

import analizadorSintactico.AnalizadorSintacticoTiny1.AccessRegFlecha;
import analizadorSintactico.AnalizadorSintacticoTiny1.AccessRegPunto;
import analizadorSintactico.AnalizadorSintacticoTiny1.And;
import analizadorSintactico.AnalizadorSintacticoTiny1.Cadena;
import analizadorSintactico.AnalizadorSintacticoTiny1.Campo;
import analizadorSintactico.AnalizadorSintacticoTiny1.Dec;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecConTipo;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecEnum;
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
import analizadorSintactico.AnalizadorSintacticoTiny1.LCampos;
import analizadorSintactico.AnalizadorSintacticoTiny1.LCamposEnum;
import analizadorSintactico.AnalizadorSintacticoTiny1.LCampos_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LCampos_muchos;
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs;
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LInsV_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LInsV_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LIns_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LIns_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParams;
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
import analizadorSintactico.AnalizadorSintacticoTiny1.Resta;
import analizadorSintactico.AnalizadorSintacticoTiny1.StringLocalizado;
import analizadorSintactico.AnalizadorSintacticoTiny1.Suma;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo;
import analizadorSintactico.AnalizadorSintacticoTiny1.TipoEnum;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_array;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_id;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_pointer;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_record;
import analizadorSintactico.AnalizadorSintacticoTiny1.True;

public class Vinculacion extends ProcesamientoPorDefecto {
	
	private Stack<HashMap<StringLocalizado, Dec>> tablaSimbolos;
	private int puntero;

	public Vinculacion() {
		this.tablaSimbolos = new Stack<HashMap<StringLocalizado, Dec>>();
		this.tablaSimbolos.push(new HashMap<StringLocalizado, Dec>());
		this.puntero = 0;
	}
	
	public void procesa(Programa programa) {
		if (programa.ldecs() == null) {
			programa.lins().procesa(this);
		} else {
			this.vincula_fase1(programa.ldecs());
			this.vincula_fase2(programa.ldecs());
			programa.lins().procesa(this);
		}
	}
	
	public void procesa(InsCall insCall) {
		if(!this.contenidoAlguno(insCall.id())) {
			System.err.println("El proceso " + insCall.id().toStringErr() + " no está declarado.");
			return;
		}
		if (insCall.lparamsreales() != null) {
			insCall.setVinculo(valorAlguno(insCall.id()));
			insCall.lparamsreales().procesa(this);
		}
		else {
			insCall.setVinculo(valorAlguno(insCall.id()));
		}
	}

	public void procesa(Suma suma) {
		suma.arg0().procesa(this);
		suma.arg1().procesa(this);
	}

	public void procesa(Resta resta) {
		resta.arg0().procesa(this);
		resta.arg1().procesa(this);
	}

	public void procesa(And and) {
		and.arg0().procesa(this);
		and.arg1().procesa(this);
	}

	public void procesa(Or or) {
		or.arg0().procesa(this);
		or.arg1().procesa(this);
	}

	public void procesa(Menor menor) {
		menor.arg0().procesa(this);
		menor.arg1().procesa(this);
	}

	public void procesa(Mayor mayor) {
		mayor.arg0().procesa(this);
		mayor.arg1().procesa(this);
	}

	public void procesa(Menor_igual menor_igual) {
		menor_igual.arg0().procesa(this);
		menor_igual.arg1().procesa(this);
	}

	public void procesa(Mayor_igual mayor_igual) {
		mayor_igual.arg0().procesa(this);
		mayor_igual.arg1().procesa(this);
	}

	public void procesa(Igualdad igualdad) {
		igualdad.arg0().procesa(this);
		igualdad.arg1().procesa(this);
	}

	public void procesa(Distinto distinto) {
		distinto.arg0().procesa(this);
		distinto.arg1().procesa(this);
	}

	public void procesa(Mul mul) {
		mul.arg0().procesa(this);
		mul.arg1().procesa(this);
	}

	public void procesa(Div div) {
		div.arg0().procesa(this);
		div.arg1().procesa(this);
	}

	public void procesa(Mod mod) {
		mod.arg0().procesa(this);
		mod.arg1().procesa(this);
	}

	public void procesa(Menos menos) {
		menos.arg0().procesa(this);
	}

	public void procesa(Not not) {
		not.arg0().procesa(this);
	}

	public void procesa(NumEnt numEnt) {
		
	}

	public void procesa(NumReal numReal) {
		
	}

	public void procesa(Identificador identificador) {
		if(this.contenidoAlguno(identificador.id())) identificador.setVinculo(this.valorAlguno(identificador.id()));
		else System.err.println("El identificador " + identificador.id().toStringErr() + " no está declarado.");
	}

	public void procesa(True true1) {
		
	}

	public void procesa(False false1) {
		
	}

	public void procesa(LIns_1 lIns_1) {
		lIns_1.ins().procesa(this);
	}

	public void procesa(LIns_muchas lIns_muchas) {
		lIns_muchas.lins().procesa(this);
		lIns_muchas.ins().procesa(this);
	}

	public void procesa(LInsV_1 lInsV_1) {
		lInsV_1.ins().procesa(this);
	}

	public void procesa(LInsV_muchas lInsV_muchas) {
		lInsV_muchas.linsv().procesa(this);
		lInsV_muchas.ins().procesa(this);
	}

	public void procesa(InsAsignacion insAsignacion) {
		insAsignacion.exp1().procesa(this);
		insAsignacion.exp2().procesa(this);
	}

	public void procesa(InsRead insRead) {
		insRead.exp1().procesa(this);
	}

	public void procesa(InsWrite insWrite) {
		insWrite.exp1().procesa(this);
	}

	public void procesa(InsNew insNew) {
		insNew.exp1().procesa(this);
	}

	public void procesa(InsDelete insDelete) {
		insDelete.exp1().procesa(this);
	}

	public void procesa(InsNL insNL) {
		
	}

	public void procesa(InsBloque insBloque) {
		this.puntero++;
		this.tablaSimbolos.add(new HashMap<StringLocalizado, Dec>());
		if(insBloque.bloque().programa() != null) insBloque.bloque().programa().procesa(this);
		this.tablaSimbolos.pop();
		this.puntero--;
	}

	public void procesa(InsIf insIf) {
		insIf.exp1().procesa(this);
		if (insIf.linsv() != null) insIf.linsv().procesa(this);
	}

	public void procesa(InsIfElse insIfElse) {
		insIfElse.exp1().procesa(this);
		if(insIfElse.linsv1() != null) insIfElse.linsv1().procesa(this);
		if(insIfElse.linsv2() != null) insIfElse.linsv2().procesa(this);
	}

	public void procesa(InsWhile insWhile) {
		insWhile.exp1().procesa(this);
		if(insWhile.linsv() != null) insWhile.linsv().procesa(this);
	}

	public void procesa(LParamsReales_1 lParamsReales_1) {
		lParamsReales_1.exp1().procesa(this);
	}

	public void procesa(LParamsReales_muchos lParamsReales_muchos) {
		lParamsReales_muchos.lparamsreales().procesa(this);
		lParamsReales_muchos.exp1().procesa(this);
	}

	public void procesa(Index index) {
		index.exp1().procesa(this);
		index.exp2().procesa(this);
	}

	public void procesa(AccessRegPunto accessRegPunto) {
		accessRegPunto.exp1().procesa(this);
		Identificador identificadorAux = (Identificador) accessRegPunto.exp1();
		if (contenidoAlguno(identificadorAux.id())) {
			if (((DecConTipo) identificadorAux.getVinculo()).tipo().getTipoTipo() == TipoEnum.RECORD) {
				if (buscaIdEnCampos(accessRegPunto.id(), ((Tipo_record) ((DecConTipo) identificadorAux.getVinculo()).tipo()).lcampos())) {

				} 
				else System.err.println("El campo " + accessRegPunto.id().toStringErr() + " no esta definido para el tipo" + ((DecVar) identificadorAux.getVinculo()).tipo());
			} 
			else if (((DecConTipo) identificadorAux.getVinculo()).tipo().getTipoTipo() == TipoEnum.ID && ref(((DecConTipo) identificadorAux.getVinculo()).tipo()) == TipoEnum.RECORD) {
				
				if (buscaIdEnCampos(accessRegPunto.id(), ((Tipo_record) refNodo(((DecConTipo) identificadorAux.getVinculo()).tipo())).lcampos())) {
					
				}
				else System.err.println("El campo " + accessRegPunto.id().toStringErr() + " no esta definido para el tipo " + ((DecConTipo) identificadorAux.getVinculo()).tipo());
			} 
			else System.err.println("La variable " + identificadorAux.toString() + " no es de tipo estructura y por tanto no se puede realizar esta operación.");
		} 
		else System.err.println("La variable " + identificadorAux.id().toStringErr() + " no esta definida.");
	}

	public void procesa(AccessRegFlecha accessRegFlecha) {
		accessRegFlecha.exp1().procesa(this);
	}

	public void procesa(Indireccion indireccion) {
		indireccion.exp1().procesa(this);
	}

	public void procesa(Cadena cadena) {
		
	}

	public void procesa(Null null1) {
		
	}

	/**************************** FASE 1 ****************************/
	
	public void vincula_fase1(LDecs ldecs) {
		if (ldecs instanceof LDecs_1) {
			LDecs_1 ldecsAux = (LDecs_1)ldecs;
			this.vincula_fase1(ldecsAux.dec());
		}
		else if (ldecs instanceof LDecs_muchas) {
			LDecs_muchas ldecsAux = (LDecs_muchas)ldecs;
			this.vincula_fase1(ldecsAux.ldecs());
			this.vincula_fase1(ldecsAux.dec());
		}
	}
	
	public void vincula_fase1(Dec dec) {
		if (dec instanceof DecVar) {
			DecVar decAux = (DecVar)dec;
			this.vincula_fase1(decAux.tipo());
			this.recolecta(decAux.id(), decAux);
		}
		else if (dec instanceof DecType) {
			DecType decAux = (DecType)dec;
			this.vincula_fase1(decAux.tipo());
			this.recolecta(decAux.id(), decAux);
		}
		else if (dec instanceof DecProc) {
			DecProc decAux = (DecProc)dec;
			this.recolecta(decAux.id(), decAux);
		}
	}
	
	private void vincula_fase1(Tipo tipo) {
		if (tipo instanceof Tipo_array) {
			Tipo_array tipoAux = (Tipo_array)tipo;
			this.vincula_fase1(tipoAux.tipo());
		}
		else if (tipo instanceof Tipo_record) {
			Tipo_record tipoAux = (Tipo_record)tipo;
			this.vincula_fase1(tipoAux.lcampos());
		}
		else if (tipo instanceof Tipo_id) {
			Tipo_id tipoAux = (Tipo_id) tipo;
			if (contenidoAlguno(tipoAux.id())) tipoAux.setVinculo(valorAlguno(tipoAux.id()));
			//CAMBIAR ERROR
	        else {
	        	System.err.println("Error:  El id " + tipoAux.id().toStringErr() + " no ha sido declarado");
	        }
		}
		else if (tipo instanceof Tipo_pointer) {
			Tipo_pointer tipoAux = (Tipo_pointer)tipo;
			if(tipoAux.tipo().getTipoTipo() != TipoEnum.ID) this.vincula_fase1(tipoAux.tipo());
		}
	}
	
	public void vincula_fase1(LParams lparams) {
		if(lparams instanceof LParams_1) {
			LParams_1 lparamsAux = (LParams_1)lparams;
			this.vincula_fase1(lparamsAux.param());
		}
		else if (lparams instanceof LParams_muchos) {
			LParams_muchos lparamsAux = (LParams_muchos)lparams;
			this.vincula_fase1(lparamsAux.lparams());
			this.vincula_fase1(lparamsAux.param());
		}
	}
	
	public void vincula_fase1(Param param) {
		this.vincula_fase1(param.tipo());
	}
	
	public void vincula_fase1(LCampos lcampos) {
		if(lcampos instanceof LCampos_1) {
			LCampos_1 lcamposAux = (LCampos_1)lcampos;
			this.vincula_fase1(lcamposAux.campo());
		}
		else if (lcampos instanceof LCampos_muchos) {
			LCampos_muchos lcamposAux = (LCampos_muchos)lcampos;
			this.vincula_fase1(lcamposAux.lcampos());
			this.vincula_fase1(lcamposAux.campo());
		}
	}
	
	public void vincula_fase1(Campo campo) {
		this.vincula_fase1(campo.tipo());
	}
	
	/**************************** FASE 2 ****************************/
	
	public void vincula_fase2(LDecs ldecs) {
		if (ldecs instanceof LDecs_1) {
			LDecs_1 ldecsAux = (LDecs_1)ldecs;
			this.vincula_fase2(ldecsAux.dec());
		}
		else if (ldecs instanceof LDecs_muchas) {
			LDecs_muchas ldecsAux = (LDecs_muchas)ldecs;
			this.vincula_fase2(ldecsAux.ldecs());
			this.vincula_fase2(ldecsAux.dec());
		}
	}
	
	public void vincula_fase2(Dec dec) {
		if (dec instanceof DecVar) {
			DecVar decAux = (DecVar)dec;
			this.vincula_fase2(decAux.tipo());
		}
		else if (dec instanceof DecType) {
			DecType decAux = (DecType)dec;
			this.vincula_fase2(decAux.tipo());
		}
		else if (dec instanceof DecProc) {
			puntero++;
			tablaSimbolos.push(new HashMap<StringLocalizado, Dec>());
			DecProc decAux = (DecProc)dec;
			if (decAux.lparams() != null) {
				this.vincula_fase1(decAux.lparams());
				this.vincula_fase2(decAux.lparams());
				if(decAux.bloque().programa() != null) this.procesa(decAux.bloque().programa());
			}
			else {
				if(decAux.bloque().programa() != null) this.procesa(decAux.bloque().programa());
			}
			tablaSimbolos.pop();
			puntero--;
		}
	}
	
	private void vincula_fase2(Tipo tipo) {
		if (tipo instanceof Tipo_array) {
			Tipo_array tipoAux = (Tipo_array)tipo;
			this.vincula_fase2(tipoAux.tipo());
		}
		else if (tipo instanceof Tipo_record) {
			Tipo_record tipoAux = (Tipo_record)tipo;
			this.vincula_fase2(tipoAux.lcampos());
		}
		else if (tipo instanceof Tipo_pointer) {
			Tipo_pointer tipoAux = (Tipo_pointer) tipo;
			if(tipoAux.tipo().getTipoTipo() == TipoEnum.ID) {
				Tipo_id tipoAuxAux = (Tipo_id) tipoAux.tipo();
				if(this.contenidoAlguno(tipoAuxAux.id())) tipoAux.setVinculo(this.valorAlguno(tipoAuxAux.id()));
				//CAMBIAR ERROR
		        else System.err.println("Error:  El id " + tipoAuxAux.id().toStringErr() + " no ha sido declarado");
			}
		}
	}
	
	public void vincula_fase2(LParams lparams) {
		if(lparams instanceof LParams_1) {
			LParams_1 lparamsAux = (LParams_1)lparams;
			this.vincula_fase2(lparamsAux.param());
		}
		else if (lparams instanceof LParams_muchos) {
			LParams_muchos lparamsAux = (LParams_muchos)lparams;
			this.vincula_fase2(lparamsAux.lparams());
			this.vincula_fase2(lparamsAux.param());
		}
	}
	
	public void vincula_fase2(Param param) {
		if (param.ref() != null) {
			this.vincula_fase2(param.tipo());
			this.recoletaParams(param.id(), param.tipo());
		}
		else {
			this.vincula_fase1(param.tipo());
			this.recoletaParams(param.id(), param.tipo());
		}
	}

	public void vincula_fase2(LCampos lcampos) {
		if(lcampos instanceof LCampos_1) {
			LCampos_1 lcamposAux = (LCampos_1)lcampos;
			this.vincula_fase2(lcamposAux.campo());
		}
		else if (lcampos instanceof LCampos_muchos) {
			LCampos_muchos lcamposAux = (LCampos_muchos)lcampos;
			this.vincula_fase2(lcamposAux.lcampos());
			this.vincula_fase2(lcamposAux.campo());
		}
	}
	
	public void vincula_fase2(Campo campo) {
		this.vincula_fase2(campo.tipo());
	}
	
	/**************************** AUXILIARES ************************/
	
	private boolean contenidoAlguno(StringLocalizado id) {
		for (int i = puntero; i >= 0; i--)
			if (tablaSimbolos.get(i).containsKey(id))
				return true;
		return false;
	}

	private Dec valorAlguno(StringLocalizado id) {
		Dec temp;
		for (int i = puntero; i >= 0; i--) {
			temp = tablaSimbolos.get(i).get(id);
			if (temp != null)
				return temp;
		}
		return null;
	}
	
	private void recolecta(StringLocalizado id, Dec dec) {
		if (tablaSimbolos.lastElement().containsKey(id)) {
			System.err.println("El identificador " + id.toStringErr() + " ya ha sido declarado.");
		} else {
			tablaSimbolos.lastElement().put(id, dec);
		}
	}
	
	private void recoletaParams(StringLocalizado id, Tipo tipo) {
		if(tablaSimbolos.lastElement().containsKey(id)) {
			System.err.println("El identificador " + id.toStringErr() + " ya ha sido declarado.");
		}
		else {
			DecVar decAux = new DecVar(tipo, id);
			tablaSimbolos.lastElement().put(id, decAux);
		}
	}
	
	private TipoEnum ref(Tipo tipo) {
		while (true) {
			if (tipo.getVinculo().tipoDec() == DecEnum.TYPE)
				tipo = ((DecConTipo) tipo.getVinculo()).tipo();
			else {
				System.err.println("Tipo incorrecto para " + tipo.toString() + ".");
				return TipoEnum.ERROR;
			}
			if (tipo.getTipoTipo() != TipoEnum.ID)
				return tipo.getTipoTipo();
		}
	}
	
	private Tipo refNodo(Tipo tipo) {
		while(true) {
			if (tipo.getVinculo().tipoDec() == DecEnum.TYPE) {
				tipo = ((DecConTipo) tipo.getVinculo()).tipo();
			}
			else System.err.println("Tipo incorrecto para " + tipo.toString() + ".");
			if(tipo.getTipoTipo() != TipoEnum.ID) return tipo;
		}
	}
	
	private boolean buscaIdEnCampos(StringLocalizado id, LCampos lcampos) {
		if(lcampos.getTipoLCampos() == LCamposEnum.SIMPLE) {
			if (((LCampos_1)lcampos).campo().id().toString().equals(id.toString())) return true;
		}
		else if (lcampos.getTipoLCampos() == LCamposEnum.COMPUESTA) {
			if (((LCampos_muchos)lcampos).campo().id().toString().equals(id.toString())) return true;
			return buscaIdEnCampos(id, ((LCampos_muchos)lcampos).lcampos());
		}
		return false;
	}
	
}