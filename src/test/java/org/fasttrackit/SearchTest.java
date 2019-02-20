package org.fasttrackit;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.fasttrackit.pageobjects.Header;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

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

        Header header = PageFactory.initElements(driver, Header.class);


        String keyword = "vase";
        header.getSearchField().sendKeys(keyword + Keys.ENTER);
        System.out.println("Pressed enter in search field.");

        List<WebElement> productNameContainers =
                driver.findElements(By.cssSelector(".product-name>a"));

        for (WebElement container : productNameContainers){
            String productName = container.getText();

       //     System.out.println(productName);

            assertThat ("Some of the products name do not contain the searched keywords", productName, containsString (keyword.toUpperCase()));

        }
    }


}
