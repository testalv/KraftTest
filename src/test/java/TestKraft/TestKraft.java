package TestKraft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestKraft extends BaseTest {

    //  Set url for yandex
    private String url = "https://www.google.com/";

    @Test
    public void yandexTest() {
//      Open google URL in browser
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url, "Step01 open google PASSED");

//      Enter query to search field and search
        WebElement searchField = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        searchField.sendKeys("yandex.ru");
        searchField.submit();
        System.out.println("Step02 search for yandex.ru PASSED");

//      Find valid result
        WebElement yandexLink = driver.findElement(By.xpath("//div[@id='search']"));
        WebElement element = yandexLink.findElement(By.tagName("a"));
        Assert.assertEquals(element.getAttribute("href"), "https://www.yandex.ru/");
        System.out.println("Step03 find first link PASSED");
    }
}