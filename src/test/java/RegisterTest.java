import org.testng.annotations.Test;

import static utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() {
        welcomePage.clickLoginButton();

        loginPage.setLoginInput(returnConfigValue("userEmail"));
        loginPage.setPasswordInput(returnConfigValue("password"));
        loginPage.clickEnterButton();

    }
}