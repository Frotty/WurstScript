package de.peeeq.pscript.ast;

import katja.common.*;
import java.io.IOException;

public interface AFieldAccess extends de.peeeq.pscript.ast.AExpr, KatjaTuple {

    //----- methods of AFieldAccess -----

    public org.eclipse.emf.ecore.EObject source();
    public de.peeeq.pscript.ast.AFieldAccess replaceSource(org.eclipse.emf.ecore.EObject source);
    public de.peeeq.pscript.ast.AExpr owner();
    public de.peeeq.pscript.ast.AFieldAccess replaceOwner(de.peeeq.pscript.ast.AExpr owner);
    public de.peeeq.pscript.ast.AIdentifier ident();
    public de.peeeq.pscript.ast.AFieldAccess replaceIdent(de.peeeq.pscript.ast.AIdentifier ident);
    public Object get(int i);
    public int size();
    public de.peeeq.pscript.ast.AFieldAccess replace(int pos, Object term);
    public <CT, E extends Throwable> CT Switch(de.peeeq.pscript.ast.AExpr.Switch<CT, E> switchClass) throws E;
    public <CT, E extends Throwable> CT Switch(de.peeeq.pscript.ast.AStatement.Switch<CT, E> switchClass) throws E;

    //----- nested classes of AFieldAccess -----

    static interface VisitorType<E extends Throwable> {

        //----- methods of VisitorType<E extends Throwable> -----

        public void visit(org.eclipse.emf.ecore.EObject term) throws E;
        public void visit(de.peeeq.pscript.ast.AExpr term) throws E;
        public void visit(de.peeeq.pscript.ast.AIdentifier term) throws E;
        public void visit(de.peeeq.pscript.ast.APrefix term) throws E;
        public void visit(de.peeeq.pscript.ast.AInfix term) throws E;
        public void visit(de.peeeq.pscript.ast.ALiteral term) throws E;
        public void visit(de.peeeq.pscript.ast.AFunctionCall term) throws E;
        public void visit(de.peeeq.pscript.ast.ABuildinCall term) throws E;
        public void visit(de.peeeq.pscript.ast.AVariableAccess term) throws E;
        public void visit(de.peeeq.pscript.ast.AFieldAccess term) throws E;
        public void visit(de.peeeq.pscript.ast.ANoExpr term) throws E;
        public void visit(de.peeeq.pscript.ast.AIntegerLiteral term) throws E;
        public void visit(de.peeeq.pscript.ast.ARealLiteral term) throws E;
        public void visit(de.peeeq.pscript.ast.AStringLiteral term) throws E;
        public void visit(de.peeeq.pscript.ast.ABooleanLiteral term) throws E;
        public void visit(java.lang.String term) throws E;
        public void visit(de.peeeq.pscript.ast.APrefixOp term) throws E;
        public void visit(de.peeeq.pscript.ast.AInfixOp term) throws E;
        public void visit(de.peeeq.pscript.ast.AArguments term) throws E;
        public void visit(java.lang.Integer term) throws E;
        public void visit(java.math.BigDecimal term) throws E;
        public void visit(java.lang.Boolean term) throws E;
        public void visit(de.peeeq.pscript.ast.APlus term) throws E;
        public void visit(de.peeeq.pscript.ast.AMinus term) throws E;
        public void visit(de.peeeq.pscript.ast.ANot term) throws E;
        public void visit(de.peeeq.pscript.ast.AEqEq term) throws E;
        public void visit(de.peeeq.pscript.ast.AGt term) throws E;
        public void visit(de.peeeq.pscript.ast.AGtEq term) throws E;
        public void visit(de.peeeq.pscript.ast.ALt term) throws E;
        public void visit(de.peeeq.pscript.ast.ALtEq term) throws E;
        public void visit(de.peeeq.pscript.ast.AMult term) throws E;
        public void visit(de.peeeq.pscript.ast.ADiv term) throws E;
        public void visit(de.peeeq.pscript.ast.ADivInt term) throws E;
        public void visit(de.peeeq.pscript.ast.AModulo term) throws E;
        public void visit(de.peeeq.pscript.ast.ADot term) throws E;
        public void visit(de.peeeq.pscript.ast.AAnd term) throws E;
        public void visit(de.peeeq.pscript.ast.AOr term) throws E;
    }

    public static abstract class Visitor<E extends Throwable> implements de.peeeq.pscript.ast.AFieldAccess.VisitorType<E> {

        //----- attributes of Visitor<E extends Throwable> -----

