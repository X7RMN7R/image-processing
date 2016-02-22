/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : image-processing
 * File : $RCSfile$
 * Created on 22 févr. 2016 by yv
 */
package impro;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Tester {

    public static void main(String[] args) {
        BufferedImage img = null;
        try {
            // Load image from resources
            img = ImageIO.read(Tester.class.getResource("/images/lutetia.jpg"));
            System.out.println("Image " + img.getWidth() + "x" + img.getHeight());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
