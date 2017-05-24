package com.caakdogan.snake;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Arif-Admin on 22.04.2017.
 */
public class LevelGenerator {

    private ArrayList<SnakeObstacle> levelConfig;
    private HashMap<GridPoint, GameElement> map;

    public LevelGenerator(HashMap<GridPoint, GameElement> map){
        levelConfig = new ArrayList<SnakeObstacle>();
        this.map = map;
    }

    public ArrayList<SnakeObstacle> generateLevel (int level){

        switch (level) {
            case 1: return this.levelOne();

            case 2: return this.levelTwo();

        }


        return  this.levelConfig;
    }

    private ArrayList<SnakeObstacle> levelOne () {
        // create top row
        for (int i = 0; i < SnakeConfig.FIELD_WIDTH; i++)
        {
            GridPoint tempPoint = new GridPoint(i, 0);
            this.levelConfig.add(new SnakeObstacle(this.map, tempPoint));
        }
        // create left side
        for ( int i = 1; i < SnakeConfig.FIELD_HEIGHT; i++)
        {
            GridPoint tempPoint = new GridPoint(0, i);
            this.levelConfig.add(new SnakeObstacle(this.map, tempPoint));
        }
        for ( int i = 1; i < SnakeConfig.FIELD_HEIGHT; i++)
        {
            GridPoint tempPoint = new GridPoint(SnakeConfig.FIELD_WIDTH - 1, i);
            this.levelConfig.add(new SnakeObstacle(this.map, tempPoint));
        }
        for ( int i = 1; i < SnakeConfig.FIELD_WIDTH - 1; i++)
        {
            GridPoint tempPoint = new GridPoint(i, SnakeConfig.FIELD_HEIGHT - 1);
            this.levelConfig.add(new SnakeObstacle(this.map, tempPoint));
        }
        return  levelConfig;
    }

    private ArrayList<SnakeObstacle> levelTwo (){
        //create vertical
        for (int i = 0; i < SnakeConfig.FIELD_HEIGHT; i++)
        {
            GridPoint tempPoint = new GridPoint(SnakeConfig.FIELD_WIDTH / 2, i);
            this.levelConfig.add(new SnakeObstacle(this.map, tempPoint));
        }
        // create horizontal
        for (int i = 0; i < SnakeConfig.FIELD_WIDTH; i++)
        {
            GridPoint tempPoint = new GridPoint(i, SnakeConfig.FIELD_HEIGHT / 2);
            this.levelConfig.add(new SnakeObstacle(this.map, tempPoint));
        }

        return  levelConfig;
    }

}