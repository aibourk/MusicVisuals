package C22308773;

import ie.tudublin.OurVisual;
import processing.core.*;
import ddf.minim.*;

public class AmyVisual1
{
    OurVisual ov;
    float cy = 0;
    float cx = 0;
    float hue = 0f;


    Square[] squares;
    int numSquares = 12;


    public AmyVisual1(OurVisual ov)
    {
        this.ov = ov;
        cy = this.ov.height / 2;
        cx = this.ov.width / 2;
        squares = new Square[numSquares];
        for (int i = 0; i < numSquares; i++) {
            squares[i] = new Square(); 
            squares[i].rotation = i * 24;
            squares[i].size = i * 25;
        }

    }

    public void render()
    {
        ov.colorMode(PApplet.HSB);
        // hue = PApplet.map(ov.getSmoothedAmplitude(), 0, 256, 0, 256);

        if(ov.isPlaying == true)
        {
            
            for (Square square : squares) {

                square.display(); 
                
                square.update();
            }
        }
        
    }

    class Square
    {
        float side = 100;
        float rotation = 0;
        float halfH = ov.height / 2;
        int size = 0;    
        
        public void display()
        {
            ov.stroke(hue, 255, 255);
            ov.noFill();

            ov.pushMatrix();
            ov.translate(cx, cy);
            ov.rotate(rotation);
            ov.rectMode(ov.CENTER);
            ov.rect(0, 0, side, side);
            ov.popMatrix();
        }


        public void update()
        {
            rotation += 0.01f;
            side = (ov.getSmoothedAmplitude() * halfH * 3) + size;
            hue = ov.map(ov.getSmoothedAmplitude(), 0, 1, 0, 256);

        }
       

    }
}
    
