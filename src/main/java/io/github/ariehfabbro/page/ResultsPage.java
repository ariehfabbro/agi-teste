package io.github.ariehfabbro.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class ResultsPage extends BasePage {
    @FindBy(xpath = "/html/body/div[1]/div/div/div[1]/section/h1")
    private WebElement titleSearch;

    @FindBy(className = "ast-row")
    private WebElement searchContent;

    @FindBy(className = "page-content")
    private WebElement supportText;

    public String getMainText() {
        return titleSearch.getText();
    }

    public WebElement getSearchContent() {
        return searchContent;
    }

    public String getSupportText() {
        return supportText.getText();
    }
}
