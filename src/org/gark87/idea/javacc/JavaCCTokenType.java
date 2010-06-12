package org.gark87.idea.javacc;

import com.intellij.psi.JavaTokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.java.IJavaElementType;

public interface JavaCCTokenType extends JavaTokenType {
    IElementType SHARP = new IJavaElementType("NUMBER_SIGN");
}
