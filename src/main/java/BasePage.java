import helpers.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helpers.ColorPrinter.printColorMessage;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Logger logger;
    protected String title;

    public BasePage(WebDriver driver, String title){
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.title = title;
        this.logger = LogManager.getLogger(this.title);
        printColorMessage("Page object of " + title + this.getClass().getName(), logger, Level.DEBUG);
    }
}
