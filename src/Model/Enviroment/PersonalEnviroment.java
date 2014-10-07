package Model.Enviroment;

import Model.Characters.Person;
import Model.Kingdom;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by serebryanskiysergei on 05-Oct-14.
 */
public class PersonalEnviroment {
    public List<Person> NearestCharacters;
    public PersonalEnviroment(Person person, Kingdom world)
    {
        NearestCharacters = new List<Person>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Person> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Person person) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Person> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Person> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Person get(int index) {
                return null;
            }

            @Override
            public Person set(int index, Person element) {
                return null;
            }

            @Override
            public void add(int index, Person element) {

            }

            @Override
            public Person remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Person> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Person> listIterator(int index) {
                return null;
            }

            @Override
            public List<Person> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        foreach (var place in world.GetHabitat().GetDictionaryOfLocations().Keys)
        {
            if (
                    Math.Sqrt(Math.Pow(place.X - person.GetLocation().X, 2) +
                            Math.Pow(place.Y - person.GetLocation().Y, 2)) <= person.GetRewiew())
                NearestCharacters.Add(
                        world.GetDictionaryOfCharacters()[world.GetHabitat().GetDictionaryOfLocations()[place]]);
        }
    }

}
