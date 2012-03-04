package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * @author gark87
 */
public class BNFProduction extends NonTerminalProduction {
    private static Icon ICON;

    public BNFProduction(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return "JavaCC BNF Production: " + getText();
    }

    @Override
    public Icon getIcon() {
        if (ICON == null)
            ICON = IconLoader.getIcon("/javacc/icons/nonterminal.png");
        return ICON;
    }
}
