package Model.Characters.Decisions;

import Model.Characters.Person;
import Model.Characters.PersonState;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class BuyingMedicine extends Decision {
    public Person opponent = null;
    @Override
    public void apply(Person person)
    {
        if (opponent != null)
        {
            if (person.getEquipment().howMoneyInCash()>=25)
            {
                opponent.addMoney(person.takeMoney(25));
                person.changeHp(50);
                person.setStatus(PersonState.LastActionCompleted);
            }
            else
            {
                person.setStatus(PersonState.LastActionCompleted);
            }

        }
        else
        {
            person.setStatus(PersonState.Ready);
        }
    }
}
