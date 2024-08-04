import apiauto.APITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class POST_TEST {

    @DataProvider(name = "userData")
    public Object[][] createUserData() {
        return new Object[][] {
                {"John Doe", "Software Developer", true},          // Positive case
                {"", "QA Engineer", false},                        // Negative case: empty name
                {"Alice", "", false},                              // Negative case: empty job
                {"VeryLongNameThatExceedsNormalLengthaldhiuhisabdkauhiugfKJKASJHFKSJH", "Dev", false}, // Negative case: very long name
                {"Bob", "Business Analyst", true},                 // Positive case
                {"!@#$%^&*()", "Engineer", false},                 // Negative case: special characters in name
                {"Jane Doe", "Tester", true}                       // Positive case
        };
    }

    @Test(dataProvider = "userData")
    public void testPostUser(String name, String job, boolean shouldPass) {
        APITest test = new APITest();
        test.PostUser(name, job, shouldPass);
    }
}