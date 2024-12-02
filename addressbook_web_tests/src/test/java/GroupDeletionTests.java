import org.junit.jupiter.api.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void CanDeleteGroup() {
        OpenGroupPage();
        if (!IsGroupPresent()) {
            CreateGroup("New group", "New header", "New footer");
        }
        DeleteGroup();
    }

}