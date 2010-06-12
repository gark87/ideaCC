package org.gark87.idea.javacc;

import com.intellij.ide.highlighter.JavaFileHighlighter;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.module.LanguageLevelUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.java.LanguageLevel;
import org.jetbrains.annotations.NotNull;

public class JavaCCLanguage extends Language {

    public JavaCCLanguage() {
    super("JavaCC", "text/javaCC");
    SyntaxHighlighterFactory.LANGUAGE_FACTORY.addExplicitExtension(this, new SyntaxHighlighterFactory() {
      @NotNull
      public SyntaxHighlighter getSyntaxHighlighter(final Project project, final VirtualFile virtualFile) {
        return new JavaCCFileHighlighter( virtualFile != null ? LanguageLevelUtil.getLanguageLevelForFile(virtualFile) : LanguageLevel.HIGHEST);
      }
    });
  }

  public String getDisplayName() {
    return "JavaCC";
  }

  public boolean isCaseSensitive() {
    return true;
  }

}
