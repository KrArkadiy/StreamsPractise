package main.java.krylosov.arkadiy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class FirstTask {

    public int streamGetResultWithSum(List<Integer> incomingData) {
        return incomingData.stream().mapToInt(s -> s).sum();
    }

    public Integer streamGetResultWithReduce(List<Integer> incomingData) {
        return incomingData.stream().reduce(Integer::sum).orElse(0);
    }

    public List<Person> streamGetListOfPersons(List<Person> incomingData) {
        return incomingData.stream().filter(s -> s.getAge() > 18).collect(Collectors.toList());
    }

    public long streamGetCountByName(List<Person> incomingData, String necessaryName) {
        return incomingData.stream().filter(s1 -> s1.getName().equals(necessaryName)).count();
    }

    public List<Cat> streamGetCatsPersonOwns(List<PersonWithCat> incomingData) {
        return incomingData.stream().flatMap(e -> Arrays.stream(e.getCats())).collect(Collectors.toList());
    }

    public List<Cat> streamGetCatsPersonWithExactNameAndAgeOwns(List<PersonWithCat> incomingData, PersonWithCat necessaryPerson) {
        return incomingData.stream()
                .filter(s1 -> s1.getName().equals(necessaryPerson.getName()) && s1.getAge() > 18)
                .collect(Collectors.toList())
                .stream()
                .flatMap(s1 -> Arrays.stream(s1.getCats()))
                .collect(Collectors.toList());
    }

    public Map<Person, Cat[]> streamGetMapOfCatsAndPersons(List<PersonWithCat> incomingData) {
        return incomingData.stream().collect(Collectors.toMap(person-> new Person(person.getAge(), person.getName()), PersonWithCat::getCats));
    }

    public Map<Integer, String> streamGetMapOfPersons(List<Person> incomingData){
        return incomingData.stream().collect(Collectors.toMap(Person::getAge, Person::getName));
    }

    public String scale(String strng, int k, int v){
        if(strng.length() == 0){
            return strng;
        }
        String[] array = strng.split("\n");
        String result = Arrays.stream(array)
                .map(e->Arrays.stream(e.split(""))
                        .map(f->f.repeat(k))
                        .collect(Collectors.joining()))
                .map(h->(h+"\n").repeat(v))
                .collect(Collectors.joining());

        return result;
    }

    public static String decode(String morseCode) {
        String[] array = morseCode.split(" ");
        String temp = Arrays.stream(array)
                .map(e->MorseCode.get(e)).collect(Collectors.joining());
        String result = Stream.of(temp)
                .map(f->f.replace("null"," "))
                .map(e->e.replaceAll("[\\s]{2,}", " "))
                .collect(Collectors.joining());

        return result;

    }
}
