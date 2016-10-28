package design_pattern.adapter_pattern;

/**
 * description Test for adapter pattern
 * author Melo Chan
 * date 2016/10/28
 * version 0.0.0.1
 */
public class Test {

    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();

        try {
            player.play("MP3", "HelloVenus.mp3");
            player.play("mp4", "HelloVenus.MP4");
            player.play("Vlc", "HelloVenus.vlc");
            player.play("ogg", "HelloVenus.ogg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
