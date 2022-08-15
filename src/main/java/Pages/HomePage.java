package Pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import Base.Setup;

public class HomePage {

    private WebDriver driver;

    By MacLink = By.xpath("//*[@id='ac-globalnav']/div/ul[2]/li[3]/a");
    By SearchBtn = By.cssSelector("#ac-gn-link-search");
    By TextCompare = By.xpath("//*[@id='main']/section[2]/div/div/p");
    By Close = By.xpath("//*[@id='ac-ls-close']");
    By Textbox = By.id("ac-gn-searchform-input");
    By Explorar = By.xpath("//*[@id='exploreCurated']/div[1]/div[2]/h2/a");
    By ComprarBtn = By.xpath("//*[@id='chapternav']/div/ul/li[11]/a");

    public WebDriver CreateDriver()	{

        System.setProperty("webdriver.chrome.driver", "src/main/Resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.apple.com.mx");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public void SendText(WebElement element, String value)
    {
        element.sendKeys(value);
    }

    public void Click(WebElement element)
    {
        element.click();
    }

    public void ClickWhenEnabled(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }


    @Test
    public static void main(String[] args) {

        HomePage program = new HomePage();
        WebDriver driver = program.CreateDriver();
        WebElement element;

        element = driver.findElement(program.MacLink);
        program.Click(element);
        System.out.println("Click on Mac Ok");

        element = driver.findElement(program.Close);
        program.Click(element);
        System.out.println("Click on close ubication Ok");

        element = driver.findElement(program.TextCompare);
        Assert.assertTrue("Tan poderosa que vuela.", element.isDisplayed());
        System.out.println("Compare text Ok "+element.getText());

        element = driver.findElement(program.SearchBtn);
        program.Click(element);
        System.out.println("Click on search button Ok");

        element = driver.findElement(program.Textbox);
        program.SendText(element, "iPhone XR");
        element.submit();

        Assert.assertEquals("iPhone XR - Apple (MX)",driver.getTitle());
        System.out.println(driver.getTitle());
        System.out.println("Title was macthed");

        element = driver.findElement(program.Explorar);
        program.Click(element);
        element =driver.findElement(program.ComprarBtn);
        Assert.assertEquals("Comprar el iPhone",element.getText());
        System.out.println(element.getText());

    }

}
