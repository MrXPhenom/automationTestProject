import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class IssuesTab extends BasePage {

    private By newIssueButton = By.xpath("//*[contains(text(), 'New issue')]");

    private By issuesTab = By.id("issues-tab");

    private By issuesTabName = By.xpath("//*[contains(text(), 'Label issues')]");

    public WebElement getIssuesTabName() {
        return driver.findElement(issuesTabName);
    }

    public IssuesTab(WebDriver driver) {
        super(driver);
    }

    public MainPage openNewIssue() {
        Assertions.assertTrue(driver.findElement(newIssueButton).isDisplayed());
        webDriverWait.until(elementToBeClickable(driver.findElement(newIssueButton)));
        driver.findElement(newIssueButton).click();
        return new MainPage(driver);
    }

    public IssuesTab goToIssuesTab() {
        Assertions.assertTrue(driver.findElement(issuesTab).isDisplayed());
        webDriverWait.until(elementToBeClickable(driver.findElement(issuesTab)));
        driver.findElement(issuesTab).click();
        return new IssuesTab(driver);
    }
}