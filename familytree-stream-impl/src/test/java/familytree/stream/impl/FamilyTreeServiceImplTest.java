/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree.stream.impl;

import familytree.json.JsonResourceLoader;
import familytree.json.PersonItems;
import familytree.service.api.FamilyTreeService;
import familytree.store.PersonStore;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tveki
 */
public class FamilyTreeServiceImplTest {
    
    private JsonResourceLoader<PersonItems> jsonLoader;
    private PersonStore store;
    private FamilyTreeService service;
    
    @Before
    public void setUp() {
        jsonLoader = new JsonResourceLoader<>();
        PersonItems items = jsonLoader.load(PersonItems.class, "testdata/simpsons.json");
        store = new PersonStore(items);
        service = new FamilyTreeServiceImpl(store);
    }
    

    @Test
    public void testCount() {
        assertEquals(13, service.count());
    }
    
}
