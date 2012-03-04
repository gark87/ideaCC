package org.gark87.idea.javacc.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

import java.util.LinkedList;
import java.util.List;

/**
* @author gark87
*/
public class RegExpProduction extends JavaCCStub {
    public RegExpProduction(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    public List<RegExpSpec> getAllRegExpSpec() {
        List<RegExpSpec> result = new LinkedList<RegExpSpec>();
        for (PsiElement child : getChildren()) {
            if (child instanceof RegExpSpec)
                result.add((RegExpSpec) child);
        }
        return result;
    }
}
