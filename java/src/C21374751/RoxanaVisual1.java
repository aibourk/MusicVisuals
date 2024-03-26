package C21374751;

import ie.tudublin.OurVisual;
import processing.core.*;

// This is an example of a visual that renders the waveform
public class RoxanaVisual1
{
    OurVisual ov;

    // public WaveForm(MyVisual mv)
    public RoxanaVisual1(OurVisual ov)
    {
        this.ov = ov;
    }

    public void render()
    {
        // float hue = map(getAmplitude(), 0, 1, 0, 255);
        // fill(hue, 255, 255);
        // rectMode(CENTER);
        // float size = map(getSmoothedAmplitude(), 0, 1, 0, 400);
        // rect(width / 2, height / 2, size, size);

        // ^ original code and then below is slightly edited to work with the OurVisual class

        ov.colorMode(PApplet.HSB);
        float hue = PApplet.map(ov.getAmplitude(), 0, 1, 0, 255);
        ov.fill(hue, 255, 255);
        ov.rectMode(PApplet.CENTER);
        float size = PApplet.map(ov.getSmoothedAmplitude(), 0, 1, 0, 400);
        ov.rect(ov.width / 2, ov.height / 2, size, size);

    }
}