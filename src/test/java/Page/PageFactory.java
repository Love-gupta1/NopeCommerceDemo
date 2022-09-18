package Page;
import org.openqa.selenium.WebDriver;
public class PageFactory {
    WebDriver driver;
    private ComputerPage computerpage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ComputerPage computerpage() {
        if (computerpage == null) {
            computerpage = new ComputerPage(driver);
        }
        return computerpage;
    }
}

