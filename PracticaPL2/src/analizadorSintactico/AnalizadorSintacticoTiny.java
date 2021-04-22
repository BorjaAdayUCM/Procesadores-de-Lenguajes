/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny.java */
package analizadorSintactico;

public class AnalizadorSintacticoTiny implements AnalizadorSintacticoTinyConstants {

  final public void Programa() throws ParseException {
    PDeclaraciones();
    PInstrucciones();
    jj_consume_token(0);
  }

  final public void PDeclaraciones() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case proc:
    case var:
    case type:
      LDecs();
      jj_consume_token(sep);
      break;
    default:
      jj_la1[0] = jj_gen;

    }
  }

  final public void LDecs() throws ParseException {
    Dec();
    RLDecs();
  }

  final public void RLDecs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pyc:
      jj_consume_token(pyc);
      Dec();
      RLDecs();
      break;
    default:
      jj_la1[1] = jj_gen;

    }
  }

  final public void Dec() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case var:
      jj_consume_token(var);
      Tipo();
      jj_consume_token(identificador);
      break;
    case type:
      jj_consume_token(type);
      Tipo();
      jj_consume_token(identificador);
      break;
    case proc:
      jj_consume_token(proc);
      jj_consume_token(67);
      jj_consume_token(pApert);
      jj_consume_token(pCierre);
      Bloque();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void ParForm() throws ParseException {
    jj_consume_token(pApert);
    LParams();
    jj_consume_token(pCierre);
  }

  final public void LParams() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case int_pr:
    case real:
    case bool:
    case string:
    case record:
    case array:
    case pointer:
    case identificador:
      Param();
      RLParams();
      break;
    default:
      jj_la1[3] = jj_gen;

    }
  }

  final public void RLParams() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case coma:
      jj_consume_token(coma);
      Param();
      RLParams();
      break;
    default:
      jj_la1[4] = jj_gen;

    }
  }

  final public void Param() throws ParseException {
    Tipo();
    Referencia();
    jj_consume_token(identificador);
  }

  final public void Referencia() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ampersand:
      jj_consume_token(ampersand);
      break;
    default:
      jj_la1[5] = jj_gen;

    }
  }

  final public void Bloque() throws ParseException {
    jj_consume_token(llaveAper);
    RBloque();
  }

  final public void RBloque() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case numeroEntero:
    case numeroReal:
    case cadena:
    case not:
    case null_pr:
    case true_pr:
    case false_pr:
    case proc:
    case if_pr:
    case while_pr:
    case call:
    case new_pr:
    case delete:
    case read:
    case write:
    case nl:
    case var:
    case type:
    case resta:
    case multiplicacion:
    case pApert:
    case llaveAper:
    case identificador:
      Programa();
      jj_consume_token(llaveCierre);
      break;
    case llaveCierre:
      jj_consume_token(llaveCierre);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case int_pr:
      jj_consume_token(int_pr);
      break;
    case real:
      jj_consume_token(real);
      break;
    case bool:
      jj_consume_token(bool);
      break;
    case string:
      jj_consume_token(string);
      break;
    case identificador:
      jj_consume_token(identificador);
      break;
    case array:
      jj_consume_token(array);
      jj_consume_token(corApert);
      jj_consume_token(numeroEntero);
      jj_consume_token(corCierre);
      jj_consume_token(of);
      Tipo();
      break;
    case record:
      jj_consume_token(record);
      jj_consume_token(llaveAper);
      LCampos();
      jj_consume_token(llaveCierre);
      break;
    case pointer:
      jj_consume_token(pointer);
      Tipo();
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void LCampos() throws ParseException {
    Campo();
    RLCampos();
  }

  final public void RLCampos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pyc:
      jj_consume_token(pyc);
      Campo();
      RLCampos();
      break;
    default:
      jj_la1[8] = jj_gen;

    }
  }

  final public void Campo() throws ParseException {
    Tipo();
    jj_consume_token(identificador);
  }

  final public void PInstrucciones() throws ParseException {
    LIns();
  }

  final public void LIns() throws ParseException {
    Ins();
    RLIns();
  }

  final public void RLIns() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pyc:
      jj_consume_token(pyc);
      Ins();
      RLIns();
      break;
    default:
      jj_la1[9] = jj_gen;

    }
  }

  final public void Ins() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case numeroEntero:
    case numeroReal:
    case cadena:
    case not:
    case null_pr:
    case true_pr:
    case false_pr:
    case resta:
    case multiplicacion:
    case pApert:
    case identificador:
      E0();
      jj_consume_token(igual);
      E0();
      break;
    case if_pr:
      InsIfThen();
      RInsIfThen();
      break;
    case while_pr:
      jj_consume_token(while_pr);
      E0();
      jj_consume_token(do_pr);
      LInsV();
      jj_consume_token(endwhile);
      break;
    case read:
      jj_consume_token(read);
      E0();
      break;
    case write:
      jj_consume_token(write);
      E0();
      break;
    case nl:
      jj_consume_token(nl);
      break;
    case new_pr:
      jj_consume_token(new_pr);
      E0();
      break;
    case delete:
      jj_consume_token(delete);
      E0();
      break;
    case call:
      jj_consume_token(call);
      jj_consume_token(identificador);
      jj_consume_token(pApert);
      LParamsReales();
      jj_consume_token(pCierre);
      break;
    case llaveAper:
      Bloque();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void InsIfThen() throws ParseException {
    jj_consume_token(if_pr);
    E0();
    jj_consume_token(then);
    LInsV();
  }

  final public void RInsIfThen() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case endif:
      jj_consume_token(endif);
      break;
    case else_pr:
      jj_consume_token(else_pr);
      LInsV();
      jj_consume_token(endif);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void LInsV() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case numeroEntero:
    case numeroReal:
    case cadena:
    case not:
    case null_pr:
    case true_pr:
    case false_pr:
    case if_pr:
    case while_pr:
    case call:
    case new_pr:
    case delete:
    case read:
    case write:
    case nl:
    case resta:
    case multiplicacion:
    case pApert:
    case llaveAper:
    case identificador:
      Ins();
      RLInsV();
      break;
    default:
      jj_la1[12] = jj_gen;

    }
  }

  final public void RLInsV() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case pyc:
      jj_consume_token(pyc);
      Ins();
      RLInsV();
      break;
    default:
      jj_la1[13] = jj_gen;

    }
  }

  final public void LParamsReales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case numeroEntero:
    case numeroReal:
    case cadena:
    case not:
    case null_pr:
    case true_pr:
    case false_pr:
    case resta:
    case multiplicacion:
    case pApert:
    case identificador:
      E0();
      RLParamsReales();
      break;
    default:
      jj_la1[14] = jj_gen;

    }
  }

  final public void RLParamsReales() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case coma:
      jj_consume_token(coma);
      E0();
      RLParamsReales();
      break;
    default:
      jj_la1[15] = jj_gen;

    }
  }

  final public void E0() throws ParseException {
    E1();
    RE0();
  }

  final public void RE0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case suma:
      jj_consume_token(suma);
      E0();
      break;
    case resta:
      jj_consume_token(resta);
      E1();
      break;
    default:
      jj_la1[16] = jj_gen;

    }
  }

  final public void E1() throws ParseException {
    E2();
    RE1();
  }

  final public void RE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
    case or:
      OpN1();
      E2();
      RE1();
      break;
    default:
      jj_la1[17] = jj_gen;

    }
  }

  final public void E2() throws ParseException {
    E3();
    RE2();
  }

  final public void RE2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case menor:
    case mayor:
    case menorIgual:
    case mayorIgual:
    case igualdad:
    case distinto:
      OpN2();
      E3();
      RE2();
      break;
    default:
      jj_la1[18] = jj_gen;

    }
  }

  final public void E3() throws ParseException {
    E4();
    RE3();
  }

  final public void RE3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case multiplicacion:
    case division:
    case modulo:
      OpN3();
      E4();
      break;
    default:
      jj_la1[19] = jj_gen;

    }
  }

  final public void E4() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case resta:
      jj_consume_token(resta);
      E5();
      break;
    case not:
      jj_consume_token(not);
      E4();
      break;
    case numeroEntero:
    case numeroReal:
    case cadena:
    case null_pr:
    case true_pr:
    case false_pr:
    case multiplicacion:
    case pApert:
    case identificador:
      E5();
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E5() throws ParseException {
    E6();
    RE5();
  }

  final public void RE5() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case corApert:
    case punto:
    case flecha:
      OpN5();
      RE5();
      break;
    default:
      jj_la1[21] = jj_gen;

    }
  }

  final public void E6() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case multiplicacion:
      jj_consume_token(multiplicacion);
      E6();
      break;
    case numeroEntero:
    case numeroReal:
    case cadena:
    case null_pr:
    case true_pr:
    case false_pr:
    case pApert:
    case identificador:
      E7();
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E7() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case identificador:
      jj_consume_token(identificador);
      break;
    case numeroEntero:
      jj_consume_token(numeroEntero);
      break;
    case numeroReal:
      jj_consume_token(numeroReal);
      break;
    case true_pr:
      jj_consume_token(true_pr);
      break;
    case false_pr:
      jj_consume_token(false_pr);
      break;
    case cadena:
      jj_consume_token(cadena);
      break;
    case null_pr:
      jj_consume_token(null_pr);
      break;
    case pApert:
      jj_consume_token(pApert);
      E0();
      jj_consume_token(pCierre);
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OpN1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case and:
      jj_consume_token(and);
      break;
    case or:
      jj_consume_token(or);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OpN2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case menor:
      jj_consume_token(menor);
      break;
    case mayor:
      jj_consume_token(mayor);
      break;
    case menorIgual:
      jj_consume_token(menorIgual);
      break;
    case mayorIgual:
      jj_consume_token(mayorIgual);
      break;
    case igualdad:
      jj_consume_token(igualdad);
      break;
    case distinto:
      jj_consume_token(distinto);
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OpN3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case multiplicacion:
      jj_consume_token(multiplicacion);
      break;
    case division:
      jj_consume_token(division);
      break;
    case modulo:
      jj_consume_token(modulo);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OpN5() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case corApert:
      jj_consume_token(corApert);
      E0();
      jj_consume_token(corCierre);
      break;
    case punto:
      jj_consume_token(punto);
      jj_consume_token(identificador);
      break;
    case flecha:
      jj_consume_token(flecha);
      jj_consume_token(identificador);
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  public AnalizadorSintacticoTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[28];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_0();
      jj_la1_1();
      jj_la1_2();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x400000,0x0,0x400000,0x8000f000,0x0,0x0,0x48fc0c80,0x8000f000,0x0,0x0,0x48bc0c80,0x6000000,0x48bc0c80,0x0,0x3c0c80,0x0,0x0,0x30000,0x0,0x0,0x3c0c80,0x0,0x380c80,0x380c80,0x30000,0x0,0x0,0x0,};
   }
   private static void jj_la1_1() {
      jj_la1_1 = new int[] {0x300,0x1000000,0x300,0x5,0x0,0x0,0x30401bf8,0x5,0x1000000,0x1000000,0x104018f8,0x0,0x104018f8,0x1000000,0x401800,0x0,0xc00,0x0,0x3f0000,0xb000,0x401800,0xc4000000,0x401000,0x400000,0x0,0x3f0000,0xb000,0xc4000000,};
   }
   private static void jj_la1_2() {
      jj_la1_2 = new int[] {0x0,0x0,0x0,0x4,0x1,0x2,0x4,0x4,0x0,0x0,0x4,0x0,0x4,0x0,0x4,0x1,0x0,0x0,0x0,0x0,0x4,0x0,0x4,0x4,0x0,0x0,0x0,0x0,};
   }

  public AnalizadorSintacticoTiny(java.io.InputStream stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  public void ReInit(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 28; i++) jj_la1[i] = -1;
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[68];
    for (int i = 0; i < 68; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 28; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 68; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

                                       }
