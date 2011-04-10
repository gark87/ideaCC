package org.gark87.idea.javacc.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import org.gark87.idea.javacc.JavaCCSupportLoader;
import org.gark87.idea.javacc.generated.JavaCCElementTypes;
import org.gark87.idea.javacc.psi.JavaCCInput;
import org.jetbrains.annotations.NotNull;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCFileImpl extends PsiFileBase {
    public JavaCCFileImpl(FileViewProvider provider) {
        super(provider, JavaCCElementTypes.LANG);
    }

    public JavaCCInput getJavaCCInput() {
        for (PsiElement child : getChildren()) {
            if (child instanceof JavaCCInput)
                return (JavaCCInput) child;
        }
        return null;
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JavaCCSupportLoader.JAVA_CC;
    }
}