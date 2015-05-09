// Generated from /Users/Shuai/Dropbox/cs652/smalltalk/syuanivy-smalltalk/src/smalltalk/compiler/parser/Smalltalk.g4 by ANTLR 4.5
package smalltalk.compiler;

package smalltalk.compiler.parser;
import smalltalk.compiler.semantics.*;
import org.antlr.symtab.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SmalltalkParser}.
 */
public interface SmalltalkListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(SmalltalkParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(SmalltalkParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(SmalltalkParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(SmalltalkParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#instanceVars}.
	 * @param ctx the parse tree
	 */
	void enterInstanceVars(SmalltalkParser.InstanceVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#instanceVars}.
	 * @param ctx the parse tree
	 */
	void exitInstanceVars(SmalltalkParser.InstanceVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(SmalltalkParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(SmalltalkParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void enterClassMethod(SmalltalkParser.ClassMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void exitClassMethod(SmalltalkParser.ClassMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NamedMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterNamedMethod(SmalltalkParser.NamedMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NamedMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitNamedMethod(SmalltalkParser.NamedMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OperatorMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterOperatorMethod(SmalltalkParser.OperatorMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OperatorMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitOperatorMethod(SmalltalkParser.OperatorMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeywordMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterKeywordMethod(SmalltalkParser.KeywordMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeywordMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitKeywordMethod(SmalltalkParser.KeywordMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SmalltalkMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void enterSmalltalkMethodBlock(SmalltalkParser.SmalltalkMethodBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SmalltalkMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void exitSmalltalkMethodBlock(SmalltalkParser.SmalltalkMethodBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimitiveMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveMethodBlock(SmalltalkParser.PrimitiveMethodBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimitiveMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveMethodBlock(SmalltalkParser.PrimitiveMethodBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#localVars}.
	 * @param ctx the parse tree
	 */
	void enterLocalVars(SmalltalkParser.LocalVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#localVars}.
	 * @param ctx the parse tree
	 */
	void exitLocalVars(SmalltalkParser.LocalVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SmalltalkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SmalltalkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#blockArgs}.
	 * @param ctx the parse tree
	 */
	void enterBlockArgs(SmalltalkParser.BlockArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#blockArgs}.
	 * @param ctx the parse tree
	 */
	void exitBlockArgs(SmalltalkParser.BlockArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FullBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void enterFullBody(SmalltalkParser.FullBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FullBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void exitFullBody(SmalltalkParser.FullBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void enterEmptyBody(SmalltalkParser.EmptyBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void exitEmptyBody(SmalltalkParser.EmptyBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(SmalltalkParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(SmalltalkParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturn(SmalltalkParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturn(SmalltalkParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SendMessage}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSendMessage(SmalltalkParser.SendMessageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SendMessage}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSendMessage(SmalltalkParser.SendMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(SmalltalkParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(SmalltalkParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#messageExpression}.
	 * @param ctx the parse tree
	 */
	void enterMessageExpression(SmalltalkParser.MessageExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#messageExpression}.
	 * @param ctx the parse tree
	 */
	void exitMessageExpression(SmalltalkParser.MessageExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void enterKeywordSend(SmalltalkParser.KeywordSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void exitKeywordSend(SmalltalkParser.KeywordSendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuperKeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void enterSuperKeywordSend(SmalltalkParser.SuperKeywordSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuperKeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void exitSuperKeywordSend(SmalltalkParser.SuperKeywordSendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(SmalltalkParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(SmalltalkParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#bop}.
	 * @param ctx the parse tree
	 */
	void enterBop(SmalltalkParser.BopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#bop}.
	 * @param ctx the parse tree
	 */
	void exitBop(SmalltalkParser.BopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#opchar}.
	 * @param ctx the parse tree
	 */
	void enterOpchar(SmalltalkParser.OpcharContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#opchar}.
	 * @param ctx the parse tree
	 */
	void exitOpchar(SmalltalkParser.OpcharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnarySuperMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnarySuperMsgSend(SmalltalkParser.UnarySuperMsgSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnarySuperMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnarySuperMsgSend(SmalltalkParser.UnarySuperMsgSendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMsgSend(SmalltalkParser.UnaryMsgSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMsgSend(SmalltalkParser.UnaryMsgSendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryIsPrimary}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryIsPrimary(SmalltalkParser.UnaryIsPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryIsPrimary}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryIsPrimary(SmalltalkParser.UnaryIsPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SmalltalkParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SmalltalkParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(SmalltalkParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(SmalltalkParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(SmalltalkParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(SmalltalkParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharLiteral(SmalltalkParser.CharLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharLiteral(SmalltalkParser.CharLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(SmalltalkParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(SmalltalkParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code predefinedLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterPredefinedLiteral(SmalltalkParser.PredefinedLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code predefinedLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitPredefinedLiteral(SmalltalkParser.PredefinedLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(SmalltalkParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(SmalltalkParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#predefined}.
	 * @param ctx the parse tree
	 */
	void enterPredefined(SmalltalkParser.PredefinedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#predefined}.
	 * @param ctx the parse tree
	 */
	void exitPredefined(SmalltalkParser.PredefinedContext ctx);
}