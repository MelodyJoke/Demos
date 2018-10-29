package scan;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestCore {
    static int firstX = 453;

    static int firstY = 565;

    static CheckModel h2o2Model;

    static CheckModel leModel;

    static CheckModel snaModel;

    static CheckModel pipModel;

    static CheckModel nagModel;

    static CheckModel oaModel;

    static CheckModel phModel;

    static {
        h2o2Model = new CheckModel();
        h2o2Model.setL1x(453);
        h2o2Model.setL1y(105);
        h2o2Model.setL2x(452);
        h2o2Model.setL2y(193);
        h2o2Model.setL3x(453);
        h2o2Model.setL3y(281);
        h2o2Model.setL4x(452);
        h2o2Model.setL4y(369);
        h2o2Model.setL5x(452);
        h2o2Model.setL5y(461);
        h2o2Model.setL6x(453);
        h2o2Model.setL6y(565);

        leModel = new CheckModel();
        leModel.setL1x(392);
        leModel.setL1y(105);
        leModel.setL2x(394);
        leModel.setL2y(193);
        leModel.setL3x(399);
        leModel.setL3y(281);
        leModel.setL4x(391);
        leModel.setL4y(365);
        leModel.setL5x(398);
        leModel.setL5y(459);
        leModel.setL6x(397);
        leModel.setL6y(570);

        snaModel = new CheckModel();
        snaModel.setL1x(336);
        snaModel.setL1y(112);
        snaModel.setL2x(337);
        snaModel.setL2y(196);
        snaModel.setL3x(337);
        snaModel.setL3y(278);
        snaModel.setL4x(338);
        snaModel.setL4y(372);
        snaModel.setL5x(337);
        snaModel.setL5y(453);
        snaModel.setL6x(335);
        snaModel.setL6y(570);

        pipModel = new CheckModel();
        pipModel.setL1x(270);
        pipModel.setL1y(105);
        pipModel.setL2x(273);
        pipModel.setL2y(198);
        pipModel.setL3x(271);
        pipModel.setL3y(282);
        pipModel.setL4x(271);
        pipModel.setL4y(371);
        pipModel.setL5x(276);
        pipModel.setL5y(463);
        pipModel.setL6x(271);
        pipModel.setL6y(574);

        nagModel = new CheckModel();
        nagModel.setL1x(210);
        nagModel.setL1y(107);
        nagModel.setL2x(212);
        nagModel.setL2y(198);
        nagModel.setL3x(212);
        nagModel.setL3y(287);
        nagModel.setL4x(212);
        nagModel.setL4y(375);
        nagModel.setL5x(215);
        nagModel.setL5y(460);
        nagModel.setL6x(217);
        nagModel.setL6y(574);

        oaModel = new CheckModel();
        oaModel.setL1x(154);
        oaModel.setL1y(112);
        oaModel.setL2x(152);
        oaModel.setL2y(194);
        oaModel.setL3x(151);
        oaModel.setL3y(280);
        oaModel.setL4x(155);
        oaModel.setL4y(369);
        oaModel.setL5x(157);
        oaModel.setL5y(453);
        oaModel.setL6x(155);
        oaModel.setL6y(570);

        phModel = new CheckModel();
        phModel.setL1x(90);
        phModel.setL1y(110);
        phModel.setL2x(90);
        phModel.setL2y(195);
        phModel.setL3x(90);
        phModel.setL3y(283);
        phModel.setL4x(90);
        phModel.setL4y(368);
        phModel.setL5x(93);
        phModel.setL5y(457);
        phModel.setL6x(97);
        phModel.setL6y(575);
    }

    public static void main(String[] args) {
        File file = new File("/Users/oujinlong/Desktop/123.png");

        checkImage(file);
    }

    public static HashMap<String, String> checkImage(File file) {
        BufferedImage srcImage = null;
        try {
            FileInputStream in = new FileInputStream(file);
            srcImage = javax.imageio.ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("读取图片文件出错！" + e.getMessage());
        }
        float width = srcImage.getWidth();
        float height = srcImage.getHeight();
        System.out.println("width:" + width + " height:" + height);

        int H2O2Index = checkH2O2(srcImage);
        System.out.println("H2O2Index:" + H2O2Index);

        int LEIndex = checkLE(srcImage);
        System.out.println("LEIndex:" + LEIndex);

        int SNAIndex = checkSNA(srcImage);
        System.out.println("SNAIndex:" + SNAIndex);

        int PIPIndex = checkPIP(srcImage);
        System.out.println("PIPIndex:" + PIPIndex);

        int NAGIndex = checkNAG(srcImage);
        System.out.println("NAGIndex:" + NAGIndex);

        int OAIndex = checkOA(srcImage);
        System.out.println("OAIndex:" + OAIndex);

        int PHIndex = checkPH(srcImage);
        System.out.println("PHIndex:" + PHIndex);

        HashMap<String, String> result = new HashMap<String, String>();
        result.put("h2o2", getResult(H2O2Index));
        result.put("le", getResult(LEIndex));
        result.put("sna", getResult(SNAIndex));
        result.put("pip", getResult(PIPIndex));
        result.put("nag", getResult(NAGIndex));
        result.put("oa", getResult(OAIndex));

        String phResult =
                PHIndex == 0 ? "4.1" : PHIndex == 1 ? "4.4" : PHIndex == 2 ? "4.6" : PHIndex == 3 ? "4.8" : "5.1";
        result.put("ph", phResult);

        return result;
    }

    private static String getResult(int index) {
        String result;
        if (index == -1) {
            result = "-";
        } else if (index == 0) {
            result = "±";
        } else {
            result = "+";
        }
        return result;
    }

    private static int[] getAvrageRGB(BufferedImage image, int x, int y) {
        int offset = 4;
        int[] rgb1 = getRGB(image, x, y);
        int[] rgb2 = getRGB(image, x + offset, y + offset);
        int[] rgb3 = getRGB(image, x - offset, y - offset);
        int[] rgb4 = getRGB(image, x + offset, y - offset);
        int[] rgb5 = getRGB(image, x - offset, y + offset);
        int[] rgb6 = getRGB(image, x - offset / 2, y - offset / 4);
        int[] rgb7 = getRGB(image, x + offset / 2, y + offset / 4);
        int[] rgb8 = getRGB(image, x - offset / 2, y + offset / 4);
        int[] rgb9 = getRGB(image, x + offset / 4, y - offset / 4);
        int[] rgb10 = getRGB(image, x - offset / 4, y - offset / 4);
        int[] rgb11 = getRGB(image, x + offset / 4, y + offset / 4);
        int[] rgb12 = getRGB(image, x - offset / 4, y + offset / 4);
        int[] rgb13 = getRGB(image, x + offset / 4, y - offset / 4);
        int[] rgb14 = getRGB(image, x - offset / 4 - 1, y - offset / 4 + 1);
        int[] rgb15 = getRGB(image, x + offset / 4 - 1, y + offset / 4 + 1);
        int[] rgb16 = getRGB(image, x - offset / 4 - 1, y + offset / 4 + 1);
        int[] rgb17 = getRGB(image, x + offset / 4 - 1, y - offset / 4 + 1);

        ArrayList<int[]> rgbList = new ArrayList<int[]>();
        rgbList.add(rgb1);
        rgbList.add(rgb2);
        rgbList.add(rgb3);
        rgbList.add(rgb4);
        rgbList.add(rgb5);
        rgbList.add(rgb6);
        rgbList.add(rgb7);
        rgbList.add(rgb8);
        rgbList.add(rgb9);
        rgbList.add(rgb10);
        rgbList.add(rgb11);
        rgbList.add(rgb12);
        rgbList.add(rgb13);
        rgbList.add(rgb14);
        rgbList.add(rgb15);
        rgbList.add(rgb16);
        rgbList.add(rgb17);

        int sum_r = 0;
        int sum_g = 0;
        int sum_b = 0;
        int count = 0;
        for (int i = 0; i < rgbList.size(); i++) {
            int[] rgb = rgbList.get(i);
            int r = rgb[0];
            int g = rgb[1];
            int b = rgb[2];
            // 去除黑色点
            if (r != 0 && g != 0 && b != 0) {
                sum_r += r;
                sum_g += g;
                sum_b += b;
                count++;
            }

        }
        int[] color = new int[3];
        color[0] = sum_r / count;
        color[1] = sum_g / count;
        color[2] = sum_b / count;

        return color;
    }

    private static int[] getRGB(BufferedImage image, int x, int y) {
        x = x * 2;
        y = y * 2;
        int[] rgb = new int[3];

        int pixel = image.getRGB(x, y);
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);

        return rgb;
    }

    private static double getDeep(int[] color) {
        int r = color[0];
        int g = color[1];
        int b = color[2];
        return r * 0.299 + g * 0.578 + b * 0.114;
    }

    private static boolean isGray(int[] color) {
        int r = color[0];
        int g = color[1];
        int b = color[2];
        return Math.abs(r - g) <= 35 && Math.abs(r - b) <= 30 && Math.abs(g - b) <= 30;
    }

    private static double getSame(int[] color1, int[] color2) {
        int r1 = color1[0];
        int r2 = color2[0];

        int g1 = color1[1];
        int g2 = color2[1];

        int b1 = color1[2];
        int b2 = color2[2];

        double r3 = (r1 - r2) / 256.0;
        double g3 = (g1 - g2) / 256.0;
        double b3 = (b1 - b2) / 256.0;

        double diff = Math.sqrt(r3 * r3 + g3 * g3 + b3 * b3);

        return 1 - diff;
    }

    private static int checkH2O2(BufferedImage image) {
        int x1 = h2o2Model.getL1x();
        int y1 = h2o2Model.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);

        int x2 = h2o2Model.getL2x();
        int y2 = h2o2Model.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);

        int x3 = h2o2Model.getL3x();
        int y3 = h2o2Model.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);

        int x4 = h2o2Model.getL4x();
        int y4 = h2o2Model.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);

        int x5 = h2o2Model.getL5x();
        int y5 = h2o2Model.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);

        int x6 = h2o2Model.getL6x();
        int y6 = h2o2Model.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);

        if (deep6 > deep3) {
            return 1;
        }

        double min1 = Math.abs(deep1 - deep6);
        double min2 = Math.abs(deep2 - deep6);
        double min3 = Math.abs(deep3 - deep6);
        double min4 = Math.abs(deep4 - deep6);
        double min = min1;
        if (min > min2) {
            min = min2;
        }

        if (min > min3) {
            min = min3;
        }

        if (min > min4) {
            min = min4;
        }

        return (min == min1 || min == min2) ? -1 : min == min3 ? 0 : 1;
    }

    private static int checkLE(BufferedImage image) {
        int x1 = leModel.getL1x();
        int y1 = leModel.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);
        int red1 = color1[0];

        float ratio1 = red1 / (color1[0] + color1[1] + color1[2]);

        int x2 = leModel.getL2x();
        int y2 = leModel.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);
        int red2 = color2[0];

        float ratio2 = red2 / (color2[0] + color2[1] + color2[2]);

        int x3 = leModel.getL3x();
        int y3 = leModel.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);
        int red3 = color3[0];

        float ratio3 = red3 / (color3[0] + color3[1] + color3[2]);

        int x4 = leModel.getL4x();
        int y4 = leModel.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);
        int red4 = color4[0];

        float ratio4 = red4 / (color4[0] + color4[1] + color4[2]);

        int x5 = leModel.getL5x();
        int y5 = leModel.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);
        int red5 = color5[0];

        float ratio5 = red5 / (color5[0] + color5[1] + color5[2]);

        int x6 = leModel.getL6x();
        int y6 = leModel.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);
        int red6 = color6[0];

        float ratio6 = red6 / (color6[0] + color6[1] + color6[2]);

        if (isGray(color6) || color6[0] < 125 || Math.abs(color6[1] - color6[2]) <= 5) {
            return -1;
        }

        if (Math.abs(color2[1] + color2[2] - color6[1] - color6[2]) <= 15) {
            return -1;
        }

        double min3 = Math.abs(deep3 - deep6);
        double min4 = Math.abs(deep4 - deep6);
        double min5 = Math.abs(deep5 - deep6);
        double min = min3;

        if (min > min4) {
            min = min4;
        }

        if (min > min5) {
            min = min5;
        }

        return min == min3 ? 0 : 1;
    }

    private static int checkSNA(BufferedImage image) {
        int x1 = snaModel.getL1x();
        int y1 = snaModel.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);

        int x2 = snaModel.getL2x();
        int y2 = snaModel.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);

        int x3 = snaModel.getL3x();
        int y3 = snaModel.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);

        int x4 = snaModel.getL4x();
        int y4 = snaModel.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);

        int x5 = snaModel.getL5x();
        int y5 = snaModel.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);

        int x6 = snaModel.getL6x();
        int y6 = snaModel.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);

        if (deep6 > deep3) {
            return -1;
        }

        double min2 = Math.abs(deep2 - deep6);
        double min3 = Math.abs(deep3 - deep6);
        double min4 = Math.abs(deep4 - deep6);
        double min5 = Math.abs(deep5 - deep6);
        double min = min2;
        if (min > min3) {
            min = min3;
        }

        if (min > min4) {
            min = min4;
        }

        if (min > min5) {
            min = min5;
        }

        return min == min2 ? -1 : min == min3 ? 0 : 1;
    }

    private static int checkPIP(BufferedImage image) {
        int x1 = pipModel.getL1x();
        int y1 = pipModel.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);

        int x2 = pipModel.getL2x();
        int y2 = pipModel.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);

        int x3 = pipModel.getL3x();
        int y3 = pipModel.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);

        int x4 = pipModel.getL4x();
        int y4 = pipModel.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);

        int x5 = pipModel.getL5x();
        int y5 = pipModel.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);

        int x6 = pipModel.getL6x();
        int y6 = pipModel.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);

        if (isGray(color6) || color6[0] <= color6[2] || color6[1] <= color6[2]) {
            return -1;
        }

        int min3 = color3[2];
        int min4 = color4[2];
        int min5 = color5[2];
        int min = min3;
        if (min > min4) {
            min = min4;
        }

        if (min > min5) {
            min = min5;
        }

        return min == min3 ? 0 : 1;
    }

    private static int checkNAG(BufferedImage image) {
        int x1 = nagModel.getL1x();
        int y1 = nagModel.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);

        int x2 = nagModel.getL2x();
        int y2 = nagModel.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);

        int x3 = nagModel.getL3x();
        int y3 = nagModel.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);

        int x4 = nagModel.getL4x();
        int y4 = nagModel.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);

        int x5 = nagModel.getL5x();
        int y5 = nagModel.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);

        int x6 = nagModel.getL6x();
        int y6 = nagModel.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);

        if (isGray(color6) || color6[0] < 110) {
            return -1;
        }

        if (isGray(color6) || color6[0] < 125 || Math.abs(color6[1] - color6[2]) <= 5) {
            return -1;
        }

        double min3 = Math.abs(deep3 - deep6);
        double min4 = Math.abs(deep4 - deep6);
        double min5 = Math.abs(deep5 - deep6);
        double min = min3;

        if (min > min4) {
            min = min4;
        }

        if (min > min5) {
            min = min5;
        }

        return min == min3 ? 0 : 1;
    }

    private static int checkOA(BufferedImage image) {
        int x1 = oaModel.getL1x();
        int y1 = oaModel.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);

        int x2 = oaModel.getL2x();
        int y2 = oaModel.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);

        int x3 = oaModel.getL3x();
        int y3 = oaModel.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);

        int x4 = oaModel.getL4x();
        int y4 = oaModel.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);

        int x5 = oaModel.getL5x();
        int y5 = oaModel.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);

        int x6 = oaModel.getL6x();
        int y6 = oaModel.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);

        if (color6[1] >= color6[2] + 10 || color6[0] >= color6[2] + 10) {
            return -1;
        }

        double min1 = Math.abs(deep1 - deep6);
        double min2 = Math.abs(deep2 - deep6);
        double min3 = Math.abs(deep3 - deep6);
        double min4 = Math.abs(deep4 - deep6);
        double min5 = Math.abs(deep5 - deep6);

        double min = min1;

        if (min > min2) {
            min = min2;
        }

        if (min > min3) {
            min = min3;
        }

        if (min > min4) {
            min = min4;
        }

        if (min > min5) {
            min = min5;
        }
        return min == min1 ? -1 : min == min2 ? 0 : 1;
    }

    private static int checkPH(BufferedImage image) {
        int x1 = phModel.getL1x();
        int y1 = phModel.getL1y();
        int[] color1 = getAvrageRGB(image, x1, y1);
        double deep1 = getDeep(color1);

        int x2 = phModel.getL2x();
        int y2 = phModel.getL2y();
        int[] color2 = getAvrageRGB(image, x2, y2);
        double deep2 = getDeep(color2);

        int x3 = phModel.getL3x();
        int y3 = phModel.getL3y();
        int[] color3 = getAvrageRGB(image, x3, y3);
        double deep3 = getDeep(color3);

        int x4 = phModel.getL4x();
        int y4 = phModel.getL4y();
        int[] color4 = getAvrageRGB(image, x4, y4);
        double deep4 = getDeep(color4);

        int x5 = phModel.getL5x();
        int y5 = phModel.getL5y();
        int[] color5 = getAvrageRGB(image, x5, y5);
        double deep5 = getDeep(color5);

        int x6 = phModel.getL6x();
        int y6 = phModel.getL6y();
        int[] color6 = getAvrageRGB(image, x6, y6);
        double deep6 = getDeep(color6);

        double same1 = getSame(color1, color6);
        double same2 = getSame(color2, color6);
        double same3 = getSame(color3, color6);
        double same4 = getSame(color4, color6);
        double same5 = getSame(color5, color6);

        double min = same1;
        if (min < same2) {
            min = same2;
        }
        if (min < same3) {
            min = same3;
        }
        if (min < same4) {
            min = same4;
        }
        if (min < same5) {
            min = same5;
        }

        return min == same1 ? 0 : min == same2 ? 1 : min == same3 ? 2 : min == same4 ? 3 : 4;
    }
}
