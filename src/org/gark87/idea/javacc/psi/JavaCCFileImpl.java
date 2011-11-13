package org.gark87.idea.javacc.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import org.gark87.idea.javacc.JavaCCSupportLoader;
import org.gark87.idea.javacc.generated.JavaCCElementTypes;
import org.jetbrains.annotations.NotNull;

//import org.gark87.idea.javacc.psi.JavaCCInput;

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

    @Override
    public boolean processDeclarations(@NotNull PsiScopeProcessor processor, @NotNull ResolveState state, PsiElement lastParent, @NotNull PsiElement place) {
        JavaCCInput input = getJavaCCInput();
        if (input == null)
            return true;
        for (Production production : input.getProductions()) {
            RegExpProduction regExpProduction = production.getRegExpProduction();
            if (regExpProduction != null) {
                for (RegExpSpec regExp : regExpProduction.getAllRegExpSpec()) {
                    if (processor.execute(regExp, state))
                        return false;
                }
            }
            NonTerminalProduction nonTerminal = production.getNonTerminalProduction();
            if (nonTerminal != null && processor.execute(nonTerminal, state))
                return false;
        }
        return true;
    }

}