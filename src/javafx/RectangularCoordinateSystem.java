package javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * description Rectangular coordinate system
 * author Melo Chan
 * date 2016/11/24
 * version 0.0.0.1
 */
public class RectangularCoordinateSystem extends Application {

    private static final double WIDTH = 1000, HEIGHT = 800;

    private static double WIDTH_SHIFT = 200, HEIGHT_SHIFT = 200;

    private static double ORIGIN_X = WIDTH_SHIFT, ORIGIN_Y = HEIGHT_SHIFT;

    private static double QUALITY, DOT_WIDTH;

    private static double ACCURATE = 50;

    private static String COLOR_FG = "#000000";

    @Override
    public void start(Stage primaryStage) throws Exception {
        QUALITY = ACCURATE / 200;
        DOT_WIDTH = ACCURATE / 100;

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT, Color.web("#FFFFFF"));

        Group base = new Group();
        root.getChildren().add(base);

        Line axisX = new Line(0, HEIGHT - ORIGIN_Y, WIDTH, HEIGHT - ORIGIN_Y);
        axisX.setStroke(Color.web(COLOR_FG));
        base.getChildren().add(axisX);

        Line axisY = new Line(ORIGIN_X, 0, ORIGIN_X, HEIGHT);
        axisY.setStroke(Color.web(COLOR_FG));
        base.getChildren().add(axisY);

        Group foreground = new Group();
        root.getChildren().add(foreground);

        foreground.getChildren().add(drawElement(x -> x + 1, "#E57373"));
        foreground.getChildren().add(drawElement(x -> x * x, "#7986CB"));
        foreground.getChildren().add(drawElement(x -> 0.2 * x * x * x + 0.3 * x * x - 1.2 * x + 0.3, "#4DB6AC"));

        primaryStage.setTitle("Rectangular coordinate system");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Group drawElement(Function function, String color) {
        Group element = new Group();

        for (double i = 0; i < WIDTH; i += QUALITY) {
            double x = (i - WIDTH_SHIFT) / ACCURATE;
            double y = function.getY(x);

            Rectangle dot = new Rectangle(x * ACCURATE + WIDTH_SHIFT - 0.5 * DOT_WIDTH, HEIGHT - (y * ACCURATE + HEIGHT_SHIFT) - 0.5 * DOT_WIDTH, DOT_WIDTH, DOT_WIDTH);
            dot.setStroke(Color.web(color));
            element.getChildren().add(dot);
        }

        return element;
    }

    private interface Function {
        double getY(double x);
    }
}
