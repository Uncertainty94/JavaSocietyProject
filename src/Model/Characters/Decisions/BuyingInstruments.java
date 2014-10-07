package Model.Characters.Decisions;

import Model.Characters.Person;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class BuyingInstruments extends Decision {

    public Person opponent;
    @Override
    public void apply(Person person)
    {
        if (person.takeMoney(50) == 50)
        {
            opponent.addMoney(50);
            person.addExp(50);
            person.setStatus(newState);
        }
    }
}
