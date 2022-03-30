package analizadorSintactico;

import procesamientos.Procesamiento;

public class AnalizadorSintacticoTiny1 {
	
	public static abstract class Nodo {
		
		private Dec vinculo;
		private TipoEnum tipoNodo;
		
		public Nodo()
		{
			vinculo = null;
		}
		
		public Dec getVinculo() {
			return vinculo;
		}
		
		public void setVinculo(Dec vinculo) {
			this.vinculo = vinculo;
		}
		
		public TipoEnum getTipoNodo() {
			return tipoNodo;
		}
		
		public void setTipoNodo(TipoEnum tipoEnum) {
			this.tipoNodo = tipoEnum;
		}
	}
	
	public enum TipoExpEnum {
		  SUMA, RESTA , AND, OR, IGUALDAD, DESIGUALDAD, MENOR, MAYOR, MENORIGUAL, MAYORIGUAL, 
		  MUL, DIV, MOD, MENOS, NOT, INDEX, PUNTO, FLECHA, INDIR, IDENTIFICADOR, NUMEROENTERO, 
		  NUMEROREAL, STRING, TRUE, FALSE, NULL
		}

	public static abstract class Exp extends Nodo {
		
		public Exp() {
			super();
		}

		public abstract int prioridad();

		public abstract void procesa(Procesamiento procesamiento);
		
		public abstract TipoExpEnum getTipoExp();
		
		public boolean esDesignador() {
			return false;
		}
	}

	public static class StringLocalizado {
		private String s;
		private int fila;
		private int col;

		public StringLocalizado(String s, int fila, int col) {
			this.s = s;
			this.fila = fila;
			this.col = col;
		}

		public int fila() {
			return fila;
		}

		public int col() {
			return col;
		}

		public String toString() {
			return s;
		}
		
		public String toStringErr() {
			return s + "(" + fila + ", " + col + ")";
		}

		public boolean equals(Object o) {
			return (o == this) || ((o instanceof StringLocalizado) && (((StringLocalizado) o).s.equals(s)));
		}

		public int hashCode() {
			return s.hashCode();
		}
	}

	public static abstract class ExpUnaria extends Exp {
		private Exp arg0;

		public Exp arg0() {
			return arg0;
		}

		public ExpUnaria(Exp arg0) {
			super();
			this.arg0 = arg0;
		}
	}

	public static abstract class ExpBin extends Exp {
		private Exp arg0;
		private Exp arg1;

		public Exp arg0() {
			return arg0;
		}

		public Exp arg1() {
			return arg1;
		}

		public ExpBin(Exp arg0, Exp arg1) {
			super();
			this.arg0 = arg0;
			this.arg1 = arg1;
		}
	}

	public static abstract class ExpAditiva extends ExpBin {
		public ExpAditiva(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 0;
		}
	}

	public static class Suma extends ExpAditiva {
		public Suma(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.SUMA;
		}
	}

	public static class Resta extends ExpAditiva {
		public Resta(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.RESTA;
		}
	}

	public static abstract class ExpLogica extends ExpBin {
		public ExpLogica(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 1;
		}
	}

	public static class And extends ExpLogica {
		public And(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.AND;
		}
	}

	public static class Or extends ExpLogica {
		public Or(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.OR;
		}
	}

	public static abstract class ExpComparativa extends ExpBin {
		public ExpComparativa(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 2;
		}
	}

