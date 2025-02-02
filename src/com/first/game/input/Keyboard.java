package com.first.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right;

    public void update(){
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        
        // if(up)
        // System.out.println("up");
        // if(down)
        // System.out.println("down");
        // if(left)
        // System.out.println("left");
        // if(right)
        // System.out.println("right");
    }

    public void keyPressed(KeyEvent arg0){
        keys[arg0.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent arg0){
        keys[arg0.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent arg0){

    }
}
