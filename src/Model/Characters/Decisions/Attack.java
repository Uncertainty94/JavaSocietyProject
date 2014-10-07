package Model.Characters.Decisions;

import Model.Characters.Person;
import Model.Characters.PersonState;
import Model.Characters.Profession;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class Attack extends Decision {
    public Person opponent;
    @Override
    public void apply(Person person)
    {
        if (opponent != null)
        {
            if (opponent.getHealth() < person.getEquipment().getDamage()*person.getLvlBonus() -
                    opponent.getEquipment().getStandUp()*opponent.getLvlBonus())
            {
                opponent.setHealth(0);
                opponent.setStatus(PersonState.Died);
                person.addExp(100);
                if (person.getProfession() == Profession.Robber)
                {
                    person.addMoney(opponent.takeAllMoney());
                    if (person.getEquipment().equipCompare(opponent.getEquipment().getWeapon()))
                        person.getEquipment().сhangeWeapon(opponent.getEquipment().getWeapon());
                    if (person.getEquipment().equipCompare(opponent.getEquipment().getArmor()))
                        person.getEquipment().сhangeArmor(opponent.getEquipment().getArmor());
                }
                person.setStatus(PersonState.LastActionCompleted);
                person.setOpponent(null);
                opponent.setOpponent(null);
            }
            else
            {
                opponent.changeHp(-(person.getEquipment().getDamage() * person.getLvlBonus() -
                        opponent.getEquipment().getStandUp() * opponent.getLvlBonus()));
                person.getEquipment().weaponUsed();
                opponent.getEquipment().armorUsed();
            }
        }

    }
}
