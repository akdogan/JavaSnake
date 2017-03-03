import com.timer.GameElement;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by Arif-Admin on 03.03.2017.
 */
public class GameField {

    HashMap<Point, GameElement> map;

    public GameField(){
        map = HashMap<Point, GameElement>;
    }


    public boolean locationHasContent(Point p)
    {
        return map.containsKey(p);
    }

    public GameElement checkLocation(Point p)
    {
        return map.get(p);
    }

    public void addValue(Point p, GameElement element)
    {
        map.put(p, element);
    }

    public void addValue(Point p, GameElement element)
    {

    }

}