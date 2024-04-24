package C21374751;

import ie.tudublin.OurVisual;
import processing.core.*;

public class RoxanaVisual1
{
    OurVisual ov;
    PImage frogImage;
    float xPos; // Horizontal position of the frog image
    float yPos; // Vertical position of the frog image
    float hopSpeed; // Horizontal speed of the frog
    float angle; // Angle for rainbow colors

    public RoxanaVisual1(OurVisual ov)
    {
        this.ov = ov;
        frogImage = ov.loadImage("images/frog.png"); // Load the frog image from the "images" folder
        frogImage.resize(100, 0); // Resize the image width to 100 pixels, keep aspect ratio
        xPos = frogImage.width / 2; // Start the frog at the left edge of the screen
        yPos = ov.height - frogImage.height / 2; // Start the frog at the bottom of the screen
        hopSpeed = 5; // Horizontal speed of the frog
        angle = 0; // Initialize angle for rainbow colors
    }

    public void render()
    {
        ov.background(10); // Set background to nearly black
        
        // Draw stationary square in the background
        ov.fill(255); // Set color to white
        ov.rectMode(PApplet.CENTER); // Set rectangle mode to center
        ov.rect(ov.width / 2, ov.height / 2, 50, 50); // Draw a small square at the center of the screen
        
        // Update frog position
        xPos += hopSpeed;
        
        // Check if frog reaches edges of the screen
        if (xPos > ov.width - frogImage.width / 2 || xPos < frogImage.width / 2) {
            // Reverse direction when frog reaches the right or left wall
            hopSpeed = -hopSpeed;
        }
        
        // Draw rainbow aura around the frog
        ov.noFill();
        for (int i = 0; i < 6; i++) {
            ov.stroke((i * 60) % 255, 255, 255); // Rainbow colors
            float auraSize = 50 + 20 * PApplet.sin(angle + i * PApplet.TWO_PI / 6);
            ov.ellipse(xPos, yPos, frogImage.width + auraSize, frogImage.height + auraSize);
        }
        
        // Calculate squish factor based on frog's vertical position relative to the bottom of the screen
        float squishFactor = 1.0f - (yPos / (ov.height - frogImage.height / 2));
        float squishedHeight = frogImage.height * squishFactor;
        
        // Draw frog image
        ov.imageMode(PApplet.CENTER); // Set image mode to center
        ov.image(frogImage, xPos, yPos, frogImage.width, squishedHeight); // Display frog image with squish effect

        // Make the frog jump higher
        float hopAmount = 20 * PApplet.sin((float)(ov.frameCount * 0.1)); // Adjust the hop amount as needed
        yPos = ov.constrain(yPos + hopAmount, 0, ov.height - frogImage.height / 2); // Ensure the frog stays within the screen
        
        angle += 0.05; // Increment angle for rainbow colors
    }
}
