package com.first.game.level.tiles;

import com.first.game.graphics.screen;
import com.first.game.graphics.sprite;

public class tile {

    public int x, y;
    public sprite spryte;

    public static tile grass = new grassTile(sprite.character);

    public tile(sprite spryte){
        this.spryte = spryte;
    }

    public void render(int x, int y, screen scr){
        
    }

    public boolean solid(){
        return false;
    }
    
}
