import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.lina.pageObject.HomePage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class GoogleSearchTest {

  static Properties googleSearch = new Properties();
  static String gsearch = "";

  @BeforeAll
  @DisplayName("Pre-Test setup")
  public static void setup() {
    Configuration.timeout = 18000;
    open("https://google.com/");
  }

  static Stream<String> stringProvider() throws IOException {
    ClassLoader classLoader = GoogleSearchTest.class.getClassLoader();
    if (System.getProperty("property") != null) {
      InputStream input = new FileInputStream(System.getProperty("property"));
      googleSearch.load(input);
      gsearch = googleSearch.getProperty("search");
      return Stream.of(gsearch.split(","));
    } else {
      try (InputStream inputStream = classLoader.getResourceAsStream("gsearch.properties")) {
        googleSearch.load(inputStream);
        gsearch = googleSearch.getProperty("search");
        return Stream.of(gsearch.split(","));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return null;
  }

  @ParameterizedTest(name = "#{index} - Google Search for : {0}")
  @MethodSource("stringProvider")
  public void googleSearchTest(String stringToSearch) {
    HomePage.searchGoogle(stringToSearch);
  }
}
