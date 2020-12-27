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
        app.getGroupHelper().GroupModification(new GroupData("Gyle", null, null));
        app.getNavigationHelper().returnToHomePage();
    }


}
