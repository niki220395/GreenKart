package org.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.PageObjects;
import resources.base;

public class FeaturesTesting extends base {

  List<WebElement> listOfSearchedProducts;

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
    driver.manage().window().maximize();

  }

  //Test 1
  @Test(dataProvider = "getData")
  public void searchingForVegetables(String itemName) throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    PageObjects pageObjects = new PageObjects(driver);
    pageObjects.getSearchVegetables().sendKeys(itemName);
    listOfSearchedProducts = driver.findElements(By.xpath("//div[@class='product']"));
    Assert.assertTrue(
        driver.findElement(By.xpath("//*[contains(text(),'" + itemName + "')]")).isDisplayed());
    Assert.assertEquals(listOfSearchedProducts.size(), 1);
    Thread.sleep(3000);
  }

  //Test2
  @Test(enabled = false)
  public void checkIncrementAndDecrementButton() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    PageObjects pageObjects = new PageObjects(driver);
    String initialNumberOfItems = pageObjects.getnumberOfIntemsYouWantToAdd().getAttribute("value")
        .toString();
    pageObjects.getIncrementButton().click();
    Thread.sleep(3000);

    String valueAfterIncrement = pageObjects.getnumberOfIntemsYouWantToAdd().getAttribute("value")
        .toString();
    Assert.assertNotEquals(valueAfterIncrement, initialNumberOfItems);
    pageObjects.getDecrementButton().click();
    Thread.sleep(3000);
    String valueAfterDecrement = pageObjects.getnumberOfIntemsYouWantToAdd().getAttribute("value")
        .toString();
    Assert.assertEquals(initialNumberOfItems, valueAfterDecrement);
  }

  //Test 3
  @Test(enabled = false)
  public void checkIfTopDealsPageWork() throws InterruptedException {
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    PageObjects pageObjects = new PageObjects(driver);
    pageObjects.getButtonForTopDeals().click();
    String currentWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();
    Iterator<String> i = allWindows.iterator();
    while (i.hasNext()) {
      String childWindow = i.next();
      if (!childWindow.equalsIgnoreCase(currentWindow)) {
        driver.switchTo().window(childWindow);
        System.out.println("The child window is presen");
        Assert.assertTrue(pageObjects.getTopDealsPage().isDisplayed());
        driver.close();
      }

    }

  }

  @DataProvider
  public Object[][] getData() {
    Object[][] data = new Object[1][1];
    data[0][0] = "Cucumber";
    return data;
  }

  @AfterTest
  public void terminate() {
    driver.close();
  }

}
