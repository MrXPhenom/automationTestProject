import helpers.Level;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.ColorPrinter.printColorMessage;

public class MainPage extends BasePage {
    private By imgLocator = By.xpath("(//img[@class='avatar circle'])[1]");

    private By menuButton = By.xpath("(//header[@class=\"AppHeader\"]//div/div//button[1])[1]");
    private final static String TITLE = "Main Page";

    public MainPage(WebDriver driver) {
        super(driver, TITLE);
    }

    public WebElement getLogoOnTheMainPage() {
        return driver.findElement(imgLocator);
    }

    public WebElement getSideMenuLogo(){
        return driver.findElement(menuButton);
    }

    public ProfileForm goToProfileForm() {
        printColorMessage(TITLE + " is opened", logger, Level.INFO);
        Assertions.assertTrue(driver.findElement(imgLocator).isDisplayed());
        driver.findElement(imgLocator).click();
        return new ProfileForm(driver);
    }

    public SideMenu goToSideMenu() {
        Assertions.assertTrue(driver.findElement(menuButton).isDisplayed());
        driver.findElement(menuButton).click();
        return new SideMenu(driver);
    }
}
