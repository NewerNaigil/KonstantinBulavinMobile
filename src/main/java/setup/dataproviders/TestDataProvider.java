package setup.dataproviders;

import java.util.Properties;
import org.testng.annotations.DataProvider;
import setup.BaseTest;
import setup.ConfigReader;

public class TestDataProvider {

    private final Properties propertyReader = ConfigReader.loadProperties();
    private final String email = propertyReader.getProperty("email");
    private final String userName = propertyReader.getProperty("userName");
    private final String password = propertyReader.getProperty("password");
    private final String requestData = propertyReader.getProperty("searchRequest");

    @DataProvider
    public Object[][] userDataProvider() {
        String nativeExpected;
        if (BaseTest.getTypeOS().equals("iOS")) {
            nativeExpected = "Budget";
        } else {
            nativeExpected = "BudgetActivity";
        }
        return new Object[][] {
            {nativeExpected, email, userName, password}
        };
    }

    @DataProvider
    public Object[][] searchDataProvider() {
        return new Object[][] {
            {requestData}
        };
    }
}
