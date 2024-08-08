import apiauto.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GET_TEST {

    @DataProvider(name = "userData")
    public Object[][] createUserData() {
        return new Object[][] {
                {7, true},
                {23, false},
                {"", false},
        };
    }

    @Test(dataProvider = "userData")
    public void GetUser(Integer ID, boolean shouldPass) {
        APITest test = new APITest();
        test.GetUser(ID, shouldPass);
    }
}
