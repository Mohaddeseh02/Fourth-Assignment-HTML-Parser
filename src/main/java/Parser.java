import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        // Sort countries alphabetically (least)
        sortedByName.sort(Comparator.comparing(Country::getName));
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        sortedByPopulation.sort(Comparator.comparing(Country::getPopulation).reversed());
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        sortedByArea.sort(Comparator.comparing(Country::getArea).reversed());
        return sortedByArea;
    }

    public void setUp() throws IOException {

        File htmlFile = new File( "C:/Users/hp/Desktop/AP/Fourth-Assignment-HTML-Parser/src/Resources/country-list.html");


        Document doc = Jsoup.parse(htmlFile, "UTF-8");

        Elements countryDivs = doc.select(".country");




        for(Element div : countryDivs) {

            String name = div.select(".country-name").text();
            String capital = div.select(".country-capital").text();

            int population = Integer.parseInt(div.select(".country-population").text());

            double area = Double.parseDouble(div.select(".country-area").text());

            Country country = new Country(name, capital, population, area);
            countries.add(country);
        }
    }

    public static void main(String[] args) {
        //you can test your code here before you run the unit tests ;)
    }
}
