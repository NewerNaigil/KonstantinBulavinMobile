package setup.dataproviders;

import static setup.BaseTest.configReader;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public Object[][] userDataProvider() {
        return new Object[][] {
            {"BudgetActivity", configReader.getEmail(), configReader.getUserName(), configReader.getPassword()}
        };
    }

    @DataProvider
    public Object[][] searchDataProvider() {
        return new Object[][] {
            {configReader.getRequestData()}
        };
    }
}
