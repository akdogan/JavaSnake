package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 19.03.2017.
 */
public class MenuItemLabel {
    public String label;
    private Color col;
    public Font font;

    public MenuItemLabel(String label)
    {
        this.label = label;
        this.col = Color.DARK_GRAY;
        this.font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    }

    public Color getColor() {
        return this.col;
    }

    public String getLabel() {
        return this.label;
    }

    public Font getFont() {
        return this.font;
    }
}
