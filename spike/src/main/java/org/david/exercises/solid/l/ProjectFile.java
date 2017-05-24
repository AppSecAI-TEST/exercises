package org.david.exercises.solid.l;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by David Marques on 24/05/2017.
 */
public class ProjectFile {

    private String filePath;
    private File file;
    private byte[] fileData;

    public ProjectFile(String filePath) {
        this.filePath = filePath;
        this.file = new File(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public void loadFileData() {
        try {
            fileData = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFileData() {
        try {
            Files.write(file.toPath(),fileData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
