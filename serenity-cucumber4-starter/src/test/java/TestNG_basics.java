import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.time.Duration;

public class TestNG_basics {

   public WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://packsys-qa-3.citrii-software.co.za/login");

    }

    @Test(priority = 1)
    public void PacksysLogin() throws InterruptedException {

        String Pass = "//input[@type='password']";
        String Usernam = "//input[@id='uxUsername']";

        driver.findElement(By.xpath(Usernam)).click();

        driver.findElement(By.xpath(Usernam)).sendKeys("SuperAdmin");

        driver.findElement(By.xpath(Pass)).sendKeys("y9YxQVqu@%N#Bg%x");

        String LGNBTN = "//span[@class='p-button-label'] ";
        driver.findElement(By.xpath(LGNBTN)).click();
       // Thread.sleep(Duration.ofMinutes(5));
    }
    @Test(priority = 2)
    public void createBulkReceipts() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));

        driver.findElement(By.xpath("//*[@id=\"main\"]/app-main/div/div[2]/app-sidebar/citrii-menu/div/div/div[1]/ul/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"BulkReceipts_header\"]")).click();

        String Popup = "//button[@class='p-element p-button-success green-button p-button p-component']";
        String WebElement_NewReceipt = " //span[normalize-space()='New Receipt']";
        String Farmreference = "//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[5]/div/div[3]/input";

        driver.findElement(By.xpath(Popup)).click();
        driver.findElement(By.xpath(WebElement_NewReceipt)).click();
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[4]/div/div[3]/div/div/p-autocomplete")));
        select.selectByVisibleText("SB");


      //  driver.findElement(By.xpath("//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[4]/div/div[3]/div/div/p-autocomplete/span/input")).sendKeys("SB");
        driver.findElement(By.xpath(Farmreference)).sendKeys("Test");
        driver.findElement(By.xpath("//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[8]/div/div[3]/input")).sendKeys("CAA 3080");
        driver.findElement(By.xpath("//*[@id=\"p-tabpanel-0\"]/receipt/form/div/packsys-input[9]/div/div[3]/input")).sendKeys("Michael");
        driver.findElement(By.xpath("//*[@id=\"main\"]/app-main/div/div[3]/main/bulk-receipts/div/div[1]/div[3]/div[2]/button")).click();


    }






}


