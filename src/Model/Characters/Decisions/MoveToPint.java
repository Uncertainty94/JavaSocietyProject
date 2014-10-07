package Model.Characters.Decisions;

import Model.Characters.Person;
import Model.Characters.PersonState;

import java.awt.*;

/**
 * Created by serebryanskiysergei on 07-Oct-14.
 */
public class MoveToPint extends Decision {
    public Point Destination;
    @Override
    public void apply(Person person)
    {
        if ((Destination.x - person.getLocation().x) != 0 && (Destination.y - person.getLocation().y)!=0)
        {
            double alpha =
                    Math.atan((Destination.y - person.getLocation().y)/(Destination.x - person.getLocation().x));
            double speedX = person.getSpeed()*0.05*Math.cos(alpha);
            double speedY = person.getSpeed()*0.05*Math.sin(alpha);
            if (Math.sqrt(Math.pow((person.getLocation().x - Destination.x), 2) +
                    Math.pow((person.getLocation().y - Destination.y), 2)) >
                    Math.sqrt(Math.pow((speedX), 2) + Math.pow((speedY), 2)))
            {
                if (person.getLocation().x < Destination.x)
                {
                    person.setLocation(new Point(person.getLocation().y + (int) speedX,
                            person.getLocation().y + (int) speedY));
                    person.setStatus(PersonState.Moving);
                }
                else
                {
                    person.setLocation(new Point(person.getLocation().x - (int) speedX,
                            person.getLocation().y - (int) speedY));
                    person.setStatus(PersonState.Moving);
                }
            }
            else
            {
                person.setLocation(Destination);
                person.setStatus(PersonState.Ready);
            }
        }
        else
        {
            person.setLocation(Destination);
            person.setStatus(PersonState.Ready);
        }
    }
}
