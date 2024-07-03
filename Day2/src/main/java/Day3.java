import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Day3 {
    private WebDriver driver;
    private String baseUrl;
    public int scc = 0;

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }
//1. Go to http://live.techpanda.org/
//2.    Click on 'Mobile' menu
//3. In the list of all mobile, click on 'ADD TO CART' for Sony Xperia Mobile
//4.Change 'QTY value to 1000 and click 'UPDATE' button
//5.Verify the error message
//6. Then click on 'EMPTY CART' link in the footer of list of all mobiles.
//7, verify cart is empy

    @Test
    public void testDay3() throws Exception {
        //1. Go to http://live.techpanda.org/
        driver.get(baseUrl);

        //2. Click on 'Mobile' menu
        driver.findElement(By.linkText("MOBILE")).click();


        //3. In the list of all mobile, click on 'ADD TO CART' for Sony Xperia Mobile
        driver.findElement(By.cssSelector(".products-grid > li:nth-of-type(3) .actions span > span")).click();
        //4.Change 'QTY value to 1000 and click 'UPDATE' button
        driver.findElement(By.cssSelector("[pattern='\\\\d*(\\\\.\\\\d+)?']")).sendKeys("1000");
        driver.findElement(By.cssSelector("[title='Update'] > span > span")).click();
        //5.Verify the error message
        String reqQty = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
        String msgQty = ("* The requested quantity for \"Sony Xperia\" is not available.");
        try {
            assertEquals(msgQty, reqQty);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //6. Then click on 'EMPTY CART' link in the footer of list of all mobiles.
        driver.findElement(By.cssSelector("#empty_cart_button > span > span")).click();

        //7, verify cart is empty
        String cartEmpyMsg = ("SHOPPING CART IS EMPTY");
        String cartEmpyAct = driver.findElement(By.xpath("//h1[.='Shopping Cart is Empty']")).getText();

        try {
            assertEquals(cartEmpyMsg, cartEmpyAct);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
