package org.gark87.idea.javacc.psi;

import com.intellij.psi.PsiElement;

/**
 * @author gark87
 */
public interface Declaration extends PsiElement {
    public Identifier getIdentifier() ;
}
