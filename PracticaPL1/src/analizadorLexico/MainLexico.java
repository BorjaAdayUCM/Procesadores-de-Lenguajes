package analizadorLexico;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainLexico {

	public static void main(String args[]) throws IOException {
		Reader input = new InputStreamReader(new FileInputStream(args[0]));
		AnalizadorLexicoTiny analizadorLexico = new AnalizadorLexicoTiny(input);
		UnidadLexica unidad;
		do {
			unidad = analizadorLexico.sigToken();
			System.out.println(unidad);
		}
		while (unidad.clase() != ClaseLexica.EOF);
	} 

}
