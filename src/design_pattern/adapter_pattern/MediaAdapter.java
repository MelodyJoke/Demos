package design_pattern.adapter_pattern;

/**
 * description MediaAdapter an adapter to call suitable implementation of {@link AdvancedMediaPlayer}
 * author Melo Chan
 * date 2016/10/28
 * version 0.0.0.1
 */
@SuppressWarnings("unused, WeakerAccess")
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer player;

    public MediaAdapter(String type) {
        String realType = type.toLowerCase();

        switch (realType) {
            case "mp4":
                player = new Mp4Player();
                break;

            case "vlc":
                player = new VlcPlayer();
                break;

            default:
        }
    }

    @Override
    public void play(String type, String fileName) throws Exception {
        String realType = type.toLowerCase();

        switch (realType) {
            case "mp4":
                player.playMp4(fileName);
                break;

            case "vlc":
                player.playVlc(fileName);
                break;

            default:
                throw new Exception("Unsupported format of audio: " + type + ".");
        }
    }
}
