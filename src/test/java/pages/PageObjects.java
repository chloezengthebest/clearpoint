package pages;

import org.openqa.selenium.By;

public class PageObjects {
    // countdown
    public static By username_cd = By.id("loginID");
    public static By password_cd = By.id("password");
    public static By invalidLoginErrorFlag_cd = By.xpath("//span[contains(text(),'invalid email and/or password') and @id = 'alertLabel']");
    public static By emailFrame_cd = By.id("easyEmailSignup-iframe");
    public static By emailFieldOnFrame_cd = By.id("email");
    public static By closeButtonOnFrame_cd = By.xpath("//button[@class='close']");
    public static By signInButtonHomePage_cd = By.xpath("//a[@id = 'signInButton' and contains(@title,'Sign in')]");
    public static By countdownicon_cd = By.xpath("//div[@id='logo']");

    // twitter
    public static By username_twitter = By.xpath("//input[@name='session[username_or_email]' and @type='text']");
    public static By password_twitter = By.xpath("//input[@name='session[password]' and @type='password']");
    public static By invalidLoginErrorFlag_twitter = By.xpath("//span[contains(text(),'you entered did not match our records.')]");
    public static By loginTitle_twitter = By.xpath("//span[contains(text(),'Log in to Twitter')]");
}
