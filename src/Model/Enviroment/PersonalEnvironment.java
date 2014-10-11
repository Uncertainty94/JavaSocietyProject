package Model.Enviroment;

import Model.Characters.Person;
import Model.Kingdom;

import java.util.*;

/**
 * Created by serebryanskiysergei on 05-Oct-14.
 */
public class PersonalEnvironment {
    public ArrayList<Person> NearestCharacters;
    public PersonalEnvironment(Person person, Kingdom world)
    {
        NearestCharacters = new ArrayList<Person>();
        foreach (var place in world.GetHabitat().GetDictionaryOfLocations().Keys)
        {
            if (
                    Math.Sqrt(Math.Pow(place.X - person.GetLocation().X, 2) +
                            Math.Pow(place.Y - person.GetLocation().Y, 2)) <= person.GetRewiew())
                NearestCharacters.Add(
                        world.GetDictionaryOfCharacters()[world.GetHabitat().GetDictionaryOfLocations()[place]]);
        }
    }

}
