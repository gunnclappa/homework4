package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {

    @BeforeAll
    static void configure() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void githubTest() {
        // Open Selenide github page
        open("selenide/selenide/");

        // Open Wiki page
        $("#wiki-tab").click();

        // Check that Wiki contains SoftAssertions page and open it
        $(".wiki-more-pages-link button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $(By.linkText("SoftAssertions")).click();

        // Check that SoftAssertions contains JUnit5 code example
        $("#wiki-body").shouldHave(text("Using JUnit5"));

    }

}
