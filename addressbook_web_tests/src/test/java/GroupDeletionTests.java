import model.GroupData;
import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        OpenGroupPage();
        if (!IsGroupPresent()) {
            CreateGroup(new GroupData("New group", "New header", "New footer"));
        }
        DeleteGroup();
    }

}