/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny.java */
package asint;

public class AnalizadorSintacticoTiny implements AnalizadorSintacticoTinyConstants {

  final public void Sp() throws ParseException {
    S();
    jj_consume_token(0);
  }

  final public void S() throws ParseException {
    jj_consume_token(evalua);
    E0();
    Ds();
  }

  final public void Ds() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case donde:
      jj_consume_token(donde);
      LDs();
      break;
    default:
      jj_la1[0] = jj_gen;

    }
  }

  final public void LDs() throws ParseException {
    D();
    RLDs();
  }

  final public void RLDs() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 13:
      jj_consume_token(13);
      D();
      RLDs();
      break;
    default:
      jj_la1[1] = jj_gen;

    }
  }

  final public void D() throws ParseException {
    jj_consume_token(identificador);
    jj_consume_token(14);
    E0();
  }

  final public void E0() throws ParseException {
    E1();
    RE0();
  }

  final public void RE0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 17:
    case 18:
      OP0();
      E1();
      RE0();
      break;
    default:
      jj_la1[2] = jj_gen;

    }
  }

  final public void E1() throws ParseException {
    E2();
    RE1();
  }

  final public void RE1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 19:
    case 20:
      OP1();
      E2();
      RE1();
      break;
    default:
      jj_la1[3] = jj_gen;

    }
  }

  final public void E2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case numeroEntero:
      jj_consume_token(numeroEntero);
      break;
    case numeroReal:
      jj_consume_token(numeroReal);
      break;
    case identificador:
      jj_consume_token(identificador);
      break;
    case 15:
      jj_consume_token(15);
      E0();
      jj_consume_token(16);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP0() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 17:
      jj_consume_token(17);
      break;
    case 18:
      jj_consume_token(18);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void OP1() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 19:
      jj_consume_token(19);
      break;
    case 20:
      jj_consume_token(20);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  public AnalizadorSintacticoTinyTokenManager token_source;
  SimpleCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0x100,0x2000,0x60000,0x180000,0x9c00,0x60000,0x180000,};
   }

  public AnalizadorSintacticoTiny(java.io.InputStream stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AnalizadorSintacticoTinyTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public AnalizadorSintacticoTiny(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  public void ReInit(AnalizadorSintacticoTinyTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[21];
    for (int i = 0; i < 21; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 21; i++) {
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
