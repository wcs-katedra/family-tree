package familytree.json;

import static org.junit.Assert.*;

import familytree.model.Gender;
import org.junit.Before;
import org.junit.Test;


public class JsonResourceLoaderTest {

    private JsonResourceLoader<PersonItems> loader;

    @Before
    public void setUp() {
        loader = new JsonResourceLoader<>();
    }

    @Test
    public void testLoad() {
        PersonItems personItems = loader.load(PersonItems.class, "testdata/simpsons.json");

        PersonItem personItem = personItems.getPersons().get(0);

        assertEquals(101, personItem.getId());
        assertEquals("Simpson", personItem.getFamilyName());
        assertEquals("Abraham", personItem.getGivenName());
        assertEquals(Gender.MALE, personItem.getGender());
    }

}
