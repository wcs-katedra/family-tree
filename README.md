This is a project for practicing the Java Stream API. (https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

The task is to traverse the family tree and gather various kinds of information there.

Implement the family tree service methods and write junit tests for each one!

The example data is from the Simpson family (https://en.wikipedia.org/wiki/Simpson_family).

Rules:
1. Try to do everything with the Stream API!
So avoid for cycles, add, addAll methods and any non-Stream API stuff as far as possible!

2. You are allowed to modify: FamilyTreeServiceImpl.java, Person.java, your own utility classes and the test classes and the test data.
Hint: It is highly recommended to implement some useful methods (most of them without parameters, returning Stream<Person>) in Person.java
like childrenStream, grandchildrenStream, cousinStream, etc.

3. You are not allowed to modify PersonStore.java for example.
It is meant to be the API to access persons from the family tree model.
You can use only these two basic API methods:
* Person get(Integer id): access any given Person by id
* Set&lt;Person&gt; getRoots(): get the root elements of the family tree (persons who have no parents defined in the model)

4. There are use cases where time (the current year) matters.
For example the number of males who are alive depends on the current year.
In this cases the current year should be accessed via TimeMachine static methods and not from the "real" current year (which your operation system defines).
You can also set the current year in TimeMachine if the default value is not suited well for your use case.
(Do not forget to reset the default value for other test cases!)


