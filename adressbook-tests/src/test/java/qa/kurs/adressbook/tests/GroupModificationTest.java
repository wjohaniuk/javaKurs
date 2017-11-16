package qa.kurs.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.kurs.adressbook.model.GroupData;
import qa.kurs.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            if (app.group().all().size() == 0) {
                app.group().create(new GroupData().withName("test1"));
            }
        }
    }

    @Test
    public void testGroupModification() {

        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();

        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withName("test1").withHeader("test2").withFooter("test3");
        app.goTo().groupPage();
        app.group().modify(group);
        assertThat(app.group().Count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }


}