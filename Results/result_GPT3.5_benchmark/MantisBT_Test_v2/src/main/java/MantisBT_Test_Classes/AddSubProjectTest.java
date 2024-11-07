package MantisBT_Test_Classes;

//import config.DriverConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import MantisBT_Test_Classes.sql.Constants;
//import testcases.mantisbt.model_based_dataset.po.Project;

import java.util.concurrent.TimeUnit;

public class AddSubProjectTest {
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver",
                "D:\\anaconda3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(Constants.BASE_URL);
        // Login User Administrator
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(Constants.Mantisbt_ADMIN_USER_NAME);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(Constants.Mantisbt_ADMIN_PASSWORD);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);
        // TODO: Project.addProject("Project001");
        // TODO: Project.addProject("SubProject001");
        // TODO: Project.cleanSubProject();
    }

    @Test(priority = 0)
    public static void subProjectTest() throws Exception {
        // Sub Project One
        driver.findElement(By.xpath("//a[text()='Manage']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='Manage Projects']")).click();
        driver.findElement(By.xpath("//a[text()='Project001']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@value='Create New Subproject']")).click();
        Thread.sleep(2000);

        WebElement dropdown1 = driver.findElement(By.name("status"));
        Select dropdownEle1 = new Select(dropdown1);
        dropdownEle1.selectByVisibleText("release");
        Thread.sleep(1000);

        WebElement dropdown2 = driver.findElement(By.name("view_state"));
        Select dropdownEle2 = new Select(dropdown2);
        dropdownEle2.selectByVisibleText("public");
        Thread.sleep(1000);

        driver.findElement(By.name("name")).sendKeys("SubProject001");
        driver.findElement(By.name("description")).sendKeys("Description Description Description");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }

    public static void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}