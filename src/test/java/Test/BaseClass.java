package Test;
import Page.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
public class BaseClass {
    static WebDriver driver;
    protected static PageFactory pageFactory;
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver.get("https://demo.nopcommerce.com/");
        pageFactory = new PageFactory(driver);
    }
    public void close(){
        driver.close();
    }
    @BeforeClass
    public static void setup(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
            driver.navigate().to("https://demo.nopcommerce.com/"));
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.navigate().to("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        }
    }
}
