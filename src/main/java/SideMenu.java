import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu extends BasePage{

    public SideMenu(WebDriver driver) {
        super(driver);
    }

    private By repositoryLocator = By.xpath("(//li//ul/li/a/span[2])[1]");

    public IssuesTab goToRepositoryTab() {
        Assertions.assertTrue(driver.findElement(repositoryLocator).isDisplayed());
        driver.findElement(repositoryLocator).click();
        return new IssuesTab(driver);
    }
}
