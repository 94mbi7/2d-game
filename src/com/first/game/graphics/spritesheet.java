package com.first.game.graphics;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


////// sprite sheet is an image that stores images of smae size this code loads that sprite sheet
/// from this sheet we choose which character to import instead of storing one file for each charqacter
/// we can choose from the sheet as choosing an element from an array

public class spritesheet {
    private String path;
    public final int SIZE;
    public int[] pixels;

    // Remove the leading slash from the resource path
    public static spritesheet charsheet = new spritesheet("res/texture/sprite.png", 420);

    public spritesheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            // Print debugging information
            System.out.println("Working directory: " + System.getProperty("user.dir"));
            System.out.println("Trying to load resource: " + path);
            
            // Try multiple loading approaches
            BufferedImage image = null;
            
            // Try loading as file first
            File file = new File(path);
            if (file.exists()) {
                System.out.println("Loading from file: " + file.getAbsolutePath());
                image = ImageIO.read(file);
            }
            
            // If file loading fails, try resource loading
            if (image == null) {
                // Try with and without leading slash
                URL resourceUrl = spritesheet.class.getResource("/" + path);
                if (resourceUrl == null) {
                    resourceUrl = spritesheet.class.getResource(path);
                }
                
                if (resourceUrl != null) {
                    System.out.println("Loading from resource: " + resourceUrl);
                    image = ImageIO.read(resourceUrl);
                }
            }
            
            if (image == null) {
                throw new RuntimeException("Failed to load spritesheet at: " + path);
            }

            int w = image.getWidth();
            int h = image.getHeight();
            System.out.println("Successfully loaded image: " + w + "x" + h);

            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading spritesheet: " + e.getMessage());
        }
    }
}