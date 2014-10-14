package Model.Prototypes;

import Model.Characters.Professions.RobberDecorator;
import Model.Enviroment.Habitat;

/**
 * Created by serebryanskiysergei on 14-Oct-14.
 */
public class RobberPrototype extends PersonPrototype{
    private static RobberDecorator decorator = new RobberDecorator();
    public RobberPrototype(Habitat setllement){
        super(setllement, decorator);
    }
}
