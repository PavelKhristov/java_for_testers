package ru.stqa.mantis.manager;

import biz.futureware.mantis.rpc.soap.client.MantisConnectLocator;
import biz.futureware.mantis.rpc.soap.client.MantisConnectPortType;
import biz.futureware.mantis.rpc.soap.client.ObjectRef;
import ru.stqa.mantis.model.IssueData;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

public class SoapApiHelper extends BaseHelper{
    MantisConnectPortType mantis;

    public SoapApiHelper(ApplicationManager manager) {
        super(manager);
        try {
            mantis = new MantisConnectLocator().getMantisConnectPort(new URL(manager.property("soap.endPoint")));
        } catch (ServiceException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createIssue(IssueData issueData) {

        try {
            var catigories = mantis.mc_project_get_categories(
                    manager.property("web.username"),
                    manager.property("web.password"),
                    BigInteger.valueOf(issueData.project()));
            var issue = new biz.futureware.mantis.rpc.soap.client.IssueData();
            issue.setSummary(issueData.summary());
            issue.setDescription(issueData.description());
            var projectId = new ObjectRef();
            projectId.setId(BigInteger.valueOf(issueData.project()));
            issue.setProject(projectId);
            issue.setCategory(catigories[0]);
            mantis.mc_issue_add(
                    manager.property("web.username"),
                    manager.property("web.password"),
                    issue);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }


}
