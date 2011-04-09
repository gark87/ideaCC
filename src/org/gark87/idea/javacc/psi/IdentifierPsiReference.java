package org.gark87.idea.javacc.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceBase;
import org.gark87.idea.javacc.JavaCCFileImpl;
import org.gark87.idea.javacc.JavaCCParserDefinition;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class IdentifierPsiReference extends PsiReferenceBase<Identifier> {

    public IdentifierPsiReference(@NotNull Identifier element) {
        super(element);
    }

    @Override
    public PsiElement resolve() {
        PsiFile file = getElement().getContainingFile();
        if (file == null || !(file instanceof JavaCCFileImpl))
            return null;
        JavaCCInput input = ((JavaCCFileImpl) file).getJavaCCInput();
        if (input == null)
            return null;
        String needle = getCanonicalText();
        for (Production production : input.getProductions()) {
            BNFProduction bnf = production.getBNFProduction();
            if (bnf == null)
                continue;
            if (bnf.getProductionName().equals(needle))
                return bnf;
        }
        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }
}
