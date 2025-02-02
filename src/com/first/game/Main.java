package com.first.game;

import java.awt.Canvas;
// import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
// import java.awt.image.DataBufferShort;

import javax.swing.JFrame;

import com.first.game.graphics.screen;
import com.first.game.input.Keyboard;

import java.awt.Graphics;

public class Main extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static int inc = 0;
    public static String name = "Game with no name";

    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private boolean running = false;
    private screen scr;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
// raster is a data structure that represent a rectangular array of pixels

    public Main(){
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);                              // method in canvas

        scr = new screen(width, height);
        frame = new JFrame();
        key = new Keyboard();

        addKeyListener(key);
    }

    public synchronized void start(){
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop(){
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


    // GAME LOOP
    public void run(){                // for runnable interface run method is the entry point in case of thread

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        requestFocus();
        while (running) {
            // update();                  // logic of the game
            // render();                  // renders the state
            long now = System.nanoTime();
            delta += (now -lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            // try{
            //     thread.sleep(700);
            // }catch(InterruptedException e){
            //     e.printStackTrace();
            // }
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                // System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(name + " | " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }

        stop();
    }

    int x = 0, y = 0;
    public void update(){
        key.update();
        
        if(key.up)y--;
        if(key.down)y++; 
        if(key.left)x--;
        if(key.right)x++; 
    }
    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);           // for multiple buffering 
            // if 2 then in one buffer calculation is done and then printed
            // 3 acts as a middlemen
            // going up doesnt give much advantage so 3 is optimal
            return;
        }

        // scr.clear();
        scr.render(x, y);

        for(int i = 0; i < pixels.length; i++){
            pixels[i] = scr.pixels[i];
        }


        Graphics g = bs.getDrawGraphics();        // links buffer strategy and graphic that is drawn
        // define graphics in between
        // g.setColor(new Color(66, 156, 181));
        // g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        // once a image time is over, swaping the buffer data
        bs.show();     // display the next available buffer

    }


    public static void main(String[] args){
        Main game = new Main();
        game.frame.setResizable(false);
        game.frame.setTitle(name);
        game.frame.add(game);
        game.frame.pack();                     // to size the frame as given
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // closes the process on clicking exit button
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);


        game.start();
    }

}


//  BUFFER STRATEGY