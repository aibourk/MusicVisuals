package ie.tudublin;

import C22308773.AmyVisual1;
import C21374751.RoxanaVisual1;
import C22787471.CiaraVisual1;
import C22790201.AleenaVisual1;
import example.AudioBandsVisual;
import example.WaveForm;
import ie.tudublin.*;
import ddf.minim.*;


public class OurVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;
    AmyVisual1 ai1;
    AleenaVisual1 am1;
    CiaraVisual1 ct1;
    RoxanaVisual1 rr1;

    public boolean isPlaying = false;


    public void settings() {
        // size(1024, 500);

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN);
    }

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("java/data/CrazyFrog.mp3");

        // Call this instead to read audio from the microphone
        // startListening();

        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        ai1 = new AmyVisual1(this);
        am1 = new AleenaVisual1(this);
        ct1 = new CiaraVisual1(this);
        rr1 = new RoxanaVisual1(this);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            isPlaying = true;

        }
    }


    public void draw() {
        background(0);

        if(getAudioPlayer().position() <= 27000)
        {
            ai1.render();
        }
        else if(getAudioPlayer().position() >= 27001 && getAudioPlayer().position() <= 42000)
        {
            am1.render();
        }
        else if(getAudioPlayer().position() >= 42001 && getAudioPlayer().position() <= 70000)
        {
            rr1.render();
        }
        else if(getAudioPlayer().position() >= 70001  && getAudioPlayer().position() < 84000)
        {
            am1.render();
        }
        else if(getAudioPlayer().position() >= 84001 && getAudioPlayer().position() < 110000)
        {
            ct1.render();
        }


        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        // wf.render();
        // abv.render();
        
    }
}
