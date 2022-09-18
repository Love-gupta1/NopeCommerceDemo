package Page;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ComputerPage {
    static WebDriver driver;
    public static String path;
    By ComputerHyperlink = By.xpath("//a[text()='Computers']");
    By Notebook = By.xpath("//a[text()='Notebooks']");
    By Product = By.xpath("//a[contains(text(),'Asus N551JK-X0076H Laptop')]");
    By Cart2 = By.xpath("//button[@id='add-to-cart-buttons-5'] ");
    By Shoppingcart = By.xpath("//a[@class='ico-cart'] ");
    By Checkbox = By.xpath("//input[contains(@name,'termsofservice')] ");
    By Checkout = By.xpath("//button[@name='checkout'] ");
    By RegisterButton = By.xpath("//button[text()='Register'] ");
    By Gender = By.xpath("//input[@id='gender-male']");

    public ComputerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void computer() throws IOException {
        path = System.getProperty("user.dir") + "";
        FileInputStream prop1 = null;
        try{
            prop1 = new FileInputStream(path);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String username = sheet.getRow(1).getCell(0).getStringCellValue();
        String  pwd = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.manage().window().maximize();
        driver.findElement(ComputerHyperlink).click();
        driver.findElement(Notebook).click();
        driver.findElement(Product).click();
        driver.findElement(Cart2).click();
        driver.findElement(Shoppingcart).click();
        driver.findElement(Checkbox).click();
        driver.findElement(Checkout).click();
        driver.findElement(RegisterButton).click();
        driver.findElement(Gender).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='content-header']/h1")).getText(), "Dashboard");
    }
    }
