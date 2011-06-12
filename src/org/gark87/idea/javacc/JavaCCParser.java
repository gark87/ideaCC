package org.gark87.idea.javacc;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.gark87.idea.javacc.generated.JavaCC;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCParser implements PsiParser {
    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        final PsiBuilder.Marker rootMarker = builder.mark();
        JavaCC javacc = new JavaCC(builder);
        while(!builder.eof())
            javacc.javacc_input();
        rootMarker.done(root);
        return builder.getTreeBuilt();
    }
}
