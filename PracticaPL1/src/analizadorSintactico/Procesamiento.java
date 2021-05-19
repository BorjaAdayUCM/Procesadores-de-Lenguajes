package analizadorSintactico;

import analizadorSintactico.AnalizadorSintacticoTiny.*;

public interface Procesamiento {
	void procesa(Programa programa); 
	void procesa(LDecs_1 ldecs);
	void procesa(LDecs_muchas ldecs);
	void procesa(Tipo_int int_p);
	void procesa(Tipo_bool bool_p);
	void procesa(Tipo_real real_p);
	void procesa(Dec dec);
	void procesa(LIns_1 lins);
	void procesa(LIns_muchas lins);
	void procesa(Ins ins);
    void procesa(Suma exp);
    void procesa(Resta exp);
    void procesa(Mul exp);
    void procesa(Div exp);
    void procesa(And exp);
    void procesa(Or exp);
    void procesa(Menor exp);
    void procesa(Mayor exp);
    void procesa(Menor_igual exp);
    void procesa(Mayor_igual exp);
    void procesa(Igualdad exp);
    void procesa(Distinto exp);
    void procesa(Menos exp);
    void procesa(Not exp);
    void procesa(Identificador exp);
    void procesa(NumEnt exp);
    void procesa(NumReal exp);
    void procesa(True true_p);
    void procesa(False false_p);
}