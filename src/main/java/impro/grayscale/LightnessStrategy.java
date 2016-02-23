/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : image-processing
 * File : $RCSfile$
 * Created on 23 févr. 2016 by yv
 */
package impro.grayscale;


import java.awt.Color;
import java.util.function.IntUnaryOperator;


public class LightnessStrategy implements IntUnaryOperator {

    @Override
    public int applyAsInt(int operand) {
        int red = new Color(operand, true).getRed();
        int green = new Color(operand, true).getGreen();
        int blue = new Color(operand, true).getBlue();
        int gray = (Math.max(red, Math.max(green, blue)) + Math.min(red, Math.min(green, blue))) / 2;
        return new Color(gray, gray, gray).getRGB();
    }

}
