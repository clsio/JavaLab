package me.zhang.java.tutorials.lambda;

import me.zhang.java.tutorials.lambda.Person.Gender;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Zhang on 11/26/2017 8:42 PM.
 */
public class PersonTest {

    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();
        roster.add(new Person("Lucy", 23, Gender.FEMALE, "18510728644"));
        roster.add(new Person("Jimmy", 22, Gender.MALE, "18510728643"));
        roster.add(new Person("Kevin", 20, Gender.FEMALE, "18510728642"));
        roster.add(new Person("Zhang", 25, Gender.MALE, "18510728641"));
        roster.add(new Person("Zhang", 25, Gender.MALE, "18510728641"));

        // Specify Search Criteria Code with a Lambda Expression
        Person.printPerson(
                roster,
                person -> person.getGender() == Gender.MALE && person.getAge() > 23,
                person -> person.getName() + ": " + person.getPhone(),
                System.out::println
        );

        processElements(
                roster,
                person -> person.getGender() == Gender.FEMALE && person.getAge() > 20,
                person -> person.getName() + ": " + person.getPhone(),
                System.out::println
        );

        // Aggregate Operations
        roster
                .stream()
                .filter(person -> person.getName().contains("K"))
                .map(person -> person.getName() + ": " + person.getPhone())
                .forEach(System.out::println);

        // Exclude duplicate person
        Set<Person> people = transferElements(roster, HashSet::new);
        System.out.println(people);
    }

    private static <T, Source extends Collection<T>, Dest extends Collection<T>>
    Dest transferElements(Source sourceCollection,
                          Supplier<Dest> collectionFactory) {
        Dest dest = collectionFactory.get();
        dest.addAll(sourceCollection);
        return dest;
    }

    /**
     * A generic version of {@link Person::printPerson} method.
     *
     * @param source a source of objects from the collection source
     * @param tester filters objects that match the Predicate object tester
     * @param mapper maps each filtered object to a value
     * @param block  performs an action on each mapped object as specified by the Consumer object block
     */
    private static <A, B> void processElements(Iterable<A> source,
                                               Predicate<A> tester,
                                               Function<A, B> mapper,
                                               Consumer<B> block) {
        for (A a : source) {
            if (tester.test(a)) {
                B data = mapper.apply(a);
                block.accept(data);
            }
        }
    }

}
