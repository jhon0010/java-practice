package features_versions.eight_8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WhoIsTheCelebrity {


    /**
     * Problem: Find the Celebrity
     * - In a team of N people, a celebrity is known by everyone but he/she doesn't know anybody.
     *
     * - Model People
     * -
     *
     *  Team = Juan, Jhon, Michael
     *
     */


    public static void main(String[] args) {

        Person juan = new Person("Juan", null);
        Person jhon = new Person("Jhon", null);
        Person michael = new Person("Michael", null);

        List<Person> juansReferencePeople = Arrays.asList(michael);
        List<Person> jhonReferencePeople = Arrays.asList(michael, juan);
        List<Person> michaelReferencePeople = new ArrayList<>();

        juan.setPeopleReference(juansReferencePeople);
        jhon.setPeopleReference(jhonReferencePeople);
        michael.setPeopleReference(michaelReferencePeople);

        try {
            Optional<Person> person = whoIsTheCelebrity(Arrays.asList(juan, jhon, michael));
            System.out.println( "the celebrity is = " + person.orElse(new Person("No celebrity", null)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static Optional<Person> whoIsTheCelebrity(List<Person> people) throws Exception {

        Optional<Person> personWithNoReferences = people.stream()
                                                .filter(person -> person.peopleReference.isEmpty()).findFirst();

        if (!personWithNoReferences.isPresent()) {
            throw new Exception("There is no celebrity in this group of people");
        }

        Optional<Person> noReferenceToCelebrity = people.stream()
                .filter(p -> !p.getName().equals(personWithNoReferences.get().getName()))
                .filter(p -> !p.getPeopleReference().contains(personWithNoReferences.get())).findFirst();

        if(noReferenceToCelebrity.isPresent()){
            throw new Exception("There is no celebrity in this group of people");
        }

        if(!noReferenceToCelebrity.isPresent()){
            try {
                throw new IllegalStateException("Some");
            } catch (IllegalStateException ese) {
                System.out.println(ese.getMessage());
            }

        }

        return personWithNoReferences;
    }


    static class Person {

        private String name;
        private List<Person> peopleReference;

        public Person(String name, List<Person> peopleReference) {
            this.name = name;
            this.peopleReference = peopleReference;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Person> getPeopleReference() {
            return peopleReference;
        }

        public void setPeopleReference(List<Person> peopleReference) {
            this.peopleReference = peopleReference;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
