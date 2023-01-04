package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class deliveriesPage {

 public   WebDriver driver;

    public deliveriesPage (WebDriver driver){
        this.driver = driver;

    }
    By BulkReceiptsIcon = By.xpath("//*[@id=\"main\"]/app-main/div/div[2]/app-sidebar/citrii-menu/div/div/div[1]/ul/li[1]/div");
    By BulkReceiptText = By.xpath("//*[@id=\"BulkReceipts_header\"]");
    By CreateNewReceiptBtn = By.xpath("//span[normalize-space()='New Receipt']");
    By FarmReference = By.xpath("//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[5]/div/div[3]/input");
    By TruckRegNumber = By.xpath("//packsys-input[@header='Truck Registration Number']//input[@type='text']");
    By DriverName = By.xpath("//div[@class='last-line receipt-row ng-invalid ng-touched ng-dirty']//input[@type='text']");
    By SaveBtn = By.xpath("//div[@class='packsys-button']//span[@class='p-button-label'][normalize-space()='Save']");
    By dropdownProducer = By.xpath("//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[4]/div/div[3]/div/div/p-autocomplete/span/button");
    By producerSelect = By.xpath("//*[@id=\"p-highlighted-option\"]");



    /*
    FluentWait<WebDriver> fluentwait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);
    */
    // capture page webelements
    public void  clickOnBulkReceipts(){

        try {
            Thread.sleep(1000);
            driver.findElement(BulkReceiptsIcon).click();
            driver.findElement(BulkReceiptText).click();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  Thread.sleep(5000);
    }

    public void ClickNewReceiptBtn(){
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.presenceOfElementLocated(CreateNewReceiptBtn));
       driver.findElement(CreateNewReceiptBtn).click();

    }

    public void EnterFarmReference(String Farmref){
        driver.findElement(FarmReference).sendKeys(Farmref);

    }

    public void EnterTruckRegNumber(String  TruckReg){
        driver.findElement(TruckRegNumber).sendKeys(TruckReg);
    }
    public void EnterDriverName(String drivername){
        driver.findElement(DriverName).sendKeys(drivername);

    }
    public void ClickSaveBtn(){
        driver.findElement(SaveBtn).click();
    }

    public void Selectproducer(String producerName){
        driver.findElement((dropdownProducer)).click();
        driver.findElement(producerSelect).click();

      //  Select na = new Select (driver.findElement(producerSelect));
      //  na.selectByVisibleText(producerName);
    }
}
