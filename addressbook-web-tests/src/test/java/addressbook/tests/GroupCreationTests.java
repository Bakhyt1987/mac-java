package addressbook.tests;

import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void groupCreationTests() throws Exception {
        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("RON", "Pit1", "Pit2"));
        app.submitGroupCreation();
        app.returnToGroupPage();

    }


}
