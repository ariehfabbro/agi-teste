package io.github.ariehfabbro.e2e;

import static io.github.ariehfabbro.util.DataProviderUtil.processTestData;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.github.ariehfabbro.dto.SearchDto;
import io.github.ariehfabbro.page.ResultsPage;
import io.github.ariehfabbro.util.TestRetry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public final class LoginTest extends BaseTest {

    private static final String FILE_PATH = "search.json";

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(final Method testMethod) {
        String testCaseId = testMethod.getAnnotation(Test.class).testName();

        return processTestData(SearchDto.class, getTestDataFilePath(FILE_PATH), testCaseId);
    }

    @Test(
            testName = "TC-1",
            dataProvider = "loginData",
            groups = {"smoke", "regression"},
            retryAnalyzer = TestRetry.class)
    public void testCorrectUserNameAndCorrectPassword(final SearchDto data) {
        ResultsPage resultsPage = loginPage.DoASearch(data.getSearchText());

        assertThat(resultsPage.getMainText()).isEqualTo("Resultados encontrados para: " + data.getSearchText());
        assertThat(resultsPage.getSearchContent().isDisplayed());
    }

    @Test(
            testName = "TC-2",
            dataProvider = "loginData",
            groups = {"validation", "regression"},
            retryAnalyzer = TestRetry.class)
    public void testImproperCredentialsShouldGiveErrorMessage(final SearchDto data) {
        ResultsPage resultsPage = loginPage.DoASearch(data.getSearchText());

        assertThat(resultsPage.getMainText()).isEqualTo("Resultados encontrados para: " + data.getSearchText());
        assertThat(resultsPage.getSupportText()).isEqualTo("Lamentamos, mas nada foi encontrado para sua pesquisa, tente novamente com outras palavras.\nPesquisar por:");
    }
}
