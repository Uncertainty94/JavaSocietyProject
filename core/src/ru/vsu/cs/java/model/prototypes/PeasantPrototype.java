package Model.Prototypes;

import Model.Characters.Professions.PeasantDecorator;
import Model.Enviroment.Habitat;

/**
 * Created by serebryanskiysergei on 14-Oct-14.
 */
public class PeasantPrototype extends PersonPrototype {
    private static PeasantDecorator decorator = new PeasantDecorator();
    public PeasantPrototype(Habitat setllement){
        super(setllement, decorator);
    }
}
