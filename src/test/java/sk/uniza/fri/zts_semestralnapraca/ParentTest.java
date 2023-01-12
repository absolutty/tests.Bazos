package sk.uniza.fri.zts_semestralnapraca;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ParentTest {
    public static final AbstractMap.SimpleEntry<String, String> pair_CHROME_DRIVER = new AbstractMap.SimpleEntry<>(
            "webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe"
    );

    protected WebDriver driver;
    protected Map<String, Object> vars;
    protected JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty(pair_CHROME_DRIVER.getKey(), pair_CHROME_DRIVER.getValue());
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
        driver.manage().window().setSize(new Dimension(989, 666));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    protected void closeCookiesIfNeeded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//button[contains(text(),'Súhlasím')]")
                    )
            );
            driver.findElement(By.xpath("//button[contains(text(),'Súhlasím')]"))
                    .click();

        } catch (NoSuchElementException ex) {
            //cookies already accepted
            System.out.println();
        }
    }

    protected void waitAndClick(String stringCss) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(stringCss)
                )
        );
        driver.findElement(By.cssSelector(stringCss)).click();
    }
}
