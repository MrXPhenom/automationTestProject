import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewIssueCreated extends BasePage{
    private By newIssueCreatedConfirmation = By.xpath("//*[@id=\"partial-discussion-header\"]//span[contains(text(), \"Edit\")]");

    public NewIssueCreated(WebDriver driver) {
        super(driver);
    }

    public WebElement getNewIssueCreatedConfirmation() {
        Assertions.assertTrue(driver.findElement(newIssueCreatedConfirmation).isDisplayed());
        return driver.findElement(newIssueCreatedConfirmation);
    }
}
