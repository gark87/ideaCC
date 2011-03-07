package org.gark87.idea.javacc;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.gark87.idea.javacc.generated.JavaCC;
import org.gark87.idea.javacc.generated.JavaCCElementTypes;
import org.gark87.idea.javacc.generated.JavaCCLexer;
import org.jetbrains.annotations.NotNull;


/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCParserDefinition implements ParserDefinition {
    private static final TokenSet WHITESPACES = TokenSet.create(JavaCC.SKIP);
    private static final TokenSet COMMENTS = TokenSet.create(JavaCC.MULTI_LINE_COMMENT, JavaCC.SINGLE_LINE_COMMENT, JavaCC.FORMAL_COMMENT);
    private static final TokenSet STRINGS = TokenSet.create(JavaCC.STRING_LITERAL);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new JavaCCLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new JavaCCParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return JavaCCElementTypes.FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITESPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return new ASTWrapperPsiElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new JavaCCFileImpl(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode astNode, ASTNode astNode1) {
        return SpaceRequirements.MAY;
    }

    private class JavaCCFileImpl extends PsiFileBase {
        public JavaCCFileImpl(FileViewProvider provider) {
            super(provider, JavaCCElementTypes.LANG);
        }

        @NotNull
        @Override
        public FileType getFileType() {
            return JavaCCSupportLoader.JAVA_CC;
        }
    }
}
