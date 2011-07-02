package de.peeeq.generator;

import de.peeeq.jassToPscript.BoolLiteral;
import de.peeeq.jassToPscript.Constant;
import de.peeeq.jassToPscript.Entity;
import de.peeeq.jassToPscript.Expr;
import de.peeeq.jassToPscript.FormalParameter;
import de.peeeq.jassToPscript.FormalParameters;
import de.peeeq.jassToPscript.FunctionCall;
import de.peeeq.jassToPscript.IntLiteral;
import de.peeeq.jassToPscript.Literal;
import de.peeeq.jassToPscript.Mult;
import de.peeeq.jassToPscript.NativeDef;
import de.peeeq.jassToPscript.Prog;
import de.peeeq.jassToPscript.ReturnType;
import de.peeeq.jassToPscript.TypeDef;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class JassToPscriptGenerator implements IGenerator {
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    StringConcatenation _compile = this.compile(resource);
    fsa.generateFile("natives.pscript", _compile);
  }
  
  public StringConcatenation compile(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// generated by JassToPscript");
    _builder.newLine();
    _builder.newLine();
    _builder.append("package jass.natives {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// standard types");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native type Int = integer");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native type Real = real");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native type String = string");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native type Bool = boolean");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native type Code = code");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("native type Handle = handle");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<EObject> _contents = resource.getContents();
      Iterable<Prog> _filter = IterableExtensions.<Prog>filter(_contents, de.peeeq.jassToPscript.Prog.class);
      for(Prog e : _filter) {
        StringConcatenation _compile = this.compile(e);
        _builder.append(_compile, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public StringConcatenation compile(final Prog prog) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Entity> _elems = prog.getElems();
      for(Entity elem : _elems) {
        StringConcatenation _compile = this.compile(elem);
        _builder.append(_compile, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _compile(final Entity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*Entity: ");
    _builder.append(e, "");
    _builder.append("*/");
    return _builder;
  }
  
  protected StringConcatenation _compile(final TypeDef t) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("native type ");
    String _name = t.getName();
    String _compileType = this.compileType(_name);
    _builder.append(_compileType, "");
    _builder.append(" = ");
    String _name_1 = t.getName();
    _builder.append(_name_1, "");
    _builder.append(" extends ");
    String _extendName = t.getExtendName();
    String _compileType_1 = this.compileType(_extendName);
    _builder.append(_compileType_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compile(final Constant c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ");
    String _name = c.getName();
    _builder.append(_name, "");
    _builder.append(" = ");
    Expr _value = c.getValue();
    StringConcatenation _compile = this.compile(_value);
    _builder.append(_compile, "");
    return _builder;
  }
  
  protected StringConcatenation _compile(final Expr e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/* not implemented */");
    return _builder;
  }
  
  protected StringConcatenation _compile(final FunctionCall e) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = e.getName();
    _builder.append(_name, "");
    _builder.append("(");
    {
      EList<Expr> _parameters = e.getParameters();
      boolean hasAnyElements = false;
      for(Expr p : _parameters) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append("p.compile");
      }
    }
    _builder.append(")");
    return _builder;
  }
  
  protected StringConcatenation _compile(final IntLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    int _intVal = e.getIntVal();
    _builder.append(_intVal, "");
    return _builder;
  }
  
  protected StringConcatenation _compile(final BoolLiteral e) {
    StringConcatenation _builder = new StringConcatenation();
    String _boolVal = e.getBoolVal();
    _builder.append(_boolVal, "");
    return _builder;
  }
  
  protected StringConcatenation _compile(final Mult e) {
    StringConcatenation _builder = new StringConcatenation();
    Literal _left = e.getLeft();
    StringConcatenation _compile = this.compile(_left);
    _builder.append(_compile, "");
    _builder.append(" * ");
    Literal _right = e.getRight();
    StringConcatenation _compile_1 = this.compile(_right);
    _builder.append(_compile_1, "");
    return _builder;
  }
  
  protected StringConcatenation _compile(final NativeDef f) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ReturnType _returnType = f.getReturnType();
      if ((_returnType instanceof de.peeeq.jassToPscript.ReturnsNothing)) {
        _builder.append("function ");
        String _name = f.getName();
        String _firstLower = StringExtensions.toFirstLower(_name);
        _builder.append(_firstLower, "");
        _builder.append(" (");
        FormalParameters _params = f.getParams();
        StringConcatenation _compile = this.compile(_params);
        _builder.append(_compile, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("buildin ");
        String _name_1 = f.getName();
        _builder.append(_name_1, "	");
        _builder.append("(");
        FormalParameters _params_1 = f.getParams();
        StringConcatenation _compileNames = this.compileNames(_params_1);
        _builder.append(_compileNames, "	");
        _builder.append(")");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();} else {
        _builder.append("function ");
        String _name_2 = f.getName();
        String _firstLower_1 = StringExtensions.toFirstLower(_name_2);
        _builder.append(_firstLower_1, "");
        _builder.append(" (");
        FormalParameters _params_2 = f.getParams();
        StringConcatenation _compile_1 = this.compile(_params_2);
        _builder.append(_compile_1, "");
        _builder.append("):");
        ReturnType _returnType_1 = f.getReturnType();
        String _name_3 = _returnType_1.getName();
        String _compileType = this.compileType(_name_3);
        _builder.append(_compileType, "");
        _builder.append(" {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("return buildin ");
        String _name_4 = f.getName();
        _builder.append(_name_4, "	");
        _builder.append("(");
        FormalParameters _params_3 = f.getParams();
        StringConcatenation _compileNames_1 = this.compileNames(_params_3);
        _builder.append(_compileNames_1, "	");
        _builder.append(")\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected StringConcatenation _compile(final FormalParameters f) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<FormalParameter> _parameters = f.getParameters();
      boolean hasAnyElements = false;
      for(FormalParameter p : _parameters) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = p.getName();
        String _firstLower = StringExtensions.toFirstLower(_name);
        _builder.append(_firstLower, "");
        _builder.append(":");
        String _type = p.getType();
        String _compileType = this.compileType(_type);
        _builder.append(_compileType, "");
      }
    }
    return _builder;
  }
  
  public StringConcatenation compileNames(final FormalParameters f) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<FormalParameter> _parameters = f.getParameters();
      boolean hasAnyElements = false;
      for(FormalParameter p : _parameters) {
        if (!hasAnyElements) {
          hasAnyElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = p.getName();
        String _firstLower = StringExtensions.toFirstLower(_name);
        _builder.append(_firstLower, "");
      }
    }
    return _builder;
  }
  
  public String compileType(final String type) {
    {
      boolean _equals = type.equals("integer");
      if (_equals) {
        return "Int";
      }
      boolean _equals_1 = type.equals("boolean");
      if (_equals_1) {
        return "Bool";
      }
      String _firstUpper = StringExtensions.toFirstUpper(type);
      return _firstUpper;
    }
  }
  
  public StringConcatenation compile(final EObject e) {
    if ((e instanceof BoolLiteral)) {
      return _compile((BoolLiteral)e);
    } else if ((e instanceof IntLiteral)) {
      return _compile((IntLiteral)e);
    } else if ((e instanceof FunctionCall)) {
      return _compile((FunctionCall)e);
    } else if ((e instanceof Mult)) {
      return _compile((Mult)e);
    } else if ((e instanceof NativeDef)) {
      return _compile((NativeDef)e);
    } else if ((e instanceof TypeDef)) {
      return _compile((TypeDef)e);
    } else if ((e instanceof Constant)) {
      return _compile((Constant)e);
    } else if ((e instanceof Entity)) {
      return _compile((Entity)e);
    } else if ((e instanceof Expr)) {
      return _compile((Expr)e);
    } else if ((e instanceof FormalParameters)) {
      return _compile((FormalParameters)e);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(e).toString());
    }
  }
}