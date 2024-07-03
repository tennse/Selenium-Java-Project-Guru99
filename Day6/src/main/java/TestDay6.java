import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDay6 {
    private WebDriver driver;
    private String baseUrl;
    public String uName = "gjlscape@gmail.com";
    public String passWord = "weare123";
    public String address = "ABC";

    public String notelp = "12345678";
    public String city = "New York";
    public String zip = "542896";

    @BeforeTest
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void testDay6() throws Exception {
        //1. Go to techpanda.org
        driver.get(baseUrl);
        //2. Click on My Account link
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[1]/a")).click();
        //3. Login in application using previouusly created credential
        driver.findElement(By.cssSelector("#email")).clear();
        driver.findElement(By.cssSelector("#email")).sendKeys(uName);
        driver.findElement(By.cssSelector("#pass")).clear();
        driver.findElement(By.cssSelector("#pass")).sendKeys(passWord);
        driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
        //4. Click on MY WISHLIST link
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[2]/a")).click();
        //5. in next page click add to cart link
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button/span/span")).click();
        //6. Click Proceed to checkout
        driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[1]/ul/li/button/span/span")).click();
        //7. Enter Shipping Information
//        driver.findElement(By.id("billing:street1")).clear();
//        driver.findElement(By.id("billing:street1")).sendKeys(address);
//        driver.findElement(By.id("billing:city")).clear();
//        driver.findElement(By.id("billing:city")).sendKeys(city);
//        new Select(driver.findElement(By.cssSelector("[name='billing[region_id]']"))).selectByValue("43");
//        driver.findElement(By.id("billing:postcode")).clear();
//        driver.findElement(By.id("billing:postcode")).sendKeys(zip);
//        new Select(driver.findElement(By.cssSelector("[name='billing[country_id]']"))).selectByValue("US");
//        driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys(notelp);
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
        //8. Click Estimate
        //9. Cerify Shipping cost generated

        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        //10. Select Ship[ping Cost, Update Total

        driver.findElement(By.xpath("//*[@id=\"dt_method_checkmo\"]/label")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button")).click();

        //11. Verify shipping cost is added to total
        //12. Click "Proceed to Checkout"
        //13. Enter Billing Information
        //14. In SHipping Method, CLick Continue
        //15. In Payment Information select 'Check/Money Order' radio button. Click COntinue
        //16. Click 'PLACE ORDER' button
        //17. Verify Oder is generated. Note the order number

    }
}
