package hooks;

import driverManager.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public WebDriver driver;

    @Before(value = "@chrome")
    public void chromeSetUp()
    {
        System.out.println("Before hooks is called to set up chrome driver");
       CreateDriver.getInstance().setDriver("chrome");
       driver= CreateDriver.getInstance().getDriver();
    }

    @Before(value = "@firefox")
    public void firefoxSetUp()
    {
        System.out.println("Before hooks is called to set up firefox driver");
        CreateDriver.getInstance().setDriver("firefox");
        driver= CreateDriver.getInstance().getDriver();
    }

    @After
    public void tearDown()
    {
        System.out.println("After hooks is called to quit driver");
        driver.quit();
    }
}
