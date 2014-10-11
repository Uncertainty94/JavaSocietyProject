package Model.Enviroment;

import Model.Characters.Person;
import Model.Characters.Profession;

import java.awt.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Среда обитания.
 */
public class Habitat {
    private Hashtable <Integer,Profession> settlersProfessions;
    private Hashtable<Point,Integer> locationsOfSettlers;
    private int widht;
    private int height;

    public Habitat(Dictionary<Integer,Person> settlers, int widht, int height )
    {
        this.widht = widht;
        this.height = height;
        setLocationsOfSettlers(new Hashtable<Point, Integer>());
        setSettlersProfessions(new Hashtable<Integer, Profession>());
    }
    public void refreshLocation(Dictionary<Integer,Person> settlers)
    {
        getLocationsOfSettlers().clear();
        Enumeration<Integer> enumKey = settlers.keys();
        while(enumKey.hasMoreElements()) {
            Integer key = enumKey.nextElement();
            Person person = settlers.get(key);
            if (getLocationsOfSettlers().containsKey(person.getLocation()))
                getLocationsOfSettlers().remove(person.getLocation());
            getLocationsOfSettlers().put(person.getLocation(), person.getId());
        }

    }

    public Hashtable<Integer, Profession> getSettlersProfessions() {
        return settlersProfessions;
    }

    public void setSettlersProfessions(Hashtable<Integer, Profession> settlersProfessions) {
        this.settlersProfessions = settlersProfessions;
    }

    public Hashtable<Point, Integer> getLocationsOfSettlers() {
        return locationsOfSettlers;
    }

    public void setLocationsOfSettlers(Hashtable<Point, Integer> locationsOfSettlers) {
        this.locationsOfSettlers = locationsOfSettlers;
    }

    public int getWidht() {
        return widht;
    }

    public void setWidht(int widht) {
        this.widht = widht;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
