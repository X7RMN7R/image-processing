package impro;


import impro.grayscale.AverageStrategy;
import impro.grayscale.LightnessStrategy;
import impro.grayscale.LuminosityStrategy;
import impro.util.Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tester {

    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            // Load image from resources
            img = ImageIO.read(Tester.class.getResource("/images/lutetia.jpg"));
            System.out.println("Image " + img.getWidth() + "x" + img.getHeight());

            process(img);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void process(BufferedImage image) {
        // Write result in a file
        BufferedImage grayAverage = Util.convertToGrayScale(image, new AverageStrategy());
        BufferedImage grayLightness = Util.convertToGrayScale(image, new LightnessStrategy());
        BufferedImage grayLuminosity = Util.convertToGrayScale(image, new LuminosityStrategy());
        try {
            File outputfileAverage = new File("target/grayAverage.jpg");
            ImageIO.write(grayAverage, "jpg", outputfileAverage);
            File outputfileLightness = new File("target/grayLightness.jpg");
            ImageIO.write(grayLightness, "jpg", outputfileLightness);
            File outputfileLuminosity = new File("target/grayLuminosity.jpg");
            ImageIO.write(grayLuminosity, "jpg", outputfileLuminosity);
            System.out.println("Saved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
