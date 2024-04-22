package C22787471;

import ie.tudublin.OurVisual;
import processing.core.*;

import java.util.ArrayList;

import ddf.minim.*;

// This is an example of a visual that renders the waveform
public class CiaraVisual1 extends PApplet
{
    OurVisual ov;
    ArrayList<Firework> fireworks = new ArrayList<>();
    float[] smoothedBuffer; // Smoothed audio buffer
    float smoothingFactor = 0.2f;

    float cy = 0;

    // public WaveForm(MyVisual mv)
    public CiaraVisual1(OurVisual ov)
    {
        this.ov = ov;
        cy = this.ov.height;
        
    }

    public void render()
    {
        ov.colorMode(PApplet.HSB);
        for(int i = 0 ; i < ov.getAudioBuffer().size() ; i ++)
        {
            ov.stroke(
                PApplet.map(i, 0, ov.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );
            
            drawFireworks();

        }
    }

    void drawFireworks() {
        ov.beginShape();
        ov.background(0);

        AudioBuffer audioBuffer = ov.getAudioBuffer();

        if (smoothedBuffer == null || smoothedBuffer.length != audioBuffer.size()) {
            // Add a firework at a random position
            fireworks.add(new Firework(random(width), random(height)));
        }

        // Update and display each firework
        for (int i = fireworks.size() - 1; i >= 0; i--) {
            Firework firework = fireworks.get(i);
            firework.update();
            firework.display();
            // Remove fireworks that have finished exploding
            if (firework.done()) {
                fireworks.remove(i);
            }
        }

        ov.endShape();
    }

    class Firework {
        PVector pos; // Position of the firework
        ArrayList<Particle> particles; // Particles in the firework explosion
        int explosionColor; // Color of the explosion
        boolean exploded; // Flag to indicate if the firework has exploded

        Firework(float x, float y) {
            pos = new PVector(x, y);
            particles = new ArrayList<>();
            exploded = false;
            explosionColor = color(random(255), random(255), random(255)); // Random explosion color
        }

        void update() {
            if (!exploded) {
                // Simulate the firework rising up
                pos.x = 500;
                pos.y = 50;
                // If the firework reaches its peak, explode
                if (pos.y <= height * 5) {
                    explode();
                }
            } else {
                // Update and display each particle in the explosion
                for (int i = particles.size() - 1; i >= 0; i--) {
                    Particle p = particles.get(i);
                    p.update();
                    p.display();
                    // Remove particles that have faded out
                    if (p.done()) {
                        particles.remove(i);
                    }
                }
            }
        }

        void explode() {
            exploded = true;
            // Create explosion particles
            for (int i = 0; i < 100; i++) {
                float angle = random(TWO_PI);
                float speed = random(2, 5);
                float vx = cos(angle) * speed;
                float vy = sin(angle) * speed;
                Particle p = new Particle(pos.x, pos.y, vx, vy, explosionColor);
                particles.add(p);
            }
        }

        void display() {
            if (!exploded) {
                // Draw the firework as a point
                ov.stroke(255);
                ov.point(pos.x, pos.y);
            }
        }

        boolean done() {
            return exploded && particles.isEmpty();
        }
    }

    class Particle {
        PVector pos; // Position of the particle
        PVector vel; // Velocity of the particle
        int color; // Color of the particle
        float lifespan; // Lifespan of the particle

        Particle(float x, float y, float vx, float vy, int color) {
            pos = new PVector(x, y);
            vel = new PVector(vx, vy);
            this.color = color;
            lifespan = 255; // Initial lifespan
        }

        void update() {
            // Move the particle
            pos.add(vel);
            // Decrease the lifespan
            lifespan -= 5;
        }

        void display() {
            // Draw the particle
            ov.stroke(color, lifespan);
            ov.point(pos.x, pos.y);
        }

        boolean done() {
            // Check if the particle has faded out
            return lifespan <= 0;
        }
    }

    


}



