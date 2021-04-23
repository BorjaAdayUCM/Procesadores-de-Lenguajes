package analizadorSintacticoDescendente;

import java.io.FileReader;
public class Main{
	
   public static void main(String[] args) throws Exception {
      AnalizadorSintacticoTiny analizadorSintactico = new AnalizadorSintacticoTiny(new FileReader(args[0]));
      analizadorSintactico.Sp();
      System.out.println("OK");
   }
   
}