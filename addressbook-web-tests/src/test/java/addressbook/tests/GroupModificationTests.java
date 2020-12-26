package addressbook.tests;


import addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("RON", null, null));
        }
        app.getGroupHelper().modifyGroup(new GroupData("Gyle", "Tony", "Trey"));
        app.getNavigationHelper().returnToHomePage();
    }


}
