package Test;
import java.io.IOException;
public class ComputerPageTest extends BaseClass {
    public static void main(String[] args) throws InterruptedException, IOException {
        setup();
        pageFactory.computerpage().computer();
    }
}
