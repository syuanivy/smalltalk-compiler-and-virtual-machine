// Generated from /Users/Shuai/Dropbox/cs652/smalltalk/syuanivy-smalltalk/src/smalltalk/compiler/parser/Smalltalk.g4 by ANTLR 4.5

package smalltalk.compiler.parser;
import smalltalk.compiler.semantics.*;
import org.antlr.symtab.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SmalltalkParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		SELF=25, SUPER=26, NIL=27, TRUE=28, FALSE=29, KEYWORD=30, ID=31, SYMBOL=32, 
		COMMENT=33, CHAR=34, WS=35, NUMBER=36, STRING=37, RETURN=38, LBRACK=39, 
		RBRACK=40;
	public static final int
		RULE_file = 0, RULE_classDef = 1, RULE_instanceVars = 2, RULE_main = 3, 
		RULE_classMethod = 4, RULE_method = 5, RULE_methodBlock = 6, RULE_localVars = 7, 
		RULE_block = 8, RULE_blockArgs = 9, RULE_body = 10, RULE_stat = 11, RULE_lvalue = 12, 
		RULE_messageExpression = 13, RULE_keywordExpression = 14, RULE_binaryExpression = 15, 
		RULE_bop = 16, RULE_opchar = 17, RULE_unaryExpression = 18, RULE_primary = 19, 
		RULE_id = 20, RULE_literal = 21, RULE_array = 22, RULE_predefined = 23;
	public static final String[] ruleNames = {
		"file", "classDef", "instanceVars", "main", "classMethod", "method", "methodBlock", 
		"localVars", "block", "blockArgs", "body", "stat", "lvalue", "messageExpression", 
		"keywordExpression", "binaryExpression", "bop", "opchar", "unaryExpression", 
		"primary", "id", "literal", "array", "predefined"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "':'", "'<'", "'primitive:'", "'>'", "'|'", "'.'", "':='", 
		"'-'", "'+'", "'/'", "'\\'", "'*'", "'~'", "'='", "'@'", "'%'", "'&'", 
		"'?'", "','", "'('", "')'", "'{'", "'}'", "'self'", "'super'", "'nil'", 
		"'true'", "'false'", null, null, null, null, null, null, null, null, "'^'", 
		"'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "SELF", "SUPER", "NIL", "TRUE", "FALSE", "KEYWORD", "ID", "SYMBOL", 
		"COMMENT", "CHAR", "WS", "NUMBER", "STRING", "RETURN", "LBRACK", "RBRACK"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Smalltalk.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SmalltalkParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public GlobalScope scope;
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SmalltalkParser.EOF, 0); }
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(48); 
				classDef();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54); 
			main();
			setState(55); 
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public STClass scope;
		public Token className;
		public Token superName;
		public List<TerminalNode> ID() { return getTokens(SmalltalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmalltalkParser.ID, i);
		}
		public InstanceVarsContext instanceVars() {
			return getRuleContext(InstanceVarsContext.class,0);
		}
		public List<ClassMethodContext> classMethod() {
			return getRuleContexts(ClassMethodContext.class);
		}
		public ClassMethodContext classMethod(int i) {
			return getRuleContext(ClassMethodContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); 
			match(T__0);
			setState(58); 
			((ClassDefContext)_localctx).className = match(ID);
			setState(61);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(59); 
				match(T__1);
				setState(60); 
				((ClassDefContext)_localctx).superName = match(ID);
				}
			}

			setState(63); 
			match(LBRACK);
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(64); 
				instanceVars();
				}
				break;
			}
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(67); 
				classMethod();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << KEYWORD) | (1L << ID))) != 0)) {
				{
				{
				setState(73); 
				method();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79); 
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstanceVarsContext extends ParserRuleContext {
		public LocalVarsContext localVars() {
			return getRuleContext(LocalVarsContext.class,0);
		}
		public InstanceVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterInstanceVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitInstanceVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitInstanceVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceVarsContext instanceVars() throws RecognitionException {
		InstanceVarsContext _localctx = new InstanceVarsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instanceVars);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); 
			localVars();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public STClass classScope;
		public STMethod scope;
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); 
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassMethodContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public ClassMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterClassMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitClassMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitClassMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMethodContext classMethod() throws RecognitionException {
		ClassMethodContext _localctx = new ClassMethodContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classMethod);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			match(T__0);
			setState(86); 
			method();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public STMethod scope;
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
	 
		public MethodContext() { }
		public void copyFrom(MethodContext ctx) {
			super.copyFrom(ctx);
			this.scope = ctx.scope;
		}
	}
	public static class NamedMethodContext extends MethodContext {
		public TerminalNode ID() { return getToken(SmalltalkParser.ID, 0); }
		public MethodBlockContext methodBlock() {
			return getRuleContext(MethodBlockContext.class,0);
		}
		public NamedMethodContext(MethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterNamedMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitNamedMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitNamedMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KeywordMethodContext extends MethodContext {
		public MethodBlockContext methodBlock() {
			return getRuleContext(MethodBlockContext.class,0);
		}
		public List<TerminalNode> KEYWORD() { return getTokens(SmalltalkParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(SmalltalkParser.KEYWORD, i);
		}
		public List<TerminalNode> ID() { return getTokens(SmalltalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmalltalkParser.ID, i);
		}
		public KeywordMethodContext(MethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterKeywordMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitKeywordMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitKeywordMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OperatorMethodContext extends MethodContext {
		public BopContext bop() {
			return getRuleContext(BopContext.class,0);
		}
		public TerminalNode ID() { return getToken(SmalltalkParser.ID, 0); }
		public MethodBlockContext methodBlock() {
			return getRuleContext(MethodBlockContext.class,0);
		}
		public OperatorMethodContext(MethodContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterOperatorMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitOperatorMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitOperatorMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			setState(101);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NamedMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(88); 
				match(ID);
				setState(89); 
				methodBlock();
				}
				break;
			case T__2:
			case T__4:
			case T__5:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				_localctx = new OperatorMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(90); 
				bop();
				setState(91); 
				match(ID);
				setState(92); 
				methodBlock();
				}
				break;
			case KEYWORD:
				_localctx = new KeywordMethodContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(94); 
					match(KEYWORD);
					setState(95); 
					match(ID);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==KEYWORD );
				setState(100); 
				methodBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBlockContext extends ParserRuleContext {
		public String selector;
		public List<String> args;
		public MethodBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBlock; }
	 
		public MethodBlockContext() { }
		public void copyFrom(MethodBlockContext ctx) {
			super.copyFrom(ctx);
			this.selector = ctx.selector;
			this.args = ctx.args;
		}
	}
	public static class PrimitiveMethodBlockContext extends MethodBlockContext {
		public TerminalNode SYMBOL() { return getToken(SmalltalkParser.SYMBOL, 0); }
		public PrimitiveMethodBlockContext(MethodBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterPrimitiveMethodBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitPrimitiveMethodBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitPrimitiveMethodBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmalltalkMethodBlockContext extends MethodBlockContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public SmalltalkMethodBlockContext(MethodBlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterSmalltalkMethodBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitSmalltalkMethodBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitSmalltalkMethodBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBlockContext methodBlock() throws RecognitionException {
		MethodBlockContext _localctx = new MethodBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodBlock);
		try {
			setState(111);
			switch (_input.LA(1)) {
			case LBRACK:
				_localctx = new SmalltalkMethodBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103); 
				match(LBRACK);
				setState(104); 
				body();
				setState(105); 
				match(RBRACK);
				}
				break;
			case T__2:
				_localctx = new PrimitiveMethodBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(107); 
				match(T__2);
				setState(108); 
				match(T__3);
				setState(109); 
				match(SYMBOL);
				setState(110); 
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalVarsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SmalltalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmalltalkParser.ID, i);
		}
		public LocalVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterLocalVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitLocalVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitLocalVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocalVarsContext localVars() throws RecognitionException {
		LocalVarsContext _localctx = new LocalVarsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_localVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			match(T__5);
			setState(115); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(114); 
				match(ID);
				}
				}
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(119); 
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public STBlock scope;
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public BlockArgsContext blockArgs() {
			return getRuleContext(BlockArgsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			match(LBRACK);
			setState(125);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(122); 
				blockArgs();
				setState(123); 
				match(T__5);
				}
			}

			setState(127); 
			body();
			setState(128); 
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockArgsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SmalltalkParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SmalltalkParser.ID, i);
		}
		public BlockArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterBlockArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitBlockArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBlockArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockArgsContext blockArgs() throws RecognitionException {
		BlockArgsContext _localctx = new BlockArgsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130); 
				match(T__1);
				setState(131); 
				match(ID);
				}
				}
				setState(134); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	 
		public BodyContext() { }
		public void copyFrom(BodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FullBodyContext extends BodyContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public LocalVarsContext localVars() {
			return getRuleContext(LocalVarsContext.class,0);
		}
		public FullBodyContext(BodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterFullBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitFullBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitFullBody(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyBodyContext extends BodyContext {
		public LocalVarsContext localVars() {
			return getRuleContext(LocalVarsContext.class,0);
		}
		public EmptyBodyContext(BodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterEmptyBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitEmptyBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitEmptyBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_body);
		int _la;
		try {
			int _alt;
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new FullBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(136); 
					localVars();
					}
				}

				setState(139); 
				stat();
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(140); 
						match(T__6);
						setState(141); 
						stat();
						}
						} 
					}
					setState(146);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(148);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(147); 
					match(T__6);
					}
				}

				}
				break;
			case 2:
				_localctx = new EmptyBodyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(150); 
					localVars();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignContext extends StatContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public MessageExpressionContext messageExpression() {
			return getRuleContext(MessageExpressionContext.class,0);
		}
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SendMessageContext extends StatContext {
		public MessageExpressionContext messageExpression() {
			return getRuleContext(MessageExpressionContext.class,0);
		}
		public SendMessageContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterSendMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitSendMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitSendMessage(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnContext extends StatContext {
		public MessageExpressionContext messageExpression() {
			return getRuleContext(MessageExpressionContext.class,0);
		}
		public ReturnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stat);
		try {
			setState(162);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155); 
				lvalue();
				setState(156); 
				match(T__7);
				setState(157); 
				messageExpression();
				}
				break;
			case 2:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159); 
				match(RETURN);
				setState(160); 
				messageExpression();
				}
				break;
			case 3:
				_localctx = new SendMessageContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161); 
				messageExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public VariableSymbol sym;
		public TerminalNode ID() { return getToken(SmalltalkParser.ID, 0); }
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lvalue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); 
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageExpressionContext extends ParserRuleContext {
		public KeywordExpressionContext keywordExpression() {
			return getRuleContext(KeywordExpressionContext.class,0);
		}
		public MessageExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterMessageExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitMessageExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitMessageExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageExpressionContext messageExpression() throws RecognitionException {
		MessageExpressionContext _localctx = new MessageExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_messageExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); 
			keywordExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordExpressionContext extends ParserRuleContext {
		public KeywordExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordExpression; }
	 
		public KeywordExpressionContext() { }
		public void copyFrom(KeywordExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SuperKeywordSendContext extends KeywordExpressionContext {
		public BinaryExpressionContext binaryExpression;
		public List<BinaryExpressionContext> args = new ArrayList<BinaryExpressionContext>();
		public List<TerminalNode> KEYWORD() { return getTokens(SmalltalkParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(SmalltalkParser.KEYWORD, i);
		}
		public List<BinaryExpressionContext> binaryExpression() {
			return getRuleContexts(BinaryExpressionContext.class);
		}
		public BinaryExpressionContext binaryExpression(int i) {
			return getRuleContext(BinaryExpressionContext.class,i);
		}
		public SuperKeywordSendContext(KeywordExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterSuperKeywordSend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitSuperKeywordSend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitSuperKeywordSend(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class KeywordSendContext extends KeywordExpressionContext {
		public BinaryExpressionContext recv;
		public BinaryExpressionContext binaryExpression;
		public List<BinaryExpressionContext> args = new ArrayList<BinaryExpressionContext>();
		public List<BinaryExpressionContext> binaryExpression() {
			return getRuleContexts(BinaryExpressionContext.class);
		}
		public BinaryExpressionContext binaryExpression(int i) {
			return getRuleContext(BinaryExpressionContext.class,i);
		}
		public List<TerminalNode> KEYWORD() { return getTokens(SmalltalkParser.KEYWORD); }
		public TerminalNode KEYWORD(int i) {
			return getToken(SmalltalkParser.KEYWORD, i);
		}
		public KeywordSendContext(KeywordExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterKeywordSend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitKeywordSend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitKeywordSend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordExpressionContext keywordExpression() throws RecognitionException {
		KeywordExpressionContext _localctx = new KeywordExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keywordExpression);
		int _la;
		try {
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new KeywordSendContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168); 
				((KeywordSendContext)_localctx).recv = binaryExpression();
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==KEYWORD) {
					{
					{
					setState(169); 
					match(KEYWORD);
					setState(170); 
					((KeywordSendContext)_localctx).binaryExpression = binaryExpression();
					((KeywordSendContext)_localctx).args.add(((KeywordSendContext)_localctx).binaryExpression);
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new SuperKeywordSendContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176); 
				match(SUPER);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(177); 
					match(KEYWORD);
					setState(178); 
					((SuperKeywordSendContext)_localctx).binaryExpression = binaryExpression();
					((SuperKeywordSendContext)_localctx).args.add(((SuperKeywordSendContext)_localctx).binaryExpression);
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==KEYWORD );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryExpressionContext extends ParserRuleContext {
		public List<UnaryExpressionContext> unaryExpression() {
			return getRuleContexts(UnaryExpressionContext.class);
		}
		public UnaryExpressionContext unaryExpression(int i) {
			return getRuleContext(UnaryExpressionContext.class,i);
		}
		public List<BopContext> bop() {
			return getRuleContexts(BopContext.class);
		}
		public BopContext bop(int i) {
			return getRuleContext(BopContext.class,i);
		}
		public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_binaryExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185); 
			unaryExpression(0);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				{
				setState(186); 
				bop();
				setState(187); 
				unaryExpression(0);
				}
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BopContext extends ParserRuleContext {
		public List<OpcharContext> opchar() {
			return getRuleContexts(OpcharContext.class);
		}
		public OpcharContext opchar(int i) {
			return getRuleContext(OpcharContext.class,i);
		}
		public BopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterBop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitBop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitBop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BopContext bop() throws RecognitionException {
		BopContext _localctx = new BopContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			switch (_input.LA(1)) {
			case T__2:
			case T__4:
			case T__5:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				{
				setState(194); 
				opchar();
				}
				break;
			case T__8:
				{
				setState(195); 
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(199);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				setState(198); 
				opchar();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpcharContext extends ParserRuleContext {
		public OpcharContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opchar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterOpchar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitOpchar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitOpchar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpcharContext opchar() throws RecognitionException {
		OpcharContext _localctx = new OpcharContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_opchar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	 
		public UnaryExpressionContext() { }
		public void copyFrom(UnaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryMsgSendContext extends UnaryExpressionContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(SmalltalkParser.ID, 0); }
		public UnaryMsgSendContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterUnaryMsgSend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitUnaryMsgSend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnaryMsgSend(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryIsPrimaryContext extends UnaryExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public UnaryIsPrimaryContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterUnaryIsPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitUnaryIsPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnaryIsPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnarySuperMsgSendContext extends UnaryExpressionContext {
		public TerminalNode ID() { return getToken(SmalltalkParser.ID, 0); }
		public UnarySuperMsgSendContext(UnaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterUnarySuperMsgSend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitUnarySuperMsgSend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitUnarySuperMsgSend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		return unaryExpression(0);
	}

	private UnaryExpressionContext unaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, _parentState);
		UnaryExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_unaryExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			switch (_input.LA(1)) {
			case T__20:
			case T__22:
			case SELF:
			case NIL:
			case TRUE:
			case FALSE:
			case ID:
			case CHAR:
			case NUMBER:
			case STRING:
			case LBRACK:
				{
				_localctx = new UnaryIsPrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(204); 
				primary();
				}
				break;
			case SUPER:
				{
				_localctx = new UnarySuperMsgSendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205); 
				match(SUPER);
				setState(206); 
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new UnaryMsgSendContext(new UnaryExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_unaryExpression);
					setState(209);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(210); 
					match(ID);
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MessageExpressionContext messageExpression() {
			return getRuleContext(MessageExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_primary);
		try {
			setState(224);
			switch (_input.LA(1)) {
			case SELF:
			case NIL:
			case TRUE:
			case FALSE:
			case CHAR:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(216); 
				literal();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(217); 
				array();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(218); 
				id();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(219); 
				block();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				setState(220); 
				match(T__20);
				setState(221); 
				messageExpression();
				setState(222); 
				match(T__21);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public Symbol sym;
		public TerminalNode ID() { return getToken(SmalltalkParser.ID, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); 
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode STRING() { return getToken(SmalltalkParser.STRING, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PredefinedLiteralContext extends LiteralContext {
		public PredefinedContext predefined() {
			return getRuleContext(PredefinedContext.class,0);
		}
		public PredefinedLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterPredefinedLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitPredefinedLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitPredefinedLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralContext extends LiteralContext {
		public TerminalNode CHAR() { return getToken(SmalltalkParser.CHAR, 0); }
		public CharLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitCharLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralContext extends LiteralContext {
		public TerminalNode NUMBER() { return getToken(SmalltalkParser.NUMBER, 0); }
		public NumberLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		try {
			setState(232);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new NumberLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(228); 
				match(NUMBER);
				}
				break;
			case CHAR:
				_localctx = new CharLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(229); 
				match(CHAR);
				}
				break;
			case STRING:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(230); 
				match(STRING);
				}
				break;
			case SELF:
			case NIL:
			case TRUE:
			case FALSE:
				_localctx = new PredefinedLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(231); 
				predefined();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<MessageExpressionContext> messageExpression() {
			return getRuleContexts(MessageExpressionContext.class);
		}
		public MessageExpressionContext messageExpression(int i) {
			return getRuleContext(MessageExpressionContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234); 
			match(T__22);
			setState(246);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__22) | (1L << SELF) | (1L << SUPER) | (1L << NIL) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << CHAR) | (1L << NUMBER) | (1L << STRING) | (1L << LBRACK))) != 0)) {
				{
				setState(235); 
				messageExpression();
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(236); 
						match(T__6);
						setState(237); 
						messageExpression();
						}
						} 
					}
					setState(242);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				setState(244);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(243); 
					match(T__6);
					}
				}

				}
			}

			setState(248); 
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredefinedContext extends ParserRuleContext {
		public TerminalNode SELF() { return getToken(SmalltalkParser.SELF, 0); }
		public TerminalNode NIL() { return getToken(SmalltalkParser.NIL, 0); }
		public TerminalNode TRUE() { return getToken(SmalltalkParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SmalltalkParser.FALSE, 0); }
		public PredefinedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predefined; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterPredefined(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitPredefined(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitPredefined(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredefinedContext predefined() throws RecognitionException {
		PredefinedContext _localctx = new PredefinedContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_predefined);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << NIL) | (1L << TRUE) | (1L << FALSE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18: 
			return unaryExpression_sempred((UnaryExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean unaryExpression_sempred(UnaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: 
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00ff\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\7\2\64\n\2\f\2\16\2\67\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3@\n\3"+
		"\3\3\3\3\5\3D\n\3\3\3\7\3G\n\3\f\3\16\3J\13\3\3\3\7\3M\n\3\f\3\16\3P\13"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\6\7c\n\7\r\7\16\7d\3\7\5\7h\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\br"+
		"\n\b\3\t\3\t\6\tv\n\t\r\t\16\tw\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0080\n\n"+
		"\3\n\3\n\3\n\3\13\3\13\6\13\u0087\n\13\r\13\16\13\u0088\3\f\5\f\u008c"+
		"\n\f\3\f\3\f\3\f\7\f\u0091\n\f\f\f\16\f\u0094\13\f\3\f\5\f\u0097\n\f\3"+
		"\f\5\f\u009a\n\f\5\f\u009c\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a5\n"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\7\20\u00ae\n\20\f\20\16\20\u00b1"+
		"\13\20\3\20\3\20\3\20\6\20\u00b6\n\20\r\20\16\20\u00b7\5\20\u00ba\n\20"+
		"\3\21\3\21\3\21\3\21\7\21\u00c0\n\21\f\21\16\21\u00c3\13\21\3\22\3\22"+
		"\5\22\u00c7\n\22\3\22\5\22\u00ca\n\22\3\23\3\23\3\24\3\24\3\24\3\24\5"+
		"\24\u00d2\n\24\3\24\3\24\7\24\u00d6\n\24\f\24\16\24\u00d9\13\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00e3\n\25\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\5\27\u00eb\n\27\3\30\3\30\3\30\3\30\7\30\u00f1\n\30\f\30\16"+
		"\30\u00f4\13\30\3\30\5\30\u00f7\n\30\5\30\u00f9\n\30\3\30\3\30\3\31\3"+
		"\31\3\31\2\3&\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2"+
		"\4\5\2\5\5\7\b\f\26\4\2\33\33\35\37\u010b\2\65\3\2\2\2\4;\3\2\2\2\6S\3"+
		"\2\2\2\bU\3\2\2\2\nW\3\2\2\2\fg\3\2\2\2\16q\3\2\2\2\20s\3\2\2\2\22{\3"+
		"\2\2\2\24\u0086\3\2\2\2\26\u009b\3\2\2\2\30\u00a4\3\2\2\2\32\u00a6\3\2"+
		"\2\2\34\u00a8\3\2\2\2\36\u00b9\3\2\2\2 \u00bb\3\2\2\2\"\u00c6\3\2\2\2"+
		"$\u00cb\3\2\2\2&\u00d1\3\2\2\2(\u00e2\3\2\2\2*\u00e4\3\2\2\2,\u00ea\3"+
		"\2\2\2.\u00ec\3\2\2\2\60\u00fc\3\2\2\2\62\64\5\4\3\2\63\62\3\2\2\2\64"+
		"\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\5"+
		"\b\5\29:\7\2\2\3:\3\3\2\2\2;<\7\3\2\2<?\7!\2\2=>\7\4\2\2>@\7!\2\2?=\3"+
		"\2\2\2?@\3\2\2\2@A\3\2\2\2AC\7)\2\2BD\5\6\4\2CB\3\2\2\2CD\3\2\2\2DH\3"+
		"\2\2\2EG\5\n\6\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IN\3\2\2\2JH\3"+
		"\2\2\2KM\5\f\7\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3"+
		"\2\2\2QR\7*\2\2R\5\3\2\2\2ST\5\20\t\2T\7\3\2\2\2UV\5\26\f\2V\t\3\2\2\2"+
		"WX\7\3\2\2XY\5\f\7\2Y\13\3\2\2\2Z[\7!\2\2[h\5\16\b\2\\]\5\"\22\2]^\7!"+
		"\2\2^_\5\16\b\2_h\3\2\2\2`a\7 \2\2ac\7!\2\2b`\3\2\2\2cd\3\2\2\2db\3\2"+
		"\2\2de\3\2\2\2ef\3\2\2\2fh\5\16\b\2gZ\3\2\2\2g\\\3\2\2\2gb\3\2\2\2h\r"+
		"\3\2\2\2ij\7)\2\2jk\5\26\f\2kl\7*\2\2lr\3\2\2\2mn\7\5\2\2no\7\6\2\2op"+
		"\7\"\2\2pr\7\7\2\2qi\3\2\2\2qm\3\2\2\2r\17\3\2\2\2su\7\b\2\2tv\7!\2\2"+
		"ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\7\b\2\2z\21\3\2\2"+
		"\2{\177\7)\2\2|}\5\24\13\2}~\7\b\2\2~\u0080\3\2\2\2\177|\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\5\26\f\2\u0082\u0083\7*\2\2\u0083"+
		"\23\3\2\2\2\u0084\u0085\7\4\2\2\u0085\u0087\7!\2\2\u0086\u0084\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\25"+
		"\3\2\2\2\u008a\u008c\5\20\t\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008d\3\2\2\2\u008d\u0092\5\30\r\2\u008e\u008f\7\t\2\2\u008f\u0091"+
		"\5\30\r\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0097"+
		"\7\t\2\2\u0096\u0095\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009c\3\2\2\2\u0098"+
		"\u009a\5\20\t\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3"+
		"\2\2\2\u009b\u008b\3\2\2\2\u009b\u0099\3\2\2\2\u009c\27\3\2\2\2\u009d"+
		"\u009e\5\32\16\2\u009e\u009f\7\n\2\2\u009f\u00a0\5\34\17\2\u00a0\u00a5"+
		"\3\2\2\2\u00a1\u00a2\7(\2\2\u00a2\u00a5\5\34\17\2\u00a3\u00a5\5\34\17"+
		"\2\u00a4\u009d\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\31"+
		"\3\2\2\2\u00a6\u00a7\7!\2\2\u00a7\33\3\2\2\2\u00a8\u00a9\5\36\20\2\u00a9"+
		"\35\3\2\2\2\u00aa\u00af\5 \21\2\u00ab\u00ac\7 \2\2\u00ac\u00ae\5 \21\2"+
		"\u00ad\u00ab\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00ba\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\7\34\2\2"+
		"\u00b3\u00b4\7 \2\2\u00b4\u00b6\5 \21\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00aa\3\2\2\2\u00b9\u00b2\3\2\2\2\u00ba\37\3\2\2\2\u00bb\u00c1\5&\24"+
		"\2\u00bc\u00bd\5\"\22\2\u00bd\u00be\5&\24\2\u00be\u00c0\3\2\2\2\u00bf"+
		"\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2!\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7\5$\23\2\u00c5\u00c7"+
		"\7\13\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c9\3\2\2\2"+
		"\u00c8\u00ca\5$\23\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca#\3"+
		"\2\2\2\u00cb\u00cc\t\2\2\2\u00cc%\3\2\2\2\u00cd\u00ce\b\24\1\2\u00ce\u00d2"+
		"\5(\25\2\u00cf\u00d0\7\34\2\2\u00d0\u00d2\7!\2\2\u00d1\u00cd\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d2\u00d7\3\2\2\2\u00d3\u00d4\f\4\2\2\u00d4\u00d6\7!"+
		"\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7"+
		"\u00d8\3\2\2\2\u00d8\'\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00e3\5,\27\2"+
		"\u00db\u00e3\5.\30\2\u00dc\u00e3\5*\26\2\u00dd\u00e3\5\22\n\2\u00de\u00df"+
		"\7\27\2\2\u00df\u00e0\5\34\17\2\u00e0\u00e1\7\30\2\2\u00e1\u00e3\3\2\2"+
		"\2\u00e2\u00da\3\2\2\2\u00e2\u00db\3\2\2\2\u00e2\u00dc\3\2\2\2\u00e2\u00dd"+
		"\3\2\2\2\u00e2\u00de\3\2\2\2\u00e3)\3\2\2\2\u00e4\u00e5\7!\2\2\u00e5+"+
		"\3\2\2\2\u00e6\u00eb\7&\2\2\u00e7\u00eb\7$\2\2\u00e8\u00eb\7\'\2\2\u00e9"+
		"\u00eb\5\60\31\2\u00ea\u00e6\3\2\2\2\u00ea\u00e7\3\2\2\2\u00ea\u00e8\3"+
		"\2\2\2\u00ea\u00e9\3\2\2\2\u00eb-\3\2\2\2\u00ec\u00f8\7\31\2\2\u00ed\u00f2"+
		"\5\34\17\2\u00ee\u00ef\7\t\2\2\u00ef\u00f1\5\34\17\2\u00f0\u00ee\3\2\2"+
		"\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6"+
		"\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f7\7\t\2\2\u00f6\u00f5\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8\u00ed\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\7\32\2\2\u00fb/\3\2\2\2\u00fc\u00fd"+
		"\t\3\2\2\u00fd\61\3\2\2\2 \65?CHNdgqw\177\u0088\u008b\u0092\u0096\u0099"+
		"\u009b\u00a4\u00af\u00b7\u00b9\u00c1\u00c6\u00c9\u00d1\u00d7\u00e2\u00ea"+
		"\u00f2\u00f6\u00f8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}