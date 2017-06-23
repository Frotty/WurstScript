package de.peeeq.wurstscript.intermediateLang.interpreter;

import de.peeeq.wurstscript.intermediateLang.ILconst;

import java.io.PrintStream;

public class BuiltinFuncs implements NativesProvider {

    public BuiltinFuncs(ProgramState globalState) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public ILconst invoke(String funcname, ILconst[] args) throws NoSuchNativeException {
        throw new NoSuchNativeException("No builtin function " + funcname + " found.");
    }

    @Override
    public void setOutStream(PrintStream outStream) {
    }

}
