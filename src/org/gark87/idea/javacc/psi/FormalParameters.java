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
public class FormalParameters extends JavaCCStub {
    public FormalParameters(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
        FormalParameter[] parameters = PsiTreeUtil.getChildrenOfType(this, FormalParameter.class);
        if (parameters == null)
            return true;
        for(FormalParameter parameter : parameters) {
            if (!(parameter.processDeclarations(processor, state, lastParent, place)))
                return false;
        }
        return true;
    }
}
