package familytree.store;

import familytree.json.JsonResourceLoader;
import familytree.json.PersonItem;
import familytree.json.PersonItems;
import familytree.model.Gender;
import familytree.model.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonStoreTest {

    private JsonResourceLoader<PersonItems> loader;
    private PersonStore store;

    @Before
    public void setUp() {
        loader = new JsonResourceLoader<>();
        PersonItems items = loader.load(PersonItems.class, "testdata/simpsons.json");
        store = new PersonStore(items);
    }

    @Test
    public void testHomer() {
        Person person = store.get(106);

        assertEquals("Simpson", person.getFamilyName());
        assertEquals("Homer", person.getGivenName());
        assertTrue(person.isMale());
        assertEquals(3, person.getChildren().size());
    }

}
