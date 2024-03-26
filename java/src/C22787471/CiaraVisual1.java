package C22787471;

import ie.tudublin.Visual;

public class CiaraVisual1 extends Visual
{
    
    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("java/data/CrazyFrog.mp3");
        //getAp().play();
        //startListening(); 
        
    }


    public void draw()
    {

    }
}
