package impro.util;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.function.IntUnaryOperator;


public class Util {
    public static BufferedImage convertToGrayScale(BufferedImage source, IntUnaryOperator strategy) {
        BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        for (int x = 0; x < source.getWidth(); x++) {
            for (int y = 0; y < source.getHeight(); y++) {
                int rgba = source.getRGB(x, y);
                result.setRGB(x, y, getGrayValue(rgba, strategy));
            }
        }
        return result;
    }

    // public static BufferedImage detectEdges(BufferedImage image) {
    // BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
    // for (int x = 1; x < image.getWidth() - 1; x++) {
    // for (int y = 1; y < image.getHeight() - 1; y++) {
    // double gradient = Math.abs(getGrayValue(image.getRGB(x + 1, y)) - getGrayValue(image.getRGB(x - 1, y)))
    // + Math.abs(getGrayValue(image.getRGB(x, y + 1)) - getGrayValue(image.getRGB(x, y - 1)));
    // if (gradient < 80) {
    // result.setRGB(x, y, 0);
    // } else {
    // result.setRGB(x, y, new Color(255, 255, 255).getRGB());
    // }
    // }
    // }
    // return result;
    // }

    public static int getGrayValue(int rgba, IntUnaryOperator strategy) {
        return strategy.applyAsInt(rgba);
    }

    public static void invert(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int rgba = image.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
                image.setRGB(x, y, col.getRGB());
            }
        }
    }
}
