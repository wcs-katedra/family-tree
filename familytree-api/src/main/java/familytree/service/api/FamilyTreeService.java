/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytree.service.api;

import familytree.model.Gender;
import familytree.model.Person;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public interface FamilyTreeService {
    
    Set<Person> getAll();
    
    int count();
    
    int countMales();
    
    int countFemales();
    
    Set<Person> getMales();
    
    Set<Person> getFemales();
    
    Set<Person> getAlive();
    
    Set<Person> getDead();
    
    Person getOldest();
    
    Person getYoungest();
    
    Person getTallest();
    
    Person getShortest();
    
    Map<Person, Integer> getFathersWithNumberOfChildren();

    // Definition of father/mother stream:
    // 1. It starts with the person with the given id (no matter if male or female).
    // 2. The next element is the father/mother of the previous element if the father/mother is existing in the model. Otherwise there is no next element.
    // Example: person -> father -> grandfather -> ... -> last forefather of person
    Stream<Person> fatherStream(int id);
    Stream<Person> motherStream(int id);

    // Definition of offspring stream:
    // 1. It starts with the person with the given id (no matter if male or female).
    // 2. It contains all the person's children, grandchildren, great-grandchildren, etc.
    // 3. The order of elements (except the first one) is not strictly defined but
    // it is recommended to use the order which is provided by depth-first-search
    // or breadth-first-search algorithm.
    Stream<Person> offspringStream(int id);
    
    List<Person> getWithHeightBetweenOrdered(Integer fromHeight, Integer toHeight);
    
    Person getYoungestBecameFather();
    
    Person getOldestBecameMother();
    
    Set<Person> getSingleAdultMales();
    
    Set<Person> getSingleAdultFemales();
    
    Set<Person> getPaternalUncles(int id);
    
    Set<Person> getMaternalAunts(int id);
    
    List<Person> getGrandchildrenOrderedByAgeDesc(int id);
    
    List<Person> getMaleCousinsOrderedByGivenName(int id);
    
    List<Person> getFemaleCousinsOrderedByHeightDesc(int id);
    
    Map<String, Set<Person>> groupByCityOfBirth();
    
    Map<Integer, Set<Person>> groupFathersByNumberOfSons();
    
    Person getFatherByMaximumSumOfChildrenHeight();
    
    Person getOldestAliveAncestor(int id);
    
    Person getOldestAliveForeFather(int id);

    Map<Gender, Double> getAverageAgeByGender();

    Map<Gender, Double> getAverageHeightByGender();

    Set<Person> getGrandparentsWithMostGrandchildren();

    Set<Person> getGrandmasWithMostGrandsons();

    Set<Person> getGrandpasWithMostGranddaughters();

    Set<Person> getPersonsWithMostCousins();

    int getMaximumNumberOfChildren();

    int getMaximumNumberOfGrandchildren();

    int getMaximumNumberOfCousins();

    Set<Person> getPersonsWhoHaveMoreSiblingsThanCousins();
}
