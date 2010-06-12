package org.gark87.idea.javacc;

import com.intellij.ide.highlighter.JavaFileHighlighter;
import com.intellij.lexer.Lexer;
import com.intellij.pom.java.LanguageLevel;
import org.jetbrains.annotations.NotNull;


public class JavaCCFileHighlighter extends JavaFileHighlighter {

    private final LanguageLevel myLanguageLevel;
    public JavaCCFileHighlighter() {
        this(LanguageLevel.HIGHEST);
    }

    public JavaCCFileHighlighter(LanguageLevel languageLevel) {
        super(languageLevel);
        myLanguageLevel = languageLevel;
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new JavaCCHighlightingLexer(myLanguageLevel);
    }
}
