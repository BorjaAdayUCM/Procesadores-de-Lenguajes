package procesamientos;

import java.util.ArrayList;
import java.util.HashMap;

import analizadorSintactico.AnalizadorSintacticoTiny1.AccessReg;
import analizadorSintactico.AnalizadorSintacticoTiny1.AccessRegFlecha;
import analizadorSintactico.AnalizadorSintacticoTiny1.AccessRegPunto;
import analizadorSintactico.AnalizadorSintacticoTiny1.And;
import analizadorSintactico.AnalizadorSintacticoTiny1.Cadena;
import analizadorSintactico.AnalizadorSintacticoTiny1.Campo;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecConTipo;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecEnum;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecProc;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecType;
import analizadorSintactico.AnalizadorSintacticoTiny1.DecVar;
import analizadorSintactico.AnalizadorSintacticoTiny1.Distinto;
import analizadorSintactico.AnalizadorSintacticoTiny1.Div;
import analizadorSintactico.AnalizadorSintacticoTiny1.Exp;
import analizadorSintactico.AnalizadorSintacticoTiny1.ExpBin;
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
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LDecs_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LInsV_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LInsV_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LIns_1;
import analizadorSintactico.AnalizadorSintacticoTiny1.LIns_muchas;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParams;
import analizadorSintactico.AnalizadorSintacticoTiny1.LParamsReales;
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
import analizadorSintactico.AnalizadorSintacticoTiny1.Nodo;
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
import analizadorSintactico.AnalizadorSintacticoTiny1.TipoExpEnum;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_array;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_bool;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_id;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_int;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_pointer;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_real;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_record;
import analizadorSintactico.AnalizadorSintacticoTiny1.Tipo_string;
import analizadorSintactico.AnalizadorSintacticoTiny1.True;

public class ComprobacionTipos extends ProcesamientoPorDefecto {

	public ComprobacionTipos() {
		new HashMap<Nodo, Nodo>();
	}
	
	public void procesa(Programa programa) {
		if (programa.ldecs() == null) {
			programa.lins().procesa(this);
			programa.setTipoNodo(programa.lins().getTipoNodo());
		} else {
			programa.ldecs().procesa(this);
			programa.lins().procesa(this);
			if(programa.ldecs().getTipoNodo() != TipoEnum.ERROR && programa.lins().getTipoNodo() != TipoEnum.ERROR) programa.setTipoNodo(TipoEnum.OK);
			else programa.setTipoNodo(TipoEnum.OK);
		}
	}
	
