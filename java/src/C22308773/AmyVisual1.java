package C22308773;

import ie.tudublin.Visual;

public class AmyVisual1 extends Visual
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
            getAudioPlayer().cue(20000);
            getAudioPlayer().play();
            
        }
        if (key == '1')
        {
            twocubes = ! twocubes;

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

    boolean twocubes = false;

    float smoothedBoxSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);
               
        float boxSize = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);        
        if (twocubes)
        {
            pushMatrix();
            translate(-100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            box(smoothedBoxSize);
            //strokeWeight(1);
            //sphere(smoothedBoxSize);
            popMatrix();
            pushMatrix();
            translate(100, 0, 0);
            rotateY(angle);
            rotateX(angle);
            strokeWeight(5); 
            box(smoothedBoxSize);
            popMatrix();
        }
        else
        {
            rotateY(angle);
            rotateX(angle);
            //strokeWeight(1);
            //sphere(smoothedBoxSize/ 2);            
            strokeWeight(5);
            
            box(smoothedBoxSize);
        }
        angle += 0.01f;
    }
    float angle = 0;
}

