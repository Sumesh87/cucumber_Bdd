package stepDef;

import driverManager.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import java.util.List;
import java.util.Map;

public class LoginStepDef {

    public WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @Given("User has launched the url {string}")
    public void launchUrl(String string) {
        driver= CreateDriver.getInstance().getDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        System.out.println("This is from User 1");
       }


    @When("user logged in with valid credentials as below")
    public void enterCredentials(DataTable dataTable) {
        List<Map<String, String>> credentails= dataTable.asMaps(String.class, String.class);

        loginPage =new LoginPage( driver);
        loginPage.userName.sendKeys(credentails.get(0).get("userName"));
        loginPage.password.sendKeys(credentails.get(0).get("password"));

    }
    @When("user clicked login")
    public void clickLogin() throws InterruptedException {
        loginPage.loginButton.click();
        Thread.sleep(5000);

    }
    @Then("User should be navigated to home page")
    public void navigateToHome() {
        // Write code here that turns the phrase above into concrete actions
        dashboardPage=new DashboardPage(driver);
        String expected ="Products";
        String actualTxt=dashboardPage.productLabel.getText();
        Assert.assertEquals(expected, actualTxt);
        System.out.println("Assertion is success : " +  actualTxt);
    }

}
