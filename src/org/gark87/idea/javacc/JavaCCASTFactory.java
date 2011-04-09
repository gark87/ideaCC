package org.gark87.idea.javacc;


import com.intellij.lang.ASTFactory;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import org.gark87.idea.javacc.generated.JavaCCConstants;
import org.gark87.idea.javacc.psi.Identifier;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCASTFactory extends ASTFactory {
    @Override
    public CompositeElement createComposite(IElementType type) {
        if (type instanceof IFileElementType)
            return new FileElement(type, null);
        return new CompositeElement(type);
    }

    @Override
    public LeafElement createLeaf(IElementType type, CharSequence text) {
        if (type == JavaCCConstants.IDENTIFIER || type == JavaCCConstants._OPTIONS)
            return new Identifier(type, text);
        return new LeafPsiElement(type, text);
    }
}
