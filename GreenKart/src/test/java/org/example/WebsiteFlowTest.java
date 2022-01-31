package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.PageObjects;
import resources.base;

public class WebsiteFlowTest extends base {

  public List<WebElement> products;
  public String[] vegetablesYouWantToBuy = {"Brocolli - 1 Kg", "Cauliflower - 1 Kg",
      "Cucumber - 1 Kg", "Beetroot - 1 Kg"};
  private static Logger log = LogManager.getLogger(base.class.getName());

  @BeforeTest
  public void initialize() throws IOException {
    driver = initializeDriver();
    driver.get(prop.getProperty("url"));
    driver.manage().window().maximize();

  }

  //Adding items in the cart
  @Test(dataProvider = "getData")
  public void makingOrder(String[] itemName) throws InterruptedException, IOException {
    products = driver.findElements(By.cssSelector("h4.product-name"));
    PageObjects homePageObject = new PageObjects(driver);
    for (int i = 0; i < itemName.length; i++) {
      for (int j = 0; j < products.size(); j++) {
        if (products.get(j).getText().equals(itemName[i])) {
          homePageObject.getAddToCartButton().click();
        }
      }
    }
    homePageObject.getCart().click();
    homePageObject.getProceedToCheckoutButton().click();
    homePageObject.getEnterPromoCodeSection().sendKeys("rahulshettyacademy");
    homePageObject.getApplayPromoCodeButton().click();
    log.info("Promo code applied.");
    homePageObject.getPlaceOrder().click();
    homePageObject.getAgreeWithTerms().click();
    homePageObject.getOpenCountryList().click();
    homePageObject.getChooseCountry().click();
    homePageObject.getFinalProceed().click();
    Thread.sleep(3000);
    log.info("Order is completed");
    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File("C:\\Users\\HP Pavilion\\screenShoot.png"));
    log.info("Screenshot is taken.");


  }

  @DataProvider
  public Object[][] getData() {
    Object[][] data = new Object[1][1];

    data[0][0] = vegetablesYouWantToBuy;

    return data;

  }

  @AfterTest
  public void terminateTest() {
    driver.close();
  }

}