	public static class Menor extends ExpComparativa {
		public Menor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MENOR;
		}
	}

	public static class Mayor extends ExpComparativa {
		public Mayor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MAYOR;
		}
	}

	public static class Menor_igual extends ExpComparativa {
		public Menor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MENORIGUAL;
		}
	}

	public static class Mayor_igual extends ExpComparativa {
		public Mayor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MAYORIGUAL;
		}
	}

	public static class Igualdad extends ExpComparativa {
		public Igualdad(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.IGUALDAD;
		}
	}

	public static class Distinto extends ExpComparativa {
		public Distinto(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.DESIGUALDAD;
		}
	}

	public static abstract class ExpMultiplicativa extends ExpBin {
		public ExpMultiplicativa(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public final int prioridad() {
			return 3;
		}
	}

	public static class Mul extends ExpMultiplicativa {
		public Mul(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MUL;
		}
	}

	public static class Div extends ExpMultiplicativa {
		public Div(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.DIV;
		}
	}

	public static class Mod extends ExpMultiplicativa {
		public Mod(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MOD;
		}
	}

	public static abstract class ExpNegativa extends ExpUnaria {
		public ExpNegativa(Exp arg0) {
			super(arg0);
		}

		public final int prioridad() {
			return 4;
		}
	}

	public static class Menos extends ExpNegativa {
		public Menos(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.MENOS;
		}
	}

	public static class Not extends ExpNegativa {
		public Not(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.NOT;
		}
	}

	public static class Index extends Exp {
		private Exp exp1, exp2;

		public Index(Exp exp1, Exp exp2) {
			this.exp1 = exp1;
			this.exp2 = exp2;
		}

		public Exp exp1() {
			return exp1;
		}

		public Exp exp2() {
			return exp2;
		}

		@Override
		public int prioridad() {
			return 5;
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.INDEX;
		}

		@Override
		public boolean esDesignador() {
			return true;
		}
	}
	
	public static abstract class AccessReg extends Exp {
		private Exp exp1;
		private StringLocalizado id;

		public AccessReg(Exp exp1, StringLocalizado id) {
			this.exp1 = exp1;
			this.id = id;
		}

		public Exp exp1() {
			return exp1;
		}

		public StringLocalizado id() {
			return id;
		}

		@Override
		public int prioridad() {
			return 5;
		}
		
		public abstract TipoExpEnum getTipoExp();
		
		@Override
		public boolean esDesignador() {
			return true;
		}

	}

	public static class AccessRegPunto extends AccessReg {

		public AccessRegPunto(Exp exp1, StringLocalizado id) {
			super(exp1, id);
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.PUNTO;
		}

	}
	
	public static class AccessRegFlecha extends AccessReg {

		public AccessRegFlecha(Exp exp1, StringLocalizado id) {
			super(exp1, id);
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.FLECHA;
		}

	}

	public static class Indireccion extends Exp {
		private Exp exp1;

		public Indireccion(Exp exp1) {
			this.exp1 = exp1;
		}

		public Exp exp1() {
			return exp1;
		}

		@Override
		public int prioridad() {
			return 6;
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.INDIR;
		}

		@Override
		public boolean esDesignador() {
			return true;
		}
	}

	public static class Identificador extends Exp {
		private StringLocalizado id;

		public Identificador(StringLocalizado id) {
			super();
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}

		@Override
		public String toString() {
			return this.id.s;
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.IDENTIFICADOR;
		}
		
		@Override
		public boolean esDesignador() {
			return true;
		}
	}

	public static class NumEnt extends Exp {
		private StringLocalizado num;

		public NumEnt(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.NUMEROENTERO;
		}
	}

	public static class NumReal extends Exp {
		private StringLocalizado num;

		public NumReal(StringLocalizado num) {
			super();
			this.num = num;
		}

		public StringLocalizado num() {
			return num;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.NUMEROREAL;
		}
	}

	public static class Cadena extends Exp {
		private StringLocalizado cadena;

		public Cadena(StringLocalizado cadena) {
			super();
			this.cadena = cadena;
		}

		public StringLocalizado cadena() {
			return cadena;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		public final int prioridad() {
			return 7;
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.STRING;
		}
	}

	public static abstract class Booleano extends Exp {
		private String lexema;

		public String lexema() {
			return lexema;
		}

		public Booleano(String lexema) {
			super();
			this.lexema = lexema;
		}

		public abstract void procesa(Procesamiento procesamiento);

		public final int prioridad() {
			return 7;
		}
	}

	public static class True extends Booleano {
		public True() {
			super("true");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.TRUE;
		}
	}

	public static class False extends Booleano {
		public False() {
			super("false");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.FALSE;
		}
	}

	public static class Null extends Exp {
		private String lexema;

		public String lexema() {
			return lexema;
		}

		public Null() {
			this.lexema = "null";
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		@Override
		public int prioridad() {
			return 7;
		}
		
		public TipoExpEnum getTipoExp() {
			return TipoExpEnum.NULL;
		}

	}
	
	public enum TipoEnum {
		INT, REAL, STRING, BOOL, ID, POINTER, ARRAY, RECORD, ERROR, OK, NULL
	}

	public static abstract class Tipo extends Nodo {
		
		public Tipo() {

		}

		public abstract void procesa(Procesamiento procesamiento);
		
		public abstract TipoEnum getTipoTipo();
	}

	public static abstract class TipoBasico extends Tipo {
		private String lexema;

		public String lexema() {
			return lexema;
		}

		public TipoBasico(String lexema) {
			super();
			this.lexema = lexema;
		}

		public abstract void procesa(Procesamiento procesamiento);
	}

	public static class Tipo_int extends TipoBasico {
		public Tipo_int() {
			super("int");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.INT;
		}
	}

	public static class Tipo_bool extends TipoBasico {
		public Tipo_bool() {
			super("bool");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.BOOL;
		}
	}

	public static class Tipo_real extends TipoBasico {
		public Tipo_real() {
			super("real");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.REAL;
		}
	}

	public static class Tipo_string extends TipoBasico {
		public Tipo_string() {
			super("string");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.STRING;
		}
	}

	public static class Tipo_id extends Tipo {
		private StringLocalizado id;

		public Tipo_id(StringLocalizado id) {
			super();
			this.id = id;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.ID;
		}
	}

	public static class Tipo_array extends Tipo {
		private StringLocalizado id;
		private Tipo tipo;

		public Tipo_array(StringLocalizado id, Tipo tipo) {
			super();
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		};

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.ARRAY;
		}
	}

	public static class Tipo_pointer extends Tipo {
		private Tipo tipo;

		public Tipo_pointer(Tipo tipo) {
			super();
			this.tipo = tipo;
		}

		public Tipo tipo() {
			return tipo;
		};

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.POINTER;
		}
	}

	public static class Tipo_record extends Tipo {
		private LCampos lcampos;

		public Tipo_record(LCampos lcampos) {
			super();
			this.lcampos = lcampos;
		}

		public LCampos lcampos() {
			return lcampos;
		};

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		@Override
		public TipoEnum getTipoTipo() {
			return TipoEnum.RECORD;
		}
	}
	
	public enum LCamposEnum {
		SIMPLE, COMPUESTA
	}

	public static abstract class LCampos extends Nodo {
		public LCampos() {
		}

		public abstract void procesa(Procesamiento p);
		
		public abstract LCamposEnum getTipoLCampos();
	}

	public static class LCampos_1 extends LCampos {
		private Campo campo;

		public LCampos_1(Campo campo) {
			super();
			this.campo = campo;
		}

		public Campo campo() {
			return campo;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		@Override
		public LCamposEnum getTipoLCampos() {
			return LCamposEnum.SIMPLE;
		}
	}

	public static class LCampos_muchos extends LCampos {
		private Campo campo;
		private LCampos lcampos;

		public LCampos_muchos(LCampos lcampos, Campo campo) {
			super();
			this.campo = campo;
			this.lcampos = lcampos;
		}

		public Campo campo() {
			return campo;
		}

		public LCampos lcampos() {
			return lcampos;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

		@Override
		public LCamposEnum getTipoLCampos() {
			return LCamposEnum.COMPUESTA;
		}
	}

	public static class Campo extends Nodo {
		private Tipo tipo;
		private StringLocalizado id;

		public Campo(Tipo tipo, StringLocalizado id) {
			super();
			this.id = id;
			this.tipo = tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public Tipo tipo() {
			return tipo;
		};

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}
	
	public enum DecEnum {
		VAR, TYPE, PROC
	}

	public static abstract class Dec extends Nodo {
		
		private int direccion;
		private StringLocalizado id;
		
		public Dec(StringLocalizado id) {
			this.id = id;
		}
		
		public int getDireccion() {
			return this.direccion;
		}
		
		public void setDireccion(int direccion) {
			this.direccion = direccion;
		}

		public abstract void procesa(Procesamiento p);
		
		public abstract DecEnum tipoDec();
		
		public StringLocalizado id() {
			return id;
		}
	}
	
	public static abstract class DecConTipo extends Dec {
		
		private Tipo tipo;

		public DecConTipo(Tipo tipo, StringLocalizado id) {
			super(id);
			this.tipo = tipo;
		}

		public Tipo tipo() {
			return tipo;
		}

		
		
		public abstract DecEnum tipoDec();
	}

	public static class DecVar extends DecConTipo {

		public DecVar(Tipo tipo, StringLocalizado id) {
			super(tipo, id);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public DecEnum tipoDec() {
			return DecEnum.VAR;
		}
	}

	public static class DecType extends DecConTipo {
		
		public DecType(Tipo tipo, StringLocalizado id) {
			super(tipo, id);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public DecEnum tipoDec() {
			return DecEnum.TYPE;
		}
	}

	public static class DecProc extends Dec {
		private LParams lparams;
		private Bloque bloque;

		public DecProc(StringLocalizado id, LParams lparams, Bloque bloque) {
			super(id);
			this.lparams = lparams;
			this.bloque = bloque;
		}

		public LParams lparams() {
			return lparams;
		}

		public Bloque bloque() {
			return bloque;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
		
		public DecEnum tipoDec() {
			return DecEnum.PROC;
		}
	}

	public static abstract class LDecs extends Nodo {
		public LDecs() {
		}

		public abstract void procesa(Procesamiento p);

	}

	public static class LDecs_1 extends LDecs {
		private Dec dec;

		public LDecs_1(Dec dec) {
			super();
			this.dec = dec;
		}

		public Dec dec() {
			return dec;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LDecs_muchas extends LDecs {
		private Dec dec;
		private LDecs LDecs;

		public LDecs_muchas(LDecs LDecs, Dec dec) {
			super();
			this.dec = dec;
			this.LDecs = LDecs;
		}

		public Dec dec() {
			return dec;
		}

		public LDecs ldecs() {
			return LDecs;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LIns extends Nodo {
		public LIns() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LIns_1 extends LIns {
		private Ins ins;

		public LIns_1(Ins ins) {
			super();
			this.ins = ins;
		}

		public Ins ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LIns_muchas extends LIns {
		private Ins ins;
		private LIns lins;

		public LIns_muchas(LIns lins, Ins ins) {
			super();
			this.ins = ins;
			this.lins = lins;
		}

		public Ins ins() {
			return ins;
		}

		public LIns lins() {
			return lins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LInsV extends Nodo {
		public LInsV() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LInsV_1 extends LInsV {
		private Ins ins;

		public LInsV_1(Ins ins) {
			super();
			this.ins = ins;
		}

		public Ins ins() {
			return ins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LInsV_muchas extends LInsV {
		private Ins ins;
		private LInsV linsv;

		public LInsV_muchas(LInsV linsv, Ins ins) {
			super();
			this.ins = ins;
			this.linsv = linsv;
		}

		public Ins ins() {
			return ins;
		}

		public LInsV linsv() {
			return linsv;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Ins extends Nodo {
		public Ins() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class InsAsignacion extends Ins {
		private Exp exp1, exp2;

		public InsAsignacion(Exp exp1, Exp exp2) {
			this.exp1 = exp1;
			this.exp2 = exp2;
		}

		public Exp exp1() {
			return exp1;
		}

		public Exp exp2() {
			return exp2;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class InsRead extends Ins {
		private Exp exp1;

		public InsRead(Exp exp1) {
			this.exp1 = exp1;
		}

		public Exp exp1() {
			return exp1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class InsWrite extends Ins {
		private Exp exp1;

		public InsWrite(Exp exp1) {
			this.exp1 = exp1;
		}

		public Exp exp1() {
			return exp1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class InsNew extends Ins {
		private Exp exp1;

		public InsNew(Exp exp1) {
			this.exp1 = exp1;
		}

		public Exp exp1() {
			return exp1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class InsDelete extends Ins {
		private Exp exp1;

		public InsDelete(Exp exp1) {
			this.exp1 = exp1;
		}

		public Exp exp1() {
			return exp1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}
	
	public static class InsNL extends Ins {
		private String lexema;

		public String lexema() {
			return lexema;
		}

		public InsNL() {
			this.lexema = "nl";
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class InsBloque extends Ins {
		private Bloque bloque;

		public InsBloque(Bloque bloque) {
			this.bloque = bloque;
		}

		public Bloque bloque() {
			return bloque;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class Bloque extends Nodo {
		private Programa programa;

		public Bloque(Programa programa) {
			this.programa = programa;
		}

		public Programa programa() {
			return programa;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class InsCall extends Ins {
		private StringLocalizado id;
		private LParamsReales lparamsreales;

		public InsCall(StringLocalizado id, LParamsReales lparamsreales) {
			this.id = id;
			this.lparamsreales = lparamsreales;
		}

		public StringLocalizado id() {
			return id;
		}

		public LParamsReales lparamsreales() {
			return lparamsreales;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class InsIf extends Ins {
		private Exp exp1;
		private LInsV linsv;

		public InsIf(Exp exp1, LInsV linsv) {
			this.exp1 = exp1;
			this.linsv = linsv;
		}

		public Exp exp1() {
			return exp1;
		}

		public LInsV linsv() {
			return linsv;
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);

		}
	}

	public static class InsIfElse extends Ins {
		private Exp exp1;
		private LInsV linsv1;
		private LInsV linsv2;

		public InsIfElse(Exp exp1, LInsV linsv1, LInsV linsv2) {
			this.exp1 = exp1;
			this.linsv1 = linsv1;
			this.linsv2 = linsv2;
		}

		public Exp exp1() {
			return exp1;
		}

		public LInsV linsv1() {
			return linsv1;
		}

		public LInsV linsv2() {
			return linsv2;
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);

		}
	}

	public static class InsWhile extends Ins {
		private Exp exp1;
		private LInsV linsv;

		public InsWhile(Exp exp1, LInsV linsv) {
			this.exp1 = exp1;
			this.linsv = linsv;
		}

		public Exp exp1() {
			return exp1;
		}

		public LInsV linsv() {
			return linsv;
		}

		@Override
		public void procesa(Procesamiento p) {
			p.procesa(this);

		}
	}

	public static abstract class LParams extends Nodo {
		public LParams() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LParams_1 extends LParams {
		private Param param;

		public LParams_1(Param param) {
			super();
			this.param = param;
		}

		public Param param() {
			return param;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LParams_muchos extends LParams {
		private Param param;
		private LParams lparams;

		public LParams_muchos(LParams lparams, Param param) {
			super();
			this.param = param;
			this.lparams = lparams;
		}

		public Param param() {
			return param;
		}

		public LParams lparams() {
			return lparams;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Param extends Nodo {
		private Tipo tipo;
		private Referencia ref;
		private StringLocalizado id;

		public Param(Tipo tipo, Referencia ref, StringLocalizado id) {
			this.tipo = tipo;
			this.ref = ref;
			this.id = id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public Referencia ref() {
			return ref;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LParamsReales extends Nodo {
		public LParamsReales() {
		}

		public abstract void procesa(Procesamiento p);
	}

	public static class LParamsReales_1 extends LParamsReales {
		private Exp exp1;

		public LParamsReales_1(Exp exp1) {
			super();
			this.exp1 = exp1;
		}

		public Exp exp1() {
			return exp1;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class LParamsReales_muchos extends LParamsReales {
		private Exp exp1;
		private LParamsReales lparamsreales;

		public LParamsReales_muchos(LParamsReales lparamsreales, Exp exp1) {
			super();
			this.exp1 = exp1;
			this.lparamsreales = lparamsreales;
		}

		public Exp exp1() {
			return exp1;
		}

		public LParamsReales lparamsreales() {
			return lparamsreales;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Referencia extends Nodo {
		private String lexema;

		public String lexema() {
			return lexema;
		}

		public Referencia() {
			this.lexema = "&";
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}

	}

	public static class Programa extends Nodo {
		private LDecs ldecs;
		private LIns lins;

		public Programa(LDecs ldecs, LIns lins) {
			this.ldecs = ldecs;
			this.lins = lins;
		}

		public LDecs ldecs() {
			return ldecs;
		}

		public LIns lins() {
			return lins;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	// Constructoras
	public Programa programa(LDecs ldecs, LIns lins) {
		return new Programa(ldecs, lins);
	}

	public Programa programa_sin_decs(LIns lins) {
		return new Programa(null, lins);
	}

	public Programa programa_con_decs(LDecs ldecs, LIns lins) {
		return new Programa(ldecs, lins);
	}

	public LDecs decs_1(Dec dec) {
		return new LDecs_1(dec);
	}

	public LDecs decs_muchas(LDecs ldecs, Dec dec) {
		return new LDecs_muchas(ldecs, dec);
	}

	public Tipo tipo_int() {
		return new Tipo_int();
	}

	public Tipo tipo_real() {
		return new Tipo_real();
	}

	public Tipo tipo_bool() {
		return new Tipo_bool();
	}

	public Tipo tipo_string() {
		return new Tipo_string();
	}

	public Tipo tipo_id(StringLocalizado id) {
		return new Tipo_id(id);
	}

	public Tipo tipo_array(StringLocalizado id, Tipo tipo) {
		return new Tipo_array(id, tipo);
	}

	public Tipo tipo_pointer(Tipo tipo) {
		return new Tipo_pointer(tipo);
	}

	public Tipo tipo_record(LCampos lcampos) {
		return new Tipo_record(lcampos);
	}

	public Dec dec_var(Tipo tipo, StringLocalizado id) {
		return new DecVar(tipo, id);
	}

	public Dec dec_type(Tipo tipo, StringLocalizado id) {
		return new DecType(tipo, id);
	}

	public Dec dec_proc_con_pf(StringLocalizado id, LParams lparams, Bloque bloque) {
		return new DecProc(id, lparams, bloque);
	}

	public Dec dec_proc_sin_pf(StringLocalizado id, Bloque bloque) {
		return new DecProc(id, null, bloque);
	}

	public LIns lins_1(Ins ins) {
		return new LIns_1(ins);
	}

	public LIns lins_muchas(LIns lins, Ins ins) {
		return new LIns_muchas(lins, ins);
	}

	public LCampos lcampos_1(Campo campo) {
		return new LCampos_1(campo);
	}

	public LCampos lcampos_muchos(LCampos lcampos, Campo campo) {
		return new LCampos_muchos(lcampos, campo);
	}

	public Campo campo(Tipo tipo, StringLocalizado id) {
		return new Campo(tipo, id);
	}

	public LInsV linsv_1(Ins ins) {
		return new LInsV_1(ins);
	}

	public LInsV linsv_muchas(LInsV linsv, Ins ins) {
		return new LInsV_muchas(linsv, ins);
	}

	public Ins ins_asignacion(Exp exp1, Exp exp2) {
		return new InsAsignacion(exp1, exp2);
	}

	public Ins ins_read(Exp exp1) {
		return new InsRead(exp1);
	}

	public Ins ins_write(Exp exp1) {
		return new InsWrite(exp1);
	}

	public Ins ins_new(Exp exp1) {
		return new InsNew(exp1);
	}

	public Ins ins_delete(Exp exp1) {
		return new InsDelete(exp1);
	}

	public Ins ins_nl() {
		return new InsNL();
	}

	public Ins ins_bloque(Bloque bloque) {
		return new InsBloque(bloque);
	}

	public Ins ins_call_con_params(StringLocalizado id, LParamsReales lparamsreales) {
		return new InsCall(id, lparamsreales);
	}

	public Ins ins_call_sin_params(StringLocalizado id) {
		return new InsCall(id, null);
	}

	public Ins ins_if_con_ins(Exp exp1, LInsV linsv) {
		return new InsIf(exp1, linsv);
	}

	public Ins ins_if_sin_ins(Exp exp1) {
		return new InsIf(exp1, null);
	}

	public Ins ins_if_else_con_ins(Exp exp1, LInsV linsv1, LInsV linsv2) {
		return new InsIfElse(exp1, linsv1, linsv2);
	}

	public Ins ins_if_else_sin_ins(Exp exp1) {
		return new InsIfElse(exp1, null, null);
	}

	public Ins ins_if_else_insarg0(Exp exp1, LInsV linsv1) {
		return new InsIfElse(exp1, linsv1, null);
	}

	public Ins ins_if_else_insarg1(Exp exp1, LInsV linsv2) {
		return new InsIfElse(exp1, null, linsv2);
	}

	public Ins ins_while_con_ins(Exp exp1, LInsV linsv) {
		return new InsWhile(exp1, linsv);
	}

	public Ins ins_while_sin_ins(Exp exp1) {
		return new InsWhile(exp1, null);
	}

	public Bloque bloque_con_programa(Programa programa) {
		return new Bloque(programa);
	}

	public Bloque bloque_sin_programa() {
		return new Bloque(null);
	}

	public LParams lparams_1(Param param) {
		return new LParams_1(param);
	}

	public LParams lparams_muchos(LParams lparams, Param param) {
		return new LParams_muchos(lparams, param);
	}

	public LParamsReales preales_1(Exp exp1) {
		return new LParamsReales_1(exp1);
	}

	public LParamsReales preales_muc(LParamsReales lparamsreales, Exp exp1) {
		return new LParamsReales_muchos(lparamsreales, exp1);
	}

	public Param param(Tipo tipo, Referencia ref, StringLocalizado id) {
		return new Param(tipo, ref, id);
	}

	public Referencia referencia() {
		return new Referencia();
	}

	public Param param_sin_referencia(Tipo tipo, StringLocalizado id) {
		return new Param(tipo, null, id);
	}

	public Param param_con_referencia(Tipo tipo, Referencia ref, StringLocalizado id) {
		return new Param(tipo, ref, id);
	}

	public Exp suma(Exp arg0, Exp arg1) {
		return new Suma(arg0, arg1);
	}

	public Exp resta(Exp arg0, Exp arg1) {
		return new Resta(arg0, arg1);
	}

	public Exp mul(Exp arg0, Exp arg1) {
		return new Mul(arg0, arg1);
	}

	public Exp div(Exp arg0, Exp arg1) {
		return new Div(arg0, arg1);
	}

	public Exp mod(Exp arg0, Exp arg1) {
		return new Mod(arg0, arg1);
	}

	public Exp and(Exp arg0, Exp arg1) {
		return new And(arg0, arg1);
	}

	public Exp or(Exp arg0, Exp arg1) {
		return new Or(arg0, arg1);
	}

	public Exp menor(Exp arg0, Exp arg1) {
		return new Menor(arg0, arg1);
	}

	public Exp mayor(Exp arg0, Exp arg1) {
		return new Mayor(arg0, arg1);
	}

	public Exp menor_igual(Exp arg0, Exp arg1) {
		return new Menor_igual(arg0, arg1);
	}

	public Exp mayor_igual(Exp arg0, Exp arg1) {
		return new Mayor_igual(arg0, arg1);
	}

	public Exp igualdad(Exp arg0, Exp arg1) {
		return new Igualdad(arg0, arg1);
	}

	public Exp distinto(Exp arg0, Exp arg1) {
		return new Distinto(arg0, arg1);
	}

	public Exp menos(Exp arg0) {
		return new Menos(arg0);
	}

	public Exp not(Exp arg0) {
		return new Not(arg0);
	}

	public Exp index(Exp arg0, Exp arg1) {
		return new Index(arg0, arg1);
	}

	public Exp access_reg_punto(Exp arg0, StringLocalizado id) {
		return new AccessRegPunto(arg0, id);
	}

	public Exp access_reg_flecha(Exp arg0, StringLocalizado id) {
		return new AccessRegFlecha(arg0, id);
	}

	public Exp indireccion(Exp arg0) {
		return new Indireccion(arg0);
	}

	public Exp identificador(StringLocalizado id) {
		return new Identificador(id);
	}

	public Exp numEnt(StringLocalizado numEnt) {
		return new NumEnt(numEnt);
	}

	public Exp numReal(StringLocalizado numReal) {
		return new NumReal(numReal);
	}

	public Exp cadena(StringLocalizado cadena) {
		return new Cadena(cadena);
	}

	public Exp true_p() {
		return new True();
	}

	public Exp false_p() {
		return new False();
	}

	public Exp null_p() {
		return new Null();
	}

	public StringLocalizado str(String lexema, int fila, int col) {
		return new StringLocalizado(lexema, fila, col);
	}

}
