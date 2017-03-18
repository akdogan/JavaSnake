package com.caakdogan.snake;

import java.awt.*;

/**
 * Created by Arif-Admin on 05.03.2017.
 */
public class SnakeConfig {
    // Default Sizes
    public static final int GRID_SIZE = 13;

    public static final int FIELD_WIDTH = GRID_SIZE * 30;
    public static final int FIELD_HEIGHT = GRID_SIZE * 20;

    public static final int WINDOW_WIDTH = FIELD_WIDTH + 16;
    public static final int WINDOW_HEIGHT = FIELD_HEIGHT + 39;

    // Default Colors
    public static final Color MENU_ITEM_DEFAULT_COLOR = Color.BLACK;
    public static final Color MENU_ITEM_DEFAULT_SELECTED_COLOR = Color.RED;

    public static final Color FRUIT_STANDARD_COLOR = new Color(170, 170, 170);
    public static final Color OBSTACLE_DEFAULT_COLOR = new Color(122, 122, 122);

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
