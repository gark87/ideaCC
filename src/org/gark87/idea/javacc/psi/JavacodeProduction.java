package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author gark87
 */
public class JavacodeProduction extends NonTerminalProduction {
    private static Icon ICON;

    public JavacodeProduction(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return "JavaCC JAVACODE Production: " + getText();
    }

    @Override
    public Icon getIcon() {
        if (ICON == null)
            ICON = IconLoader.getIcon("/nodes/method.png");
        return ICON;
    }
}
