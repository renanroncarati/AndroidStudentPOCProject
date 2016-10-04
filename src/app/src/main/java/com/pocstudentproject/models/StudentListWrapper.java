

package com.pocstudentproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;


@JsonPropertyOrder({
        "results"
})
public class StudentListWrapper {

    @JsonProperty("results")
    private List<Student> results = new ArrayList<>();

    /**
     * @return The results
     */
    @JsonProperty("results")
    public List<Student> getStudents() {
        return results;
    }

    /**
     * @param students The results
     */
    @JsonProperty("results")
    public void setStudents(List<Student> students) {
        this.results = students;
    }

}