package com.gs.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private String name;
    private int teacherId;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", teacherId=" + teacherId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
