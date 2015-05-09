// Generated from /Users/Shuai/Dropbox/cs652/smalltalk/syuanivy-smalltalk/src/smalltalk/compiler/parser/Smalltalk.g4 by ANTLR 4.5
package smalltalk.compiler;

package smalltalk.compiler.parser;
import smalltalk.compiler.semantics.*;
import org.antlr.symtab.*;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SmalltalkParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SmalltalkVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(SmalltalkParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(SmalltalkParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#instanceVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceVars(SmalltalkParser.InstanceVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(SmalltalkParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#classMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethod(SmalltalkParser.ClassMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NamedMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedMethod(SmalltalkParser.NamedMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OperatorMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorMethod(SmalltalkParser.OperatorMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeywordMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordMethod(SmalltalkParser.KeywordMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SmalltalkMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSmalltalkMethodBlock(SmalltalkParser.SmalltalkMethodBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveMethodBlock(SmalltalkParser.PrimitiveMethodBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#localVars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVars(SmalltalkParser.LocalVarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SmalltalkParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#blockArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockArgs(SmalltalkParser.BlockArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FullBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullBody(SmalltalkParser.FullBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyBody(SmalltalkParser.EmptyBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SmalltalkParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(SmalltalkParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SendMessage}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSendMessage(SmalltalkParser.SendMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#lvalue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLvalue(SmalltalkParser.LvalueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#messageExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageExpression(SmalltalkParser.MessageExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordSend(SmalltalkParser.KeywordSendContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SuperKeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperKeywordSend(SmalltalkParser.SuperKeywordSendContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#binaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpression(SmalltalkParser.BinaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#bop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBop(SmalltalkParser.BopContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#opchar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpchar(SmalltalkParser.OpcharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnarySuperMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnarySuperMsgSend(SmalltalkParser.UnarySuperMsgSendContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMsgSend(SmalltalkParser.UnaryMsgSendContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryIsPrimary}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryIsPrimary(SmalltalkParser.UnaryIsPrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SmalltalkParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(SmalltalkParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(SmalltalkParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharLiteral(SmalltalkParser.CharLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(SmalltalkParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code predefinedLiteral}
	 * labeled alternative in {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredefinedLiteral(SmalltalkParser.PredefinedLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(SmalltalkParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link SmalltalkParser#predefined}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredefined(SmalltalkParser.PredefinedContext ctx);
}