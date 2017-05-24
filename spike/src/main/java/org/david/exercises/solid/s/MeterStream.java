package org.david.exercises.solid.s;

/**
 * Created by David Marques on 23/05/2017.
 * Hardware device Abstraction
 */
public class MeterStream {

    public static final byte DEFAULT_DATA = 0x10;
    private String name;
    private byte data;

    public MeterStream(String name) {
        this.name = name;
        data = DEFAULT_DATA;
    }

    public byte readByte() {
        return data;
    }

    public void setMockData(byte data) {
        this.data = data;
    }
}
