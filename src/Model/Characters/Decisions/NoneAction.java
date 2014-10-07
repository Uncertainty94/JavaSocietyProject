package Model.Characters.Decisions;

import Model.Characters.Person;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class NoneAction extends Decision {
    @Override
    public void apply(Person person)
    {
        person.setStatus(newState);
    }
}
