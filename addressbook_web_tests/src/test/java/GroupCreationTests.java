import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        OpenGroupPage();
        CreateGroup(new GroupData("New group", "New header", "New footer"));
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        OpenGroupPage();
        CreateGroup(new GroupData());
    }

    @Test
    public void CanCreateGroupWithNameOnly() {
        OpenGroupPage();
        CreateGroup(new GroupData().withName("OnlyWithName"));
    }

}
