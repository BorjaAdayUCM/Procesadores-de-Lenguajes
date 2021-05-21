package errores;

import constructorAST_descendente_manual.ClaseLexica;

public class GestionErroresTiny {
	
	public void errorLexico(int fila, int col, String lexema) {
		if(lexema.equals("\n")) lexema = "salto de línea";
		System.err.println("ERROR LEXICO: Fila: " + fila + ", Columna: " + col + ", " + "Caracter inexperado: " + lexema + ".");
		System.exit(1);
	}
   
   public void errorSintactico(int fila, int col, ClaseLexica encontrada, ClaseLexica ... esperadas) {
     System.err.print("ERROR SINTACTICO: fila "+fila+","+col+": Encontrado "+encontrada+" Se esperaba: ");
     for(ClaseLexica esperada: esperadas)
         System.err.print(esperada+" ");
     System.err.println();
     System.exit(1);
   }
   
   public void errorFatal(Exception e) {
     System.err.println(e);
     e.printStackTrace();
     System.exit(1);
   }
}
