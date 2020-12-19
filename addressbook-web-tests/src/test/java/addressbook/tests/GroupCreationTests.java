package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void groupCreationTests() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("RON", null, null));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().goToHomePage();

    }


}
