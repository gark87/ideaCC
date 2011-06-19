package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class VariableDeclaratorId extends JavaCCStub {
    public VariableDeclaratorId(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    public Identifier getIdentifier() {
        return PsiTreeUtil.getChildOfType(this, Identifier.class);
    }

}
