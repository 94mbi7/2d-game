package com.first.game.level;

import com.first.game.graphics.screen;

public class level {
    
    protected int width, height;
    protected int[] tiles;                   // tile index
    
    public level(int width, int height){
        this.height = height;
        this.width = width; 
        tiles = new int[width * height];
        generateLevel();
    }

    public level(String path){
        loadLevel(path);
    }

    protected void generateLevel(){

    }

    private void loadLevel(String path){

    }

    public void update(){                  ///// for bots

    }

    private void time(){
    }

    public void render(int xScroll, int yScroll, screen scr){
        
    }
}
