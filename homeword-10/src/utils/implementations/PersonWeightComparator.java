package utils.implementations;

import models.Person;

import java.util.Comparator;

public class PersonWeightComparator implements Comparator<Person> {
    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Integer.compare(firstPerson.getWeight(), secondPerson.getWeight());
    }
}
