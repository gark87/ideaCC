package org.gark87.idea.javacc.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.gark87.idea.javacc.generated.JavaCCTreeConstants;
import org.gark87.idea.javacc.psi.reference.NonTerminalReference;
import org.gark87.idea.javacc.psi.reference.TokenReference;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


/**
* @author gark87 <arkady.galyash@gmail.com>
*/
public class Identifier extends LeafPsiElement implements PsiNameIdentifierOwner {

    public Identifier(IElementType type, CharSequence text) {
        super(type, text);
    }

    @Override
    public PsiElement getNameIdentifier() {
        return this;
    }

    @Override
    public PsiReference getReference() {
        PsiElement parent = getParent();
        if (parent == null)
            return null;
        if (parent.getNode().getElementType() != JavaCCTreeConstants.JJTIDENTIFIER) {
            IElementType elementType = parent.getNode().getElementType();
            if (parent instanceof BNFProduction || elementType == JavaCCTreeConstants.JJTEXPANSION_UNIT)
                return new NonTerminalReference(this);
        }
        PsiElement grandParent = parent.getParent();
        if (grandParent == null)
            return null;
        IElementType elementType = grandParent.getNode().getElementType();
        if (grandParent instanceof BNFProduction || elementType == JavaCCTreeConstants.JJTEXPANSION_UNIT)
            return new NonTerminalReference(this);
        if (elementType == JavaCCTreeConstants.JJTREGULAR_EXPRESSION)
            return new TokenReference(this);
        return null;
    }

    @Override
    @NotNull
    public String getName() {
        return getText();
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String s) throws IncorrectOperationException {
        return this;
    }
}
