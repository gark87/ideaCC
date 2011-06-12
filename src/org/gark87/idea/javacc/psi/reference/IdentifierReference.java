package org.gark87.idea.javacc.psi.reference;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import org.gark87.idea.javacc.psi.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
* @author gark87 <arkady.galyash@gmail.com>
*/
public abstract class IdentifierReference extends PsiReferenceBase<Identifier> {
    public IdentifierReference(@org.jetbrains.annotations.NotNull Identifier element) {
        super(element);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        VariantsProcessor processor = new VariantsProcessor();
        process(processor);
        return processor.getResult().toArray();
    }

    @Override
    public PsiElement resolve() {
        String needle = getCanonicalText();
        ResolveProcessor processor = new ResolveProcessor(needle);
        process(processor);
        return processor.getResult();
    }

    protected abstract void process(Processor processor);


    public static interface Processor {
        boolean process(Identifier i);
    }

    public static class ResolveProcessor implements Processor {
        private final String needle;
        private Identifier result;

        public ResolveProcessor(@NotNull String needle){
            this.needle = needle;
        }

        @Override
        public boolean process(Identifier identifier) {
            if (needle.equals(identifier.getName())) {
                result = identifier;
                return true;
            }
            return false;
        }

        public Identifier getResult() {
            return result;
        }
    }

     public static class VariantsProcessor implements Processor {
        private final List<Identifier> result = new ArrayList<Identifier>();

        @Override
        public boolean process(Identifier identifier) {
            result.add(identifier);
            return false;
        }

        public List<Identifier> getResult() {
            return result;
        }
    }
}
