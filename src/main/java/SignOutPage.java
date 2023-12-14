import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignOutPage extends BasePage{
    private By questionLocator = By.xpath("//h1[text()=\"Select account to sign out\"]");

    public SignOutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getQuestionElement() {
        return driver.findElement(questionLocator);
    }
}
