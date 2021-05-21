package analizadorSintactico;

public class AnalizadorSintacticoTiny {

	public static abstract class Exp {
		public Exp() {
		}

		public abstract int prioridad();

		public abstract void procesa(Procesamiento procesamiento);
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
	}

	public static class Resta extends ExpAditiva {
		public Resta(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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
	}

	public static class Or extends ExpLogica {
		public Or(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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
	}

	public static class Mayor extends ExpComparativa {
		public Mayor(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Menor_igual extends ExpComparativa {
		public Menor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Mayor_igual extends ExpComparativa {
		public Mayor_igual(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Igualdad extends ExpComparativa {
		public Igualdad(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Distinto extends ExpComparativa {
		public Distinto(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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
	}

	public static class Div extends ExpMultiplicativa {
		public Div(Exp arg0, Exp arg1) {
			super(arg0, arg1);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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
	}

	public static class Not extends ExpNegativa {
		public Not(Exp arg0) {
			super(arg0);
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
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
			return 5;
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
			return 5;
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
			return 5;
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
			return 5;
		}
	}

	public static class True extends Booleano {
		public True() {
			super("true");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class False extends Booleano {
		public False() {
			super("false");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class Tipo {
		private String lexema;

		public String lexema() {
			return lexema;
		}

		public Tipo(String lexema) {
			super();
			this.lexema = lexema;
		}

		public abstract void procesa(Procesamiento procesamiento);
	}

	public static class Tipo_int extends Tipo {
		public Tipo_int() {
			super("int");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_bool extends Tipo {
		public Tipo_bool() {
			super("bool");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Tipo_real extends Tipo {
		public Tipo_real() {
			super("real");
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Dec {
		private Tipo tipo;
		private StringLocalizado id;

		public Dec(Tipo tipo, StringLocalizado id) {
			this.tipo = tipo;
			this.id = id;
		}

		public Tipo tipo() {
			return tipo;
		}

		public StringLocalizado id() {
			return id;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static abstract class LDecs {
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

	public static abstract class LIns {
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

	public static class Ins {
		private StringLocalizado id;
		private Exp exp;

		public Ins(StringLocalizado id, Exp exp) {
			this.id = id;
			this.exp = exp;
		}

		public StringLocalizado id() {
			return id;
		}

		public Exp exp() {
			return exp;
		}

		public void procesa(Procesamiento p) {
			p.procesa(this);
		}
	}

	public static class Programa {
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

	public LDecs decs_1(Dec dec) {
		return new LDecs_1(dec);
	}

	public LDecs decs_muchas(LDecs ldecs, Dec dec) {
		return new LDecs_muchas(ldecs, dec);
	}

	public Tipo tipo_int() {
		return new Tipo_int();
	}

	public Tipo tipo_bool() {
		return new Tipo_bool();
	}

	public Tipo tipo_real() {
		return new Tipo_real();
	}

	public Dec dec(Tipo tipo, StringLocalizado id) {
		return new Dec(tipo, id);
	}

	public LIns lins_1(Ins ins) {
		return new LIns_1(ins);
	}

	public LIns lins_muchas(LIns lins, Ins ins) {
		return new LIns_muchas(lins, ins);
	}

	public Ins ins(StringLocalizado id, Exp exp) {
		return new Ins(id, exp);
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

	public Exp identificador(StringLocalizado id) {
		return new Identificador(id);
	}

	public Exp numEnt(StringLocalizado numEnt) {
		return new NumEnt(numEnt);
	}

	public Exp numReal(StringLocalizado numReal) {
		return new NumReal(numReal);
	}

	public Exp true_p() {
		return new True();
	}

	public Exp false_p() {
		return new False();
	}

	public StringLocalizado str(String lexema, int fila, int col) {
		return new StringLocalizado(lexema, fila, col);
	}

}
