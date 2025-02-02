package com.first.game.graphics;

import com.first.game.level.tiles.tile;

// import java.util.Random;

public class screen {
    
    private int width, height;
    public int[] pixels;
    // public final int MAP_SIZE = 8;
    // public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    // public final int TILE_SIZE = 4;
    // public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; 

    // private Random random = new Random();
    // int incTileX = 10, incTileY = 10;
    // int cnt = 0, movX=0, movY=0;
    // int incX=15, incY=15;

    public screen(int width, int height){
        this.height = height;
        this.width = width;
        pixels = new int[width * height];

        // for(int i=0;i< MAP_SIZE * MAP_SIZE; i++){
        //     tiles[i] = random.nextInt(0xffffff);
        // }
    }

    // public void clear(){
    //     for(int i=0;i<pixels.length;i++){
    //         pixels[i]=0x429CB5;
    //     }
    // }
    // setting pixelss

    public void render(int xOffset, int yOffset){

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------
        // int backgroundColor = 0x429CB5; // Background color (Hex)

//         int pacmanColor = 0xf8fc03;     // Pac-Man color (Hex)

//         // Create a 3D array for the pixels (height x width x RGB channels)
//         // Pac-Man parameters

//         int centerX = width / 2;
//         int centerY = height / 2;
//         int radius = Math.min(width, height) / 4; // Radius of Pac-Man
//         double mouthAngle = Math.PI / 4;          // Opening angle for the mouth

//         centerX = radius + movX;
//         centerY = radius + movY;

//         // Populate the array
//         for (int y = 0; y < height; y++) {
//             for (int x = 0; x < width; x++) {
//                 int index = y * width + x; // Map 2D coordinates to 1D index

//                 // Default to background color
//                 pixels[index] = backgroundColor;

//                 // Calculate distance from the center
//                 double distance = Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
//                 if (distance <= radius) {
//                     // Calculate angle relative to the center
//                     if((cnt^1)==0)
//                     {
//                         double angle = Math.atan2(y - centerY, x - centerX);
//                         // Check if the pixels is part of Pac-Man and not in the mouth
//                         if (!(angle > -mouthAngle && angle < mouthAngle)) {
//                             pixels[index] = pacmanColor;
//                         }
//                     }else{
//                         pixels[index] = pacmanColor;
//                     }
//                 }
//             }
//         }

//         cnt^=1;
//         if (centerX + radius > width){
//             incX = -1 * incX;
//         }else if (centerX - radius < 0){
//             incX = -1 * incX; 
//         }
//         if (centerY + radius > height){
//             incY = -1 * incY; 
//         }else if (centerY - radius < 0){
//             incY = -1 * incY; 
//         }
//         movX+=incX;
//         movY+=incY;
// __________________________________________________________________________________________________________
    
        for(int y = 0; y < height ; y++){
            int yy = y + yOffset;
            if(yy < 0 || yy >= height) continue;
            for(int x = 0; x < width ; x++){
                int xx = x + xOffset;
                if(xx < 0 || xx >= width) continue;
                // int tilesIndex = ((xx >> TILE_SIZE) & MAP_SIZE_MASK) + ((yy >> TILE_SIZE) & MAP_SIZE_MASK) * MAP_SIZE;               //  x>>4 == x/16
                // pixels[y * width + x] = tiles[tilesIndex];
                pixels[yy * width + xx] = sprite.character.pixels[(x & 15) + (y % 16) * sprite.character.SIZE];            //// x & 15 == x % 16
                // 16 is the dimension of each tile
            }
        }

    }

    public void renderTile(int xp, int yp, tile tyle){
        for(int y=0; y < tyle.spryte.SIZE; y++){
            int ya = y + yp;
            for(int x=0; x < tyle.spryte.SIZE; x++){
                int xa = x + xp;
                if(xa < 0 || xa >= width || ya < 0 || ya >= height) break;
                pixels[xa + ya * width] = tyle.spryte.pixels[y * tyle.spryte.SIZE + x];
            }
        }
    }

}