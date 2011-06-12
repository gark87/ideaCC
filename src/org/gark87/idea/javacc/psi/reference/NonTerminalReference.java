package org.gark87.idea.javacc.psi.reference;

import com.intellij.psi.PsiFile;
import org.gark87.idea.javacc.psi.JavaCCFileImpl;
import org.gark87.idea.javacc.psi.*;
import org.jetbrains.annotations.NotNull;

/**
* @author gark87 <arkady.galyash@gmail.com>
*/
public class NonTerminalReference extends IdentifierReference {

    public NonTerminalReference(@NotNull Identifier element) {
        super(element);
    }

    protected void process(Processor processor) {
        PsiFile file = getElement().getContainingFile();
        if (file == null || !(file instanceof JavaCCFileImpl))
            return;
        JavaCCInput input = ((JavaCCFileImpl) file).getJavaCCInput();
        if (input == null)
            return;
        for (Production production : input.getProductions()) {
            BNFProduction bnf = production.getBNFProduction();
            if (bnf == null)
                continue;
            Identifier productionName = bnf.getProductionName();
            if (productionName == null)
                continue;
            if (processor.process(productionName))
                return;
        }
    }
}
