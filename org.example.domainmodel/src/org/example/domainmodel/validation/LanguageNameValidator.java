/*
 * generated by Xtext 2.25.0
 */
package org.example.domainmodel.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.example.domainmodel.languageName.Entity;
import org.example.domainmodel.languageName.Feature;
import org.example.domainmodel.languageName.LanguageNamePackage;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class LanguageNameValidator extends AbstractLanguageNameValidator {
	
	public static final String NO_FEATURE = "noFeature";
	public static final String INVALID_NAME = "invalidName";

	@Check
	public void checkNameStartsWithCapital(Entity entity) {
	    if (!Character.isUpperCase(entity.getName().charAt(0))) {
	        warning("Name should start with a capital",
	        		LanguageNamePackage.Literals.TYPE__NAME,
	            INVALID_NAME);
	    }
	}

	@Check(CheckType.NORMAL)
	public void checkFeatureNameIsUnique(Feature feature) {
	    Entity superEntity = ((Entity) feature.eContainer()).getSuperType();
	    while (superEntity != null) {
	        for (Feature other : superEntity.getFeatures()) {
	            //if (Objects.equal(feature.getName(), other.getName())) {
	        	if (feature.getName().equals(other.getName())){
	                error("Feature names have to be unique", 
	                		LanguageNamePackage.Literals.FEATURE__NAME);
	                return;
	            }
	        }
	        superEntity = superEntity.getSuperType();
	    }
	}
	
	@Check
	public void checkAtLeastOneFeature(Entity entity) {
		if (entity.getFeatures().size()<= 0) {
			warning("Entity has no feature", 
					LanguageNamePackage.Literals.TYPE__NAME,
					NO_FEATURE);
		}
	}
	
	
//	public static final String INVALID_NAME = "invalidName";
//
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital",
//					LanguageNamePackage.Literals.GREETING__NAME,
//					INVALID_NAME);
//		}
//	}
	
}
