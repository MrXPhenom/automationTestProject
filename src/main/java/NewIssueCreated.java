import helpers.Level;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helpers.ColorPrinter.printColorMessage;

public class NewIssueCreated extends BasePage{
    private By newIssueCreatedConfirmation = By.xpath("//*[@id=\"partial-discussion-header\"]//span[contains(text(), \"Edit\")]");
    private final static String TITLE = "New issue created page";

    public NewIssueCreated(WebDriver driver) {
        super(driver, TITLE);
    }

    public WebElement getNewIssueCreatedConfirmation() {
        Assertions.assertTrue(driver.findElement(newIssueCreatedConfirmation).isDisplayed());
        printColorMessage("New issue created", logger, Level.INFO);
        return driver.findElement(newIssueCreatedConfirmation);
    }
}
