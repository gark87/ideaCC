package org.gark87.idea.javacc.psi.reference;

import org.gark87.idea.javacc.psi.Declaration;
import org.gark87.idea.javacc.psi.Identifier;

import java.util.EnumSet;

/**
 * @author gark87
 */
public class JavaCCResolveProcessor extends JavaCCScopeProcessor {
    protected final String myName;
    public JavaCCResolveProcessor(String myName, EnumSet<JavaCCScopeProcessor.DeclarationType> myTypes) {
        super(myTypes);
        this.myName = myName;
    }

    protected boolean isValid(Declaration decl) {
        return decl.getIdentifier().getName().equals(myName);
    }

    protected boolean keepLooking(Declaration decl) {
        return !isValid(decl);
    }

    public Identifier getResult() {
        if (candidates.isEmpty())
            return null;
        return candidates.get(0);
    }
}
