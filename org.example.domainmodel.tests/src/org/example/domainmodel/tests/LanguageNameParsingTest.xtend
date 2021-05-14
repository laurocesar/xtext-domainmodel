/*
 * generated by Xtext 2.25.0
 */
package org.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.example.domainmodel.languageName.Entity
import org.example.domainmodel.languageName.LanguageName
import org.example.domainmodel.languageName.LanguageNamePackage
import org.example.domainmodel.validation.LanguageNameValidator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith

import static org.junit.Assert.assertSame

@ExtendWith(InjectionExtension)
@InjectWith(LanguageNameInjectorProvider)
class LanguageNameParsingTest {
	@Inject
	ParseHelper<LanguageName> parseHelper
	@Inject 
	ValidationTestHelper validationTestHelper
	
	/*
	@Test
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", ")»''')
	}
	*/
		
     @Test 
     def void parseDomainmodel() {
         val model = parseHelper.parse(
             "entity MyEntity {
                 parent: MyEntity
             }")
         val entity = model.elements.head as Entity
         assertSame(entity, entity.features.head.type)
     }
     
     @Test
 	 def testNameStartsWithCapitalWarning() {
	     val entity = parseHelper.parse(
	         "entity myEntity {
	             parent: myEntity
	         }")
	     validationTestHelper.assertWarning(entity,
	         LanguageNamePackage.Literals.ENTITY,
	         LanguageNameValidator.INVALID_NAME,
	         	"Name should start with a capital"
	     )
	 }
     
	
}
