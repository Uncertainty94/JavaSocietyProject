package Model.Characters.Strategies;

import Model.Characters.Decisions.Decision;
import Model.Characters.IPersonToStrategy;
import Model.Enviroment.Habitat;

/**
 * Стратегия персонажа.
 * Принимает решение что делать персонажу в следующий ход.
 */
public interface IStrategy {
    Decision TakeDecision(IPersonToStrategy person,PersonalEnviroment personEnvir, Habitat settlement);
}
