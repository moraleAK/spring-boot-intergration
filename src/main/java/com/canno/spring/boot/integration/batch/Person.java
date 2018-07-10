package com.canno.spring.boot.integration.batch;

/**
 * @author CannoGcc
 * @since 2018/6/29 15:11
 */
public class Person {
    private Long personId;
    private String lastName;
    private String firstName;

    public Person() {
    }


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId=System.nanoTime();
        System.out.println(personId);
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "personId: " + "firstName: " + firstName + ", lastName: " + lastName;
    }

}
