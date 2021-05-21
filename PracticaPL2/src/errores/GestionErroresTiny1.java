package errores;

import constructorAST_ascendente.UnidadLexica;
import constructorAST_descendente.ConstructorASTConstants;

public class GestionErroresTiny1 {
	
   public void errorLexico(int fila, String lexema) {
     System.err.println("ERROR LEXICO, fila "+fila+": Caracter inexperado: "+lexema); 
     System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.err.println("ERROR SINTACTICO, fila "+unidadLexica.lexema().fila()+", columna "+unidadLexica.lexema().col()+" "
     		+ ": Elemento inexperado "+ ConstructorASTConstants.tokenImage[unidadLexica.sym]);
     System.exit(1);
   }
}
