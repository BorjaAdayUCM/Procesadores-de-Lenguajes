package errores;

import constructorAST_ascendente.UnidadLexica;

public class GestionErroresTiny1 {
	
   public void errorLexico(int fila, String lexema) {
     System.err.println("ERROR LEXICO, fila "+fila+": Caracter inexperado: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.err.println("ERROR SINTACTICO, fila "+unidadLexica.lexema().fila()+", columna "+unidadLexica.lexema().col()+" "
     		+ ": Elemento inexperado "+ unidadLexica.value);
     System.exit(1);
   }
}
