package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCInput extends JavaCCStub {
    public JavaCCInput(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    public List<Production> getProductions() {
        List<Production> result = new LinkedList<Production>();
        for (PsiElement child : getChildren()) {
            if (child instanceof Production)
                result.add((Production) child);
        }
        return result;
    }
}
