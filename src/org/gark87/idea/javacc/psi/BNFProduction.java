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

    public String getProductionName() {
        PsiElement[] children = getChildren();
        if (children.length >= 3)
            return children[2].getText();
        return "";
    }

    @Override
    public String toString() {
        return "JavaCC BNF Production: " + getText();
    }
}
