package com.stayingorganized.api.folder.model.exception;

public class CircularFolderReferenceException extends IllegalStateException {
    public CircularFolderReferenceException() {
        super("This folder path forms a circular reference");
    }

    public CircularFolderReferenceException(String s) {
        super(s);
    }
}
