/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTinyTokenManager.java */
package analizadorSintactico;

public class AnalizadorSintacticoTinyTokenManager implements AnalizadorSintacticoTinyConstants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x80000c0000000000L) != 0L)
            return 9;
         if ((active0 & 0x3fffffff000L) != 0L)
            return 7;
         return -1;
      case 1:
         if ((active0 & 0x37def7df000L) != 0L)
         {
            jjmatchedKind = 66;
            jjmatchedPos = 1;
            return -1;
         }
         return -1;
      case 2:
         if ((active0 & 0x37def7df000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 66;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 3:
         if ((active0 & 0x275ef78e000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 66;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 4:
         if ((active0 & 0x55ac208000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 66;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 5:
         if ((active0 & 0x14a0008000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 66;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      case 6:
         if ((active0 & 0x420000000L) != 0L)
         {
            if (jjmatchedPos < 1)
            {
               jjmatchedKind = 66;
               jjmatchedPos = 1;
            }
            return -1;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x20000000000000L);
      case 37:
         return jjStopAtPos(0, 47);
      case 38:
         jjmatchedKind = 65;
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 40:
         return jjStopAtPos(0, 54);
      case 41:
         return jjStopAtPos(0, 55);
      case 42:
         return jjStopAtPos(0, 44);
      case 43:
         return jjStartNfaWithStates_0(0, 42, 9);
      case 44:
         return jjStopAtPos(0, 64);
      case 45:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x8000000000000000L);
      case 46:
         return jjStopAtPos(0, 62);
      case 47:
         return jjStopAtPos(0, 45);
      case 59:
         return jjStopAtPos(0, 56);
      case 60:
         jjmatchedKind = 48;
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 61:
         jjmatchedKind = 57;
         return jjMoveStringLiteralDfa1_0(0x10000000000000L);
      case 62:
         jjmatchedKind = 49;
         return jjMoveStringLiteralDfa1_0(0x8000000000000L);
      case 91:
         return jjStopAtPos(0, 58);
      case 93:
         return jjStopAtPos(0, 59);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x100010000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x1010000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x26000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x801000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x88000c0000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x200020000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x400400000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x2080002000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x20001100000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x4008000000L);
      case 123:
         return jjStopAtPos(0, 60);
      case 125:
         return jjStopAtPos(0, 61);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, 0L);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         break;
      case 61:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStopAtPos(1, 50);
         else if ((active0 & 0x8000000000000L) != 0L)
            return jjStopAtPos(1, 51);
         else if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStopAtPos(1, 53);
         break;
      case 62:
         if ((active0 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 63);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x10040200000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x3880002000L);
      case 102:
         if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(1, 23);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x9000000L);
      case 108:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x24011000L);
      case 111:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         return jjMoveStringLiteralDfa2_0(active0, 0x400044000L);
      case 114:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(1, 17);
         return jjMoveStringLiteralDfa2_0(active0, 0x4100500000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0, 0L);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000002000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000L);
      case 100:
         if ((active0 & 0x10000L) != 0L)
            return jjStopAtPos(2, 16);
         return jjMoveStringLiteralDfa3_0(active0, 0x24000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x4408000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x1040280000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x404000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000000L);
      case 114:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(2, 40);
         return jjMoveStringLiteralDfa3_0(active0, 0x100008000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000L);
      case 116:
         if ((active0 & 0x1000L) != 0L)
            return jjStopAtPos(2, 12);
         else if ((active0 & 0x40000L) != 0L)
            return jjStopAtPos(2, 18);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000L);
      case 119:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(2, 35);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000L);
      case 99:
         if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(3, 22);
         break;
      case 100:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStopAtPos(3, 37);
         break;
      case 101:
         if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(3, 20);
         else if ((active0 & 0x2000000L) != 0L)
            return jjStopAtPos(3, 25);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(3, 41);
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x4008000L);
      case 108:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(3, 13);
         else if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(3, 14);
         else if ((active0 & 0x80000L) != 0L)
            return jjStopAtPos(3, 19);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(3, 30);
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000L);
      case 110:
         if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(3, 24);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000L);
      case 119:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(4, 21);
         else if ((active0 & 0x8000000L) != 0L)
            return jjStopAtPos(4, 27);
         else if ((active0 & 0x4000000000L) != 0L)
            return jjStopAtPos(4, 38);
         break;
      case 102:
         if ((active0 & 0x4000000L) != 0L)
            return jjStopAtPos(4, 26);
         break;
      case 104:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x80000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x1400000000L);
      case 121:
         if ((active0 & 0x100000000L) != 0L)
            return jjStopAtPos(4, 32);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(5, 31);
         break;
      case 101:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(5, 36);
         return jjMoveStringLiteralDfa6_0(active0, 0x400000000L);
      case 103:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(5, 15);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa7_0(active0, 0x20000000L);
      case 114:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(6, 34);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(7, 29);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 32;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 9:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  else if (curChar == 48)
                     jjCheckNAddTwoStates(14, 19);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 5)
                        kind = 5;
                     jjCheckNAdd(10);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 5)
                        kind = 5;
                  }
                  break;
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 5)
                        kind = 5;
                     jjCheckNAddStates(3, 6);
                  }
                  else if ((0x100002700L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjAddStates(7, 10);
                  else if (curChar == 48)
                  {
                     if (kind > 5)
                        kind = 5;
                     jjCheckNAddTwoStates(14, 19);
                  }
                  else if (curChar == 35)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAdd(5);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 1:
                  if ((0xfffffffbffffd8ffL & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar == 34 && kind > 9)
                     kind = 9;
                  break;
               case 3:
                  if ((0x100002700L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 4:
                  if (curChar != 35)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(5);
                  break;
               case 5:
                  if ((0xfffffffffffffbffL & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(5);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) != 0L && kind > 66)
                     kind = 66;
                  break;
               case 8:
                  if ((0x280000000000L & l) != 0L)
                     jjAddStates(7, 10);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if (curChar == 48 && kind > 5)
                     kind = 5;
                  break;
               case 12:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(0, 2);
                  break;
               case 15:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(16, 18);
                  break;
               case 16:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(17);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(17);
                  break;
               case 18:
                  if (curChar == 48 && kind > 8)
                     kind = 8;
                  break;
               case 19:
                  if (curChar == 46)
                     jjCheckNAddStates(11, 16);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(20, 21);
                  break;
               case 21:
                  if ((0x3fe000000000000L & l) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 22:
                  if (curChar == 48)
                     jjCheckNAdd(23);
                  break;
               case 24:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(25, 18);
                  break;
               case 25:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(26);
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAdd(26);
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(27, 28);
                  break;
               case 28:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAdd(23);
                  break;
               case 29:
                  if (curChar == 48)
                     jjCheckNAddTwoStates(14, 19);
                  break;
               case 30:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjCheckNAddStates(3, 6);
                  break;
               case 31:
                  if (curChar != 48)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjCheckNAddTwoStates(14, 19);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 1:
                  jjAddStates(17, 18);
                  break;
               case 5:
                  if (kind > 11)
                     kind = 11;
                  jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if ((0x7fffffe87fffffeL & l) != 0L && kind > 66)
                     kind = 66;
                  break;
               case 14:
                  if ((0x2000000020L & l) != 0L)
                     jjCheckNAddStates(19, 21);
                  break;
               case 23:
                  if ((0x2000000020L & l) != 0L)
                     jjCheckNAddStates(22, 24);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(17, 18);
                  break;
               case 5:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjstateSet[jjnewStateCnt++] = 5;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 32 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   13, 14, 19, 10, 13, 14, 19, 9, 11, 12, 29, 18, 20, 21, 22, 27, 
   28, 1, 2, 15, 16, 18, 24, 25, 18, 
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, 
"\151\156\164", "\162\145\141\154", "\142\157\157\154", "\163\164\162\151\156\147", 
"\141\156\144", "\157\162", "\156\157\164", "\156\165\154\154", "\164\162\165\145", 
"\146\141\154\163\145", "\160\162\157\143", "\151\146", "\164\150\145\156", "\145\154\163\145", 
"\145\156\144\151\146", "\167\150\151\154\145", "\144\157", "\145\156\144\167\150\151\154\145", 
"\143\141\154\154", "\162\145\143\157\162\144", "\141\162\162\141\171", "\157\146", 
"\160\157\151\156\164\145\162", "\156\145\167", "\144\145\154\145\164\145", "\162\145\141\144", 
"\167\162\151\164\145", "\156\154", "\166\141\162", "\164\171\160\145", "\53", "\55", "\52", "\57", 
"\46\46", "\45", "\74", "\76", "\74\75", "\76\75", "\75\75", "\41\75", "\50", "\51", 
"\73", "\75", "\133", "\135", "\173", "\175", "\56", "\55\76", "\54", "\46", null, };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0xfffffffffffff321L, 0x7L, 
};
static final long[] jjtoSkip = {
   0xc00L, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[32];
private final int[] jjstateSet = new int[64];
protected char curChar;
public AnalizadorSintacticoTinyTokenManager(SimpleCharStream stream)
{
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public AnalizadorSintacticoTinyTokenManager(SimpleCharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 32; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
