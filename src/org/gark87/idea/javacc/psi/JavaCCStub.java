package org.gark87.idea.javacc.psi;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.StubElement;
import org.gark87.idea.javacc.generated.JavaCCElementTypes;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCStub<T extends StubElement> extends StubBasedPsiElementBase<T> {
    public JavaCCStub(@org.jetbrains.annotations.NotNull ASTNode node) {
        super(node);
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return JavaCCElementTypes.LANG;
    }
}
