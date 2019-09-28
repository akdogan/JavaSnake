package com.caakdogan.snake;

import com.caakdogan.shared.GridPoint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Arif-Admin on 26.09.2019.
 */
public class FileImporter {
    private static final String NUMBERS = "0123456789";
    private static final String SEPARATORS = ".:,;";
    private ArrayList<GridPoint> importedPoints;

    public FileImporter() {
        this.importedPoints = new ArrayList<GridPoint>();
    }

    public ArrayList<GridPoint> parseFile(){
        readUsingBufferedReader("./res/test");

        return this.importedPoints;
    }

    private void readUsingBufferedReader(String fileName) {
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            //String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                //stringBuilder.append(line);
                //stringBuilder.append(ls);
                System.out.println("Readline: " + line);
                parseLineToPoint(line);
            }
            // delete the last ls
            //stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("TEST: " + e);
                }
        }
    }

    private void parseLineToPoint(String ls){
        System.out.println("parseLineToPoint called with: " + ls);
        String[] line = new String[ls.length()];
        for(int i = 0; i < ls.length(); i++) {
            System.out.println(ls.substring(i, i + 1));
            line[i] = ls.substring(i, i + 1);
        }
        String sy = "";
        String sx = "";
        GridPoint p = new GridPoint();
        Boolean valid = true;
        Boolean foundSeparator = false;
        int i = 0;
        System.out.println(line.length);
        while ( (i < line.length) && valid ) {
            if (NUMBERS.contains(line[i])) {
                if (!foundSeparator){
                    sx = sx + line[i];
                    System.out.println("adding x :" + line[i]);
                }
                else {
                    sy = sy + line[i];
                    System.out.println("adding y :" + line[i]);
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
                System.out.println("sx=" + sx);
                p.x = Integer.parseInt(sx);
                System.out.println("sy=" + sy);
                p.y = Integer.parseInt(sy);
                success = true;
            }
            catch (Exception e) {
                System.out.println("parsing x error:" + e);
            }
            if (success) {
                System.out.println("GRIDPOINT.X: " + p.x);
                System.out.println("GRIDPOINT.X: " + p.y);
                importedPoints.add(p);
            }

        }

    }

}
