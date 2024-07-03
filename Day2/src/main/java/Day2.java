import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Day2 {

    private WebDriver driver;
    private String baseUrl;
    public int scc = 0;

    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        //Step 1 Goto http://live.techpanda.org/
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Test
    public void testDay2() throws Exception {

        // 1. Go to http://live.techpanda.org
        driver.get(baseUrl);
        // 2. Click on Mobile menu
        driver.findElement(By.linkText("MOBILE")).click();

        // 3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
        String XPeriaPrice = driver.findElement(By.cssSelector("span.price")).getText();
        // 4. Click on Sony Xperia mobile
        driver.findElement(By.cssSelector("img#product-collection-image-1")).click();
        // 5. Read the XPeria mobile price from details page
        String detailPrice = driver.findElement(By.cssSelector("span.price")).getText();
        //  Product price in list and details page should be equal ($100)
        try {
            assertEquals(XPeriaPrice, detailPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

}
