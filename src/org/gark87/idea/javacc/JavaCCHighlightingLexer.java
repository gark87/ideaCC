/**
 * ATTENTION! Copied from IDEA sources with cosmetic changes
 */
package org.gark87.idea.javacc;

import com.intellij.lexer.*;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.JavaDocTokenType;
import com.intellij.psi.JavaTokenType;
import com.intellij.psi.tree.IElementType;


/**
 * @author max
 */
public class JavaCCHighlightingLexer extends LayeredLexer {
    public JavaCCHighlightingLexer(LanguageLevel languageLevel) {
        super(new JavaCCLexer(languageLevel));
        registerSelfStoppingLayer(new StringLiteralLexer('\"', JavaTokenType.STRING_LITERAL),
                new IElementType[]{JavaTokenType.STRING_LITERAL}, IElementType.EMPTY_ARRAY);

        registerSelfStoppingLayer(new StringLiteralLexer('\'', JavaTokenType.STRING_LITERAL),
                new IElementType[]{JavaTokenType.CHARACTER_LITERAL}, IElementType.EMPTY_ARRAY);


        LayeredLexer docLexer = new LayeredLexer(new JavaDocLexer(languageLevel.hasEnumKeywordAndAutoboxing()));

        HtmlHighlightingLexer lexer = new HtmlHighlightingLexer();
        lexer.setHasNoEmbeddments(true);
        docLexer.registerLayer(lexer,
                new IElementType[]{JavaDocTokenType.DOC_COMMENT_DATA});

        registerSelfStoppingLayer(docLexer,
                new IElementType[]{JavaTokenType.DOC_COMMENT},
                new IElementType[]{JavaDocTokenType.DOC_COMMENT_END});
    }
}
