package com.first.game.level;

import java.util.Random;

public class randomLvl extends level{

    private final Random random = new Random();
    
    public randomLvl(int width, int height){
        super(width,height);
    }

    protected void generateLevel(){
        for(int y=0; y < height; y++){
            for(int x = 0; x < width; x++){
                tiles[x +y *width] = random.nextInt(4);
            }
        }

        for(int i = 0;i < tiles.length; i++){
            
        }
    }
    
}
