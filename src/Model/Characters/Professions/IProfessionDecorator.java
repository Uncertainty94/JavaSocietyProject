package Model.Characters.Professions;

import Model.Characters.Person;
import Model.Enviroment.Habitat;

/**
 * Created by serebryanskiysergei on 11-Oct-14.
 */
public interface IProfessionDecorator {
    void takeProfession(Person person, Habitat settlement);
}
