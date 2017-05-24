package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 05.03.2017.
 */
public class SnakeConfig {
    // Default Sizes
    public static final int GRID_SIZE = 13;

    public static final int FIELD_WIDTH = 30;
    public static final int FIELD_HEIGHT = 20;

    public static final int CANVAS_WIDTH = GRID_SIZE * FIELD_WIDTH;
    public static final int CANVAS_HEIGHT = GRID_SIZE * FIELD_HEIGHT;

   // public static final int HUD_HEIGHT_PER_LABEL = 30;

    public static final int WINDOW_WIDTH = CANVAS_WIDTH + 16;
    public static final int WINDOW_HEIGHT = CANVAS_HEIGHT + 39;

    // Colors
    public static final Color FRUIT_STANDARD_COLOR = new Color(170, 170, 170);
    public static final Color OBSTACLE_DEFAULT_COLOR = new Color(122, 122, 122);

    // MENU ITEMS
    public static final int MENU_START_Y = 110;
    public static final int MENU_X = 50;
    public static final int MENU_BLOCK_HEIGHT = 30;

    // Menu Fonts
    public static final Font MENU_ITEM_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Font MENU_LABEL_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 20);
    public static final Font HUD_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 15);
    //
    // Menu Colors
    public static final Color MENU_LABEL_COLOR = Color.DARK_GRAY;
    public static final Color MENU_ITEM_DEFAULT_COLOR = Color.BLACK;
    public static final Color MENU_ITEM_DEFAULT_SELECTED_COLOR = Color.RED;

    // Keys for the players to move
    public static final int PLAYER_1_DEFAULT_LEFT = 37;
    public static final int PLAYER_1_DEFAULT_UP = 38;
    public static final int PLAYER_1_DEFAULT_RIGHT = 39;
    public static final int PLAYER_1_DEFAULT_DOWN = 40;

    public static final int PLAYER_2_DEFAULT_LEFT = 65;
    public static final int PLAYER_2_DEFAULT_UP = 87;
    public static final int PLAYER_2_DEFAULT_RIGHT = 68;
    public static final int PLAYER_2_DEFAULT_DOWN = 83;
}
