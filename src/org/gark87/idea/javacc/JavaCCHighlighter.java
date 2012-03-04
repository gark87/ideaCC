package org.gark87.idea.javacc;

import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.tree.IElementType;
import org.gark87.idea.javacc.generated.JavaCCConstants;
import org.gark87.idea.javacc.generated.JavaCCLexer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gark87
 */
public class JavaCCHighlighter extends SyntaxHighlighterBase {
        
    private static final Map<IElementType, TextAttributesKey> keys1;
    private static final Map<IElementType, TextAttributesKey> keys2;

    public static final TextAttributesKey JAVACC_KEYWORD =
            TextAttributesKey.createTextAttributesKey("JAVACC.JAVACC_KEYWORD",
                    SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
            );

        public static final TextAttributesKey JAVA_KEYWORD =
            TextAttributesKey.createTextAttributesKey("JAVACC.JAVA_KEYWORD",
                    SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
            );

        public static final TextAttributesKey PARENTHS =
            TextAttributesKey.createTextAttributesKey("JAVACC.PARENTHS",
                    SyntaxHighlighterColors.PARENTHS.getDefaultAttributes()
            );
      public static final TextAttributesKey DOT =
            TextAttributesKey.createTextAttributesKey("JAVACC.DOT",
                    SyntaxHighlighterColors.DOT.getDefaultAttributes()
            );
    public static final TextAttributesKey COMMA =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.COMMA",
            SyntaxHighlighterColors.COMMA.getDefaultAttributes()
    );

    public static final TextAttributesKey BRACKETS =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.BRACKETS",
            SyntaxHighlighterColors.BRACKETS.getDefaultAttributes()
    );

    public static final TextAttributesKey NUMBER =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.NUMBER",
            SyntaxHighlighterColors.NUMBER.getDefaultAttributes()
    );

    public static final TextAttributesKey OPERATOR =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.OPERATOR",
            SyntaxHighlighterColors.OPERATION_SIGN.getDefaultAttributes()
    );

    public static final TextAttributesKey STRING =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.STRING",
            SyntaxHighlighterColors.STRING.getDefaultAttributes()
    );

    public static final TextAttributesKey COMMENT =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.COMMENT",
            SyntaxHighlighterColors.LINE_COMMENT.getDefaultAttributes()
    );

    public static final TextAttributesKey TOKEN =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.TOKEN",
            SyntaxHighlighterColors.KEYWORD.getDefaultAttributes()
    );

    public static final TextAttributesKey ERROR =
    TextAttributesKey.createTextAttributesKey(
            "JAVACC.ERROR",
            SyntaxHighlighterColors.INVALID_STRING_ESCAPE.getDefaultAttributes()
    );

    static {
        keys1 = new HashMap<IElementType, TextAttributesKey>();
        keys2 = new HashMap<IElementType, TextAttributesKey>();

        // comment
        keys1.put(JavaCCConstants.SINGLE_LINE_COMMENT, COMMENT);
        keys1.put(JavaCCConstants.FORMAL_COMMENT, COMMENT);
        keys1.put(JavaCCConstants.MULTI_LINE_COMMENT, COMMENT);
        // javacc keywords
        keys1.put(JavaCCConstants._OPTIONS, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._LOOKAHEAD, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._IGNORE_CASE, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._PARSER_BEGIN, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._PARSER_END, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._JAVACODE, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._TOKEN, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._SPECIAL_TOKEN, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._MORE, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._SKIP, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._TOKEN_MGR_DECLS, JAVACC_KEYWORD);
        keys1.put(JavaCCConstants._EOF, JAVACC_KEYWORD);
        // java keywords
        keys1.put(JavaCCConstants.ABSTRACT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.BOOLEAN, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.BREAK, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.BYTE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.CASE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.CATCH, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.CHAR, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.CLASS, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.CONST, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.CONTINUE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants._DEFAULT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.DO, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.DOUBLE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.ELSE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.EXTENDS, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.FALSE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.FINAL, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.FINALLY, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.FLOAT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.FOR, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.GOTO, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.IF, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.IMPLEMENTS, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.IMPORT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.INSTANCEOF, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.INT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.INTERFACE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.LONG, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.NATIVE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.NEW, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.NULL, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.PACKAGE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.PRIVATE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.PROTECTED, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.PUBLIC, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.RETURN, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.SHORT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.STATIC, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.SUPER, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.SWITCH, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.SYNCHRONIZED, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.THIS, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.THROW, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.THROWS, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.TRANSIENT, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.TRUE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.TRY, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.VOID, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.VOLATILE, JAVA_KEYWORD);
        keys1.put(JavaCCConstants.WHILE, JAVA_KEYWORD);

        // operator
        keys1.put(JavaCCConstants. ASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. GT, OPERATOR);
        keys1.put(JavaCCConstants. LT, OPERATOR);
        keys1.put(JavaCCConstants. BANG, OPERATOR);
        keys1.put(JavaCCConstants. TILDE, OPERATOR);
        keys1.put(JavaCCConstants. HOOK, OPERATOR);
        keys1.put(JavaCCConstants. COLON, OPERATOR);
        keys1.put(JavaCCConstants. EQ, OPERATOR);
        keys1.put(JavaCCConstants. LE, OPERATOR);
        keys1.put(JavaCCConstants. GE, OPERATOR);
        keys1.put(JavaCCConstants. NE, OPERATOR);
        keys1.put(JavaCCConstants. SC_OR, OPERATOR);
        keys1.put(JavaCCConstants. SC_AND, OPERATOR);
        keys1.put(JavaCCConstants. INCR, OPERATOR);
        keys1.put(JavaCCConstants. DECR, OPERATOR);
        keys1.put(JavaCCConstants. PLUS, OPERATOR);
        keys1.put(JavaCCConstants. MINUS, OPERATOR);
        keys1.put(JavaCCConstants. STAR, OPERATOR);
        keys1.put(JavaCCConstants. SLASH, OPERATOR);
        keys1.put(JavaCCConstants. BIT_AND, OPERATOR);
        keys1.put(JavaCCConstants. BIT_OR, OPERATOR);
        keys1.put(JavaCCConstants. XOR, OPERATOR);
        keys1.put(JavaCCConstants. REM, OPERATOR);
        keys1.put(JavaCCConstants. PLUSASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. MINUSASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. STARASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. SLASHASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. ANDASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. ORASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. XORASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. REMASSIGN, OPERATOR);
        keys1.put(JavaCCConstants. SHARP, OPERATOR);

        // semicolon
        keys1.put(JavaCCConstants.SEMICOLON, OPERATOR);
        // parenths
        keys1.put(JavaCCConstants.LPAREN, PARENTHS);
        keys1.put(JavaCCConstants.RPAREN, PARENTHS);
        // brackets
        keys1.put(JavaCCConstants.LBRACKET, BRACKETS);
        keys1.put(JavaCCConstants.RBRACKET, BRACKETS);
        // comma
        keys1.put(JavaCCConstants.COMMA, COMMA);
        // dot
        keys1.put(JavaCCConstants.DOT, DOT);
        // number
        keys1.put(JavaCCConstants.INTEGER_LITERAL, NUMBER);
        keys1.put(JavaCCConstants.FLOATING_POINT_LITERAL, NUMBER);
        // quoted string
        keys1.put(JavaCCConstants.STRING_LITERAL, STRING);
        keys1.put(JavaCCConstants.CHARACTER_LITERAL, STRING);

        // error
        keys1.put(JavaCCConstants.ERROR, ERROR);
    }
    

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new JavaCCLexer();
    }

    @NotNull
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(keys1.get(tokenType), keys2.get(tokenType));
    }

    public static final Map<TextAttributesKey, Pair<String, HighlightSeverity>> DISPLAY_NAMES = new HashMap<TextAttributesKey, Pair<String, HighlightSeverity>>(6);

    static {
        DISPLAY_NAMES.put(JAVACC_KEYWORD, new Pair<String, HighlightSeverity>("JavaCC keyword", null));
        DISPLAY_NAMES.put(JAVA_KEYWORD, new Pair<String, HighlightSeverity>("Java keyword", null));
        DISPLAY_NAMES.put(PARENTHS, new Pair<String, HighlightSeverity>("parenths", null));
        DISPLAY_NAMES.put(DOT, new Pair<String, HighlightSeverity>("dot", null));
        DISPLAY_NAMES.put(COMMA, new Pair<String, HighlightSeverity>("comma", null));
        DISPLAY_NAMES.put(BRACKETS, new Pair<String, HighlightSeverity>("brackets", null));
        DISPLAY_NAMES.put(NUMBER, new Pair<String, HighlightSeverity>("number", null));
        DISPLAY_NAMES.put(OPERATOR, new Pair<String, HighlightSeverity>("operator", null));
        DISPLAY_NAMES.put(STRING, new Pair<String, HighlightSeverity>("quoted string", null));
        DISPLAY_NAMES.put(COMMENT, new Pair<String, HighlightSeverity>("comment", null));
        DISPLAY_NAMES.put(ERROR, new Pair<String, HighlightSeverity>("error", null));
        DISPLAY_NAMES.put(TOKEN, new Pair<String, HighlightSeverity>("token", null));
    }
}
