package co.id.mhanifmuhsin.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Ini merupakan model yang menggambarkan object dari Student
 */
public class Student {
    private UUID id;
    private final Integer age;
    private final String firstName;
    private final String lastName;
    private final String course;

    /**
     * @JsonProperty berfungsi untuk meng-custom value key dalam JSON
     * @param id
     * @param age
     * @param firstName
     * @param lastName
     * @param course
     */
    public Student(@JsonProperty("id") UUID id, @JsonProperty("age") Integer age,
                   @JsonProperty("first_name") String firstName,
                   @JsonProperty("last_name") String lastName,
                   @JsonProperty("course") String course) {
        this.id = id;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }
}
