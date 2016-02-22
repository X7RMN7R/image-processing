/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : image-processing
 * File : $RCSfile$
 * Created on 22 févr. 2016 by yv
 */
package impro;


import java.awt.Color;
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

    private static BufferedImage detectEdges(BufferedImage image) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int x = 1; x < image.getWidth() - 1; x++) {
            for (int y = 1; y < image.getHeight() - 1; y++) {
                double gradient = Math.abs(getGrayValue(image.getRGB(x + 1, y)) - getGrayValue(image.getRGB(x - 1, y)))
                        + Math.abs(getGrayValue(image.getRGB(x, y + 1)) - getGrayValue(image.getRGB(x, y - 1)));
                if (gradient < 100) {
                    result.setRGB(x, y, 0);
                } else {
                    result.setRGB(x, y, new Color(255, 255, 255).getRGB());
                }
            }
        }
        return result;
    }

    private static double getGrayValue(int rgba) {
        return new Color(rgba, true).getRed() * 0.299 + new Color(rgba, true).getGreen() * 0.587
                + new Color(rgba, true).getBlue() * 0.114;
    }

    private static void invert(BufferedImage image) {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int rgba = image.getRGB(x, y);
                Color col = new Color(rgba, true);
                col = new Color(255 - col.getRed(), 255 - col.getGreen(), 255 - col.getBlue());
                image.setRGB(x, y, col.getRGB());
            }
        }
    }

    private static void process(BufferedImage image) {
        // Write result in a file
        BufferedImage processed = detectEdges(image);
        try {
            File outputfile = new File("processed.jpg");
            ImageIO.write(processed, "jpg", outputfile);
            System.out.println("Saved");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
