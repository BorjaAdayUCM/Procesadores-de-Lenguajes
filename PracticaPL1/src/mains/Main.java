package mains;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import analizadorSintactico.AnalizadorSintacticoTiny.Programa;
import constructorAST_descendente_manual.ConstructorAST;
import procesamientos.Impresion;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		ConstructorAST constructorast = new ConstructorAST(input);
		Programa programa = constructorast.init();
		programa.procesa(new Impresion());
	}

}   

