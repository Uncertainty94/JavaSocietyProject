package Model.Characters.Decisions;

import Model.Characters.Person;
import Model.Characters.PersonState;
import Model.Characters.Profession;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class ChangeProfession extends Decision {

    public Profession newProfession;
    @Override
    public void apply(Person person)
    {
        person.setStatus(newState);
        person.setProfession(newProfession);
        person.setStatus(PersonState.LastActionCompleted);
        person.setDecision(null);
    }
}
