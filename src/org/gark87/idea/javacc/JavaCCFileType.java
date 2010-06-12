package org.gark87.idea.javacc;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class JavaCCFileType extends LanguageFileType {
   private static final Icon ICON = IconLoader.getIcon("/fileTypes/java.png");
    public JavaCCFileType() {
        super(new JavaCCLanguage());
    }

    @NotNull
    public String getName() {
        return "JavaCC";
    }

    @NotNull
    public String getDescription() {
        return "JavaCC";
    }

    @NotNull
    public String getDefaultExtension() {
        return "jj";
    }

    public Icon getIcon() {
        return ICON;
    }
}


