package tests.wurstscript.tests;

import de.peeeq.wurstio.WurstCompilerJassImpl;
import de.peeeq.wurstscript.RunArgs;
import de.peeeq.wurstscript.WurstCompiler;
import de.peeeq.wurstscript.ast.FunctionCall;
import de.peeeq.wurstscript.ast.WurstModel;
import de.peeeq.wurstscript.gui.WurstGui;
import de.peeeq.wurstscript.gui.WurstGuiCliImpl;
import de.peeeq.wurstscript.gui.WurstGuiLogger;
import de.peeeq.wurstscript.parser.WPos;
import de.peeeq.wurstscript.utils.Utils;
import org.eclipse.jdt.annotation.Nullable;
import org.junit.Test;

import java.util.function.Function;

public class PositionTests extends WurstScriptTest {

    @Test
    public void testFuncCallPos() {
        WurstModel model = testScript("blub", false, String.join("\n",
                "package Test",
                "function foo() returns int",
                "    return foo()",
                ""
        ));

        FunctionCall c = (FunctionCall) Utils.getAstElementAtPos(model.get(0), 3, 12, false);

        WPos pos = c.attrErrorPos();
        System.out.println("pos = " + pos.getLine());
        System.out.println("pos = " + pos.getStartColumn());
        System.out.println("pos = " + pos.getEndColumn());

    }
}
