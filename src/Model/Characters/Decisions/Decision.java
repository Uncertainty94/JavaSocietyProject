package Model.Characters.Decisions;

import Model.Characters.ActionType;
import Model.Characters.Person;
import Model.Characters.PersonState;

/**
 * Решение персонажа о следующем действии.
 */
public abstract class Decision {
    public PersonState newState;
    public ActionType nextAction;
    public abstract void apply(Person person);
}
