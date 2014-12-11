package Model.Characters;

import Model.Characters.Decisions.Decision;
import Model.Characters.Strategies.IStrategy;
import Model.Enviroment.Equipment;

import java.awt.*;

/**
 * Интерфейс для работы стратегии с персонажем
 */
public interface IPersonToStrategy {
    Person getOpponent();
    void setOpponent(Person op);
    int getHealth();
    int getLvlBonus();
    int getReview();
    Equipment getEquipment();
    PersonState getStatus();
    Decision getLastDecision();
    int getSpeed();
    Point getLocation();
    int getId();
    IStrategy getStrategy();
    Profession getProfession();
    void setDecision(Decision newDecision);
    void changeStrategy(IStrategy newstrategy);
}

