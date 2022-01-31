package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

  public Properties prop;
  public WebDriver driver;
  public String browserName;

  public WebDriver initializeDriver() throws IOException {
    prop = new Properties();
    FileInputStream fis = new FileInputStream(
        "C:\\Users\\HP Pavilion\\Dropbox\\Testing\\Java dokumentacija\\Idea Projects\\GreenKart\\src\\main\\java\\resources\\properties");
    prop.load(fis);
    browserName = prop.getProperty("browser");
    if (browserName.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver",
          "C:\\Users\\HP Pavilion\\Dropbox\\Testing\\chromedriver.exe");
      driver = new ChromeDriver();
    }
    //Do the modification if you want to expand the numbers of browsers you want to use

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
  }


}
