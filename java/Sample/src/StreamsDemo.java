import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Country {
    private String name;
    private int population;
    private String continent;

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Country(String name, int population, String continent) {
        this.name = name;
        this.population = population;
        this.continent = continent;
    }
}
public class StreamsDemo {
    public static void main(String[] args) {
        Country country1 = new Country("China", 1000, "Asia");
        Country country2 = new Country("India", 2000, "Asia");
        Country country3 = new Country("Poland", 200, "Europe");
        Country country4 = new Country("Finland", 100, "Europe");

        List<Country> countries = Stream.of(country1, country2, country3, country4).toList();
        Map<String, Integer> countryMap = countries
                .stream()
                .collect(Collectors.groupingBy(Country::getContinent, Collectors.summingInt(Country::getPopulation)));
        countryMap.forEach((k,v) -> System.out.println("Continent : " + k + " Total population : " + v));

        Map<String, Integer> map = Stream.of("bla", "blabla", "blablabla").distinct().collect(Collectors.toMap(k->k, String::length));
        map.forEach((k,v) -> System.out.println("Key : " + k + " Value : " + v));
    }
}
