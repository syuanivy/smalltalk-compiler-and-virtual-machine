// Generated from /Users/Shuai/Dropbox/cs652/smalltalk/syuanivy-smalltalk/src/smalltalk/compiler/parser/Smalltalk.g4 by ANTLR 4.5

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
	void enterFile(@NotNull SmalltalkParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(@NotNull SmalltalkParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(@NotNull SmalltalkParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(@NotNull SmalltalkParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#instanceVars}.
	 * @param ctx the parse tree
	 */
	void enterInstanceVars(@NotNull SmalltalkParser.InstanceVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#instanceVars}.
	 * @param ctx the parse tree
	 */
	void exitInstanceVars(@NotNull SmalltalkParser.InstanceVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(@NotNull SmalltalkParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(@NotNull SmalltalkParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void enterClassMethod(@NotNull SmalltalkParser.ClassMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void exitClassMethod(@NotNull SmalltalkParser.ClassMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NamedMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterNamedMethod(@NotNull SmalltalkParser.NamedMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NamedMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitNamedMethod(@NotNull SmalltalkParser.NamedMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code OperatorMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterOperatorMethod(@NotNull SmalltalkParser.OperatorMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code OperatorMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitOperatorMethod(@NotNull SmalltalkParser.OperatorMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeywordMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void enterKeywordMethod(@NotNull SmalltalkParser.KeywordMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeywordMethod}
	 * labeled alternative in {@link SmalltalkParser#method}.
	 * @param ctx the parse tree
	 */
	void exitKeywordMethod(@NotNull SmalltalkParser.KeywordMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SmalltalkMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void enterSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SmalltalkMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void exitSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimitiveMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveMethodBlock(@NotNull SmalltalkParser.PrimitiveMethodBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimitiveMethodBlock}
	 * labeled alternative in {@link SmalltalkParser#methodBlock}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveMethodBlock(@NotNull SmalltalkParser.PrimitiveMethodBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#localVars}.
	 * @param ctx the parse tree
	 */
	void enterLocalVars(@NotNull SmalltalkParser.LocalVarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#localVars}.
	 * @param ctx the parse tree
	 */
	void exitLocalVars(@NotNull SmalltalkParser.LocalVarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull SmalltalkParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull SmalltalkParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#blockArgs}.
	 * @param ctx the parse tree
	 */
	void enterBlockArgs(@NotNull SmalltalkParser.BlockArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#blockArgs}.
	 * @param ctx the parse tree
	 */
	void exitBlockArgs(@NotNull SmalltalkParser.BlockArgsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FullBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void enterFullBody(@NotNull SmalltalkParser.FullBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FullBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void exitFullBody(@NotNull SmalltalkParser.FullBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EmptyBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void enterEmptyBody(@NotNull SmalltalkParser.EmptyBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EmptyBody}
	 * labeled alternative in {@link SmalltalkParser#body}.
	 * @param ctx the parse tree
	 */
	void exitEmptyBody(@NotNull SmalltalkParser.EmptyBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull SmalltalkParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull SmalltalkParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturn(@NotNull SmalltalkParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Return}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturn(@NotNull SmalltalkParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SendMessage}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSendMessage(@NotNull SmalltalkParser.SendMessageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SendMessage}
	 * labeled alternative in {@link SmalltalkParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSendMessage(@NotNull SmalltalkParser.SendMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(@NotNull SmalltalkParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(@NotNull SmalltalkParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#messageExpression}.
	 * @param ctx the parse tree
	 */
	void enterMessageExpression(@NotNull SmalltalkParser.MessageExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#messageExpression}.
	 * @param ctx the parse tree
	 */
	void exitMessageExpression(@NotNull SmalltalkParser.MessageExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void enterKeywordSend(@NotNull SmalltalkParser.KeywordSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void exitKeywordSend(@NotNull SmalltalkParser.KeywordSendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuperKeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void enterSuperKeywordSend(@NotNull SmalltalkParser.SuperKeywordSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuperKeywordSend}
	 * labeled alternative in {@link SmalltalkParser#keywordExpression}.
	 * @param ctx the parse tree
	 */
	void exitSuperKeywordSend(@NotNull SmalltalkParser.SuperKeywordSendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(@NotNull SmalltalkParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(@NotNull SmalltalkParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#bop}.
	 * @param ctx the parse tree
	 */
	void enterBop(@NotNull SmalltalkParser.BopContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#bop}.
	 * @param ctx the parse tree
	 */
	void exitBop(@NotNull SmalltalkParser.BopContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#opchar}.
	 * @param ctx the parse tree
	 */
	void enterOpchar(@NotNull SmalltalkParser.OpcharContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#opchar}.
	 * @param ctx the parse tree
	 */
	void exitOpchar(@NotNull SmalltalkParser.OpcharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMsgSend(@NotNull SmalltalkParser.UnaryMsgSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMsgSend(@NotNull SmalltalkParser.UnaryMsgSendContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryIsPrimary}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryIsPrimary(@NotNull SmalltalkParser.UnaryIsPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryIsPrimary}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryIsPrimary(@NotNull SmalltalkParser.UnaryIsPrimaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnarySuperMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnarySuperMsgSend(@NotNull SmalltalkParser.UnarySuperMsgSendContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnarySuperMsgSend}
	 * labeled alternative in {@link SmalltalkParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnarySuperMsgSend(@NotNull SmalltalkParser.UnarySuperMsgSendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull SmalltalkParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull SmalltalkParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull SmalltalkParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull SmalltalkParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull SmalltalkParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull SmalltalkParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SmalltalkParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(@NotNull SmalltalkParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link SmalltalkParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(@NotNull SmalltalkParser.ArrayContext ctx);
}