package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.util.PsiTreeUtil;

/**
* @author gark87 <arkady.galyash@gmail.com>
*/
public class Production extends JavaCCStub {
    public Production(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    public NonTerminalProduction getNonTerminalProduction() {
        return PsiTreeUtil.getChildOfType(this, NonTerminalProduction.class);
    }

    public RegExpProduction getRegExpProduction() {
        return PsiTreeUtil.getChildOfType(this, RegExpProduction.class);
    }

    @Override
    public String toString() {
        return "JavaCC Production: " + getText();
    }
}
