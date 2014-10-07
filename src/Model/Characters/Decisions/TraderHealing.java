package Model.Characters.Decisions;

import Model.Characters.ActionType;
import Model.Characters.Person;
import Model.Characters.PersonState;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class TraderHealing extends Decision {
    public TraderHealing()
    {
        newState = PersonState.Ready;
        nextAction = ActionType.Free;
    }
    @Override
    public void apply(Person person)
    {
        person.changeHp(50);
        person.addMoney(-25);
        person.setStatus(PersonState.Ready);
    }
}
