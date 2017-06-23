package de.peeeq.wurstscript.translation.imtranslation;

import de.peeeq.wurstscript.ast.Element;
import de.peeeq.wurstscript.ast.*;
import de.peeeq.wurstscript.jassIm.*;
import de.peeeq.wurstscript.types.WurstType;
import de.peeeq.wurstscript.types.WurstTypeBoundTypeParam;
import de.peeeq.wurstscript.types.WurstTypeClassOrInterface;
import de.peeeq.wurstscript.types.WurstTypeTypeParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OverrideUtils {

    public static void addOverrideClosure(ImTranslator tr, FuncDef superMethod, ImMethod m, ExprClosure exprClosure) {


        WurstType expected = exprClosure.attrExpectedTyp();

        Element e = exprClosure;


        if (expected instanceof WurstTypeClassOrInterface) {
            WurstTypeClassOrInterface t = (WurstTypeClassOrInterface) expected;
            Map<TypeParamDef, WurstTypeBoundTypeParam> typeBinding = t.getTypeArgBinding();

            addOverride(tr, superMethod, m.attrClass(), m, e, typeBinding);
        } else {
            ImMethod superMethodIm = tr.getMethodFor(superMethod);
            superMethodIm.getSubMethods().add(m);
        }
    }


    public static void addOverride(
            ImTranslator tr,
            FuncDef superMethod,
            ImClass subClass,
            ImMethod subMethod,
            Element e,
            Map<TypeParamDef, WurstTypeBoundTypeParam> typeBinding) {
        ImMethod superMethodIm = tr.getMethodFor(superMethod);
        boolean needConversion = false;
        List<FuncDef> argFromIndexFuncs = new ArrayList<>();
        // for the this-pointer:
        argFromIndexFuncs.add(null);
        FuncDef retToIndexFunc = null;

        for (int i = 0; i < superMethod.getParameters().size(); i++) {
            WParameter param = superMethod.getParameters().get(i);
            WurstType paramType = param.getTyp().attrTyp();

            if (paramType instanceof WurstTypeTypeParam) {
                WurstTypeTypeParam bt = (WurstTypeTypeParam) paramType; // TODO also bound type params?
                TypeParamDef tpDef = bt.getDef();
                if (typeBinding.containsKey(tpDef)) {
                    WurstTypeBoundTypeParam btp = typeBinding.get(tpDef);
                    if (btp.getToIndex() != null) {
                        needConversion = true;
                        argFromIndexFuncs.add(btp.getFromIndex());
                        continue;
                    }
                }
            }
            argFromIndexFuncs.add(null);
        }

        WurstType retType = superMethod.getReturnTyp().attrTyp();
        if (retType instanceof WurstTypeTypeParam) {
            WurstTypeTypeParam bt = (WurstTypeTypeParam) retType;
            TypeParamDef tpDef = bt.getDef();
            if (typeBinding.containsKey(tpDef)) {
                WurstTypeBoundTypeParam btp = typeBinding.get(tpDef);
                if (btp.getToIndex() != null) {
                    needConversion = true;
                    retToIndexFunc = btp.getToIndex();
                }
            }
        }

        if (!needConversion) {
            superMethodIm.getSubMethods().add(subMethod);
            return;
        }

        ImVars parameters = superMethodIm.getImplementation().getParameters().copy();
        ImType rType = superMethodIm.getImplementation().getReturnType();
        ImVars locals = JassIm.ImVars();
        ImStmts body = JassIm.ImStmts();

        ImExprs arguments = JassIm.ImExprs();


        for (int i = 0; i < parameters.size(); i++) {
            ImExpr arg = JassIm.ImVarAccess(parameters.get(i));
            FuncDef toIndex = argFromIndexFuncs.get(i);
            if (toIndex != null) {
                ImFunction toIndexF = tr.getFuncFor(toIndex);
                arg = JassIm.ImFunctionCall(e, toIndexF, JassIm.ImExprs(arg), false, CallType.NORMAL);
            }
            arguments.add(arg);
        }

        ImExpr wrappedCall = JassIm.ImFunctionCall(e, subMethod.getImplementation(), arguments, false, CallType.NORMAL);
        if (rType instanceof ImVoid) {
            body.add(wrappedCall);
        } else {
            if (retToIndexFunc != null) {
                ImFunction toIndexF = tr.getFuncFor(retToIndexFunc);
                wrappedCall = JassIm.ImFunctionCall(e, toIndexF, JassIm.ImExprs(wrappedCall), false, CallType.NORMAL);
            }
            body.add(JassIm.ImReturn(e, wrappedCall));
        }

        List<FunctionFlag> flags = Collections.emptyList();
        ImFunction implementation = JassIm.ImFunction(e, subMethod.getName() + "_wrapper", parameters, rType, locals, body, flags);
        tr.getImProg().getFunctions().add(implementation);

        List<ImMethod> subMethods = Collections.emptyList();
        ImMethod wrapperMethod = JassIm.ImMethod(e, subMethod.getName() + "_wrapper", implementation, subMethods, false);
        subClass.getMethods().add(wrapperMethod);
        superMethodIm.getSubMethods().add(wrapperMethod);
    }


}
