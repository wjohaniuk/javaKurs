package qa.kurs.adressbook.tests;

import org.testng.annotations.Test;
import qa.kurs.adressbook.model.GroupData;
import qa.kurs.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreatingTest extends TestBase {

  @Test
  public void testGroupCreation() {

    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    assertThat(app.group().Count(), equalTo(before.size() + 1));
    Groups after = app.group().all();


    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
