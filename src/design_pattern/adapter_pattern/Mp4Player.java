package design_pattern.adapter_pattern;

/**
 * description Mp4Player to play mp4 audio, a impl of {@link AdvancedMediaPlayer}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) throws Exception {
        throw new Exception("Unsupported format!");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("mp4 format audio: " + fileName + " is playing...");
    }
}
