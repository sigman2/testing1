package sdtest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class AppTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sigurds\\Desktop\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://timvroom.com/selenium/playground/");

        //1
        driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());
        //2
        driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
        //3
        driver.findElement(By.id("occupation")).sendKeys("Science Fiction Author");
        //4
        int skaits = driver.findElements(By.className("bluebox")).size();
        String skaits2 = Float.toString(skaits);
        driver.findElement(By.id("answer4")).sendKeys(skaits2);
        //5
        driver.findElement(By.linkText("click me")).click();
        //6
        String element = driver.findElement(By.id("redbox")).getAttribute("class");
        driver.findElement(By.id("answer6")).sendKeys(element);
        //7
        ((JavascriptExecutor)driver).executeScript("ran_this_js_function();");
        //8
        Object abc = ((JavascriptExecutor)driver).executeScript("return got_return_from_js_function();");
        String abcd= String.valueOf(abc);
        driver.findElement(By.id("answer8")).sendKeys(abcd);
        //9
        driver.findElement(By.name("wrotebook")).click();
        //10
        String teksts = driver.findElement(By.id("redbox")).getText();
        driver.findElement(By.id("answer10")).sendKeys(teksts);
        //11
        int orangebox = driver.findElement(By.id("orangebox")).getLocation().y;
        int greenbox = driver.findElement(By.id("greenbox")).getLocation().y;
        if(orangebox<greenbox)
            driver.findElement(By.id("answer11")).sendKeys("orange");
        else
            driver.findElement(By.id("answer11")).sendKeys("green");
        //12
        Dimension dimension = new Dimension(850, 650);
        driver.manage().window().setSize(dimension);
        //13
        int i = driver.findElements(By.id("ishere")).size();
        if(i == 0)
            driver.findElement(By.id("answer13")).sendKeys("no");
        else
            driver.findElement(By.id("answer13")).sendKeys("yes");
        //14
        if(driver.findElement(By.id("purplebox")).isDisplayed())
            driver.findElement(By.id("answer14")).sendKeys("yes");
        else
            driver.findElement(By.id("answer14")).sendKeys("no");
        //15
        driver.findElement(By.linkText("click then wait")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(100, MILLISECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("click after wait"))).click();
        //16
        Alert popup = driver.switchTo().alert();
        popup.accept();
        //17
        driver.findElement(By.id("submitbutton")).click();
    }
}