package C21374751;

import ie.tudublin.OurVisual;
import processing.core.*;

public class RoxanaVisual1
{
    OurVisual ov;
    PImage frogImage; // Load an image of a frog

    float jumpHeight = 0; // Variable to control the height of the frog's jump

    public RoxanaVisual1(OurVisual ov)
    {
        this.ov = ov;
        frogImage = ov.loadImage("frog.png"); // Load the image of the frog
    }

    public void render()
    {
        ov.background(0); // Set background to black

        // Calculate the y-position of the frog based on the amplitude of the sound
        float yPos = ov.map(ov.getAmplitude(), 0, 1, ov.height, 0);
        yPos += jumpHeight; // Add jump height to y-position

        // Draw the frog image at the center of the screen
        ov.imageMode(PApplet.CENTER);
        ov.image(frogImage, ov.width / 2, yPos);

        // Update jump height based on the amplitude of the sound
        jumpHeight = ov.map(ov.getSmoothedAmplitude(), 0, 1, -100, 100);
    }
}
