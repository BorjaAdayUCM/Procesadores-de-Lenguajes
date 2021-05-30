package constructorAST_ascendente;



%%
%cup
%line
%column
%class AnalizadorLexicoTiny1
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErroresTiny1 errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna()  {return yycolumn+1;}

%}

%eofval{
  return ops.token(ClaseLexica.EOF);
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = (0|{digitoPositivo}{digito}*)
numeroEntero = [\+\-]?{parteEntera}
parteDecimal = \.(0|{digito}* {digitoPositivo})
parteExponencial = (E|e){numeroEntero}
numeroReal = {numeroEntero}({parteDecimal}|{parteExponencial}|{parteDecimal}{parteExponencial})
identificador = {letra}({letra}|{digito}|_)*
cadena = \"[^\"\b\r\n]*\"
separador = [ \t\r\b\n]
comentario = #[^\n]*
int = int
real = real
bool = bool
string = string
and = and
or = or
not = not
null = null
true = true
false = false
proc = proc
if = if
then = then
else = else
endif = endif
while = while
do = do
endwhile = endwhile
call = call
record = record
array = array
of = of
pointer = pointer
new = new
delete = delete
read = read
write = write
nl = nl
var = var
type = type
suma = \+
resta = \-
multiplicacion = \*
division = \/
sep = &&
modulo = %
menor = \<
mayor = \>
menorIgual = \<\=
mayorIgual = \>\=
igualdad = \=\=
distinto = \!\=
pApert = \(
pCierre = \)
pyc = ;
igual = \=
corApert = \[
corCierre = \]
llaveAper = \{
llaveCierre = \}
punto = \.
flecha = \-\>
coma = \,
ampersand = &
%%
{separador}               {}
{comentario}              {}
{int}                     {return ops.token(ClaseLexica.INT);}
{real}                    {return ops.token(ClaseLexica.REAL);}
{bool}                    {return ops.token(ClaseLexica.BOOL);}
{string}                  {return ops.token(ClaseLexica.STRING);}
{and}                     {return ops.token(ClaseLexica.AND);}
{or}                      {return ops.token(ClaseLexica.OR);}
{not}                     {return ops.token(ClaseLexica.NOT);}
{null}                    {return ops.token(ClaseLexica.NULL);}
{true}                    {return ops.token(ClaseLexica.TRUE);}
{false}                   {return ops.token(ClaseLexica.FALSE);}
{proc}                    {return ops.token(ClaseLexica.PROC);}
{if}                      {return ops.token(ClaseLexica.IF);}
{then}                    {return ops.token(ClaseLexica.THEN);}
{else}                    {return ops.token(ClaseLexica.ELSE);}
{endif}                   {return ops.token(ClaseLexica.ENDIF);}
{while}                   {return ops.token(ClaseLexica.WHILE);}
{do}                      {return ops.token(ClaseLexica.DO);}
{endwhile}                {return ops.token(ClaseLexica.ENDWHILE);}
{call}                    {return ops.token(ClaseLexica.CALL);}
{record}                  {return ops.token(ClaseLexica.RECORD);}
{array}                   {return ops.token(ClaseLexica.ARRAY);}
{of}                      {return ops.token(ClaseLexica.OF);}
{pointer}                 {return ops.token(ClaseLexica.POINTER);}
{new}                     {return ops.token(ClaseLexica.NEW);}
{delete}                  {return ops.token(ClaseLexica.DELETE);}
{read}                    {return ops.token(ClaseLexica.READ);}
{write}                   {return ops.token(ClaseLexica.WRITE);}
{nl}                      {return ops.token(ClaseLexica.NL);}
{var}                     {return ops.token(ClaseLexica.VAR);}
{type}                    {return ops.token(ClaseLexica.TYPE);}
{identificador}           {return ops.token(ClaseLexica.IDEN);}
{numeroEntero}            {return ops.token(ClaseLexica.NUMENT);}
{numeroReal}              {return ops.token(ClaseLexica.NUMREAL);}
{cadena}                  {return ops.token(ClaseLexica.CADENA);}
{suma}                    {return ops.token(ClaseLexica.MAS);}
{resta}                   {return ops.token(ClaseLexica.MENOS);}
{multiplicacion}          {return ops.token(ClaseLexica.POR);}
{division}                {return ops.token(ClaseLexica.DIV);}
{pApert}                  {return ops.token(ClaseLexica.PAPER);}
{pCierre}                 {return ops.token(ClaseLexica.PCIERRE);}
{igual}                   {return ops.token(ClaseLexica.IGUAL);}
{coma}                    {return ops.token(ClaseLexica.COMA);}
{sep}                     {return ops.token(ClaseLexica.SEP);}
{modulo}                  {return ops.token(ClaseLexica.MOD);}
{menor}                   {return ops.token(ClaseLexica.MENOR);}
{mayor}                   {return ops.token(ClaseLexica.MAYOR);}
{menorIgual}              {return ops.token(ClaseLexica.MENORIGUAL);}
{mayorIgual}              {return ops.token(ClaseLexica.MAYORIGUAL);}
{igualdad}                {return ops.token(ClaseLexica.IGUALDAD);}
{distinto}                {return ops.token(ClaseLexica.DISTINTO);}
{pyc}                     {return ops.token(ClaseLexica.PYC);}
{corApert}                {return ops.token(ClaseLexica.CORAPER);}
{corCierre}               {return ops.token(ClaseLexica.CORCIERRE);}
{llaveAper}               {return ops.token(ClaseLexica.LLAVEAPER);}
{llaveCierre}             {return ops.token(ClaseLexica.LLAVECIERRE);}
{punto}                   {return ops.token(ClaseLexica.PUNTO);}
{flecha}                  {return ops.token(ClaseLexica.FLECHA);}
{ampersand}               {return ops.token(ClaseLexica.AMPERSAND);}
[^]                       {errores.errorLexico(fila(),lexema());} 