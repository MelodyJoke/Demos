package design_pattern.adapter_pattern;

/**
 * description AdvancedMediaPlayer interface to play more types
 * author Melo Chan
 * date 2016/10/26
 * version 0.0.0.1
 */
@SuppressWarnings("unused")
public interface AdvancedMediaPlayer {

    void playVlc(String fileName) throws Exception;

    void playMp4(String fileName) throws Exception;
}
