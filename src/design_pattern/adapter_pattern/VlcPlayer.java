package design_pattern.adapter_pattern;

/**
 * description VlcPlayer to play vlc audio, a impl of {@link AdvancedMediaPlayer}
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("vlc format audio: " + fileName + " is playing...");
    }

    @Override
    public void playMp4(String fileName) throws Exception {
        throw new Exception("Unsupported format!");
    }
}
