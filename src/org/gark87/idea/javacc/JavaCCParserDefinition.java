package org.gark87.idea.javacc;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.gark87.idea.javacc.generated.JavaCC;
import org.gark87.idea.javacc.generated.JavaCCElementTypes;
import org.gark87.idea.javacc.generated.JavaCCLexer;
import org.gark87.idea.javacc.generated.JavaCCTreeConstants;
import org.gark87.idea.javacc.psi.*;
import org.jetbrains.annotations.NotNull;


/**
 * @author gark87
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
        final IElementType type = node.getElementType();
        if (type == JavaCCTreeConstants.JJTBNF_PRODUCTION)
            return new BNFProduction(node);
        if (type == JavaCCTreeConstants.JJTJAVACODE_PRODUCTION)
            return new JavacodeProduction(node);
        if (type == JavaCCTreeConstants.JJTFORMALPARAMETER)
            return new FormalParameter(node);
        if (type == JavaCCTreeConstants.JJTFORMALPARAMETERS)
            return new FormalParameters(node);
        if (type == JavaCCTreeConstants.JJTVARIABLEDECLARATORID)
            return new VariableDeclaratorId(node);
        if (type == JavaCCTreeConstants.JJTPRODUCTION)
            return new Production(node);
        if (type == JavaCCTreeConstants.JJTBLOCK)
            return new Block(node);
        if (type == JavaCCTreeConstants.JJTLOCALVARIABLEDECLARATION || type == JavaCCTreeConstants.JJTFIELDDECLARATION)
            return new VariableDeclaration(node);
        if (type == JavaCCTreeConstants.JJTVARIABLEDECLARATOR)
            return new VariableDeclarator(node);
        if (type == JavaCCTreeConstants.JJTJAVACC_INPUT)
            return new JavaCCInput(node);
        if (type == JavaCCTreeConstants.JJTREGULAR_EXPR_PRODUCTION)
            return new RegExpProduction(node);
        if (type == JavaCCTreeConstants.JJTREGEXPR_SPEC)
            return new RegExpSpec(node);
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
}
