package Test_Scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.PacksysLoginPage;
import objects.deliveriesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestMethods_BulkReceipts {

//    PacksysLoginPage objectRepo;
//    deliveriesPage deliveriespge;
    WebDriver driver;

    @BeforeTest
    public void beforetest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://packsys-qa-3.citrii-software.co.za/login");
    }
    @Test(priority = 1)
    public void packsysLogin(){

        PacksysLoginPage packsysLoginPage = new PacksysLoginPage(driver);
        packsysLoginPage.LoginDetails("SuperAdmin", "y9YxQVqu@%N#Bg%x");
        packsysLoginPage.ClickLoginBtn();

    }
    @Test(priority = 2)
    public void CreateBulkRecpt(){

        deliveriesPage  deliveriespge = new deliveriesPage(driver);
        deliveriespge.clickOnBulkReceipts();
        deliveriespge.ClickNewReceiptBtn();
        deliveriespge.Selectproducer("SB");
        deliveriespge.EnterFarmReference("Test");
        deliveriespge.EnterTruckRegNumber("CAA 0012");
        deliveriespge.EnterDriverName("Peter");
        deliveriespge.ClickSaveBtn();

    }


    @AfterTest
    public void afterTest(){
        driver.quit();

    }
}
