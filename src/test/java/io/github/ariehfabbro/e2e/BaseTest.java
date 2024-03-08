package io.github.ariehfabbro.e2e;

import static io.github.ariehfabbro.config.ConfigurationManager.config;

import io.github.ariehfabbro.factory.BasePageFactory;
import io.github.ariehfabbro.factory.BrowserFactory;
import io.github.ariehfabbro.page.LoginPage;
import io.github.ariehfabbro.util.TestListener;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest {

    private final WebDriver driver =
            BrowserFactory.valueOf(config().browser().toUpperCase()).getDriver();
    protected LoginPage loginPage;

    protected String getTestDataFilePath(String path) {
        return config().baseTestDataPath() + path;
    }

    protected String getScreenshotFilePath(String path) {
        return config().baseScreenshotPath() + path;
    }

    @BeforeClass(alwaysRun = true)
    public void setup() {
        loginPage = BasePageFactory.createInstance(driver, LoginPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
