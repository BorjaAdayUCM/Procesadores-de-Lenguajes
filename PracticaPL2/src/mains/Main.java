package mains;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import analizadorSintactico.AnalizadorSintacticoTiny1.Programa;
import procesamientos.Impresion;

public class Main {

	public static void main(String[] args) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		constructorAST_descendente.ConstructorAST constructorast = new constructorAST_descendente.ConstructorAST(input);
		Programa programa = constructorast.Sp();
		Impresion impresion = new Impresion();
		programa.procesa(impresion);
		System.out.println(impresion.getPrograma());
	}
}