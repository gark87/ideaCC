package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

import org.gark87.idea.javacc.util.JavaCCIcons;


/**
 * @author gark87
 */
public class BNFProduction extends NonTerminalProduction {

    public BNFProduction(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return "JavaCC BNF Production: " + getText();
    }

    @Override
    public Icon getIcon() {
        return JavaCCIcons.NONTERMINAL.getIcon();
    }
}
