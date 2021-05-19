package mains;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

import analizadorSintactico.AnalizadorSintacticoTiny1;
import constructorAST_ascendente.AnalizadorLexicoTiny1;
import constructorAST_descendente.AnalizadorSintacticoTiny1Descendente;

public class Main {

	public static void main(String[] args) throws Exception {
		if(args.length == 2) {
			if(args[1].equals("desc")) {
				AnalizadorSintacticoTiny1Descendente analizadorSintactico = new AnalizadorSintacticoTiny1Descendente(new FileReader(args[0]));
			      analizadorSintactico.Sp();
			}
			else if (args[1].equals("asc")){
				Reader input = new InputStreamReader(new FileInputStream(args[0]));
				 AnalizadorLexicoTiny1 alex = new AnalizadorLexicoTiny1(input);
				 AnalizadorSintacticoTiny1 asint = new AnalizadorSintacticoTiny1(alex);
				 asint.parse();
			}
			System.out.println("OK");
		}
		else {
			
			System.out.println("Los argumetos deben ser el fichero de entrada y la opcion 'asc' o 'desc'");
		}
		
	}

}
