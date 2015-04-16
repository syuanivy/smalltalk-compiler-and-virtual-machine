package org.antlr.symtab;

import java.util.List;
import java.util.Set;

/** A scope is a dictionary of symbols that are grouped together by some
 *  lexical construct in the input language. Examples include structs,
 *  functions, {...} code blocks, argument lists, etc...
 *
 *  Scopes all have an enclosing scope that encloses them lexically.
 *  In other words, am I wrapped in a class? a function? a {...} code block?
 *
 *  This is distinguished from the parent scope. The parent scope is usually
 *  the enclosing scope, but in the case of inheritance, it is the superclass
 *  rather than the enclosing scope. Otherwise, the global scope would be
 *  considered the parent scope of a class. When resolving symbols, we look
 *  up the parent scope chain not the enclosing scope chain.
 *
 *  For convenience of code using this library, I have added a bunch of
 *  methods one can use to get lots of useful information from a scope, but
 *  they don't necessarily define what a scope is.
 */
public interface Scope {
	/** Often scopes have names like function or class names. For
	 *  unnamed scopes like code blocks, you can just return "local" or something.
	 */
	String getName();

	/** Where to look next for symbols if just one parent; superclass or enclosing scope. */
	Scope getParentScope();

	/** Multiple superclass or interface implementations and the like... */
	List<Scope> getParentScopes();

	/** Scope in which this scope defined. null if no enclosing scope */
	Scope getEnclosingScope();

	/** What scope encloses this scope. E.g., if this scope is a function,
	 *  the enclosing scope could be a class. The BaseScope class automatically
	 *  adds this to nested scope list of s.
	 */
	void setEnclosingScope(Scope s);

	/** Define a symbol in this scope, throw IllegalArgumentException
	 *  if sym already defined in this scope. This alters sym:
	 *
	 *  1. Set insertion order number of sym
	 *  2. Set sym's scope to be the scope.
	 *
	 *  The order in which symbols are defined must be preserved so that
	 *  {@link #getSymbols()} returns the list in definition order.
	 */
	void define(Symbol sym) throws IllegalArgumentException;

	/** Look up name in this scope or recursively in parent scope if not here */
	Symbol resolve(String name);

	/** Get symbol if name defined within this specific scope */
	Symbol getSymbol(String name);

	// ------------ Convenience methods --------------------------------

	/** Return (inclusive) list of all scopes on path to root scope.
	 *  The first element is the current scope and the last is the root scope.
	 */
	List<Scope> getEnclosingPathToRoot();

	/** Return all immediately enclosed scopes. E.g., a class would return
	 *  all nested classes and any methods. There is no explicit pointer to the
	 *  nested scopes. This method generally searches the list of symbols
	 *  looking for symbols that implement Scope.
	 */
	List<Scope> getNestedScopes();

	/** Return the symbols within the scope. The order of insertion
	 *  into the scope is the order returns in this list.
	 */
	List<? extends Symbol> getSymbols();

	/** Return all symbols found in all nested scopes. The order of insertion
	 *  into the scope is the order returned in this list for each scope.
	 *  The scopes are traversed in the order in which they are encountered
	 *  in the input.
	 */
	List<? extends Symbol> getAllSymbols();

	/** Return the set of names associated with all symbols in the scope. */
	Set<String> getSymbolNames();

	/** Number of symbols in this specific scope */
	int getNumberOfSymbols();

	/** Return scopes from to current with separator in between */
	public String toQualifierString(String separator);
}
