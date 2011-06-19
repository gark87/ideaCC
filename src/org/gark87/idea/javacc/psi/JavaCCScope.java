package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public abstract class JavaCCScope extends JavaCCStub {

    public JavaCCScope(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state,
                                       PsiElement lastParent, @NotNull PsiElement place) {
        if (!(processScopeDeclarations(processor, state, lastParent, place)))
            return false;
        JavaCCScope nextScope = findNextScope();
        if (nextScope == null)
            return getContainingFile().processDeclarations(processor, state, this, place);
        return nextScope.processDeclarations(processor, state, this, place);
    }

    protected JavaCCScope findNextScope() {
        return PsiTreeUtil.getParentOfType(this, JavaCCScope.class);
    }

    public abstract boolean processScopeDeclarations(@NotNull PsiScopeProcessor processor,
                             @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place);

}