        private final de.peeeq.pscript.ast.AExpr.Switch<Object, E> variantVisit$AExpr = new de.peeeq.pscript.ast.AExpr.Switch<Object, E>() { public final Object CaseAPrefix(de.peeeq.pscript.ast.APrefix term) throws E { visit(term); return null; } public final Object CaseAInfix(de.peeeq.pscript.ast.AInfix term) throws E { visit(term); return null; } public final Object CaseAFunctionCall(de.peeeq.pscript.ast.AFunctionCall term) throws E { visit(term); return null; } public final Object CaseABuildinCall(de.peeeq.pscript.ast.ABuildinCall term) throws E { visit(term); return null; } public final Object CaseAVariableAccess(de.peeeq.pscript.ast.AVariableAccess term) throws E { visit(term); return null; } public final Object CaseAFieldAccess(de.peeeq.pscript.ast.AFieldAccess term) throws E { visit(term); return null; } public final Object CaseANoExpr(de.peeeq.pscript.ast.ANoExpr term) throws E { visit(term); return null; } public final Object CaseAIntegerLiteral(de.peeeq.pscript.ast.AIntegerLiteral term) throws E { visit(term); return null; } public final Object CaseARealLiteral(de.peeeq.pscript.ast.ARealLiteral term) throws E { visit(term); return null; } public final Object CaseAStringLiteral(de.peeeq.pscript.ast.AStringLiteral term) throws E { visit(term); return null; } public final Object CaseABooleanLiteral(de.peeeq.pscript.ast.ABooleanLiteral term) throws E { visit(term); return null; } };
        private final de.peeeq.pscript.ast.AInfixOp.Switch<Object, E> variantVisit$AInfixOp = new de.peeeq.pscript.ast.AInfixOp.Switch<Object, E>() { public final Object CaseAEqEq(de.peeeq.pscript.ast.AEqEq term) throws E { visit(term); return null; } public final Object CaseAGt(de.peeeq.pscript.ast.AGt term) throws E { visit(term); return null; } public final Object CaseAGtEq(de.peeeq.pscript.ast.AGtEq term) throws E { visit(term); return null; } public final Object CaseALt(de.peeeq.pscript.ast.ALt term) throws E { visit(term); return null; } public final Object CaseALtEq(de.peeeq.pscript.ast.ALtEq term) throws E { visit(term); return null; } public final Object CaseAPlus(de.peeeq.pscript.ast.APlus term) throws E { visit(term); return null; } public final Object CaseAMinus(de.peeeq.pscript.ast.AMinus term) throws E { visit(term); return null; } public final Object CaseAMult(de.peeeq.pscript.ast.AMult term) throws E { visit(term); return null; } public final Object CaseADiv(de.peeeq.pscript.ast.ADiv term) throws E { visit(term); return null; } public final Object CaseADivInt(de.peeeq.pscript.ast.ADivInt term) throws E { visit(term); return null; } public final Object CaseAModulo(de.peeeq.pscript.ast.AModulo term) throws E { visit(term); return null; } public final Object CaseADot(de.peeeq.pscript.ast.ADot term) throws E { visit(term); return null; } public final Object CaseAAnd(de.peeeq.pscript.ast.AAnd term) throws E { visit(term); return null; } public final Object CaseAOr(de.peeeq.pscript.ast.AOr term) throws E { visit(term); return null; } };
        private final de.peeeq.pscript.ast.APrefixOp.Switch<Object, E> variantVisit$APrefixOp = new de.peeeq.pscript.ast.APrefixOp.Switch<Object, E>() { public final Object CaseAPlus(de.peeeq.pscript.ast.APlus term) throws E { visit(term); return null; } public final Object CaseAMinus(de.peeeq.pscript.ast.AMinus term) throws E { visit(term); return null; } public final Object CaseANot(de.peeeq.pscript.ast.ANot term) throws E { visit(term); return null; } };

        //----- methods of Visitor<E extends Throwable> -----

        public final void visit(de.peeeq.pscript.ast.AExpr term) throws E {
            term.Switch(variantVisit$AExpr);
        }

        public final void visit(de.peeeq.pscript.ast.AInfixOp term) throws E {
            term.Switch(variantVisit$AInfixOp);
        }

        public final void visit(de.peeeq.pscript.ast.ALiteral term) throws E {
            term.Switch(variantVisit$AExpr);
        }

        public final void visit(de.peeeq.pscript.ast.APrefixOp term) throws E {
            term.Switch(variantVisit$APrefixOp);
        }
    }

    static class Impl extends KatjaTupleImpl implements de.peeeq.pscript.ast.AFieldAccess {

        //----- attributes of Impl -----

        private org.eclipse.emf.ecore.EObject _source = null;
        private de.peeeq.pscript.ast.AExpr _owner = null;
        private de.peeeq.pscript.ast.AIdentifier _ident = null;

        //----- methods of Impl -----

