package scan;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"WeakerAccess", "unchecked"})
public class Scanner {

    private static final int WIDTH_SAMPLE = 1020, HEIGHT_SAMPLE = 1385;

    private static final int RED_GREEN_X_DIFF_SAMPLE = 811, FIRST_RESULT_HOLE_X_OFFSET_SAMPLE = 80, X_RESULT_HOLE_STEP = 120;

    private static final int GREEN_BLUE_Y_DIFF_SAMPLE = 227, RESULT_HOLE_GREEN_Y_DIFF_SAMPLE = 172, FIRST_CHECK_PANEL_Y_SAMPLE = 120;

    private int width, height;

    private BufferedImage image;

    private Point[] primaryColorPoints = new Point[3];

    private int[] xs = new int[7];

    private int[] ys = new int[5];

    public Scanner(BufferedImage image) {
        this.image = image;

        width = image.getWidth();
        height = image.getHeight();

        System.out.println("full width: " + width + ", height: " + height + ".");
    }

    public void getPrimaryColorPoints() {
        List<Point>[] rgbPoints = filterColors(new Rect(0, Math.round((float) (WIDTH_SAMPLE * 1.0 * height / HEIGHT_SAMPLE)), width, height));

        for (int i = 0; i < Math.min(rgbPoints.length, primaryColorPoints.length); i++) {
            primaryColorPoints[i] = getCenter(rgbPoints[i]);
        }

        System.out.println(Arrays.toString(primaryColorPoints));
    }

    public void getXs() {
        int end = primaryColorPoints[0].x;
        int start = primaryColorPoints[1].x;
        int startFixDouble = start + primaryColorPoints[2].x;

        int diff = end - start;

        xs[0] = Math.round((float) ((diff * 1.0 * FIRST_RESULT_HOLE_X_OFFSET_SAMPLE / RED_GREEN_X_DIFF_SAMPLE) + startFixDouble * 1.0 / 2));

        for (int i = 0; i < xs.length - 1; i++) {
            xs[i + 1] = Math.round((float) ((diff * 1.0 * (FIRST_RESULT_HOLE_X_OFFSET_SAMPLE + X_RESULT_HOLE_STEP * (i + 1)) / RED_GREEN_X_DIFF_SAMPLE) + startFixDouble * 1.0 / 2));
        }

        System.out.println(Arrays.toString(xs));
    }

    public void HoleY() {
        int top = primaryColorPoints[2].y;
        int bottom = primaryColorPoints[1].y;
        int bottomFixDouble = bottom + primaryColorPoints[0].y;

        int diff = bottom - top;

        int holeY = Math.round((float) (bottomFixDouble * 1.0 / 2 - diff * RESULT_HOLE_GREEN_Y_DIFF_SAMPLE / GREEN_BLUE_Y_DIFF_SAMPLE));

        System.out.println(holeY);
    }

    public void getYs() {
        double topGap = width * 1.0 * FIRST_CHECK_PANEL_Y_SAMPLE / WIDTH_SAMPLE;

        for (int i = 0; i < ys.length; i++) {
            ys[i] = Math.round((float) (topGap + (width - topGap) * (i + 0.5) / ys.length));
        }

        System.out.println(Arrays.toString(ys));
    }

