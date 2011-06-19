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
public class FormalParameter extends JavaCCStub implements Declaration {
    public FormalParameter(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
        if (processor.execute(this, state))
            return false;
        return true;
    }

    public Identifier getIdentifier() {
        VariableDeclaratorId id = PsiTreeUtil.getChildOfType(this, VariableDeclaratorId.class);
        if (id == null)
            return null;
        return id.getIdentifier();
    }
}
