package org.gark87.idea.javacc;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCColorsPage implements ColorSettingsPage {
      private static final AttributesDescriptor[] ATTRS;

    static {
        ATTRS = new AttributesDescriptor[JavaCCHighlighter.DISPLAY_NAMES.size()];
        TextAttributesKey[] keys = JavaCCHighlighter.DISPLAY_NAMES.keySet().toArray(
                new TextAttributesKey[JavaCCHighlighter.DISPLAY_NAMES.keySet().size()]);
        for (int i = 0; i < keys.length; i++) {
            TextAttributesKey key = keys[i];
            String name = JavaCCHighlighter.DISPLAY_NAMES.get(key).getFirst();
            ATTRS[i] = new AttributesDescriptor(name, key);
        }
    }

    @NotNull
    public String getDisplayName() {
        return "JavaCC";
    }

    public Icon getIcon() {
        return null;
    }

    @NotNull
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    @NotNull
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    public SyntaxHighlighter getHighlighter() {
        return new JavaCCHighlighter();
    }

    @NotNull
    public String getDemoText() {
        return "options {\n" +
                "  LOOKAHEAD = 1;\n" +
                "  CHOICE_AMBIGUITY_CHECK = 2;\n" +
                "  OTHER_AMBIGUITY_CHECK = 1;\n" +
                "  STATIC = true;\n" +
                "  DEBUG_PARSER = false;\n" +
                "  DEBUG_LOOKAHEAD = false;\n" +
                "  DEBUG_TOKEN_MANAGER = false;\n" +
                "  ERROR_REPORTING = true;\n" +
                "  JAVA_UNICODE_ESCAPE = false;\n" +
                "  UNICODE_INPUT = false;\n" +
                "  IGNORE_CASE = false;\n" +
                "  USER_TOKEN_MANAGER = false;\n" +
                "  USER_CHAR_STREAM = false;\n" +
                "  BUILD_PARSER = true;\n" +
                "  BUILD_TOKEN_MANAGER = true;\n" +
                "  SANITY_CHECK = true;\n" +
                "  FORCE_LA_CHECK = false;\n" +
                "}\n" +
                "\n" +
                "PARSER_BEGIN(Simple1)\n" +
                "\n" +
                "public class Simple1 {\n" +
                "\n" +
                "  public static void main(String args[]) throws ParseException {\n" +
                "    Simple1 parser = new Simple1(System.in);\n" +
                "    parser.Input();\n" +
                "  }\n" +
                "\n" +
                "}\n" +
                "\n" +
                "PARSER_END(Simple1)\n" +
                "\n" +
                "void Input() :\n" +
                "{}\n" +
                "{\n" +
                "  MatchedBraces() (\"\\n\"|\"\\r\")* <EOF>\n" +
                "}\n" +
                "\n" +
                "void MatchedBraces() :\n" +
                "{}\n" +
                "{\n" +
                "  \"{\" [ MatchedBraces() ] \"}\"\n" +
                "}";

    }

    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
}