    public List<Point>[] filterColors(Rect rect) {
        List<Point> reds = new ArrayList<>();
        Rect rectRed = new Rect(Math.round((float) ((rect.right - rect.left) * 0.75)), Math.round((float) ((rect.top + rect.bottom) * 0.5)), rect.right, rect.bottom);

        for (int y = rectRed.top; y < rectRed.bottom; y++) {
            for (int x = rectRed.left; x < rectRed.right; x++) {
                Point point = new Point(x, y);

                RGB rgb = getRGB(image, point);

                if (rgb.isRed()) reds.add(point);
            }
        }

        List<Point> greens = new ArrayList<>();
        Rect rectGreen = new Rect(rect.left, Math.round((float) ((rect.top + rect.bottom) * 0.5)), Math.round((float) ((rect.right - rect.left) * 0.25)), rect.bottom);

        for (int y = rectGreen.top; y < rectGreen.bottom; y++) {
            for (int x = rectGreen.left; x < rectGreen.right; x++) {
                Point point = new Point(x, y);

                RGB rgb = getRGB(image, point);

                if (rgb.isGreen()) greens.add(point);
            }
        }

        List<Point> blues = new ArrayList<>();
        Rect rectBlue = new Rect(rect.left, rect.top, Math.round((float) ((rect.right - rect.left) * 0.25)), Math.round((float) ((rect.bottom + rect.top) * 0.5)));

        for (int y = rectBlue.top; y < rectBlue.bottom; y++) {
            for (int x = rectBlue.left; x < rectBlue.right; x++) {
                Point point = new Point(x, y);

                RGB rgb = getRGB(image, point);

                if (rgb.isBlue()) blues.add(point);
            }
        }

        fixContinuity(reds, rectRed);
        fixContinuity(greens, rectGreen);
        fixContinuity(blues, rectBlue);

        return new List[]{reds, greens, blues};
    }

    public static void main(String... args) throws IOException {
        BufferedImage image = ImageIO.read(new FileInputStream(new File(args[0])));

        Scanner scanner = new Scanner(image);
        scanner.getPrimaryColorPoints();
        scanner.getXs();
        scanner.HoleY();
        scanner.getYs();
    }

    private static Point getCenter(List<Point> points) {
        long totalX = 0, totalY = 0;

        for (Point point : points) {
            totalX += point.x;
            totalY += point.y;
        }

        return new Point(Math.round((float) (totalX * 1.0 / points.size())), Math.round((float) (totalY * 1.0 / points.size())));
    }

    private static double getDeep(int[] color) {
        int r = color[0];
        int g = color[1];
        int b = color[2];
        return r * 0.299 + g * 0.578 + b * 0.114;
    }

    private static boolean isPointInRect(Point point, Rect rect) {
        return point.x >= rect.left && point.x <= rect.right && point.y >= rect.top && point.y <= rect.bottom;
    }

    private static void fixContinuity(List<Point> points, Rect rect) {
        List<Point> toRemove = new ArrayList<>();

        for (Point point : points) {
            if (point.x > rect.left) {
                Point left = new Point(point.x - 1, point.y);
                if (points.contains(left)) continue;
            }

            if (point.x < rect.right - 1) {
                Point right = new Point(point.x + 1, point.y);
                if (points.contains(right)) continue;
            }

            if (point.y > rect.top) {
                Point top = new Point(point.x, point.y - 1);
                if (points.contains(top)) continue;
            }

            if (point.y < rect.bottom - 1) {
                Point bottom = new Point(point.x, point.y + 1);
                if (points.contains(bottom)) continue;
            }

            toRemove.add(point);
        }

        if (!toRemove.isEmpty()) points.removeAll(toRemove);
    }

    private static RGB getRGB(BufferedImage image, Point point) {
        int pixel = image.getRGB(point.x, point.y);
        return new RGB((pixel & 0xff0000) >> 16, (pixel & 0xff00) >> 8, (pixel & 0xff));
    }

    public static class Rect {

        public int left, top, right, bottom;

        public Rect(int left, int top, int right, int bottom) {
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }

        @Override
        public String toString() {
            return "[" + left + ", " + top + "; " + right + ", " + bottom + "]";
        }
    }

    public static class Point {

        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Point && ((Point) obj).x == x && ((Point) obj).y == y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static class RGB {

        public int r, g, b;

        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + r + ", " + g + ", " + b + ")";
        }

        boolean isRed() {
            return r > 120 && g < 60 && b < 70;
        }

        boolean isGreen() {
            return g > 100 && r < 100 && b < 100;
        }

        boolean isBlue() {
            return b > 100 && r < 100 && g < 100;
        }
    }
}
