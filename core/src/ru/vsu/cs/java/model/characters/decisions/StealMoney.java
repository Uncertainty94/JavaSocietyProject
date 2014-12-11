package Model.Characters.Decisions;

import Model.Characters.Person;
import Model.Characters.PersonState;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class StealMoney extends Decision {
    public Person opponent;
    @Override
    public void apply(Person person)
    {
        person.addMoney(opponent.takeAllMoney());
        person.addExp(100);
        person.setStatus(PersonState.LastActionCompleted);
    }
}
