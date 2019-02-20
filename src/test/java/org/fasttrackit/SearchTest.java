package org.fasttrackit;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {
    @Test
    public void searchByOneKeywordTest(){
      System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
        WebDriver driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());
        driver.findElement(By.className("input-text")).sendKeys("vase" + Keys.ENTER);
        //driver.findElement(By.partialLinkText("WOMEN")).click();

        String keyword = "vase";
        List<WebElement> productNameContainers =
                driver.findElements(By.cssSelector(".product-name>a"));

        for (WebElement container : productNameContainers){
            String productName = container.getText();

       //     System.out.println(productName);

            assertThat ("Some of the products name do not contain the searched keywords", productName, containsString (keyword.toUpperCase()));

        }
    }


}
