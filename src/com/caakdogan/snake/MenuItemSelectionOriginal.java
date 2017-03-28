package com.caakdogan.snake;

/**
 * Created by Arif-Admin on 23.03.2017.
 * Backup File of MenuItemSelection Class (probably really bad practice)
 */
public class MenuItemSelectionOriginal extends MenuItem {
    private String labelBase;
    /*private boolean selected; // instance variables don't seem to be required more than once
    private Color color;
    private Font font;
    private String label;*/

    // Action related
    private int[] speed;
    private int selectedItem;
    private int selection;
    private MainMenuPanel menu;


    public MenuItemSelectionOriginal(String label, boolean selected, int[] speed, MainMenuPanel menu){


        super(label, selected);
        this.speed = speed;
        this.selectedItem = 0;
        this.selection = speed[selectedItem];
        this.labelBase = label;
        this.menu = menu;
        this.menu.speed = speed[speed.length/2]; // TODO Doesn't seem to work
        this.setLabel(this.labelBase + " " + this.selectedItem);

        print();
    }

    private void print(){
        //System.out.println(label);
        System.out.print("Item: " + this.selectedItem);
        System.out.println(" | " + this.selection);
    }

    @Override
    void performAction(int key) {
        if (key == 37) this.selectPrevious();
        else if (key == 39) this.selectNext();

    }



    void selectNext(){
        if (selectedItem < speed.length - 1)
        {
            selectedItem++;
            this.selection = speed[selectedItem];
        }
        else
        {
            selectedItem = 0;
            this.selection = speed[selectedItem];
        }
        print();
        this.setLabel(this.labelBase + " " + this.selectedItem);
        this.menu.speed = this.selection;

    }

    void selectPrevious(){
        if (selectedItem > 0)
        {
            selectedItem--;
            this.selection = speed[selectedItem];
        }
        else
        {
            selectedItem = speed.length - 1;
            this.selection = speed[selectedItem];
        }
        print();
        this.setLabel(this.labelBase + " " + this.selectedItem);
        this.menu.speed = this.selection;
    }


}
