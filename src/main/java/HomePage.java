import helpers.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class HomePage extends BasePage{
    private By signInButtonLocator = By.xpath("(//a[contains(text(), \"Sign in\")])[2]");
    private final static String TITLE = "Home Page";

    public HomePage(WebDriver driver) {
        super(driver, TITLE);
    }

    public LoginPage goToLoginPage() {
        webDriverWait.until(elementToBeClickable(driver.findElement(signInButtonLocator)));
        driver.findElement(signInButtonLocator).click();
        printColorMessage("Sign in page opened", logger, Level.INFO);
        return new LoginPage(driver);
    }
}
