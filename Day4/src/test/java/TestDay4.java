import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class TestDay4 {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    //    1. Goto live.techpanda.org
//    2. Click on 'MOBILE' menu
//    3. in mobile products list, click on 'Add To Compare' for 2 mobiles
//    4. Click on 'COMPARE' button.
//    5. Verify the pop-up window and check that the products are reflected in it
//    6. Close the Popup Windows
    @Test
    public void testDay4() throws Exception {
        //    1. Goto live.techpanda.org
        driver.get(baseUrl);
//    2. Click on 'MOBILE' menu
        driver.findElement(By.linkText("MOBILE")).click();
//    3. in mobile products list, click on 'Add To Compare' for 2 mobiles
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();
        String mainMobile1 = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/h2/a")).getText();
        System.out.println("mainMobile1 = " + mainMobile1);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
        String mainMobile2 = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a")).getText();
        System.out.println("mainMobile2 = " + mainMobile2);
        Thread.sleep(1000);

//    4. Click on 'COMPARE' button.
        driver.findElement(By.cssSelector("[title='Compare'] > span > span")).click();
        Thread.sleep(1000);

        // switching to new window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }


//    5. Verify the pop-up window and check that the products are reflected in it
        String strHead = "COMPARE PRODUCTS";
        String compHead = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[1]/h1")).getText();
        System.out.println("strHead = " + compHead);
        String popupMobile1 = driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[1]/h2")).getText();
        String popupMobile2 = driver.findElement(By.xpath("//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[2]/h2/a")).getText();
        System.out.println("popupMobile1 = " + popupMobile1);
        System.out.println("popupMobile2 = " + popupMobile2);
        Thread.sleep(1000);

        try {
            assertEquals(strHead, compHead);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertEquals(popupMobile1, mainMobile1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertEquals(popupMobile2, mainMobile2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Close window
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div[2]/button/span/span")).click();
    }

    @AfterTest
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
