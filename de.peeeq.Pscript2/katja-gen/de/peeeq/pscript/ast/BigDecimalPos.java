package de.peeeq.pscript.ast;

import java.util.List;
import katja.common.*;
import java.io.IOException;

public interface BigDecimalPos extends de.peeeq.pscript.ast.pscriptAST.LeafPos<java.math.BigDecimal> {

    //----- methods of BigDecimalPos -----

    public java.math.BigDecimal term();
    public de.peeeq.pscript.ast.ARealLiteralPos parent();
    public de.peeeq.pscript.ast.EObjectPos lsib();
    public de.peeeq.pscript.ast.pscriptAST.SortPos rsib();
    public de.peeeq.pscript.ast.pscriptAST.SortPos preOrder();
    public de.peeeq.pscript.ast.pscriptAST.SortPos preOrderSkip();
    public de.peeeq.pscript.ast.pscriptAST.SortPos postOrder();
    public de.peeeq.pscript.ast.pscriptAST.SortPos postOrderStart();
    public de.peeeq.pscript.ast.pscriptAST.SortPos follow(List<Integer> path);

    //----- nested classes of BigDecimalPos -----

    static class Impl extends KatjaLeafPosImpl<de.peeeq.pscript.ast.ACompilationUnitPos, java.math.BigDecimal> implements de.peeeq.pscript.ast.BigDecimalPos {

        //----- methods of Impl -----

        Impl(KatjaNodePos<de.peeeq.pscript.ast.ACompilationUnitPos, ?> parent, java.math.BigDecimal term, int pos) {
            super(parent, term, pos);
        }

        protected de.peeeq.pscript.ast.ACompilationUnitPos freshRootPosition(KatjaSort term) {
            if(!(term instanceof de.peeeq.pscript.ast.ACompilationUnit))
                throw new IllegalArgumentException("given term to replace root position has not the correct sort ACompilationUnit");

            return pscriptAST.ACompilationUnitPos((ACompilationUnit) term);
        }

        public de.peeeq.pscript.ast.ARealLiteralPos parent() {
            return (de.peeeq.pscript.ast.ARealLiteralPos) super.parent();
        }

        public de.peeeq.pscript.ast.EObjectPos lsib() {
            return (de.peeeq.pscript.ast.EObjectPos) super.lsib();
        }

        public de.peeeq.pscript.ast.pscriptAST.SortPos rsib() {
            return (de.peeeq.pscript.ast.pscriptAST.SortPos) super.rsib();
        }

        public de.peeeq.pscript.ast.pscriptAST.SortPos preOrder() {
            return (de.peeeq.pscript.ast.pscriptAST.SortPos) super.preOrder();
        }

        public de.peeeq.pscript.ast.pscriptAST.SortPos preOrderSkip() {
            return (de.peeeq.pscript.ast.pscriptAST.SortPos) super.preOrderSkip();
        }

        public de.peeeq.pscript.ast.pscriptAST.SortPos postOrder() {
            return (de.peeeq.pscript.ast.pscriptAST.SortPos) super.postOrder();
        }

        public de.peeeq.pscript.ast.pscriptAST.SortPos postOrderStart() {
            return (de.peeeq.pscript.ast.pscriptAST.SortPos) super.postOrderStart();
        }

        public de.peeeq.pscript.ast.pscriptAST.SortPos follow(List<Integer> path) {
            return (de.peeeq.pscript.ast.pscriptAST.SortPos) super.follow(path);
        }

        public Appendable toJavaCode(Appendable builder) throws IOException {
            builder.append("pscriptAST.ACompilationUnitPos");
            builder.append("( ");
            root().term().toJavaCode(builder);
            builder.append(" )");
            for(int pos : path()) builder.append(".get("+pos+")");

            return builder;
        }

        public Appendable toString(Appendable builder) throws IOException {
            builder.append(term().toString());
            builder.append("@ACompilationUnit");
            for(int pos : path()) builder.append("."+pos);

            return builder;
        }

        public final String sortName() {
            return "BigDecimalPos";
        }
    }
}

