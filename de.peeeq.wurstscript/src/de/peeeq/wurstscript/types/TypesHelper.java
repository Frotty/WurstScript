package de.peeeq.wurstscript.types;

import com.google.common.collect.Lists;

import de.peeeq.wurstscript.ast.ClassDef;
import de.peeeq.wurstscript.ast.ClassOrModule;
import de.peeeq.wurstscript.ast.ModuleDef;
import de.peeeq.wurstscript.jassIm.ImType;
import de.peeeq.wurstscript.jassIm.JassIm;

public class TypesHelper {

	private static final ImType intType = PScriptTypeInt.instance().imTranslateType();
	private static final ImType intPair = JassIm.ImTupleType(Lists.newArrayList(intType, intType));

	public static PscriptType typeOf(ClassOrModule classOrModule, final boolean isStatic) {
		return classOrModule.match(new ClassOrModule.Matcher<PscriptType>() {

			@Override
			public PscriptType case_ClassDef(ClassDef classDef) {
				PscriptType t = classDef.attrTyp();
				if (!isStatic)  {
					t = t.dynamic();
				}
				return t;
			}

			@Override
			public PscriptType case_ModuleDef(ModuleDef moduleDef) {
				return new PscriptTypeModule(moduleDef, isStatic);
			}
		});
	}

	public static ImType imIntPair() {
		return intPair;
	}

	public static ImType imInt() {
		return intType;
	}

	public static ImType imVoid() {
		return PScriptTypeVoid.instance().imTranslateType();
	}

//	public static boolean checkTypeArgs(InstanceDef iDef, List<PscriptType> classParams, List<PscriptType> interfaceParams) {
//		if (classParams.size() == 0 && interfaceParams.size() == 0) {
//			return true;
//		}
//		
//		Map<TypeParamDef, PscriptType> typeParamBinding = Maps.newHashMap(); 
//		
//		PscriptTypeClass classType = (PscriptTypeClass) iDef.getClassTyp().attrTyp();
//		int i = 0;
//		for (PscriptType classTp : classType.getTypeParameters()) {
//			PscriptTypeTypeParam classTp2 = (PscriptTypeTypeParam) classTp;
//			TypeParamDef tpDef = classTp2.getDef();
//			typeParamBinding.put(tpDef, classParams.get(i));
//			i++;
//		}
//		
//		ArrayList<PscriptType> actualInterfaceTypes = Lists.newArrayList();
//		
//		PscriptTypeInterface interfaceType = (PscriptTypeInterface) iDef.getImplementedTyp().attrTyp();
//		for (PscriptType intTp : interfaceType.getTypeParameters()) {
//			if (intTp instanceof PscriptTypeTypeParam) {
//				PscriptTypeTypeParam intTp2 = (PscriptTypeTypeParam) intTp;
//				actualInterfaceTypes.add(typeParamBinding.get(intTp2.getDef()));
//			} else {
//				actualInterfaceTypes.add(intTp);
//			}
//		}
//		
//		if (actualInterfaceTypes.size() != interfaceParams.size()) {
//			throw new CompileError(iDef.getSource(), "sizes do not match: " + actualInterfaceTypes.size()+ " != " + interfaceParams.size());
//		}
//		
//		i = 0;
//		for (PscriptType iTp : interfaceParams) {
//			if (!iTp.equalsType(actualInterfaceTypes.get(i), iDef)) {
//				return false;
//			}
//			i++;
//		}
//		
//		
//		return true;
//	}


}
