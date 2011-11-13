package org.gark87.idea.javacc;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

public class JavaCCSupportLoader implements ApplicationComponent {
    public static final LanguageFileType JAVA_CC = new JavaCCFileType();
    private final String[] EXTENSIONS = {"jj", "jjt"};

    public void initComponent() {
        ApplicationManager.getApplication().runWriteAction(
                new Runnable() {
                    public void run() {
                        for (String extension: EXTENSIONS)
                            FileTypeManager.getInstance().registerFileType(JAVA_CC, extension);
                    }
                }
        );
    }

    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "JavaCC support loader";
    }
}
   
