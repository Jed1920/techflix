package uk.co.techswitch;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {

    @Test
    public void testGoogleHomepage() {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://google.com");

        WebElement searchForm = browser.findElement(By.id("searchform"));

        assertThat(searchForm).isNotNull();
    }
}
