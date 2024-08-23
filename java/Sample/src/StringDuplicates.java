import java.util.Arrays;
import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class StringDuplicates {

    public static void removeDuplicates(String str) {
        //str.chars().mapToObj(ch -> (char)ch).collect(Collectors.toSet()).forEach(System.out::print);
        //Arrays.stream(str.split("")).collect(Collectors.toSet()).forEach(System.out::print);
        //Arrays.stream(str.split("")).distinct().toList().forEach(System.out::print);
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        int getAge(){
            return this.age;
        }
    }

    public static void printDuplicates(String str) {
//        char [] arr = str.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : arr) {
//            if (map.containsKey(c)) {
//                map.put(c, map.getOrDefault(c, 0) + 1);
//            } else {
//                map.put(c, 1);
//            }
//        }
//        map.forEach((k, v) -> {
//            if (v > 1) {
//                System.out.print(k + " " + v);
//            }
//        });
        Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(ch->ch, Collectors.counting()))
                .forEach((k,v) ->  {
                    if (v > 1)
                        System.out.print(k + " :: "+ v);
                });
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        removeDuplicates(str);
        printDuplicates(str);

        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        double averageAge = persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.println(averageAge);

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        Map<String, Long> stringCount = words.stream()
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(stringCount);
    }
}
