package ie.tudublin;

import C22308773.AmyVisual1;
import C21374751.RoxanaVisual1;
import C22787471.CiaraVisual1;
import C22790201.AleenaVisual1;
import example.AudioBandsVisual;
import example.WaveForm;
import ie.tudublin.*;


public class OurVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;

    public void settings() {
        size(1024, 500);

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    public void setup() {
        startMinim();

        // Call loadAudio to load an audio file to process
        loadAudio("java/data/CrazyFrog.mp3");

        // Call this instead to read audio from the microphone
        // startListening();

        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }


    public void draw() {
        background(0);

        if(getAudioPlayer().position() <= 27000)
        {
            wf.render();
        }
        else if(getAudioPlayer().position() >= 27001 && getAudioPlayer().position() <= 42000)
        {
            abv.render();
        }
        else if(getAudioPlayer().position() >= 42001 && getAudioPlayer().position() <= 70000)
        {
            wf.render();
        }
        else if(getAudioPlayer().position() >= 70001  && getAudioPlayer().position() < 84000)
        {
            abv.render();
        }
        else if(getAudioPlayer().position() >= 84001 && getAudioPlayer().position() < 110000)
        {
            wf.render();
        }


        // getAudioPlayer().cue(0);
        // getAudioPlayer().play(27000);
        // getAudioPlayer().pause();
        


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
