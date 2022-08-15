package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class Setup {

    private WebDriver driver;
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

    public void type(String inputText, By locator) {
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
