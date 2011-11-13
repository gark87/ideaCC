package org.gark87.idea.javacc.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.gark87.idea.javacc.generated.JavaCCTreeConstants;
import org.gark87.idea.javacc.psi.reference.IdentifierReference;
import org.gark87.idea.javacc.psi.reference.JavaCCScopeProcessor;
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
            if (isNonTerminalProduction(elementType))
                return new IdentifierReference(this, JavaCCScopeProcessor.NONTERMINAL_OR_VAR);
        }
        PsiElement grandParent = parent.getParent();
        if (grandParent == null)
            return null;
        IElementType elementType = grandParent.getNode().getElementType();
        if (isNonTerminalProduction(elementType))
            return new IdentifierReference(this, JavaCCScopeProcessor.NONTERMINAL);
        if (elementType == JavaCCTreeConstants.JJTREGULAR_EXPRESSION)
            return new IdentifierReference(this, JavaCCScopeProcessor.TOKEN);
        return new IdentifierReference(this, JavaCCScopeProcessor.VARIABLE);
    }

    private static boolean isNonTerminalProduction(IElementType elementType) {
        return elementType == JavaCCTreeConstants.JJTBNF_PRODUCTION ||
            elementType == JavaCCTreeConstants.JJTJAVACODE_PRODUCTION ||
            elementType == JavaCCTreeConstants.JJTEXPANSION_UNIT;
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
