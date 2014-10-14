package Model.Characters.Strategies;

import Model.Characters.Decisions.Decision;
import Model.Characters.IPersonToStrategy;
import Model.Enviroment.Habitat;
import Model.Enviroment.PersonalEnvironment;

/**
 * Стратегия персонажа.
 * Принимает решение что делать персонажу в следующий ход.
 */
public interface IStrategy {
    Decision takeDecision(IPersonToStrategy person,PersonalEnvironment personEnvir, Habitat settlement);
}
