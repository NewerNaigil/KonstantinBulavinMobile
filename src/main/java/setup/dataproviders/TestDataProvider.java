package setup.dataproviders;

import static setup.BaseTest.configReader;
import static setup.BaseTest.typeOS;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    private String nativeExpected;

    @DataProvider
    public Object[][] userDataProvider() {
        if (typeOS.equals("iOS")) {
            nativeExpected = "Budget";
        } else {
            nativeExpected = "BudgetActivity";
        }
        return new Object[][] {
            {nativeExpected, configReader.getEmail(), configReader.getUserName(), configReader.getPassword()}
        };
    }

    @DataProvider
    public Object[][] searchDataProvider() {
        return new Object[][] {
            {configReader.getRequestData()}
        };
    }
}
