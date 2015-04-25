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
		RULE_id = 20, RULE_literal = 21, RULE_array = 22;
	public static final String[] ruleNames = {
		"file", "classDef", "instanceVars", "main", "classMethod", "method", "methodBlock", 
		"localVars", "block", "blockArgs", "body", "stat", "lvalue", "messageExpression", 
		"keywordExpression", "binaryExpression", "bop", "opchar", "unaryExpression", 
		"primary", "id", "literal", "array"
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(46); 
				classDef();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52); 
			main();
			setState(53); 
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
			setState(55); 
			match(T__0);
			setState(56); 
			((ClassDefContext)_localctx).className = match(ID);
			setState(59);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(57); 
				match(T__1);
				setState(58); 
				((ClassDefContext)_localctx).superName = match(ID);
				}
			}

			setState(61); 
			match(LBRACK);
			setState(63);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(62); 
				instanceVars();
				}
				break;
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(65); 
				classMethod();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << KEYWORD) | (1L << ID))) != 0)) {
				{
				{
				setState(71); 
				method();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77); 
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
			setState(79); 
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
			setState(81); 
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
			setState(83); 
			match(T__0);
			setState(84); 
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
			setState(99);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new NamedMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(86); 
				match(ID);
				setState(87); 
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
				setState(88); 
				bop();
				setState(89); 
				match(ID);
				setState(90); 
				methodBlock();
				}
				break;
			case KEYWORD:
				_localctx = new KeywordMethodContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92); 
					match(KEYWORD);
					setState(93); 
					match(ID);
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==KEYWORD );
				setState(98); 
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
			setState(109);
			switch (_input.LA(1)) {
			case LBRACK:
				_localctx = new SmalltalkMethodBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(101); 
				match(LBRACK);
				setState(102); 
				body();
				setState(103); 
				match(RBRACK);
				}
				break;
			case T__2:
				_localctx = new PrimitiveMethodBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(105); 
				match(T__2);
				setState(106); 
				match(T__3);
				setState(107); 
				match(SYMBOL);
				setState(108); 
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
			setState(111); 
			match(T__5);
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112); 
				match(ID);
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(117); 
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
			setState(119); 
			match(LBRACK);
			setState(123);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(120); 
				blockArgs();
				setState(121); 
				match(T__5);
				}
			}

			setState(125); 
			body();
			setState(126); 
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
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128); 
				match(T__1);
				setState(129); 
				match(ID);
				}
				}
				setState(132); 
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
			setState(151);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new FullBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(134); 
					localVars();
					}
				}

				setState(137); 
				stat();
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(138); 
						match(T__6);
						setState(139); 
						stat();
						}
						} 
					}
					setState(144);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
				setState(146);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(145); 
					match(T__6);
					}
				}

				}
				break;
			case 2:
				_localctx = new EmptyBodyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(148); 
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
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153); 
				lvalue();
				setState(154); 
				match(T__7);
				setState(155); 
				messageExpression();
				}
				break;
			case 2:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(157); 
				match(RETURN);
				setState(158); 
				messageExpression();
				}
				break;
			case 3:
				_localctx = new SendMessageContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159); 
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
			setState(162); 
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
			setState(164); 
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
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new KeywordSendContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166); 
				((KeywordSendContext)_localctx).recv = binaryExpression();
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==KEYWORD) {
					{
					{
					setState(167); 
					match(KEYWORD);
					setState(168); 
					((KeywordSendContext)_localctx).binaryExpression = binaryExpression();
					((KeywordSendContext)_localctx).args.add(((KeywordSendContext)_localctx).binaryExpression);
					}
					}
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				_localctx = new SuperKeywordSendContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(174); 
				match(SUPER);
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(175); 
					match(KEYWORD);
					setState(176); 
					((SuperKeywordSendContext)_localctx).binaryExpression = binaryExpression();
					((SuperKeywordSendContext)_localctx).args.add(((SuperKeywordSendContext)_localctx).binaryExpression);
					}
					}
					setState(179); 
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
			setState(183); 
			unaryExpression(0);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				{
				setState(184); 
				bop();
				setState(185); 
				unaryExpression(0);
				}
				}
				setState(191);
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
			setState(194);
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
				setState(192); 
				opchar();
				}
				break;
			case T__8:
				{
				setState(193); 
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(197);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				setState(196); 
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
			setState(199);
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
			setState(205);
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

				setState(202); 
				primary();
				}
				break;
			case SUPER:
				{
				_localctx = new UnarySuperMsgSendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203); 
				match(SUPER);
				setState(204); 
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
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
					setState(207);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(208); 
					match(ID);
					}
					} 
				}
				setState(213);
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
			setState(222);
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
				setState(214); 
				literal();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(215); 
				array();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(216); 
				id();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(217); 
				block();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 5);
				{
				setState(218); 
				match(T__20);
				setState(219); 
				messageExpression();
				setState(220); 
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
			setState(224); 
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
		public TerminalNode NUMBER() { return getToken(SmalltalkParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(SmalltalkParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(SmalltalkParser.STRING, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SmalltalkListener ) ((SmalltalkListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SmalltalkVisitor ) return ((SmalltalkVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SELF) | (1L << NIL) | (1L << TRUE) | (1L << FALSE) | (1L << CHAR) | (1L << NUMBER) | (1L << STRING))) != 0)) ) {
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
			setState(228); 
			match(T__22);
			setState(240);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__22) | (1L << SELF) | (1L << SUPER) | (1L << NIL) | (1L << TRUE) | (1L << FALSE) | (1L << ID) | (1L << CHAR) | (1L << NUMBER) | (1L << STRING) | (1L << LBRACK))) != 0)) {
				{
				setState(229); 
				messageExpression();
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(230); 
						match(T__6);
						setState(231); 
						messageExpression();
						}
						} 
					}
					setState(236);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				}
				setState(238);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(237); 
					match(T__6);
					}
				}

				}
			}

			setState(242); 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00f7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3>\n\3\3\3\3\3\5\3"+
		"B\n\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7a\n\7"+
		"\r\7\16\7b\3\7\5\7f\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bp\n\b\3\t\3"+
		"\t\6\tt\n\t\r\t\16\tu\3\t\3\t\3\n\3\n\3\n\3\n\5\n~\n\n\3\n\3\n\3\n\3\13"+
		"\3\13\6\13\u0085\n\13\r\13\16\13\u0086\3\f\5\f\u008a\n\f\3\f\3\f\3\f\7"+
		"\f\u008f\n\f\f\f\16\f\u0092\13\f\3\f\5\f\u0095\n\f\3\f\5\f\u0098\n\f\5"+
		"\f\u009a\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\3\20\7\20\u00ac\n\20\f\20\16\20\u00af\13\20\3\20\3\20"+
		"\3\20\6\20\u00b4\n\20\r\20\16\20\u00b5\5\20\u00b8\n\20\3\21\3\21\3\21"+
		"\3\21\7\21\u00be\n\21\f\21\16\21\u00c1\13\21\3\22\3\22\5\22\u00c5\n\22"+
		"\3\22\5\22\u00c8\n\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u00d0\n\24\3"+
		"\24\3\24\7\24\u00d4\n\24\f\24\16\24\u00d7\13\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\5\25\u00e1\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\7\30\u00eb\n\30\f\30\16\30\u00ee\13\30\3\30\5\30\u00f1\n\30\5\30"+
		"\u00f3\n\30\3\30\3\30\3\30\2\3&\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\2\4\5\2\5\5\7\b\f\26\6\2\33\33\35\37$$&\'\u0101\2\63\3\2"+
		"\2\2\49\3\2\2\2\6Q\3\2\2\2\bS\3\2\2\2\nU\3\2\2\2\fe\3\2\2\2\16o\3\2\2"+
		"\2\20q\3\2\2\2\22y\3\2\2\2\24\u0084\3\2\2\2\26\u0099\3\2\2\2\30\u00a2"+
		"\3\2\2\2\32\u00a4\3\2\2\2\34\u00a6\3\2\2\2\36\u00b7\3\2\2\2 \u00b9\3\2"+
		"\2\2\"\u00c4\3\2\2\2$\u00c9\3\2\2\2&\u00cf\3\2\2\2(\u00e0\3\2\2\2*\u00e2"+
		"\3\2\2\2,\u00e4\3\2\2\2.\u00e6\3\2\2\2\60\62\5\4\3\2\61\60\3\2\2\2\62"+
		"\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66"+
		"\67\5\b\5\2\678\7\2\2\38\3\3\2\2\29:\7\3\2\2:=\7!\2\2;<\7\4\2\2<>\7!\2"+
		"\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?A\7)\2\2@B\5\6\4\2A@\3\2\2\2AB\3\2\2"+
		"\2BF\3\2\2\2CE\5\n\6\2DC\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GL\3\2\2"+
		"\2HF\3\2\2\2IK\5\f\7\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2"+
		"\2NL\3\2\2\2OP\7*\2\2P\5\3\2\2\2QR\5\20\t\2R\7\3\2\2\2ST\5\26\f\2T\t\3"+
		"\2\2\2UV\7\3\2\2VW\5\f\7\2W\13\3\2\2\2XY\7!\2\2Yf\5\16\b\2Z[\5\"\22\2"+
		"[\\\7!\2\2\\]\5\16\b\2]f\3\2\2\2^_\7 \2\2_a\7!\2\2`^\3\2\2\2ab\3\2\2\2"+
		"b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2df\5\16\b\2eX\3\2\2\2eZ\3\2\2\2e`\3\2\2"+
		"\2f\r\3\2\2\2gh\7)\2\2hi\5\26\f\2ij\7*\2\2jp\3\2\2\2kl\7\5\2\2lm\7\6\2"+
		"\2mn\7\"\2\2np\7\7\2\2og\3\2\2\2ok\3\2\2\2p\17\3\2\2\2qs\7\b\2\2rt\7!"+
		"\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\7\b\2\2x\21\3"+
		"\2\2\2y}\7)\2\2z{\5\24\13\2{|\7\b\2\2|~\3\2\2\2}z\3\2\2\2}~\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\5\26\f\2\u0080\u0081\7*\2\2\u0081\23\3\2\2\2\u0082"+
		"\u0083\7\4\2\2\u0083\u0085\7!\2\2\u0084\u0082\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088\u008a"+
		"\5\20\t\2\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2"+
		"\u008b\u0090\5\30\r\2\u008c\u008d\7\t\2\2\u008d\u008f\5\30\r\2\u008e\u008c"+
		"\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\7\t\2\2\u0094\u0093\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u009a\3\2\2\2\u0096\u0098\5\20\t\2\u0097"+
		"\u0096\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0089\3\2"+
		"\2\2\u0099\u0097\3\2\2\2\u009a\27\3\2\2\2\u009b\u009c\5\32\16\2\u009c"+
		"\u009d\7\n\2\2\u009d\u009e\5\34\17\2\u009e\u00a3\3\2\2\2\u009f\u00a0\7"+
		"(\2\2\u00a0\u00a3\5\34\17\2\u00a1\u00a3\5\34\17\2\u00a2\u009b\3\2\2\2"+
		"\u00a2\u009f\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a5"+
		"\7!\2\2\u00a5\33\3\2\2\2\u00a6\u00a7\5\36\20\2\u00a7\35\3\2\2\2\u00a8"+
		"\u00ad\5 \21\2\u00a9\u00aa\7 \2\2\u00aa\u00ac\5 \21\2\u00ab\u00a9\3\2"+
		"\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00b8\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\7\34\2\2\u00b1\u00b2\7"+
		" \2\2\u00b2\u00b4\5 \21\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00a8\3\2"+
		"\2\2\u00b7\u00b0\3\2\2\2\u00b8\37\3\2\2\2\u00b9\u00bf\5&\24\2\u00ba\u00bb"+
		"\5\"\22\2\u00bb\u00bc\5&\24\2\u00bc\u00be\3\2\2\2\u00bd\u00ba\3\2\2\2"+
		"\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0!\3"+
		"\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\5$\23\2\u00c3\u00c5\7\13\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6\u00c8\5$"+
		"\23\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8#\3\2\2\2\u00c9\u00ca"+
		"\t\2\2\2\u00ca%\3\2\2\2\u00cb\u00cc\b\24\1\2\u00cc\u00d0\5(\25\2\u00cd"+
		"\u00ce\7\34\2\2\u00ce\u00d0\7!\2\2\u00cf\u00cb\3\2\2\2\u00cf\u00cd\3\2"+
		"\2\2\u00d0\u00d5\3\2\2\2\u00d1\u00d2\f\4\2\2\u00d2\u00d4\7!\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\'\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00e1\5,\27\2\u00d9\u00e1"+
		"\5.\30\2\u00da\u00e1\5*\26\2\u00db\u00e1\5\22\n\2\u00dc\u00dd\7\27\2\2"+
		"\u00dd\u00de\5\34\17\2\u00de\u00df\7\30\2\2\u00df\u00e1\3\2\2\2\u00e0"+
		"\u00d8\3\2\2\2\u00e0\u00d9\3\2\2\2\u00e0\u00da\3\2\2\2\u00e0\u00db\3\2"+
		"\2\2\u00e0\u00dc\3\2\2\2\u00e1)\3\2\2\2\u00e2\u00e3\7!\2\2\u00e3+\3\2"+
		"\2\2\u00e4\u00e5\t\3\2\2\u00e5-\3\2\2\2\u00e6\u00f2\7\31\2\2\u00e7\u00ec"+
		"\5\34\17\2\u00e8\u00e9\7\t\2\2\u00e9\u00eb\5\34\17\2\u00ea\u00e8\3\2\2"+
		"\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f0"+
		"\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f1\7\t\2\2\u00f0\u00ef\3\2\2\2\u00f0"+
		"\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00e7\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\7\32\2\2\u00f5/\3\2\2\2\37\63=AF"+
		"Lbeou}\u0086\u0089\u0090\u0094\u0097\u0099\u00a2\u00ad\u00b5\u00b7\u00bf"+
		"\u00c4\u00c7\u00cf\u00d5\u00e0\u00ec\u00f0\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}