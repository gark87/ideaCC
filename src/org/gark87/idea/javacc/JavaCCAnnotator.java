package org.gark87.idea.javacc;

import com.intellij.lang.ASTNode;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import org.gark87.idea.javacc.generated.JavaCCTreeConstants;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCAnnotator implements Annotator {
    public void annotate(@NotNull PsiElement psiElement, @NotNull AnnotationHolder holder) {
        ASTNode node = psiElement.getNode();
        if (node.getElementType() != JavaCCTreeConstants.JJTREGULAR_EXPRESSION ||
                psiElement.getParent().getNode().getElementType() != JavaCCTreeConstants.JJTEXPANSION_UNIT)
        {
            return;
        }
        Annotation annotation = holder.createInfoAnnotation(node, null);
        annotation.setTextAttributes(JavaCCHighlighter.TOKEN);
    }
}
