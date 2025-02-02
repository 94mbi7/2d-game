package com.first.game.level.tiles;

import com.first.game.graphics.screen;
import com.first.game.graphics.sprite;

public class grassTile extends tile{

    public grassTile(sprite spr){
        super(spr);
    }

    public void render(int x, int y, screen scr){
        scr.renderTile(x, y, this);
    }
    
}
