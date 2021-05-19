package constructorAST_ascendente;


public class UnidadLexicaMultivaluada extends UnidadLexica {
  private String lexema;
  
  public UnidadLexicaMultivaluada(int fila, int columna, int clase, String lexema) {
     super(fila, columna, clase, lexema);  
   }
  public String lexema() {return lexema;}
  
  public String toString() {
    return "[clase:"+clase()+",fila:"+fila()+",col:"+columna()+",lexema:"+lexema()+"]";  
  }
}
