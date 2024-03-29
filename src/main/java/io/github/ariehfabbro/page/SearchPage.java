package io.github.ariehfabbro.page;

import static io.github.ariehfabbro.config.ConfigurationManager.config;

import io.github.ariehfabbro.factory.BasePageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class SearchPage extends BasePage {

    @FindBy(id = "search-field")
    private WebElement txtUsername;

    @FindBy(className = "ast-search-menu-icon")
    private WebElement seachIcon;

    public SearchPage open() {
        driver.get(config().baseUrl());

        return this;
    }

    private void clearAndType(final WebElement elem, final String text) {
        elem.clear();
        elem.sendKeys(text);
    }

    public SearchPage typeSearchText(final String username) {
        clearAndType(txtUsername, username);

        return this;
    }

    public String getErrorMessage() {
        return driver.findElement(By.className("error-message-container"))
                .findElement(By.tagName("h3"))
                .getText();
    }

    public SearchPage clickOnLogin() {
        seachIcon.click();

        return this;
//        return BasePageFactory.createInstance(driver, ProductsPage.class);
    }

    public ResultsPage pressEnter() {
        txtUsername.sendKeys(Keys.RETURN);

//        return this;
        return BasePageFactory.createInstance(driver, ResultsPage.class);
    }

    public ResultsPage DoASearch(String searchText) {
        open();
        seachIcon.click();
        typeSearchText(searchText);

        return pressEnter();
    }
}
