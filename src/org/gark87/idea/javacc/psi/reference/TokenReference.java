package org.gark87.idea.javacc.psi.reference;

import com.intellij.psi.PsiFile;
import org.gark87.idea.javacc.psi.JavaCCFileImpl;
import org.gark87.idea.javacc.psi.*;
import org.jetbrains.annotations.NotNull;

/**
* @author gark87 <arkady.galyash@gmail.com>
*/
public class TokenReference extends IdentifierReference {
    public TokenReference(@NotNull Identifier element) {
        super(element);
    }

    @Override
    protected void process(Processor processor) {
        PsiFile file = getElement().getContainingFile();
        if (file == null || !(file instanceof JavaCCFileImpl))
            return;
        JavaCCInput input = ((JavaCCFileImpl) file).getJavaCCInput();
        if (input == null)
            return;
        for (Production production : input.getProductions()) {
            RegExpProduction regExpProduction = production.getRegExpProduction();
            if (regExpProduction == null)
                continue;
            for(RegExpSpec regExp: regExpProduction.getAllRegExpSpec()){
                Identifier name = regExp.getRegExpName();
                if (name == null)
                    continue;
                if (processor.process(name))
                    return;
            }
        }
    }
}
