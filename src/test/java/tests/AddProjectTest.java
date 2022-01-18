package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Randomization;

public class AddProjectTest extends BaseTest {

    @Test
    public void lll( ){
         Project project = new Project.BuilderProject.Builder()
                .withName(Randomization.getRandomString(9))
                .withAnouncement(Randomization.getRandomString(18))
                .wihtIsShowAnnouncement(true)
//TODO добавить полностью реализованный билдер
                .build();
        User user = new User()
                .setEmail(ReadProperties.getUsername())
                .setPassword(ReadProperties.getPassword());
        loginSteps.loginGeneralUsers(user);


    }


}

