package C22790201;

import ie.tudublin.OurVisual;
import processing.core.*;

// This is an example of a visual that renders the waveform
public class AleenaVisual1
{
    OurVisual ov;

    // public WaveForm(MyVisual mv)
    public AleenaVisual1(OurVisual ov)
    {
        this.ov = ov;
    }

    public void render()
    {
        ov.colorMode(PApplet.HSB);
        
    }
}