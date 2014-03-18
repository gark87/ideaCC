package org.gark87.idea.javacc;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import org.gark87.idea.javacc.generated.JavaCC;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87
 */
public class JavaCCParser implements PsiParser {
    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        final PsiBuilder.Marker rootMarker = builder.mark();
        JavaCC javacc = new JavaCC(builder);
        javacc.javacc_input();
        if (!builder.eof()) {
            PsiBuilder.Marker errorMark = builder.mark();
            while (!builder.eof())
                builder.advanceLexer();
            errorMark.error("Extra text");
        }
        rootMarker.done(root);
        return builder.getTreeBuilt();
    }
}
