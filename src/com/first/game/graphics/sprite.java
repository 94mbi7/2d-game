package com.first.game.graphics;


///// this accesses individual sprite character from the spritesheet loaded image

public class sprite {

    public final int SIZE;
    private int x, y;
    public int[] pixels;
    private spritesheet sheet;

    public static sprite character = new sprite(16, 419, 6, spritesheet.charsheet);    // this will create sprite

    public sprite(int size, int x, int y, spritesheet sheet){
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.sheet = sheet;
        load();
    }

    private void load(){             // used to select sprite from a set of srite sheets
        for(int j = 0; j < SIZE; j++){
            for(int i = 0; i < SIZE; i++){
                pixels[i + j * SIZE] = sheet.pixels[(i + x) + (j + y) * sheet.SIZE];
            }
        }
    }

}
