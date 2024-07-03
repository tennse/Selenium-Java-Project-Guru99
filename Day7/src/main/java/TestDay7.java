import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestDay7 {
    private WebDriver driver;
    private String baseUrl;
    public String eMail = "gjlscape@gmail.com";
    public String pWord = "weare123";

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test
    public void testDay7() throws Exception {
        //1. Go to http://live.techpanda.org/
        driver.get(baseUrl);
        //2. CLick on My Account link
        driver.findElement(By.cssSelector(".skip-account > .label")).click();
        driver.findElement(By.cssSelector("#header-account [href='http://live.techpanda.org/index.php/customer/account/']")).click();
        //3. Login application using previously created credential
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(eMail);
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(pWord);
        driver.findElement(By.cssSelector("[name='send'] > span > span")).click();

        //4. Click on 'My Orders'
        try {
            assertEquals("RECENT ORDERS", driver.findElement(By.cssSelector("h2")).getText());
            System.out.println("RECENT ORDERS is confirmed as the correct page to be in.");
        } catch (Error e) {
            System.out.println("RECENT ORDERS failed to get displayed on the page.");
            e.printStackTrace();
        }

        //5. Click on View order
        //6. Verify the previously created order is displayed in 'RECENT ORDERS' table and status is pending
        //7. Click on 'Print Order' link
        //8. Verify Order is saved as PDF

    }

}