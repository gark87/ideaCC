package org.gark87.idea.javacc;

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
  }

  public String getDisplayName() {
    return "JavaCC";
  }

  public boolean isCaseSensitive() {
    return true;
  }

}
