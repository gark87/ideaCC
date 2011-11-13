package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavacodeProduction extends NonTerminalProduction {
    public JavacodeProduction(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String toString() {
        return "JavaCC JAVACODE Production: " + getText();
    }
}
