import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestDay5 {
    private WebDriver driver;
    private String baseUrl;
public String firstname = "ASELOLE";
public String lastname = "ASELOLE2";
public String eMail = "gjlscape@gmail.com";

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test
    public void testDay5() throws Exception {
        //1. Go to http://live.techpanda.org/
        driver.get(baseUrl);
        //2. Click on my account link
        driver.findElement(By.cssSelector(".skip-account > .label")).click();
        //3. Click Create Account link and fill New User Information except Email ID
        driver.findElement(By.cssSelector("[href='http://live.techpanda.org/index.php/customer/account/create/']")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys(firstname);
        driver.findElement(By.cssSelector("#lastname")).sendKeys(lastname);
        driver.findElement(By.id("email_address")).clear();
        driver.findElement(By.id("email_address")).sendKeys(eMail);
        driver.findElement(By.cssSelector("#password")).sendKeys("weare123");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("weare123");
        Thread.sleep(2000);

        //4. Click Register
        driver.findElement(By.cssSelector(".button[title='Register']")).click();
        //5. Verify Registration is done
        String vWelcome = ("WELCOME, " + firstname + " " + lastname + "!");
        String tWelcome = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[1]/div/p")).getText();
        System.out.println("tWelcome = " + tWelcome);

        try {
            assertEquals(tWelcome, vWelcome);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //6. Go to TV Menu
        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
        Thread.sleep(2000);

        //7. Add Product in your wish list
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
        Thread.sleep(2000);

        //8. Click Share Wishlist
        driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]/span/span")).click();
        Thread.sleep(2000);

        //9. In next page enter Email and a message and click SHARE WISHLIST
        driver.findElement(By.id("email_address")).clear();
        driver.findElement(By.id("email_address")).sendKeys("tentrading1551@gmail.com");
        driver.findElement(By.id("message")).clear();
        driver.findElement(By.id("message")).sendKeys("Training");
        Thread.sleep(2000);

        //10. Check wishlist is shared
        driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
        Thread.sleep(2000);

        String eWishlist = ("Your Wishlist has been shared.");
        String aWishlist = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();

        System.out.println("aWishlist =" + aWishlist);

        try {
            assertEquals(aWishlist, eWishlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}