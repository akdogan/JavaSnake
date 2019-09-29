package com.caakdogan.snake;

import com.caakdogan.shared.GameElement;
import com.caakdogan.shared.GridPoint;
import com.caakdogan.shared.SnakeConfig;
import com.caakdogan.shared.SnakeObstacle;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Arif-Admin on 22.04.2017.
 */
public class LevelGenerator {

    private ArrayList<SnakeObstacle> levelConfig;
    private HashMap<GridPoint, GameElement> map;

    public LevelGenerator(HashMap<GridPoint, GameElement> map){
        this.levelConfig = new ArrayList<>();
        this.map = map;
    }

    public ArrayList<SnakeObstacle> generateLevel (String fileName){
        FileHandler importer = new FileHandler();
        ArrayList<GridPoint> obstacleList = importer.parseFile(fileName);

        for (int i = 0; i < obstacleList.size(); i++ ) {
            this.levelConfig.add(new SnakeObstacle(this.map, obstacleList.get(i)));

        }

        return this.levelConfig;
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

    private ArrayList<SnakeObstacle> dynamic (String fileName) {
        FileHandler importer = new FileHandler();
        ArrayList<GridPoint> obstacleList = importer.parseFile(fileName);

        for (int i = 0; i < obstacleList.size(); i++ ) {
            this.levelConfig.add(new SnakeObstacle(this.map, obstacleList.get(i)));

        }

        return levelConfig;
    }

}
