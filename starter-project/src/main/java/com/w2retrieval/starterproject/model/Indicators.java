package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Indicators {
    protected String employeeW2;
    protected String employerW2;
    protected String formDataSortInfo;
}
