package objects;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PacksysLoginPage {
    WebDriver driver;

    // create a constructor
    public PacksysLoginPage(WebDriver driver){
        this.driver = driver;
    }

    By Username = By.xpath("//input[@id='uxUsername']");
    By Password = By.xpath("//input[@type='password']");
    By LoginBtn = By.xpath("//span[@class='p-button-label']");

    public void LoginDetails (String username, String password){


        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        }



        @SneakyThrows
        public void ClickLoginBtn() {

        driver.findElement(LoginBtn).click();
        Thread.sleep(10);










}}
