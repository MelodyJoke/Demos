package design_pattern.adapter_pattern;

/**
 * description AudioPlayer a implementation of {@link MediaPlayer}
 * author Melo Chan
 * date 2016/10/28
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public class AudioPlayer implements MediaPlayer {

    @Override
    public void play(String type, String fileName) throws Exception {
        String realType = type.toLowerCase();

        switch (realType) {
            case "mp3":
                playLocal(fileName);
                break;

            case "mp4":
            case "vlc":
                playSupport(type, fileName);
                break;

            default:
                throw new Exception("Unsupported format: " + type + " of audio!");
        }
    }

    private void playLocal(String fileName) {
        System.out.println("mp3 format audio: " + fileName + " is playing...");
    }

    private void playSupport(String type, String fileName) throws Exception {
        new MediaAdapter(type).play(type, fileName);
    }
}
