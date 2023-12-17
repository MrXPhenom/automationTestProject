import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GitHubTest extends BaseTest{

    @Test
    public void checkLogoOnTheLoginPage() {
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.goToLoginPage().getLogo().isDisplayed(), "Logo is not displayed");
    }

    @Test
    public void checkLoginIsSuccessful() {
        HomePage home = new HomePage(driver);
        home.goToLoginPage().loginSuccessful("alex.meryhold@gmail.com", "alex.meryhold@gmail.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.getLogoOnTheMainPage();
        assertTrue(mainPage.getLogoOnTheMainPage().isDisplayed());
    }

    @Test
    public void checkFailedLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFailed("alex.meryhold@gmail.com", "alex.meryhold@gmail.com1");
        loginPage.validateErrorMessage("Incorrect username or password.");
    }

    @Test
    public void checkLogOutFromGitHub() {
        String expectedQuestionText = "Select account to sign out";
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage().loginSuccessful("alex.meryhold@gmail.com", "alex.meryhold@gmail.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm();
        ProfileForm profileForm = new ProfileForm(driver);
        Assertions.assertEquals(expectedQuestionText, profileForm.signOutFromGitHub().getQuestionElement().getText());
    }

    @Test
    public void checkRepositoriesList() {
        List<String> expReposList = new ArrayList<>();
        expReposList.add("Test2");
        expReposList.add("Test1");
        expReposList.add("Test");

        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage().loginSuccessful("alex.meryhold@gmail.com", "alex.meryhold@gmail.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToProfileForm().goToRepositoriesPage();
        RepositoriesPage repositoriesPage = new RepositoriesPage(driver);
        Assertions.assertEquals(expReposList, repositoriesPage.getRepositories());
    }

    @Test
    public void issuesTabTest(){
        String expectedNewIssueText = "Edit";
        String expectedIssuesTabText = "Label issues and pull requests for new contributors";
        String newIssueCreatedText = "Edit";

        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage().loginSuccessful("alex.meryhold@gmail.com", "alex.meryhold@gmail.com");
        MainPage mainPage = new MainPage(driver);
        mainPage.goToSideMenu().goToRepositoryTab().goToIssuesTab();
        IssuesTab issuesTab = new IssuesTab(driver);
        Assertions.assertEquals(expectedIssuesTabText, issuesTab.getIssuesTabName().getText());
        issuesTab.openNewIssue();
        CreateNewIssue createNewIssue = new CreateNewIssue(driver);
        createNewIssue.createNewIssueTab("Lorem, ipsum dolor.", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Officiis, blanditiis.");
        Assertions.assertEquals(expectedNewIssueText, createNewIssue.getNewIssueTitle().getText());
        NewIssueCreated newIssueCreated = new NewIssueCreated(driver);
        Assertions.assertEquals(newIssueCreatedText, newIssueCreated.getNewIssueCreatedConfirmation().getText());
    }
}
