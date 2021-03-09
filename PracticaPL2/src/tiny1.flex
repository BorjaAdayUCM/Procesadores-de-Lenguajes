

%%
%line
%column
%class AnalizadorLexicoTiny1
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = (0|{digitoPositivo}{digito}*)
numeroEntero = [\+,\-]?{parteEntera}
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
{int}                     {return ops.unidadInt();}
{real}                    {return ops.unidadReal();}
{bool}                    {return ops.unidadBool();}
{string}                  {return ops.unidadString();}
{and}                     {return ops.unidadAnd();}
{or}                      {return ops.unidadOr();}
{not}                     {return ops.unidadNot();}
{null}                    {return ops.unidadNull();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{proc}                    {return ops.unidadProc();}
{if}                      {return ops.unidadIf();}
{then}                    {return ops.unidadThen();}
{else}                    {return ops.unidadElse();}
{endif}                   {return ops.unidadEndIf();}
{while}                   {return ops.unidadWhile();}
{do}                      {return ops.unidadDo();}
{endwhile}                {return ops.unidadEndWhile();}
{call}                    {return ops.unidadCall();}
{record}                  {return ops.unidadRecord();}
{array}                   {return ops.unidadArray();}
{of}                      {return ops.unidadOf();}
{pointer}                 {return ops.unidadPointer();}
{new}                     {return ops.unidadNew();}
{delete}                  {return ops.unidadDelete();}
{read}                    {return ops.unidadRead();}
{write}                   {return ops.unidadWrite();}
{nl}                      {return ops.unidadNl();}
{var}                     {return ops.unidadVar();}
{type}                    {return ops.unidadType();}
{identificador}           {return ops.unidadId();}
{numeroEntero}            {return ops.unidadNumEnt();}
{numeroReal}              {return ops.unidadNumReal();}
{cadena}                  {return ops.unidadCadena();}
{suma}                    {return ops.unidadMas();}
{resta}                   {return ops.unidadMenos();}
{multiplicacion}          {return ops.unidadPor();}
{division}                {return ops.unidadDiv();}
{pApert}                  {return ops.unidadPAper();}
{pCierre}                 {return ops.unidadPCierre();} 
{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{sep}                     {return ops.unidadSep();}
{modulo}                  {return ops.unidadMod();}
{menor}                   {return ops.unidadMenor();}
{mayor}                   {return ops.unidadMayor();}
{menorIgual}              {return ops.unidadMenorIgual();}
{mayorIgual}              {return ops.unidadMayorIgual();}
{igualdad}                {return ops.unidadIgualdad();}
{distinto}                {return ops.unidadDistinto();}
{pyc}                     {return ops.unidadPyC();}
{corApert}                {return ops.unidadCorAper();}
{corCierre}               {return ops.unidadCorCierre();}
{llaveAper}               {return ops.unidadLlaveAper();}
{llaveCierre}             {return ops.unidadLlaveCierre();}
{punto}                   {return ops.unidadPunto();}
{flecha}                  {return ops.unidadFlecha();}
{ampersand}               {return ops.unidadAmpersand();}
[^]                       {ops.error();} 