	private void setTipoExpAritmetica(ExpBin exp) {
		if (ref(exp.arg0()) == TipoEnum.INT && ref(exp.arg1()) == TipoEnum.INT)
			exp.setTipoNodo(TipoEnum.INT);
		else if ((ref(exp.arg0()) == TipoEnum.REAL || ref(exp.arg0()) == TipoEnum.INT) && (ref(exp.arg1()) == TipoEnum.REAL || ref(exp.arg1()) == TipoEnum.INT))
			exp.setTipoNodo(TipoEnum.REAL);
		else {
			System.err.println("Las expresiones " + exp.arg0() + " y " + exp.arg1() + " deben ser de tipo entero o real");
			exp.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(Suma suma) {
		suma.arg0().procesa(this);
		suma.arg1().procesa(this);
		this.setTipoExpAritmetica(suma);
	}

	public void procesa(Resta resta) {
		resta.arg0().procesa(this);
		resta.arg1().procesa(this);
		this.setTipoExpAritmetica(resta);
	}
	
	public void procesa(Mul mul) {
		mul.arg0().procesa(this);
		mul.arg1().procesa(this);
		this.setTipoExpAritmetica(mul);
	}

	public void procesa(Div div) {
		div.arg0().procesa(this);
		div.arg1().procesa(this);
		this.setTipoExpAritmetica(div);
	}

	public void procesa(Mod mod) {
		mod.arg0().procesa(this);
		mod.arg1().procesa(this);
		this.setTipoExpAritmetica(mod);
	}
	
	public void procesa(Menos menos) {
		menos.arg0().procesa(this);
		if (ref(menos.arg0()) == TipoEnum.INT) menos.setTipoNodo(TipoEnum.INT);
		else if (ref(menos.arg0()) == TipoEnum.REAL) menos.setTipoNodo(TipoEnum.REAL);
		else {
			System.err.println("La expresion " + menos.arg0() + " debe ser de tipo Int o Real.");
			menos.setTipoNodo(TipoEnum.ERROR);
		}
	}
	
	private void setTipoExpLogica(ExpBin exp) {
		if (ref(exp.arg0()) == TipoEnum.BOOL && ref(exp.arg1()) == TipoEnum.BOOL)
			exp.setTipoNodo(TipoEnum.BOOL);
		else {
			System.out.println("Las expresiones " + exp.arg0() + " y " + exp.arg1() + " deben ser de tipo Bool");
			exp.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(And and) {
		and.arg0().procesa(this);
		and.arg1().procesa(this);
		this.setTipoExpLogica(and);
	}

	public void procesa(Or or) {
		or.arg0().procesa(this);
		or.arg1().procesa(this);
		this.setTipoExpLogica(or);
	}
	
	public void procesa(Not not) {
		not.arg0().procesa(this);
		if(ref(not.arg0()) == TipoEnum.BOOL) not.setTipoNodo(TipoEnum.BOOL);
		else {
			System.err.println("La expresion " + not.arg0() + " debe ser de tipo Bool");
			not.setTipoNodo(TipoEnum.ERROR);
		}
	}
	
	private void setTipoExpRelacional (ExpBin exp) {
		if ((ref(exp.arg0()) == TipoEnum.INT || ref(exp.arg0()) == TipoEnum.REAL) && (ref(exp.arg1()) == TipoEnum.INT || ref(exp.arg1()) == TipoEnum.REAL)) exp.setTipoNodo(TipoEnum.BOOL);
		else if (ref(exp.arg0()) == TipoEnum.BOOL && ref(exp.arg1()) == TipoEnum.BOOL) exp.setTipoNodo(TipoEnum.BOOL);
		else if (ref(exp.arg0()) == TipoEnum.STRING && ref(exp.arg1()) == TipoEnum.STRING) exp.setTipoNodo(TipoEnum.BOOL);
		else if (exp.getTipoExp() == TipoExpEnum.IGUALDAD || exp.getTipoExp() == TipoExpEnum.DESIGUALDAD) {
			if (ref(exp.arg0()) == TipoEnum.POINTER && ref(exp.arg1()) == TipoEnum.POINTER) exp.setTipoNodo(TipoEnum.BOOL); 
			else if (ref(exp.arg0()) == TipoEnum.NULL && ref(exp.arg1()) == TipoEnum.NULL) exp.setTipoNodo(TipoEnum.BOOL);
			else if ((ref(exp.arg0()) == TipoEnum.NULL && ref(exp.arg1()) == TipoEnum.POINTER) || (ref(exp.arg0()) == TipoEnum.POINTER && ref(exp.arg1()) == TipoEnum.NULL)) exp.setTipoNodo(TipoEnum.BOOL);
			else exp.setTipoNodo(TipoEnum.ERROR);
		} else {
			System.err.println("Las expresiones " + exp.arg0() + " y " + exp.arg1() + " deben ser de tipos compatibles.");
			exp.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(Menor menor) {
		menor.arg0().procesa(this);
		menor.arg1().procesa(this);
		setTipoExpRelacional(menor);
		
	}

	public void procesa(Mayor mayor) {
		mayor.arg0().procesa(this);
		mayor.arg1().procesa(this);
		setTipoExpRelacional(mayor);
	}

	public void procesa(Menor_igual menor_igual) {
		menor_igual.arg0().procesa(this);
		menor_igual.arg1().procesa(this);
		setTipoExpRelacional(menor_igual);
	}

	public void procesa(Mayor_igual mayor_igual) {
		mayor_igual.arg0().procesa(this);
		mayor_igual.arg1().procesa(this);
		setTipoExpRelacional(mayor_igual);
	}

	public void procesa(Igualdad igualdad) {
		igualdad.arg0().procesa(this);
		igualdad.arg1().procesa(this);
		setTipoExpRelacional(igualdad);
	}

	public void procesa(Distinto distinto) {
		distinto.arg0().procesa(this);
		distinto.arg1().procesa(this);
		setTipoExpRelacional(distinto);
	}
	
	public void procesa(Cadena cadena) {
		cadena.setTipoNodo(TipoEnum.STRING);
	}

	public void procesa(Null null1) {
		null1.setTipoNodo(TipoEnum.NULL);
	}

	public void procesa(NumEnt numEnt) {
		numEnt.setTipoNodo(TipoEnum.INT);
	}

	public void procesa(NumReal numReal) {
		numReal.setTipoNodo(TipoEnum.REAL);
	}

	public void procesa(Identificador identificador) {
		if (identificador.getVinculo().tipoDec() == DecEnum.VAR) {
			identificador.setTipoNodo(((DecConTipo) identificador.getVinculo()).tipo().getTipoTipo());
		} else {
			System.out.println("El identificador " + identificador.id() + " no es una variable.");
			identificador.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(True true1) {
		true1.setTipoNodo(TipoEnum.BOOL);
	}

	public void procesa(False false1) {
		false1.setTipoNodo(TipoEnum.BOOL);
	}

	public void procesa(Tipo_int tipo_int) {
		tipo_int.setTipoNodo(TipoEnum.INT);
	}

	public void procesa(Tipo_bool tipo_bool) {
		tipo_bool.setTipoNodo(TipoEnum.BOOL);
	}

	public void procesa(Tipo_real tipo_real) {
		tipo_real.setTipoNodo(TipoEnum.REAL);
	}
	
	public void procesa(Tipo_string tipo_string) {
		tipo_string.setTipoNodo(TipoEnum.STRING);
	}

	public void procesa(DecVar decVar) {
		decVar.tipo().procesa(this);
		if (decVar.tipo().getTipoNodo() != TipoEnum.ERROR) decVar.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error de tipo en la declaracion de variable " + decVar.id().toStringErr() + ".");
		}
	}

	public void procesa(DecType decType) {
		decType.tipo().procesa(this);
		if (decType.tipo().getTipoNodo() != TipoEnum.ERROR) decType.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error de tipo en la declaracion de tipo " + decType.id().toStringErr() + ".");
		}
	}

	//LOS TIPOS DE LOS BLOQUES ASOCIADOS A TODOS LOS PROCEDIMIENTOS SON SIEMPRE OK???????????????
	public void procesa(DecProc decProc) {
		if (decProc.lparams() != null  && decProc.bloque().programa() != null) {
			decProc.lparams().procesa(this);
			decProc.bloque().programa().procesa(this);
			if(decProc.lparams().getTipoNodo() == TipoEnum.OK && decProc.bloque().programa().getTipoNodo() == TipoEnum.OK) decProc.setTipoNodo(TipoEnum.OK);
			else {
				System.err.println("Error en la declaración del procedimiento " + decProc.id().toStringErr() + ".");
				decProc.setTipoNodo(TipoEnum.ERROR);
			}
		}
		else if (decProc.lparams() != null  && decProc.bloque().programa() == null) {
			decProc.lparams().procesa(this);
			if(decProc.lparams().getTipoNodo() == TipoEnum.OK) decProc.setTipoNodo(TipoEnum.OK);
			else {
				System.err.println("Error en la declaración del procedimiento " + decProc.id().toStringErr() + ".");
				decProc.setTipoNodo(TipoEnum.ERROR);
			}
		}
		else if (decProc.lparams() == null  && decProc.bloque().programa() != null) {
			decProc.bloque().programa().procesa(this);
			if(decProc.bloque().programa().getTipoNodo() == TipoEnum.OK) decProc.setTipoNodo(TipoEnum.OK);
			else {
				System.err.println("Error en la declaración del procedimiento " + decProc.id().toStringErr() + ".");
				decProc.setTipoNodo(TipoEnum.ERROR);
			}
		}
		else {
			decProc.setTipoNodo(TipoEnum.OK);
		}
	}

	public void procesa(LDecs_1 lDecs_1) {
		lDecs_1.dec().procesa(this);
		if(lDecs_1.dec().getTipoNodo() == TipoEnum.OK) lDecs_1.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en la declaracion " + lDecs_1.dec().id().toStringErr() + ".");
			lDecs_1.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(LDecs_muchas lDecs_muchas) {
		lDecs_muchas.ldecs().procesa(this);
		lDecs_muchas.dec().procesa(this);
		if(lDecs_muchas.dec().getTipoNodo() == TipoEnum.OK && lDecs_muchas.ldecs().getTipoNodo() == TipoEnum.OK) lDecs_muchas.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en la declaracion " + lDecs_muchas.dec().id().toStringErr() + ".");
			lDecs_muchas.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(LIns_1 lIns_1) {
		lIns_1.ins().procesa(this);
		lIns_1.setTipoNodo(lIns_1.ins().getTipoNodo());
	}

	public void procesa(LIns_muchas lIns_muchas) {
		lIns_muchas.lins().procesa(this);
		lIns_muchas.ins().procesa(this);
		if(lIns_muchas.lins().getTipoNodo() == TipoEnum.OK && lIns_muchas.ins().getTipoNodo() == TipoEnum.OK) lIns_muchas.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en la instrucccion " + lIns_muchas.ins().toString());
			lIns_muchas.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(LInsV_1 lInsV_1) {
		lInsV_1.ins().procesa(this);
		lInsV_1.setTipoNodo(lInsV_1.ins().getTipoNodo());
	}

	public void procesa(LInsV_muchas lInsV_muchas) {
		lInsV_muchas.linsv().procesa(this);
		lInsV_muchas.ins().procesa(this);
		if(lInsV_muchas.linsv().getTipoNodo() == TipoEnum.OK && lInsV_muchas.ins().getTipoNodo() == TipoEnum.OK) lInsV_muchas.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en la instrucccion " + lInsV_muchas.ins().toString());
			lInsV_muchas.setTipoNodo(TipoEnum.ERROR);
		}
	}
	
	public void procesa(InsCall insCall) {
		if(insCall.lparamsreales() == null) {
			if(((DecProc) insCall.getVinculo()).lparams() == null) insCall.setTipoNodo(TipoEnum.OK);
			else {
				System.err.println("Faltan los argumentos para el proceso " + insCall.id().toStringErr() + ".");
				insCall.setTipoNodo(TipoEnum.ERROR);
			}
		}
		else if(insCall.lparamsreales() != null) {
			insCall.lparamsreales().procesa(this);
			if(((DecProc) insCall.getVinculo()).lparams() != null) {
				DecProc nodo = (DecProc) insCall.getVinculo();
				if (cuentaParamsReales(insCall.lparamsreales()) == cuentaParamsReales(nodo.lparams())) {
					if (compatibleParamsFormalesReales(insCall.lparamsreales(), nodo.lparams())) {
						new HashMap<Nodo, Nodo>();
						insCall.setTipoNodo(TipoEnum.OK);
					} else {
						new HashMap<Nodo, Nodo>();
						insCall.setTipoNodo(TipoEnum.ERROR);
						System.err.println("Los argumentos de la llamada en " + insCall.id().toStringErr() + " no coinciden con los de la declaracion del proceso.");
					}
				} else {
					insCall.setTipoNodo(TipoEnum.ERROR);
					System.err.println("El numero de argumentos de la llamada a " + insCall.id().toStringErr() + " es incorrecto.");
				}
			}
			else {
				System.err.println("La llamada a " + insCall.id().toStringErr() + " no acepta argumetos.");
				insCall.setTipoNodo(TipoEnum.ERROR);
			}
		}
	}

	public void procesa(InsAsignacion insAsignacion) {
		insAsignacion.exp1().procesa(this);
		insAsignacion.exp2().procesa(this);
		
		if (compatible(insAsignacion.exp1(), insAsignacion.exp2())) {
			new HashMap<Nodo, Nodo>();
			if (insAsignacion.exp1().esDesignador())
				insAsignacion.setTipoNodo(TipoEnum.OK);
			else {
				insAsignacion.setTipoNodo(TipoEnum.ERROR);
				System.out.println("La expresion " + insAsignacion.exp1() + " debe ser un designador");
			}
		} else {
			new HashMap<Nodo, Nodo>();
			insAsignacion.setTipoNodo(TipoEnum.ERROR);
			System.out.println("Los tipos de las expresiones no son compatibles.");
		}
	}

	public void procesa(InsRead insRead) {
		insRead.exp1().procesa(this);
		if (ref(insRead.exp1()) == TipoEnum.INT || ref(insRead.exp1()) == TipoEnum.REAL || ref(insRead.exp1()) == TipoEnum.STRING) {
			if (insRead.exp1().esDesignador()) insRead.setTipoNodo(TipoEnum.OK);
			else {
				insRead.setTipoNodo(TipoEnum.ERROR);
				System.out.println("La expresion " + insRead.exp1() + " debe ser un designador.");
			}
		} else {
			insRead.setTipoNodo(TipoEnum.ERROR);
			System.err.println("La expresion " + insRead.exp1() + " debe ser de tipo Real, Int o String");
		}
	}

	public void procesa(InsWrite insWrite) {
		insWrite.exp1().procesa(this);
		if (ref(insWrite.exp1()) == TipoEnum.INT || ref(insWrite.exp1()) == TipoEnum.BOOL || ref(insWrite.exp1()) == TipoEnum.REAL || ref(insWrite.exp1()) == TipoEnum.STRING) insWrite.setTipoNodo(TipoEnum.OK);
		else {
			insWrite.setTipoNodo(TipoEnum.ERROR);
			System.err.println("La expresion " + insWrite.exp1() + " debe ser de tipo Real, Intero, Bool o String");
		}
	}

	public void procesa(InsNew insNew) {
		insNew.exp1().procesa(this);
		if (ref(insNew.exp1()) == TipoEnum.POINTER)
			insNew.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("La expresion " + insNew.exp1() + " debe ser de tipo puntero.");
			insNew.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(InsDelete insDelete) {
		insDelete.exp1().procesa(this);
		if (ref(insDelete.exp1()) == TipoEnum.POINTER)
			insDelete.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("La expresion " + insDelete.exp1() + " debe ser de tipo puntero.");
			insDelete.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(InsNL insNL) {
		insNL.setTipoNodo(TipoEnum.OK);
	}

	public void procesa(InsBloque insBloque) {
		if (insBloque.bloque().programa() != null) {
			insBloque.bloque().programa().procesa(this);
			insBloque.setTipoNodo(insBloque.bloque().programa().getTipoNodo());
		}
		else {
			insBloque.setTipoNodo(TipoEnum.OK);
		}
	}

	public void procesa(InsIf insIf) {
		insIf.exp1().procesa(this);
		if (insIf.linsv() != null) {
			insIf.linsv().procesa(this);
			if (ref(insIf.exp1()) == TipoEnum.BOOL && insIf.linsv().getTipoNodo() == TipoEnum.OK) insIf.setTipoNodo(TipoEnum.OK);
		}
		else {
			if(ref(insIf.exp1()) == TipoEnum.BOOL) insIf.setTipoNodo(TipoEnum.OK);
		}
	}

	public void procesa(InsIfElse insIfElse) {
		insIfElse.exp1().procesa(this);
		if (insIfElse.linsv1() != null && insIfElse.linsv1() != null) {
			insIfElse.linsv1().procesa(this);
			insIfElse.linsv2().procesa(this);
			if (ref(insIfElse.exp1()) == TipoEnum.BOOL && insIfElse.linsv1().getTipoNodo() == TipoEnum.OK && insIfElse.linsv2().getTipoNodo() == TipoEnum.OK) insIfElse.setTipoNodo(TipoEnum.OK);
		}
		else if (insIfElse.linsv1() != null){
			insIfElse.linsv1().procesa(this);
			if(ref(insIfElse.exp1()) == TipoEnum.BOOL && insIfElse.linsv1().getTipoNodo() == TipoEnum.OK) insIfElse.setTipoNodo(TipoEnum.OK);
		}
		else if (insIfElse.linsv2() != null){
			insIfElse.linsv2().procesa(this);
			if(ref(insIfElse.exp1()) == TipoEnum.BOOL && insIfElse.linsv2().getTipoNodo() == TipoEnum.OK) insIfElse.setTipoNodo(TipoEnum.OK);
		}
		else {
			if(ref(insIfElse.exp1()) == TipoEnum.BOOL) insIfElse.setTipoNodo(TipoEnum.OK);
		}
	}

	public void procesa(InsWhile insWhile) {
		insWhile.exp1().procesa(this);
		if (insWhile.linsv() != null) {
			insWhile.linsv().procesa(this);
			if (ref(insWhile.exp1()) == TipoEnum.BOOL && insWhile.linsv().getTipoNodo() == TipoEnum.OK) insWhile.setTipoNodo(TipoEnum.OK);
		}
		else {
			if(ref(insWhile.exp1()) == TipoEnum.BOOL) insWhile.setTipoNodo(TipoEnum.OK);
		}
	}

	public void procesa(LParams_1 lParams_1) {
		lParams_1.param().procesa(this);
		lParams_1.setTipoNodo(lParams_1.param().getTipoNodo());
	}

	public void procesa(LParams_muchos lParams_muchos) {
		lParams_muchos.lparams().procesa(this);
		lParams_muchos.param().procesa(this);
		if(lParams_muchos.param().getTipoNodo() == TipoEnum.OK && lParams_muchos.lparams().getTipoNodo() == TipoEnum.OK) lParams_muchos.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en el argumento " + lParams_muchos.param().id().toStringErr() + ".");
			lParams_muchos.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(Param param) {
		if (param.id().toString().equals("nombres")) {
			System.out.println();
		}
		param.tipo().procesa(this);
		//if(param.tipo().getTipoNodo() == TipoEnum.OK) param.setTipoNodo(TipoEnum.OK);
		if(param.tipo().getTipoNodo() != TipoEnum.ERROR) param.setTipoNodo(TipoEnum.OK);
		else {
			param.setTipoNodo(TipoEnum.ERROR);
			System.err.println("Error en el parametro " +  param.id().toStringErr() + ".");
		}
	}

	public void procesa(LParamsReales_1 lParamsReales_1) {
		lParamsReales_1.exp1().procesa(this);
		if(lParamsReales_1.exp1().getTipoNodo() == TipoEnum.OK) lParamsReales_1.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en el argumento " + lParamsReales_1.exp1().toString() + ".");
			lParamsReales_1.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(LParamsReales_muchos lParamsReales_muchos) {
		lParamsReales_muchos.lparamsreales().procesa(this);
		lParamsReales_muchos.exp1().procesa(this);
		if(lParamsReales_muchos.exp1().getTipoNodo() == TipoEnum.OK && lParamsReales_muchos.lparamsreales().getTipoNodo() == TipoEnum.OK) lParamsReales_muchos.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en el argumento " + lParamsReales_muchos.exp1() + ".");
			lParamsReales_muchos.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(Index index) {
		index.exp1().procesa(this);
		index.exp2().procesa(this);
		if (index.exp2().getTipoNodo() == TipoEnum.INT) {
			if (ref(index.exp1()) == TipoEnum.ARRAY) {
				if (index.exp1().getTipoExp() == TipoExpEnum.PUNTO || index.exp1().getTipoExp() == TipoExpEnum.FLECHA) {
					Tipo nodo = refNodo(((DecConTipo) ((AccessReg) index.exp1()).exp1().getVinculo()).tipo());
					Tipo nodo2 = tipoCampos(((Tipo_record)nodo).lcampos(), ((Identificador) index.exp1()).id());
					index.setTipoNodo(ref(((Tipo_array) nodo2).tipo()));
				} else {
					Tipo nodo = refNodo(index.exp1());
					index.setTipoNodo(ref(((Tipo_array) nodo).tipo()));
				}

			} else {
				index.setTipoNodo(TipoEnum.ERROR);
				System.err.println("El tipo de la expresion " + index.exp1() + " no es de tipo array.");
			}
		} else {
			index.setTipoNodo(TipoEnum.ERROR);
			System.err.println("La variable " + index.exp2() + " debe ser un numero entero.");
		}
	}

	public void procesa(AccessRegPunto accessRegPunto) {
		accessRegPunto.exp1().procesa(this);
		if (ref(accessRegPunto.exp1()) == TipoEnum.RECORD) {
			Tipo nodo = refNodo(accessRegPunto.exp1());
			Tipo nodo2 = tipoCampos(((Tipo_record)nodo).lcampos(), accessRegPunto.id());
			accessRegPunto.setTipoNodo(ref(nodo2));
		} else {
			accessRegPunto.setTipoNodo(TipoEnum.ERROR);
			System.err.println("La expresion " + accessRegPunto.exp1() + " debe ser de tipo record.");
		}
	}

	public void procesa(AccessRegFlecha accessRegFlecha) {
		accessRegFlecha.exp1().procesa(this);
		if (ref(accessRegFlecha.exp1()) == TipoEnum.POINTER) {
			Exp temp = accessRegFlecha.exp1();

			while (temp.getVinculo() == null) {
				temp = ((AccessReg) temp).exp1();
			}
			Tipo nodo = refNodo(temp);
			if (ref(((DecConTipo) nodo.getVinculo()).tipo()) == TipoEnum.RECORD) {
				Tipo nodo2 = refNodo(nodo);
				Tipo nodo3 = tipoCampos(((Tipo_record) nodo2).lcampos(), accessRegFlecha.id());
				accessRegFlecha.setTipoNodo(ref(nodo3));
			} else {
				accessRegFlecha.setTipoNodo(TipoEnum.ERROR);
				System.out.println("El tipo " + nodo + " no es de tipo record.");
			}
		} else {
			accessRegFlecha.setTipoNodo(TipoEnum.ERROR);
			System.err.println("La expresion " + accessRegFlecha.exp1() + " no es un variable del tipo puntero.");
		}
	}

	public void procesa(Indireccion indireccion) {
		indireccion.exp1().procesa(this);
		if (ref(indireccion.exp1()) == TipoEnum.POINTER) {
			Tipo nodo = refNodo(indireccion.exp1());
			indireccion.setTipoNodo(ref(((Tipo_pointer) nodo).tipo()));
		} else {
			indireccion.setTipoNodo(TipoEnum.ERROR);
			System.err.println("La expresion " + indireccion.exp1() + " no es de tipo puntero");
		}
	}


	public void procesa(Tipo_id tipo_id) {
		if(ref(tipo_id) != TipoEnum.ERROR) tipo_id.setTipoNodo(TipoEnum.ID);
		else {
			System.err.println("Error en el tipo " + tipo_id.id().toStringErr() + ".");
			tipo_id.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(Tipo_array tipo_array) {
		tipo_array.setTipoNodo(TipoEnum.ARRAY);
	}

	public void procesa(Tipo_pointer tipo_pointer) {
		tipo_pointer.setTipoNodo(TipoEnum.POINTER);
	}

	public void procesa(Campo campo) {
		campo.tipo().procesa(this);
		if(ref(campo.tipo()) != TipoEnum.ERROR) campo.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("El tipo del campo " + campo.id().toStringErr() + " es erroneo.");
			campo.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(LCampos_1 lCampos_1) {
		lCampos_1.campo().procesa(this);
		if(lCampos_1.campo().getTipoNodo() == TipoEnum.OK) lCampos_1.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en el campo " + lCampos_1.campo().id().toStringErr() + ".");
			lCampos_1.setTipoNodo(TipoEnum.ERROR);
		}
		
	}

	public void procesa(LCampos_muchos lCampos_muchos) {
		lCampos_muchos.lcampos().procesa(this);
		lCampos_muchos.campo().procesa(this);
		if(lCampos_muchos.campo().getTipoNodo() == TipoEnum.OK && lCampos_muchos.lcampos().getTipoNodo() == TipoEnum.OK) lCampos_muchos.setTipoNodo(TipoEnum.OK);
		else {
			System.err.println("Error en el campo " + lCampos_muchos.campo().id().toStringErr() + ".");
			lCampos_muchos.setTipoNodo(TipoEnum.ERROR);
		}
	}

	public void procesa(Tipo_record tipo_record) {
		tipo_record.lcampos().procesa(this);
		if (!camposDuplicados(tipo_record.lcampos(), new ArrayList<String>()) && tipo_record.lcampos().getTipoNodo() == TipoEnum.OK) tipo_record.setTipoNodo(TipoEnum.RECORD);
		else {
			System.out.println("El tipo compuesto " + tipo_record.toString() + " tiene campos duplicados");
			tipo_record.setTipoNodo(TipoEnum.ERROR);
		}
	}

	private TipoEnum ref(Nodo nodo) {
		if (nodo.getTipoNodo() != TipoEnum.ID) return nodo.getTipoNodo();
		Tipo temp = ((DecConTipo) nodo.getVinculo()).tipo();
		while (true) {
			if (temp.getTipoTipo() != TipoEnum.ID) return temp.getTipoTipo();
			if (temp.getVinculo().tipoDec() == DecEnum.TYPE) temp = ((DecConTipo)temp.getVinculo()).tipo();
			else {
				System.err.println("Tipo incorrecto para " + nodo.toString() + ".");
				return TipoEnum.ERROR;
			}
		}
	}
	
	private Tipo refNodo(Nodo nodo) {
		if (nodo.getTipoNodo() != TipoEnum.ID) return ((DecConTipo) nodo.getVinculo()).tipo();
		Tipo temp = ((DecConTipo) nodo.getVinculo()).tipo();
		while (true) {
			if (temp.getTipoTipo() != TipoEnum.ID) return temp;
			if (temp.getVinculo().tipoDec() == DecEnum.TYPE) temp = ((DecConTipo) temp.getVinculo()).tipo();
			else {
				System.err.println("Tipo incorrecto para " + nodo.toString() + ".");
				return null;
			}
		}
	}
	
	private Tipo tipoCampos(LCampos lCampos, StringLocalizado id) {
		if (lCampos.getTipoLCampos() == LCamposEnum.SIMPLE) {
			if (((LCampos_1) lCampos).campo().id().equals(id)) return ((LCampos_1) lCampos).campo().tipo();
			else return null;
		} 
		else {
			if (((LCampos_muchos) lCampos).campo().id().equals(id)) return ((LCampos_muchos) lCampos).campo().tipo();
			else return tipoCampos(((LCampos_muchos) lCampos).lcampos(), id);
		}
	}
	
	private int cuentaParamsReales(LParams lParams) {
		return 0;
	}
	
	private int cuentaParamsReales(LParamsReales lparamsreales) {
		return 0;
	}

	private boolean compatibleParamsFormalesReales(LParamsReales lparamsreales, LParams lparams) {
		return true;
	}

	private boolean compatible(Nodo nodo1, Nodo nodo2) {
		return true;
	}
	
	
	
	private boolean camposDuplicados(LCampos lcampos, ArrayList<String> arrayList) {
		return false;
	}
	
}