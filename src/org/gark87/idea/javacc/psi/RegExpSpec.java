package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import org.gark87.idea.javacc.generated.JavaCCTreeConstants;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class RegExpSpec extends JavaCCStub {
    public RegExpSpec(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

     public Identifier getRegExpName() {
        PsiElement[] children = getChildren();
        if (children.length == 0)
            return null;
        PsiElement regular_expression = children[0];
        for(PsiElement grandChild: regular_expression.getChildren()) {
            if (grandChild.getNode().getElementType() == JavaCCTreeConstants.JJTIDENTIFIER) {
                PsiElement result =  grandChild.getFirstChild();
                if (result instanceof Identifier)
                    return (Identifier) result;
                return null;
            }
        }
        return null;
    }
}
