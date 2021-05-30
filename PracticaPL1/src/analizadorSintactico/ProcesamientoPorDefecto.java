package analizadorSintactico;

import analizadorSintactico.AnalizadorSintacticoTiny.*;

public class ProcesamientoPorDefecto implements Procesamiento {
	public void procesa(Programa programa) { } 
	public void procesa(LDecs_1 ldecs) { }
	public void procesa(LDecs_muchas ldecs) { }
	public void procesa(Tipo_int int_p) { }
	public void procesa(Tipo_bool bool_p) { }
	public void procesa(Tipo_real real_p) { }
	public void procesa(Dec dec) { }
	public void procesa(LIns_1 lins) { }
	public void procesa(LIns_muchas lins) { }
	public void procesa(Ins ins) { }
    public void procesa(Suma exp) { }
    public void procesa(Resta exp) { }
    public void procesa(Mul exp) { }
    public void procesa(Div exp) { }
    public void procesa(And exp) { }
    public void procesa(Or exp) { }
    public void procesa(Menor exp) { }
    public void procesa(Mayor exp) { }
    public void procesa(Menor_igual exp) { }
    public void procesa(Mayor_igual exp) { }
    public void procesa(Igualdad exp) { }
    public void procesa(Distinto exp) { }
    public void procesa(Menos exp) { }
    public void procesa(Not exp) { }
    public void procesa(Identificador exp) { }
    public void procesa(NumEnt exp) { }
    public void procesa(NumReal exp) { }
    public void procesa(True true_p) { }
    public void procesa(False false_p) { }
}
