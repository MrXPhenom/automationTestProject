import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateNewIssue extends BasePage{

    private By newIssueTitleLocator = By.xpath("(//*[@id=\"show_issue\"]//span[contains(text(), \"Edit\")])[1]");

    private By newIssueTitle = By.id("issue_title");

    private By newIssueBody = By.id("issue_body");

    private By submitNewIssueButton = By.xpath("(//button[contains(text(), \"Submit new issue\")])[1]");
    public CreateNewIssue(WebDriver driver) {
        super(driver);
    }

    public WebElement getNewIssueTitle() {
        return driver.findElement(newIssueTitleLocator);
    }

    public CreateNewIssue createNewIssueTab(String titleIssue, String bodyIssue) {
        driver.findElement(newIssueTitle).sendKeys(titleIssue);
        driver.findElement(newIssueBody).sendKeys(bodyIssue);
        driver.findElement(submitNewIssueButton).click();
        return new CreateNewIssue(driver);
    }
}
