package Model.Characters;

import Model.Characters.Decisions.*;
import Model.Enviroment.Habitat;
import Model.Enviroment.PersonalEnvironment;

import javax.print.attribute.standard.Destination;
import java.awt.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by serebryanskiysergei on 11-Oct-14.
 */
public class Actions {
    public static Attack attacking(IPersonToStrategy opponent)
    {
        Attack decision = new Attack();
        decision.opponent = (Person) opponent;
        decision.newState = PersonState.Fighting;
        decision.nextAction = ActionType.Free;
        return decision;
    }
    public static BuyingInstruments buyingInstruments(Habitat settlement, PersonalEnvironment pEnvir)
    {
        BuyingInstruments decision = new BuyingInstruments();
        decision.newState = PersonState.Ready;
        decision.nextAction = ActionType.MoveToCrafthouse;
        Iterator<Person> iter = pEnvir.NearestCharacters.iterator();
        while(iter.hasNext()){
            Person item = iter.next();
            if(item.getProfession()==Profession.Trader)
                decision.opponent=item;
        }
        return decision;
    }
    public static BuyingMedicine buyMedicine(IPersonToStrategy opponent)
    {
        BuyingMedicine decsion = new BuyingMedicine();
        decsion.newState = PersonState.LastActionCompleted;
        decsion.opponent = (Person) opponent;
        decsion.nextAction = ActionType.Free;
        return decsion;
    }
    public static Decision free()
    {
        NoneAction decision = new NoneAction(); decision.newState = PersonState.LastActionCompleted;
        decision.nextAction = ActionType.Free;
        return decision;
    }
    public static MoveToPoint patroling(Habitat settlement)
    {
        MoveToPoint decision = new MoveToPoint();
        decision.destination = new Point((int)(Math.random() * ((settlement.getWidht()) + 1)),(int)(Math.random() * ((settlement.getHeight()) + 1)));
        decision.newState = PersonState.Moving;
        decision.nextAction = ActionType.Free;
        return decision;
    }
    public static StealMoney stealMoney(IPersonToStrategy opponent)
    {
        StealMoney decision = new StealMoney();
        decision.opponent = (Person) opponent;
        decision.newState = PersonState.Ready;
        decision.nextAction = ActionType.Free;
        return decision;
    }
    public static Selling sell(Habitat settlement, PersonalEnvironment pEnvir)
    {
        Selling decision = new  Selling ();
        Iterator<Person> iter = pEnvir.NearestCharacters.iterator();
        while(iter.hasNext()){
            Person item = iter.next();
            if(item.getProfession()==Profession.Trader)
                decision.opponent=item;
        }
        decision.newState = PersonState.Ready;
        decision.nextAction = ActionType.Free;
        return decision;
    }
    public static Trade trading(Habitat settlement, PersonalEnvironment pEnvir)
    {
        Trade decision = new Trade();
        decision.newState = PersonState.Ready;
        decision.nextAction = ActionType.Free;
        return decision;
    }
    public static MoveToPoint goingToFarm(Habitat settlement,PersonalEnvironment pEnvir)
    {
        var move = new MoveToPoint
        {
            NewState = State.Moving,
                    NextAction = ActionType.Work,
                    Destination =
                            {
                                    X = RandomContainer.Random.Next(settlement.Farm.X, settlement.Farm.X + settlement.Farm.Width),
                                    Y = RandomContainer.Random.Next(settlement.Farm.Y, settlement.Farm.Y + settlement.Farm.Height)
                            }
        };
        return move;
    }


    public static Working work(Habitat settlement,PersonalEnvironment pEnvir)
    {
        var decision = new Working {NewState = State.Working, NextAction = ActionType.MoveToTrader};
        return decision;
    }

    /// <summary>
    /// Идет продать собранное зерно.
    /// </summary>
    /// <param name="settlement">Мир</param>
    /// <param name="pEnvir">Окружение персонажа.</param>
    /// <returns></returns>
    public static MoveToPoint GoingToTrader(Habitat settlement,PersonalEnvironment pEnvir)
    {
        var move = new MoveToPoint
        {
            Destination = settlement.FindFullTraderPlace(),
                    NextAction = ActionType.Sell,
                    NewState = State.Moving
        };
        return move;
    }
    /// <summary>
    /// Идти за иструментами.
    /// </summary>
    /// <param name="settlement"></param>
    /// <param name="pEnvir"></param>
    /// <returns></returns>
    public static MoveToPoint GoingForInstruments(Habitat settlement, PersonalEnvironment pEnvir)
    {
        var move = new MoveToPoint
        {
            Destination = settlement.FindFullTraderPlace(),
                    NextAction = ActionType.BuyInstruments,
                    NewState = State.Moving
        };
        return move;
    }
    /// <summary>
    /// Идет на работу.
    /// </summary>
    /// <param name="settlement">Окружающий мир.</param>
    /// <returns></returns>
    public static MoveToPoint GoingToCrafthouse(Habitat settlement, PersonalEnvironment pEnvir)
    {
        MoveToPoint decision = new MoveToPoint();
        decision.newState = PersonState.Moving;
        decision.nextAction = ActionType.Craft;
        decision.destination =new Point(RandomContainer.Random.Next(settlement.CrHouse.X,
                settlement.CrHouse.X + settlement.CrHouse.Width),RandomContainer.Random.Next(settlement.CrHouse.Y,
                settlement.CrHouse.Y + settlement.CrHouse.Height));
        return move;
    }
    /// <summary>
    /// Работает.
    /// </summary>
    /// <param name="settlement"></param>
    /// <param name="pEnvir"></param>
    /// <returns></returns>
    public static Working Crafting(Habitat settlement, PersonalEnvironment pEnvir)
    {
        Working decision = new Working ();
        decision.newState = PersonState.Working;
        decision.nextAction = ActionType.MoveToTrader;
        return decision;
    }
}
