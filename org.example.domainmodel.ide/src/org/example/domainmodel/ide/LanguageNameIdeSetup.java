/*
 * generated by Xtext 2.25.0
 */
package org.example.domainmodel.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.util.Modules2;
import org.example.domainmodel.LanguageNameRuntimeModule;
import org.example.domainmodel.LanguageNameStandaloneSetup;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class LanguageNameIdeSetup extends LanguageNameStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new LanguageNameRuntimeModule(), new LanguageNameIdeModule()));
	}
	
}
