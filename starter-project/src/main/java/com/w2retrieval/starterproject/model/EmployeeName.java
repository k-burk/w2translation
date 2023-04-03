package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeName {
    protected String firstName;
    protected String fullName;
    protected String lastName;
    protected String middleInitial;
}
