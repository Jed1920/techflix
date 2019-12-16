package uk.co.techswitch;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {

    @Test
    public void testTechflixHomepage() {
        WebDriver browser = new FirefoxDriver();
        browser.get("http://localhost:3000/");

        WebElement welcomeImg = browser.findElement(By.xpath("//*[@data-testid='welcomeImage']"));
        WebElement welcomeTxt = browser.findElement(By.xpath("//*[@data-testid='welcomeText']"));

        WebElement filmList = browser.findElement(By.xpath("//*[@data-testid='filmList']"));
        List<WebElement> films = filmList.findElements(By.tagName("li"));

        assertThat(welcomeImg).isNotNull();
        assertThat(welcomeTxt).isNotNull();

        assertThat(films).size().isGreaterThan(1);
    }

    @Test
    public void testUserJourney(){
        WebDriver browser = new FirefoxDriver();
        browser.get("http://localhost:3000/");

        WebElement searchBox = browser.findElement(By.id("searchInput"));
        searchBox.sendKeys("Liam");
//        assertThat(searchBox).isNotNull();
        WebElement search = browser.findElement((By.xpath("//*[@data-testid='searchButton']")));
        search.click();
        WebElement peopleCard = browser.findElement(By.xpath("//*[text()='Liam Neeson']"));
        peopleCard.click();



    }
}
