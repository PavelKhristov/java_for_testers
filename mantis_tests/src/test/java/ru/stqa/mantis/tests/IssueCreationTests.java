package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.CommonFunctions;
import ru.stqa.mantis.model.IssueData;

public class IssueCreationTests extends TestBase{

    @Test
    void canCreateIssue1(){
        app.rest().createIssue(new IssueData()
                .withSummary(CommonFunctions.randomString(10))
                .withDescription(CommonFunctions.randomString(10))
                .withProject(1L));
    }

    @Test
    void canCreateIssue2(){
        app.soap().createIssue(new IssueData()
                .withSummary(CommonFunctions.randomString(10))
                .withDescription(CommonFunctions.randomString(10))
                .withProject(1L));
    }

}
