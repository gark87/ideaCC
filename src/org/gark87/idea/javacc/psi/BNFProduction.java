package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class BNFProduction extends NonTerminalProduction {
    public BNFProduction(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return "JavaCC BNF Production: " + getText();
    }
}
