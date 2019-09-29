package com.caakdogan.snake;

import com.caakdogan.shared.GridPoint;
import com.caakdogan.shared.SnakeConfig;
import com.caakdogan.shared.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by Arif-Admin on 26.09.2019.
 */
public class FileHandler {
    private static final String NUMBERS = "0123456789";
    private static final String SEPARATORS = ".:,;";
    private ArrayList<GridPoint> importedPoints;

    public FileHandler() {
        this.importedPoints = new ArrayList<>();
        this.getListOfMaps(SnakeConfig.MAPS_DIRECTORY);
    }

    public ArrayList<String> getListOfMaps(String dir){
        File folder = new File(dir);
        ArrayList<String> listOfMaps = new ArrayList<>();
        File[] fileList = folder.listFiles();
        for ( File f : fileList) {
            if (checkFileType(f)) {
                listOfMaps.add(getMapName(f));
            }
        }
        return listOfMaps;
    }

    private Boolean checkFileType(File f) {
        String name = f.getName();
        String ext = name.substring(name.length() - 4);
        if (ext.equals(SnakeConfig.MAPS_EXT)) {
            return true;
        }
        return false;
    }

    private String getMapName(File f) {
        return f.getName().substring(0, f.getName().length() - 4);
    }

    public ArrayList<GridPoint> parseFile(String name){
        String filePath = SnakeConfig.MAPS_DIRECTORY + name + SnakeConfig.MAPS_EXT;
        readUsingBufferedReader(filePath);
        return this.importedPoints;
    }

    private void readUsingBufferedReader(String fileName) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                parseLineToPoint(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    Tools.log("TEST: " + e);
                }
        }
    }

    private void parseLineToPoint(String ls){
        String[] line = new String[ls.length()];
        for(int i = 0; i < ls.length(); i++) {
            line[i] = ls.substring(i, i + 1);
        }
        String sy = "";
        String sx = "";
        GridPoint p = new GridPoint();
        Boolean valid = true;
        Boolean foundSeparator = false;
        int i = 0;
        while ( (i < line.length) && valid ) {
            if (NUMBERS.contains(line[i])) {
                if (!foundSeparator){
                    sx = sx + line[i];
                }
                else {
                    sy = sy + line[i];
                }


            }
            else if (SEPARATORS.contains(line[i]) && !foundSeparator) {
                foundSeparator = true;
            }
            else {
                valid = false;
            }
            i++;
        }
        if (valid && foundSeparator) {
            boolean success = false;
            try {
                p.x = Integer.parseInt(sx);
                p.y = Integer.parseInt(sy);
                success = true;
            }
            catch (Exception e) {
                Tools.log("parsing error:" + e);
            }
            if (success) {
                importedPoints.add(p);
            }

        }

    }

}
