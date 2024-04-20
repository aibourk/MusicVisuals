package C22308773;

import ie.tudublin.OurVisual;
import processing.core.*;

// This is an example of a visual that renders the waveform
public class AmyVisual1
{
    OurVisual ov;

    // public WaveForm(MyVisual mv)
    public AmyVisual1(OurVisual ov)
    {
        this.ov = ov;
    }

    public void render()
    {
        ov.colorMode(PApplet.HSB);
        ov.line(0, 0, 100, 100);
    }
}