package org.david.exercises.solid.l;

import java.util.Collection;

/**
 * Created by David Marques on 24/05/2017.
 * This example violates the LSP for many reasons
 * -1- It's clear that the Sub Type ReadOnly File is not actually a sub type of Project files
 * -2- By Throwing an UnsupportedOperationException we are changing the invariant from the parent type
 * -3- Using the instance of to filter the file to not save is clearly breaking the OPP
 * One solution for this project is breaking the type hierarchy between ProjectFile and ReadOnlyFile
 */
public class Project {

    private Collection<ProjectFile> projectFiles;

    public void loadAllFiles() {
        projectFiles.forEach(p -> p.loadFileData());
    }

    public void saveAllFiles() {
        projectFiles.stream().forEach(p -> {
            if (!(p instanceof ReadOnlyFile))
                p.saveFileData();
        });
    }
}
