package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

/**
* @author gark87 <arkady.galyash@gmail.com>
*/
public class Production extends JavaCCStub {
    public Production(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    public BNFProduction getBNFProduction() {
        for (PsiElement child : getChildren()) {
            if (child instanceof BNFProduction)
                return ((BNFProduction) child);
        }
        return null;
    }


     public RegExpProduction getRegExpProduction() {
        for (PsiElement child : getChildren()) {
            if (child instanceof RegExpProduction)
                return ((RegExpProduction) child);
        }
        return null;
    }

    @Override
    public String toString() {
        return "JavaCC Production: " + getText();
    }
}
