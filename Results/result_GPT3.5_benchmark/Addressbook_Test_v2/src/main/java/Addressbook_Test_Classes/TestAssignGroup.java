package Addressbook_Test_Classes;

import Addressbook_Test_Classes.sql.Constants;
//import config.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import Addressbook_Test_Classes.sql.Constants;
//import testcases.addressbook.model_based_dataset.po.Group;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestAssignGroup {
	WebDriver driver;
	Random random = new Random();
	int rand_number = random.nextInt(1520000);
	static int expected_row_count = 0;
	private static String downloadPath = "C:\\Users\\A653\\Downloads";

	@BeforeMethod
	public void before() throws IOException, SQLException, ClassNotFoundException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\anaconda3\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.get(Constants.BASE_URL);
		//TODO: Group.addGroup("Suleman Group Demo");
	}

	@Test(priority = 0)
	public void testAssignGroup() throws InterruptedException {
		driver.findElement(By.xpath("//A[@href='group.php'][text()='groups']/self::A")).click();
		driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a")).click();
		Thread.sleep(100);
		driver.findElement(By.cssSelector("[title*='Suleman']")).click();
		Select grp = new Select(driver.findElement(By.name("to_group")));
		grp.selectByVisibleText("Suleman Group Demo");
		driver.findElement(By.xpath("//input[@value='Add to']")).click();
		String message = driver.findElement(By.className("msgbox")).getText();
		System.out.println(message);
		Assert.assertTrue(message.contains("Users added."));
	}

	@AfterTest
	public void end(){
		driver.quit();
	}
}
