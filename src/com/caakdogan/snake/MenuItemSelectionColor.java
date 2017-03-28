package com.caakdogan.snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Arif-Admin on 24.03.2017.
 */
public class MenuItemSelectionColor extends MenuItem {

    private String label;
    private boolean selected;
    private Color color;
    private Font font;

    // Action related
    private  ArrayList<Color> colors;
    private int selectedItem;
    private Color selection;
    private MainMenuPanel menu;


    public MenuItemSelectionColor(String label, boolean selected, ArrayList<Color> colors, MainMenuPanel menu){


        super(label, selected);
        this.colors = colors;
        this.selectedItem = 0;
        this.selection = colors.get(selectedItem);

        this.menu = menu;
        this.menu.p1 = this.selection;

        print();
    }

    private void print(){
        //System.out.println(label);
        System.out.print("Item: " + this.selectedItem);

    }

    @Override
    void performAction(int key) {
        if (key == 37) this.selectPrevious();
        else if (key == 39) this.selectNext();

    }



    void selectNext(){
        if (selectedItem < colors.size() - 1)
        {
            selectedItem++;
            this.selection = colors.get(selectedItem);
        }
        else
        {
            selectedItem = 0;
            this.selection = colors.get(selectedItem);
        }
        print();

        this.menu.p1 = this.selection;

    }

    void selectPrevious(){
        if (selectedItem > 0)
        {
            selectedItem--;
            this.selection = colors.get(selectedItem);
        }
        else
        {
            selectedItem = colors.size() - 1;
            this.selection = colors.get(selectedItem);
        }
        print();

        this.menu.p1 = this.selection;
    }

    @Override
    public void draw(int x, int y, Graphics g){
        g.setColor(getColor());
        g.drawString(getLabel(), x, y);
        g.setColor(selection);
        g.fillRect(x + 145, y - 18, 20, 20);
    }
}
