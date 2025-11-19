package SeleniumTesting.audioValidation;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AudioValidationTest {

    @Test(dataProvider = "dp_NoSound")
    public void hasSound(String file){

        final double threshold = 0.02;

        final Boolean[] soundDetected = {false};

        AudioDispatcher dispatcher = AudioDispatcherFactory.fromPipe(file, 44100, 1024, 0);

        dispatcher.addAudioProcessor(new AudioProcessor() {

            @Override
            public boolean process(AudioEvent event) {

                float[] buffer = event.getFloatBuffer();

                for (float sample : buffer) {

                    if (Math.abs(sample) > threshold) {
                        soundDetected[0] = true;
                        return false;
                    }
                }
                return true;
            }
            @Override public void processingFinished() {}
        });

        dispatcher.run();

        Assert.assertEquals(soundDetected[0],false);
    }

    @DataProvider(name = "dp_NoSound")
    public Object[] silenceAudioData(){
        Object[] data = {
                "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                        "Automation-testing\\src\\test\\java\\SeleniumTesting\\audioValidation\\audios\\1-second-of-silence.mp3",

                "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                        "Automation-testing\\src\\test\\java\\SeleniumTesting\\audioValidation\\audios\\2-seconds-silence.mp3",

                "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\src\\" +
                        "test\\java\\SeleniumTesting\\audioValidation\\audios\\5-seconds-of-silence.mp3",

                "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\" +
                        "src\\test\\java\\SeleniumTesting\\audioValidation\\audios\\10-seconds-of-silence.mp3"
        };

        return data;
    }

    @DataProvider(name = "dp_Sound")
    public Object[] soundAudioData(){
      Object[] data = {"C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\src\\" +
              "test\\java\\SeleniumTesting\\audioValidation\\audios\\Recording_2.m4a",

              "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing\\src\\test\\" +
                      "java\\SeleniumTesting\\audioValidation\\audios\\Recording_3 1.m4a"
      };
      return data;
    }

}
