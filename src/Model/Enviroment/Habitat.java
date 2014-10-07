package Model.Enviroment;

import Model.Characters.Person;
import Model.Characters.Profession;
import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.util.Dictionary;

/**
 * Среда обитания.
 */
public class Habitat {
    private Dictionary <Integer,Profession> settlersProfessions;
    private Dictionary<Point,Integer> locationsOfSettlers;
    private int widht;
    private int height;

    public Dictionary<Integer, Profession> getSettlersProfessions() {
        return settlersProfessions;
    }

    public void setSettlersProfessions(Dictionary<Integer, Profession> settlersProfessions) {
        this.settlersProfessions = settlersProfessions;
    }

    public Habitat(Dictionary<Integer,Person> settlers, int widht, int height )
    {
        this.widht = widht;
        this.height = height;
        /** Разобраться как делать словарь и форыч*/
        locationsOfSettlers = new Dictionary<Point,Integer>();
        setSettlersProfessions(new Dictionary<Integer,Profession>());
    }
    public void refreshLocation(Dictionary<Integer,Person> settlers)
    {
        locationsOfSettlers.notifyAll();
        foreach (Person p in settlers.elements())
        {
            if (locationsOfSettlers.elements().contains(p.GetLocation()))
            {
                locationsOfSettlers.remove(p.GetLocation()); //лист
            }
            locationsOfSettlers.put(p.GetLocation(), p.GetId());
        }

    }
    public Dictionary<Point, Integer> GetDictionaryOfLocations()
    {
        return locationsOfSettlers;
    }
}
