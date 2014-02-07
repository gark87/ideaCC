package org.gark87.idea.javacc;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.util.IconLoader;
import org.gark87.idea.javacc.generated.JavaCCLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author gark87
 */
public class JavaCCFileType extends LanguageFileType {
    public static final Icon FILE = IconLoader.findIcon("/javacc/icons/javacc.png");

    public JavaCCFileType() {
        super(new JavaCCLanguage());
        SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(getLanguage(), new SingleLazyInstanceSyntaxHighlighterFactory() {
            @NotNull
            protected SyntaxHighlighter createHighlighter() {
                return new JavaCCHighlighter();
            }
        });
    }

    @NotNull
    @Override
    public String getName() {
        return "JavaCC";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "JavaCC *.jj files support";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "jj";
    }

    @Override
    public Icon getIcon() {
        return FILE;
    }
}
