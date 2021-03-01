package familytree.store;

import familytree.json.PersonItem;
import familytree.json.PersonItems;
import familytree.model.Person;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonStore {

    private PersonItems personItems;
    private Map<Integer, Person> persons;

    public PersonStore(PersonItems personItems) {
        this.personItems = personItems;
        initPersons();
        initConnections();
    }

    private void initPersons() {
        persons = personItems.getPersons().stream()
                .collect(Collectors.toMap(PersonItem::getId, this::createPerson));
    }

    public Person get(Integer id) {
        return persons.get(id);
    }

    public Set<Person> getRoots() {
        return personStream()
                .filter(Person::isRoot)
                .collect(Collectors.toSet());
    }

    private Stream<Person> personStream() {
        return persons.values().stream();
    }

    private Person createPerson(PersonItem item) {
        Person person = new Person();

        person.setId(item.getId());
        person.setFamilyName(item.getFamilyName());
        person.setGivenName(item.getGivenName());
        person.setGender(item.getGender());
        person.setCityOfBirth(item.getCityOfBirth());
        person.setHeight(item.getHeight());
        person.setYearOfBirth(item.getYearOfBirth());
        person.setYearOfDeath(item.getYearOfDeath());

        return person;
    }

    private void initConnections() {
        personItems.getPersons().stream().forEach(this::initConnections);
    }

    private void initConnections(PersonItem item) {
        Person person = get(item.getId());

        if (item.getMotherId() != null) {
            Person mother = get(item.getMotherId());
            person.setMother(mother);
            mother.addChild(person);
        }

        if (item.getFatherId() != null) {
            Person father = get(item.getFatherId());
            person.setFather(father);
            father.addChild(person);
        }

        if (item.getHusbandId() != null) {
            Person husband = get(item.getHusbandId());
            person.setHusband(husband);
            husband.setWife(person);
        }

        if (item.getWifeId() != null) {
            Person wife = get(item.getWifeId());
            person.setWife(wife);
            wife.setHusband(person);
        }
    }

}
