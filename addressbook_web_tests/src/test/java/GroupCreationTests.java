import org.junit.jupiter.api.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void CanCreateGroup() {
        OpenGroupPage();
        CreateGroup("New group", "New header", "New footer");
    }

    @Test
    public void CanCreateGroupWithEmptyName() {
        OpenGroupPage();
        CreateGroup("", "", "");
    }

}
