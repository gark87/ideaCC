package org.gark87.idea.javacc;

import com.intellij.ide.structureView.*;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.ResolveState;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.util.PsiTreeUtil;
import org.gark87.idea.javacc.psi.DeclarationForStructureView;
import org.gark87.idea.javacc.psi.Identifier;
import org.gark87.idea.javacc.psi.JavaCCFileImpl;
import org.gark87.idea.javacc.psi.reference.JavaCCScopeProcessor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author gark87
 */
public class JavaCCStructureViewBuilderFactory implements PsiStructureViewFactory {
    @Override
    public StructureViewBuilder getStructureViewBuilder(PsiFile psiFile) {
        if (!(psiFile instanceof JavaCCFileImpl))
            return null;
        final JavaCCFileImpl file = (JavaCCFileImpl) psiFile;
        return new TreeBasedStructureViewBuilder() {

            @Override
            public boolean isRootNodeShown() {
                return false;
            }

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
            final List<DeclarationForStructureView> result = new ArrayList<DeclarationForStructureView>();
            file.processDeclarations(new PsiScopeProcessor() {
                        @Override
                        public boolean execute(PsiElement psiElement, ResolveState resolveState) {
                            if (psiElement instanceof DeclarationForStructureView) {
                                DeclarationForStructureView forStructureView = (DeclarationForStructureView) psiElement;
                                if (forStructureView.getIdentifier() != null)
                                    result.add(forStructureView);
                            }
                            return false;
                        }

                        @Override
                        public <T> T getHint(Key<T> tKey) {
                            return null;
                        }

                        @Override
                        public void handleEvent(Event event, Object o) {
                            System.err.println(""+event);
                        }
                    }, ResolveState.initial(), file, file);
            for (DeclarationForStructureView id : result)
                children.add(new JavaCCLeafElement(id));
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

        protected JavaCCLeafElement(DeclarationForStructureView declaration) {
            super(declaration.getIdentifier());
            icon = declaration.getIcon();
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
