package errores;

import analizadorLexico.UnidadLexica;

public class GestionErroresTiny1 {
	
   public void errorLexico(int fila, String lexema) {
     System.out.println("ERROR LEXICO, fila "+fila+": Caracter inexperado: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.println("ERROR SINTACTICO, fila "+unidadLexica.fila()+", columna "+unidadLexica.columna()+" : Elemento inexperado "+ unidadLexica.sym);
     System.exit(1);
   }
}