        public org.eclipse.emf.ecore.EObject source() {
            return _source;
        }

        public de.peeeq.pscript.ast.AFieldAccess replaceSource(org.eclipse.emf.ecore.EObject source) {
            return replace(0, source);
        }

        public de.peeeq.pscript.ast.AExpr owner() {
            return _owner;
        }

        public de.peeeq.pscript.ast.AFieldAccess replaceOwner(de.peeeq.pscript.ast.AExpr owner) {
            return replace(1, owner);
        }

        public de.peeeq.pscript.ast.AIdentifier ident() {
            return _ident;
        }

        public de.peeeq.pscript.ast.AFieldAccess replaceIdent(de.peeeq.pscript.ast.AIdentifier ident) {
            return replace(2, ident);
        }

        Impl(org.eclipse.emf.ecore.EObject source, de.peeeq.pscript.ast.AExpr owner, de.peeeq.pscript.ast.AIdentifier ident) {
            if(source == null)
                throw new IllegalArgumentException("constructor of sort AFieldAccess invoked with null parameter source");
            if(owner == null)
                throw new IllegalArgumentException("constructor of sort AFieldAccess invoked with null parameter owner");
            if(ident == null)
                throw new IllegalArgumentException("constructor of sort AFieldAccess invoked with null parameter ident");

            this._source = source;
            this._owner = owner;
            this._ident = ident;
        }

        public Object get(int i) {
            int ith = i;

            if(ith < 0) ith += 3;

            switch(ith) {
                case 0: return _source;
                case 1: return _owner;
                case 2: return _ident;
                default:
                    if(ith < 0) {
                        throw new IllegalArgumentException("get on sort AFieldAccess invoked with negative parameter "+i);
                    } else {
                        throw new IllegalArgumentException("get on sort AFieldAccess invoked with too large parameter "+i+", sort has only 3 components");
                    }
            }
        }

        public int size() {
            return 3;
        }

        public de.peeeq.pscript.ast.AFieldAccess replace(int pos, Object term) {
            if(pos < 0)
                throw new IllegalArgumentException("replace on sort AFieldAccess invoked with negative parameter "+pos);
            if(pos >= 3)
                throw new IllegalArgumentException("replace on sort AFieldAccess invoked with too large parameter "+pos+", sort has only 3 components");

            if(pos == 0 && !(term instanceof org.eclipse.emf.ecore.EObject))
                throw new IllegalArgumentException("replace on sort AFieldAccess invoked with term of incorrect sort, EObject expected");
            if(pos == 1 && !(term instanceof de.peeeq.pscript.ast.AExpr))
                throw new IllegalArgumentException("replace on sort AFieldAccess invoked with term of incorrect sort, AExpr expected");
            if(pos == 2 && !(term instanceof de.peeeq.pscript.ast.AIdentifier))
                throw new IllegalArgumentException("replace on sort AFieldAccess invoked with term of incorrect sort, AIdentifier expected");

            return (de.peeeq.pscript.ast.AFieldAccess) pscriptAST.unique(new de.peeeq.pscript.ast.AFieldAccess.Impl(
                pos == 0 ? (org.eclipse.emf.ecore.EObject) term : _source,
                pos == 1 ? (de.peeeq.pscript.ast.AExpr) term : _owner,
                pos == 2 ? (de.peeeq.pscript.ast.AIdentifier) term : _ident
            ));
        }

        public <CT, E extends Throwable> CT Switch(de.peeeq.pscript.ast.AExpr.Switch<CT, E> switchClass) throws E {
            return switchClass.CaseAFieldAccess(this);
        }

        public <CT, E extends Throwable> CT Switch(de.peeeq.pscript.ast.AStatement.Switch<CT, E> switchClass) throws E {
            return switchClass.CaseAFieldAccess(this);
        }

        public Appendable toJavaCode(Appendable builder) throws IOException {
            builder.append("pscriptAST.AFieldAccess");
            builder.append("( ");
            if(_source instanceof KatjaElement) ((KatjaElement) _source).toJavaCode(builder); else throw new UnsupportedOperationException("extern sort EObject can't be unparsed to Java code (don't know how to do it)");
            builder.append(", ");
            _owner.toJavaCode(builder);
            builder.append(", ");
            _ident.toJavaCode(builder);
            builder.append(" )");

            return builder;
        }

        public Appendable toString(Appendable builder) throws IOException {
            builder.append("AFieldAccess");
            builder.append("( ");
            builder.append(_source.toString());
            builder.append(", ");
            _owner.toString(builder);
            builder.append(", ");
            _ident.toString(builder);
            builder.append(" )");

            return builder;
        }

        public final String sortName() {
            return "AFieldAccess";
        }
    }
}

