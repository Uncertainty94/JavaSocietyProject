package Model.Prototypes;

import Model.Characters.Professions.TraderDecorator;
import Model.Enviroment.Habitat;

/**
 * Created by serebryanskiysergei on 14-Oct-14.
 */
public class TraderPrototype extends PersonPrototype {
    private static TraderDecorator decorator = new TraderDecorator();
    public TraderPrototype(Habitat setllement){
        super(setllement, decorator);
    }
}
