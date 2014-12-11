package Model.Characters.Strategies;

import Model.Characters.*;
import Model.Characters.Decisions.ChangeProfession;
import Model.Characters.Decisions.Decision;
import Model.Characters.Decisions.TraderHealing;
import Model.Enviroment.Habitat;
import Model.Enviroment.PersonalEnvironment;

/**
 * Created by serebryanskiysergei on 13-Oct-14.
 */
public class TraderStrategy implements IStrategy {
    public Decision takeDecision(IPersonToStrategy person, PersonalEnvironment personEnvir, Habitat settlement)
    {
        if (inDangerous(person))
        {
            return new TraderHealing();
        }
        if (person.getEquipment().howMoneyInCash() < 10) {
            ChangeProfession decision = new ChangeProfession();
            decision.newState = PersonState.LastActionCompleted;
            decision.newProfession = Profession.Peasant;
            return decision;
        }
        switch (person.getStatus())
        {
            case Ready:
                switch (person.getLastDecision().nextAction)
                {
                    case Free:
                        return Actions.free();
                }
                return person.getLastDecision();
            case LastActionCompleted:
                return Actions.trading(settlement, personEnvir);
            case Fighting:
                return Actions.attacking(person.getOpponent());
        }
        return Actions.free();

    }
    /// <summary>
    /// Проверка на опсность для жизни.
    /// В случае опасности стратегия переключается на безопасную.
    /// </summary>
    /// <param name="person">Персонаж.</param>
    /// <returns>В опасности или нет.</returns>
    private boolean inDangerous(IPersonToStrategy person)
    {
        return person.getHealth() < 25;
    }
}




