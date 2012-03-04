package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87
 */
public abstract class NonTerminalProduction extends JavaCCScope implements DeclarationForStructureView {
    public NonTerminalProduction(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean processScopeDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
        Block[] blocks = PsiTreeUtil.getChildrenOfType(this, Block.class);
        if (blocks != null && blocks.length > 0) {
            if (!(blocks[0].processScopeDeclarations(processor, state, lastParent, place)))
                return false;
        }
        FormalParameters[] parameters = PsiTreeUtil.getChildrenOfType(this, FormalParameters.class);
        if (parameters != null) {
            for (FormalParameters params : parameters) {
                if (!(params.processDeclarations(processor, state, lastParent, place)))
                    return false;
            }
        }
        return true;
    }

    public Identifier getIdentifier() {
        PsiElement[] children = getChildren();
        if (children.length >= 3) {
            PsiElement result = children[2].getFirstChild();
            if (result instanceof Identifier)
                return (Identifier) result;
            return null;
        }
        return null;
    }
}
