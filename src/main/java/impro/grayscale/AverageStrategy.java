/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : image-processing
 * File : $RCSfile$
 * Created on 23 févr. 2016 by yv
 */
package impro.grayscale;


import java.awt.Color;
import java.util.function.IntUnaryOperator;


public class AverageStrategy implements IntUnaryOperator {

    @Override
    public int applyAsInt(int operand) {
        int gray = (new Color(operand, true).getRed() + new Color(operand, true).getGreen() + new Color(operand, true)
                .getBlue()) / 3;
        return new Color(gray, gray, gray).getRGB();
    }

}
