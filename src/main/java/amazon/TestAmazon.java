package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestAmazon {

    //xpath strategy
    //tag[@key='value']
    //tag[@key='value' and @key='value']

    public static WebDriver driver;

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        sleepFor(3);
    }

    public void close() {
        sleepFor(3);
        driver.close();
        driver.quit();
    }

    @Test
    public void clickOnAccount() {
        setup();
        sleepFor(3);
        driver.findElement(By.id("nav-link-accountList")).click();
        close();
    }

    @Test
    public void clickOnOrders() {
        setup();
        driver.findElement(By.id("nav-orders")).click();
        close();
    }

    @Test
    public void searchForBooks() {
        setup();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Go']")).click();
        close();
    }

}
