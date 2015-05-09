grammar Smalltalk;

@header {
package smalltalk.compiler.parser;
import smalltalk.compiler.semantics.*;
import org.antlr.symtab.*;
}

file returns [GlobalScope scope]
    : classDef* main EOF ;

classDef returns [STClass scope]
	:	'class' className = ID (':' superName = ID)? '[' instanceVars? classMethod* method* ']'
	;

instanceVars : localVars ;

main returns [STClass classScope, STMethod scope] : body ;

classMethod
	:	'class' method
	;

method returns [STMethod scope]
	:	ID methodBlock						# NamedMethod
	|	bop ID methodBlock					# OperatorMethod
	|	(KEYWORD ID)+ methodBlock			# KeywordMethod
	;


methodBlock locals [String selector, List<String> args]
// listeners for rule method can set these locals, rule methodBlock listeners can read
// use locals not args so no antlr warnings.
	:	'[' body ']'						# SmalltalkMethodBlock
    |   '<' 'primitive:' SYMBOL '>'			# PrimitiveMethodBlock
	;

localVars
	:	'|' ID+ '|'
	;

block returns [STBlock scope]
	:	'[' (blockArgs '|')? body ']'
	;

blockArgs : (':' ID)+ ;

body:	localVars? stat ('.' stat)* '.'?	# FullBody
    |  	localVars?							# EmptyBody
    ;

stat:	lvalue ':=' messageExpression		# Assign
	|	'^' messageExpression				# Return
	|	messageExpression					# SendMessage
	;

lvalue returns [VariableSymbol sym] // set sym to ID if assignment
	:	ID
	;

messageExpression
	:	keywordExpression
	;

keywordExpression
	:	recv=binaryExpression ( KEYWORD args+=binaryExpression )*	# KeywordSend
	|	'super' ( KEYWORD args+=binaryExpression )+					# SuperKeywordSend
	;

binaryExpression
	:	unaryExpression ( bop unaryExpression )*
	;

/** "A binary message selector is composed of one or two nonalphanumeric characters.
    The only restriction is that the second character cannot be a minus sign."
    BlueBlook p 49 in pdf.
*/
bop : (opchar|'-') opchar? ;

opchar
	:	'+'
	|	'/' | '\\'
	|	'*' | '~'
	|	'<' | '>'
	|	'='	| '@' | '%' | '|' | '&' | '?' | ','
	;

unaryExpression
	:	primary								# UnaryIsPrimary
	|	unaryExpression ID					# UnaryMsgSend
	|	'super' ID							# UnarySuperMsgSend
	;

primary
	:	literal
	|	array
	|	id
	|	block
	|	'(' messageExpression ')'
	;

id returns [Symbol sym] // could be class, field, arg ref etc...
	:	ID
	;

literal
	:	NUMBER                              #numberLiteral
	|	CHAR                                #charLiteral
	|	STRING                              #stringLiteral
	|	predefined                          #predefinedLiteral
	;

/** Like #(1 2 3) except we can have expressions in array not just literals */
array : '{' ( messageExpression ('.' messageExpression)* '.'? )? '}' ;

predefined
    :   SELF
    |   NIL
    |   TRUE
    |   FALSE
    ;

SELF   : 'self' ;
SUPER  : 'super' ;
NIL    : 'nil' ;
TRUE   : 'true' ;
FALSE  : 'false' ;

KEYWORD
	:	ID ':' {getInputStream().LA(1)!='='}?
	;

ID  :	[a-zA-Z_] [a-zA-Z_0-9]*
    ;

SYMBOL
	:	'#' ID
	;

COMMENT
	:	'"' ('""' | ~'"')* '"' -> channel(HIDDEN)
	;

CHAR:	'$' ~('@'|'\n'|'\t'|' ') ;

WS	:	(' '|'\t'|'\n')+ -> channel(HIDDEN) ;

NUMBER
	:	'-' NUMBER
	|	[0-9]+
	|	[0-9]+ '.' [0-9]+
	;

STRING : '\'' ('\'\'' | ~'\'')* '\'' ;

RETURN : '^' ;

LBRACK : '[' ;

RBRACK : ']' ;



