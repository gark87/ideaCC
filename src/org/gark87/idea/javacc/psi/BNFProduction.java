package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class BNFProduction extends JavaCCStub {
    public BNFProduction(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    public Identifier getProductionName() {
        PsiElement[] children = getChildren();
        if (children.length >= 3) {
            PsiElement result = children[2].getFirstChild();
            if (result instanceof Identifier)
                return (Identifier) result;
            return null;
        }
        return null;
    }

    @Override
    public String toString() {
        return "JavaCC BNF Production: " + getText();
    }
}
