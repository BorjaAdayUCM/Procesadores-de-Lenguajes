package analizadorSintactico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainSintactico {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
     AnalizadorSintacticoTiny analizadorSintactico = new AnalizadorSintacticoTiny(input);
     analizadorSintactico.init();
     System.out.println("OK\n");
 }
}   
   
