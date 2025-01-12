package Collabtive_Test_Classes;

//import config.DriverConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Collabtive_Test_Classes.sql.Constants;
import Collabtive_Test_Classes.sql.Login;
//import testcases.collabtive.model_based_dataset.po.Project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class AddProjectTest {

    WebDriver driver;

    @BeforeMethod
    void setUp() throws IOException, SQLException, ClassNotFoundException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\anaconda3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get(Constants.BASE_URL);
        Login.login(driver,Constants.Collabtive_ADMIN_USER_NAME,Constants.Collabtive_ADMIN_PASSWORD);
        //TODO: Project.deleteProject("huzaim");
    }

    @Test(priority = 1)
    void addProject1() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"add_butn_myprojects\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("huzaim");
        driver.findElement(By.xpath("//*[@id=\"desc_ifr\"]")).sendKeys("final ride");
        driver.findElement(By.xpath("//*[@name=\"end\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[7]/td[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"add_project\"]/table/tbody/tr[8]/td/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"budget\"]")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id=\"1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"form_addmyproject\"]/div/form/fieldset/div[9]/button[1]")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector(".info_in_green")).getText(), ("Project was added"));
    }
    @AfterMethod
	public void end(){
		driver.quit();
	}
}
