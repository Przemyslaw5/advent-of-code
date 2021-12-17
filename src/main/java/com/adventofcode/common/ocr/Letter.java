package com.adventofcode.common.ocr;

public class Letter {

    private final boolean[][] image;

    public Letter(boolean[][] image) {
        this.image = image;
    }

    public boolean[][] getImage() {
        return image;
    }
}
