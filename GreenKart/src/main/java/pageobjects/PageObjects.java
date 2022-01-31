package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {

  WebDriver driver;


  public PageObjects(WebDriver driver) {
    this.driver = driver;
  }

  By addToCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
  By searchVegetables = By.xpath("//input[@class='search-keyword']");
  By searchVegetablesButton = By.xpath("//button[@class='search-button']");
  By cart = By.xpath("//img[@alt='Cart']");
  By proceedToCheckout = By.xpath("//div[@class='action-block']/button");
  By enterPromoCode = By.xpath("//input[@class='promoCode']");
  By applayPromoCode = By.xpath("//button[@class='promoBtn']");
  By placeOrder = By.xpath("//button[contains(text(),'Place Order')] ");
  By agreeWithTerms = By.xpath("//input[@class='chkAgree']");
  By openCountryList = By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select");
  By chooseCountry = By.xpath("//option[@value='Serbia']");
  By finalProceed = By.xpath("//*[@id=\"root\"]/div/div/div/div/button");
  By numberOfIntemsYouWantToAdd = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/div[2]/input");
  By incrementButtonForItemsYouWantToAdd = By.xpath("//a[@class='increment']");
  By decrementButtonForItemsYouWantToAdd = By.xpath("//a[@class='decrement']");
  By topDealsPage = By.xpath("//div[@class='container-fluid']");
  By buttonForTopDealsPage = By.xpath("//a[@href='#/offers']");

  public WebElement getAddToCartButton() {

    return driver.findElement(addToCartButton);
  }

  public WebElement getSearchVegetables() {

    return driver.findElement(searchVegetables);
  }

  public WebElement getSearchVegetablesButton() {

    return driver.findElement(searchVegetablesButton);
  }

  public WebElement getCart() {
    return driver.findElement(cart);
  }

  public WebElement getProceedToCheckoutButton() {
    return driver.findElement(proceedToCheckout);
  }

  public WebElement getEnterPromoCodeSection() {
    return driver.findElement(enterPromoCode);
  }

  public WebElement getApplayPromoCodeButton() {
    return driver.findElement(applayPromoCode);
  }

  public WebElement getPlaceOrder() {
    return driver.findElement(placeOrder);
  }

  public WebElement getAgreeWithTerms() {
    return driver.findElement(agreeWithTerms);
  }

  public WebElement getChooseCountry() {
    return driver.findElement(chooseCountry);
  }

  public WebElement getOpenCountryList() {
    return driver.findElement(openCountryList);
  }

  public WebElement getFinalProceed() {
    return driver.findElement(finalProceed);
  }

  public WebElement getnumberOfIntemsYouWantToAdd() {
    return driver.findElement(numberOfIntemsYouWantToAdd);
  }

  public WebElement getIncrementButton() {
    return driver.findElement(incrementButtonForItemsYouWantToAdd);
  }

  public WebElement getDecrementButton() {
    return driver.findElement(decrementButtonForItemsYouWantToAdd);
  }

  public WebElement getButtonForTopDeals() {
    return driver.findElement(buttonForTopDealsPage);
  }

  public WebElement getTopDealsPage() {
    return driver.findElement(topDealsPage);
  }

}
