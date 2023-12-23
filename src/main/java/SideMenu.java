import helpers.Level;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.ColorPrinter.printColorMessage;

public class SideMenu extends BasePage{
    private final static String TITLE = "Side menu";

    public SideMenu(WebDriver driver) {
        super(driver, TITLE);
    }

    private By repositoryLocator = By.xpath("(//li//ul/li/a/span[2])[1]");

    public IssuesTab goToRepositoryTab() {
        Assertions.assertTrue(driver.findElement(repositoryLocator).isDisplayed());
        driver.findElement(repositoryLocator).click();
        printColorMessage("Repository page opened", logger, Level.INFO);
        return new IssuesTab(driver);
    }
}
