package io.github.ariehfabbro.factory;

import static io.github.ariehfabbro.config.ConfigurationManager.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver getDriver() {
            WebDriver driver = new ChromeDriver(getOptions());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config().timeout()));
            driver.manage().window().maximize();

            return driver;
        }

        private ChromeOptions getOptions() {
            ChromeOptions options = new ChromeOptions();

            options.setAcceptInsecureCerts(true);

            if (Boolean.TRUE.equals(config().headless())) {
                options.addArguments("--headless=new");
            }

            return options;
        }
    },

    FIREFOX {
        @Override
        public WebDriver getDriver() {
            WebDriver driver = new FirefoxDriver(getOptions());

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config().timeout()));
            driver.manage().window().maximize();

            return driver;
        }

        private FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();

            options.setAcceptInsecureCerts(true);

            if (Boolean.TRUE.equals(config().headless())) {
                options.addArguments("--headless=new");
            }

            return options;
        }
    };

    public abstract WebDriver getDriver();
}
