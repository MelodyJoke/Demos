package javafx;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.random;

/**
 * description Javafx UI test
 * author Melo Chan
 * date 2016/10/24
 * version 0.0.0.1
 */
public class BubblesDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 960, 540, Color.BLACK);

        // background
        Rectangle background = new Rectangle(scene.getWidth(), scene.getHeight(),
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#f8bd55")),
                        new Stop(0.14, Color.web("#c0fe56")),
                        new Stop(0.28, Color.web("#5dfbc1")),
                        new Stop(0.43, Color.web("#64c2f8")),
                        new Stop(0.57, Color.web("#be4af7")),
                        new Stop(0.71, Color.web("#ed5fc2")),
                        new Stop(0.85, Color.web("#ef504c")),
                        new Stop(1, Color.web("#f2660f"))));

        // bubbles
        Group bubbles = new Group();
        for (int i = 0; i < 30; i++) {
            Circle bubble = new Circle(150, Color.web("white", 0.05));

            // stroke
            bubble.setStrokeType(StrokeType.OUTSIDE);
            bubble.setStroke(Color.web("white", 0.16));
            bubble.setStrokeWidth(4);

            // blur
            bubble.setEffect(new BoxBlur(10, 10, 3));

            bubbles.getChildren().add(bubble);
        }

        Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK), bubbles), background);
        background.setBlendMode(BlendMode.OVERLAY);

        root.getChildren().add(blendModeGroup);

        Timeline timeline = new Timeline();
        for (Node bubble :
                bubbles.getChildren())
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(bubble.translateXProperty(), random() * 960),
                            new KeyValue(bubble.translateYProperty(), random() * 540)),
                    new KeyFrame(new Duration(40000),
                            new KeyValue(bubble.translateXProperty(), random() * 960),
                            new KeyValue(bubble.translateYProperty(), random() * 540)));
        timeline.play();

        // config primary stage
        primaryStage.setTitle("Hello Venus!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
