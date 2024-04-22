package C22787471;

import ie.tudublin.OurVisual;
import processing.core.*;
import ddf.minim.*;

// This is an example of a visual that renders the waveform
public class CiaraVisual1
{
    OurVisual ov;
    AudioPlayer player;
    Firework[] fireworks;
    int numFireworks = 100;

    // public WaveForm(MyVisual mv)
    public CiaraVisual1(OurVisual ov)
    {
        this.ov = ov;
        
    }

    public void render()
    {
        ov.colorMode(PApplet.HSB);
        ov.background(0);

        AudioBuffer audioBuffer = ov.getAudioBuffer();

        fireworks = new Firework[numFireworks];

        for (int i = 0; i < numFireworks; i++) {
            fireworks[i] = new Firework();
        }

        
    }

}
