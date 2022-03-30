package mains;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import analizadorSintactico.AnalizadorSintacticoTiny1.Programa;
import constructorAST_ascendente.AnalizadorLexicoTiny1;
import procesamientos.ComprobacionTipos;
import procesamientos.Impresion;
import procesamientos.Vinculacion;

public class Main {

	public static void main(String[] args) throws Exception {
		Programa programa = null;
		if (args[1].equals("desc")) {
			programa = ejecuta_descendente(args[0]);
		} else if (args[1].equals("asc")) {
			programa = ejecuta_ascendente(args[0]);
		} else {
			System.err.println("Debe introducir el nombre del fichero y la opción \"asc\" o \"desc\" como parámetros de entrada.");
			System.exit(1);
		}
		
		Impresion impresion = new Impresion();
		programa.procesa(impresion);
		System.out.println(impresion.getPrograma());
		
		Vinculacion vinculacion = new Vinculacion();
		programa.procesa(vinculacion);
		
		ComprobacionTipos comprobacionTipos = new ComprobacionTipos();
		programa.procesa(comprobacionTipos);
		
		System.out.println("OK");
	}

	private static Programa ejecuta_ascendente(String in) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(in));
		AnalizadorLexicoTiny1 alex = new AnalizadorLexicoTiny1(input);
		constructorAST_ascendente.ConstructorAST constructorast = new constructorAST_ascendente.ConstructorAST(alex);
		return (Programa) constructorast.parse().value;
	}

	private static Programa ejecuta_descendente(String in) throws Exception {
		Reader input = new InputStreamReader(new FileInputStream(in));
		constructorAST_descendente.ConstructorAST constructorast = new constructorAST_descendente.ConstructorAST(input);
		return constructorast.Programa();
	}
}