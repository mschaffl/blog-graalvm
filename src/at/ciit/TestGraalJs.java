package at.ciit;

import javax.naming.Context;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestGraalJs {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        ScriptContext context = engine.getContext();

        Object eval = engine.eval("var a = -5 + 3; Math.abs(a);");
        engine.put("b","Hello JavaScript World;");
        engine.eval("function square(i){return i*i;}");
        engine.eval("var b = square(a)");

        System.out.println("JavaScript Implementation: " + engine.getClass().getName()); //GraalJSScriptEngine
        System.out.println("Result of type: " + eval.getClass().getName());
        System.out.println("Result: " + eval);
        System.out.println("Variable a in engine: " + engine.get("a"));
        System.out.println("Variable b in engine: " + engine.get("b"));
    }
}
