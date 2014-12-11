package Model.Prototypes;

import Model.Characters.Professions.WarriorDecorator;
import Model.Enviroment.Habitat;

/**
 * Created by serebryanskiysergei on 14-Oct-14.
 */
public class WarriorPrototype extends PersonPrototype {
    private static WarriorDecorator decorator = new WarriorDecorator();
    public WarriorPrototype(Habitat settlement)
    {
        super(settlement, decorator);
    }
}
