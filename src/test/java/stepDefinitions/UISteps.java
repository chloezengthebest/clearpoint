package stepDefinitions;

import base.TestBase;
import com.aventstack.extentreports.GherkinKeyword;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePageCountdown;
import pages.LoginPageCountdown;
import pages.LoginPageTwitter;

import static org.junit.Assert.assertTrue;

public class UISteps extends TestBase {

    @Given("{string} website")
    public void gotoWebsite(String website) throws Throwable {
        System.out.println("Step :: Opening Website");
        scenarioDef.createNode(new GherkinKeyword("Given"), "Website is:: " + website);
        switch (website) {
            case "Countdown":
                driver.get("https://www.countdown.co.nz/");
                Assert.assertEquals("Oops, I went to wrong window", "Countdown - NZ Supermarket - Find A Supermarket Near You", driver.getTitle());
                break;
            case "CountdownLogin":
                driver.get("https://shop.countdown.co.nz/shop/securelogin");
                Assert.assertEquals("Oops, I went to wrong window", "Online Supermarket: Online Grocery Shopping & Free Recipes at shop.countdown.co.nz", driver.getTitle());
                break;
            case "TwitterLogin":
                driver.get("https://twitter.com/login?lang=en");
                LoginPageTwitter loginPageTwitter = new LoginPageTwitter();
                assertTrue(loginPageTwitter.loginPageDisplay());
                break;
            default:
                System.out.println("Website is not been support Yet:: ----" + website);
        }
    }


    @When("I close {string}")
    public void closeWindow(String window) throws Throwable {
        System.out.println("Step :: I close Page:: " + window);
        scenarioDef.createNode(new GherkinKeyword("Given"), "Closing Window:: " + window);
        switch (window) {
            case "easyEmailSignup":
                // verify
                HomePageCountdown homePageCountdown = new HomePageCountdown();
                assertTrue("email window not pops up", homePageCountdown.VerifyEmailFrame());
                // action
                homePageCountdown.CloseEmailSignUpWindow();
                break;
            case "otherWindow":
                //close other window logic goes here
                break;
            default:
                System.out.println("Window is not been support Yet:: ----" + window);
        }
    }

    @Then("I should in {string} Page")
    public void newPageVerify(String page) throws Throwable {
        System.out.println("Step :: I should in " + page + " Page");
        scenarioDef.createNode(new GherkinKeyword("Then"), "page is:: " + page);
        switch (page) {
            case "Countdown":
                HomePageCountdown homePageCountdown = new HomePageCountdown();
                assertTrue("HomePage not been loaded", homePageCountdown.VerifyHomePageDisplayed());
                break;
            case "otherPage":
                /* other page logic added here */
                break;
            default:
                System.out.println("Page is not been support Yet:: ----" + page);
        }
    }

    @When("Login with incorrect {string} and {string} in {string} Page")
    public void login(String username, String password, String page) throws Throwable {
        System.out.println("Step :: Login with incorrect username and password");
        scenarioDef.createNode(new GherkinKeyword("When"), "Login with incorrect username::" + username + " and password:: " + password);
        switch (page) {
            case "Countdown":
                LoginPageCountdown loginPageCountdown = new LoginPageCountdown();
                loginPageCountdown.login(username, password);
                break;
            case "TwitterLogin":
                LoginPageTwitter loginPageTwitter = new LoginPageTwitter();
                loginPageTwitter.login(username, password);
                break;
            default:
                System.out.println("Login step something went wrong---");
        }
    }

    @Then("Error would show up in {string} Page")
    public void loginVerify(String page) throws Throwable {
        System.out.println("Step :: Error would show up");
        scenarioDef.createNode(new GherkinKeyword("Then"), "Error would show up in " + page + "  Page");
        switch (page) {
            case "Countdown":
                LoginPageCountdown loginPageCountdown = new LoginPageCountdown();
                assertTrue("Error not displayed in Countdown Page", loginPageCountdown.errorIsDisplayed());
                break;
            case "TwitterLogin":
                LoginPageTwitter loginPageTwitter = new LoginPageTwitter();
                assertTrue("Error not displayed in TwitterLogin Page", loginPageTwitter.errorIsDisplayed());
                break;
            default:
                System.out.println("Error step something went wrong---");
        }
    }
}
