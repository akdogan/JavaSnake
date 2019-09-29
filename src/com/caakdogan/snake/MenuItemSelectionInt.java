package com.caakdogan.snake;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Arif-Admin on 23.03.2017.
 * Backup File of MenuItemSelection Class (probably really bad practice)
 */
public class MenuItemSelectionInt extends MenuItemSelection<Integer> {

    private AtomicInteger selector;

    public MenuItemSelectionInt(String label, int x, int y, boolean selected, ArrayList<Integer> items, int defaultSelection, AtomicInteger selector){

        super(label, x, y, selected, items, defaultSelection);
        this.selector = selector;
    }

    @Override
    public void setSelectorValue(){
        this.selector.set(items.get(selectedItemIndex));
    }

    @Override
    public String setLabelAppendix() {
        return Integer.toString(selectedItemIndex);
    }








}
