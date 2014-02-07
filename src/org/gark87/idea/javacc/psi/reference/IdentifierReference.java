package org.gark87.idea.javacc.psi.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.ResolveState;
import com.intellij.psi.util.PsiTreeUtil;
import org.gark87.idea.javacc.psi.Identifier;
import org.gark87.idea.javacc.psi.JavaCCFileImpl;
import org.gark87.idea.javacc.psi.JavaCCScope;
import org.gark87.idea.javacc.psi.reference.JavaCCScopeProcessor.DeclarationType;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

/**
* @author gark87
*/
public class IdentifierReference extends PsiReferenceBase<Identifier> {
    private final EnumSet<DeclarationType> myTypes;

    public IdentifierReference(@org.jetbrains.annotations.NotNull Identifier element, EnumSet<DeclarationType> types) {
        super(element);
        this.myTypes = types;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        JavaCCScopeProcessor processor = new JavaCCScopeProcessor(myTypes);
        process(processor);
        return processor.getCandidates();
    }

    @Override
    public PsiElement resolve() {
        String needle = getCanonicalText();
        JavaCCResolveProcessor processor = new JavaCCResolveProcessor(needle, myTypes);
        process(processor);
        return processor.getResult();
    }

    private void process(JavaCCScopeProcessor processor) {
        Identifier element = getElement();
        PsiElement scope = PsiTreeUtil.getParentOfType(element, JavaCCScope.class, JavaCCFileImpl.class);
        scope.processDeclarations(processor, ResolveState.initial(), element, element);
    }
}
