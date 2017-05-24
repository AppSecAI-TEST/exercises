package org.david.exercises.solid.l;

/**
 * Created by David Marques on 24/05/2017.
 */
public class ReadOnlyFile extends ProjectFile {

    public ReadOnlyFile(String filePath) {
        super(filePath);
    }

    @Override
    public void saveFileData() {
        throw new UnsupportedOperationException("not supported");
    }
}
