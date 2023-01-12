package sk.uniza.fri.zts_semestralnapraca;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ParentTest {
    public static final String WEBSITE_URL = "https://www.bazos.sk/";
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

        driver.get(WEBSITE_URL);
        driver.manage().window().setSize(new Dimension(989, 666));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
