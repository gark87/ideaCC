package org.gark87.idea.javacc;

import com.intellij.ide.structureView.*;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveState;
import org.gark87.idea.javacc.psi.Identifier;
import org.gark87.idea.javacc.psi.JavaCCFileImpl;
import org.gark87.idea.javacc.psi.reference.JavaCCScopeProcessor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class JavaCCStructureViewBuilderFactory implements PsiStructureViewFactory {
    private static final Icon TERMINAL = IconLoader.getIcon("/icons/terminal.png");
    private static final Icon NONTERMINAL = IconLoader.getIcon("/icons/nonterminal.png");

    @Override
    public StructureViewBuilder getStructureViewBuilder(PsiFile psiFile) {
        if (!(psiFile instanceof JavaCCFileImpl))
            return null;
        final JavaCCFileImpl file = (JavaCCFileImpl) psiFile;
        return new TreeBasedStructureViewBuilder() {

            @NotNull
            @Override
            public StructureViewModel createStructureViewModel() {
                return new StructureViewModelBase(file, new JavaCCFileTreeElement(file));
            }
        };
    }

    private static class JavaCCFileTreeElement extends PsiTreeElementBase<JavaCCFileImpl> {
        private final List<StructureViewTreeElement> children = new ArrayList<StructureViewTreeElement>();

        protected JavaCCFileTreeElement(JavaCCFileImpl file) {
            super(file);
            // first tokens
            JavaCCScopeProcessor tokenProcessor = new JavaCCScopeProcessor(JavaCCScopeProcessor.TOKEN);
            file.processDeclarations(tokenProcessor, ResolveState.initial(), file, file);
            for (Identifier id : tokenProcessor.getCandidates())
                children.add(new JavaCCLeafElement(id, TERMINAL));
            // then nonterminals
            JavaCCScopeProcessor nonTerminalProcessor = new JavaCCScopeProcessor(JavaCCScopeProcessor.NONTERMINAL);
            file.processDeclarations(nonTerminalProcessor, ResolveState.initial(), file, file);
            for (Identifier id : nonTerminalProcessor.getCandidates())
                children.add(new JavaCCLeafElement(id, NONTERMINAL));
        }

        @NotNull
        @Override
        public Collection<StructureViewTreeElement> getChildrenBase() {
            return children;
        }

        @Override
        public String getPresentableText() {
            return getElement().getName();
        }
    }

    private static class JavaCCLeafElement extends PsiTreeElementBase<Identifier> {

        private final Icon icon;

        protected JavaCCLeafElement(Identifier psiElement, Icon icon) {
            super(psiElement);
            this.icon = icon;
        }

        @NotNull
        @Override
        public Collection<StructureViewTreeElement> getChildrenBase() {
            return new ArrayList<StructureViewTreeElement>();
        }

        @Override
        public String getPresentableText() {
            Identifier element = getElement();
            if (element == null)
                return "";
            return element.getName();
        }

        @Override
        public Icon getIcon(boolean open) {
            return icon;
        }
    }
}
