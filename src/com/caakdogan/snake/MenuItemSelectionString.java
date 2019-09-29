package com.caakdogan.snake;

import com.caakdogan.shared.Tools;

import java.util.ArrayList;

/**
 * Created by Arif-Admin on 29.09.2019.
 */
public class MenuItemSelectionString extends MenuItemSelection<String> {

    private SnFileName selector;

    public MenuItemSelectionString(String label, int x, int y, boolean selected, ArrayList<String> items, int defaultSelection, SnFileName selector) {

        super(label, x, y, selected, items, defaultSelection);
        this.selector = selector;
        // Eigene Klasse erstellen, di
        this.selector.setFileName(items.get(selectedItemIndex));
        Tools.log("Create MapMenu: " + this.selector);

    }

    @Override
    public void setSelectorValue() {
        this.selector.setFileName(items.get(selectedItemIndex));
    }

    @Override
    public String setLabelAppendix(){
        return  this.items.get(selectedItemIndex);
    }

}
