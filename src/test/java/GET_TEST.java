import apiauto.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GET_TEST {

    @DataProvider(name = "userData")
    public Object[][] createUserData() {
        return new Object[][] {
                {7, true},  // Positive case
                {23, false}, // Negative case: false id
                {"", false}, // Negative case: empty ID
        };
    }

    @Test(dataProvider = "userData")
    public void GetUser(Integer ID, boolean shouldPass) {
        APITest test = new APITest();
        test.GetUser(ID, shouldPass);
    }
}
