package addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


    @Test
    public void groupCreationTests() throws Exception {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("Bill", "Pit1", "Pit2"));
        submitGroupCreation();
        returnToGroupPage();

    }


}
