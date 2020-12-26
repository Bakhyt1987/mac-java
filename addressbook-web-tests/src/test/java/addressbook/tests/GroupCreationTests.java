package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void groupCreationTests() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("RON", null, null));
        app.getNavigationHelper().returnToHomePage();

    }


}
