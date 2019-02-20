package org.fasttrackit;

import org.fasttrackit.pageobjects.ProductGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {
    @Test
    public void addToCartFromSearchResultsTest() {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new WebDriver() {
            @Override
            public void get(String s) {

            }

            @Override
            public String getCurrentUrl() {
                return null;
            }

            @Override
            public String getTitle() {
                return null;
            }

            @Override
            public List<WebElement> findElements(By by) {
                return null;
            }

            @Override
            public WebElement findElement(By by) {
                return null;
            }

            @Override
            public String getPageSource() {
                return null;
            }

            @Override
            public void close() {

            }

            @Override
            public void quit() {

            }

            @Override
            public Set<String> getWindowHandles() {
                return null;
            }

            @Override
            public String getWindowHandle() {
                return null;
            }

            @Override
            public TargetLocator switchTo() {
                return null;
            }

            @Override
            public Navigation navigate() {
                return null;
            }

            @Override
            public Options manage() {
                return null;
            }
        };
        driver.get("https://fasttrackit.org/selenium-test/");

        System.out.println("Opened homepage");

        String keyword = "vase";
        header.search(keyword);

        ProductGrid productGrid = PageFactory.initElements(driver, ProductGrid.class);

        driver.findElement(By.className("input-text")).sendKeys("vase" + Keys.ENTER);
        //driver.findElement(By.partialLinkText("WOMEN")).click();
        String productName = "Herald Glass Vase";
        driver.findElement(By.xpath
                ("//div[@class='product-info' and .//a[text()='" +productName + "']]//button[@title='Add to Cart']"))
                .click();

       String succesMessage = driver.findElement(By.className("success-msg")).getText();

       assertThat("Unexpected succes message", succesMessage, is(productName + " was added to your shopping cart."));

        WebElement productNameInCart = driver.findElement(By.xpath("//"));
    }
}
