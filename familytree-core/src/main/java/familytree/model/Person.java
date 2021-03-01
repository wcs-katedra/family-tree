package familytree.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class Person {

    private int id;

    private Person father;
    private Person mother;

    private Person wife;
    private Person husband;

    private Set<Person> children = new HashSet<>();

    private String familyName;
    private String givenName;

    private Gender gender;

    private String cityOfBirth;

    private Integer yearOfBirth;
    private Integer yearOfDeath;

    private Integer height;

    public boolean isAlive() {
        return  yearOfDeath == null;
    }

    public Set<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Integer getYearOfDeath() {
        return yearOfDeath;
    }

    public void setYearOfDeath(Integer yearOfDeath) {
        this.yearOfDeath = yearOfDeath;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getWife() {
        return wife;
    }

    public void setWife(Person wife) {
        this.wife = wife;
    }

    public Person getHusband() {
        return husband;
    }

    public void setHusband(Person husband) {
        this.husband = husband;
    }

    public boolean isMale() {
        return getGender() == Gender.MALE;
    }

    public boolean isFemale() {
        return getGender() == Gender.FEMALE;
    }

    public boolean isRoot() {
        return getFather() == null && getMother() == null;
    }

    public boolean isRootFather() {
        return isRoot() && isMale();
    }

    public boolean isRootMother() {
        return isRoot() && isFemale();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Person{" + id + "}";
    }
}
