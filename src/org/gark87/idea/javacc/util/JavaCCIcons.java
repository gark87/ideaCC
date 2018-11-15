package org.gark87.idea.javacc.util;

import javax.swing.Icon;

import com.intellij.openapi.util.IconLoader;


/**
 * Interfaces with the icons of the plugin.
 */
public enum JavaCCIcons {
    /** Terminal icon for the structure view. */
    TERMINAL("terminal.png"),
    /** Non-terminal icon for the structure view. */
    NONTERMINAL("nonterminal.png"),
    /** File type icon. */
    JAVACC_FILE("javacc.png");

    private final Icon icon;


    JavaCCIcons(String fname) {
        icon = IconLoader.getIcon("icons/" + fname);
    }


    /** Returns the AWT icon. */
    public Icon getIcon() {
        return icon;
    }
}
