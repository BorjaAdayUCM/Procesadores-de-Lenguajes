package errores;

import analizadorLexico.ClaseLexica;

public class GestionErroresTiny {
	
	public void errorLexico(int fila, int col, String lexema) {
		if(lexema.equals("\n")) lexema = "salto de línea";
		System.err.println("ERROR LEXICO: Fila: " + fila + ", Columna: " + col + ", " + "Caracter inexperado: " + lexema + ".");
		System.exit(1);
	}
   
   public void errorSintactico(int fila, int col, ClaseLexica encontrada, ClaseLexica ... esperadas) {
     System.out.print("ERROR SINTACTICO: fila "+fila+","+col+": Encontrado "+encontrada+" Se esperada: ");
     for(ClaseLexica esperada: esperadas)
         System.out.print(esperada+" ");
     System.out.println();
     System.exit(1);
   }
   
   public void errorFatal(Exception e) {
     System.out.println(e);
     e.printStackTrace();
     System.exit(1);
   }
}
