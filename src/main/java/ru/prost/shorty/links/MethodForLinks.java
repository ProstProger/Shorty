package ru.prost.shorty.links;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MethodForLinks {

    public static String cutLink(String longLink) {
        String hashLink = "http://localhost:8080/links/" + longLink.hashCode();
        return hashLink;
    }

    public static void copyToClipBoard(String stringCopy){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(stringCopy);
        clipboard.setContents(stringSelection,null);
    }
}
