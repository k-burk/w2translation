package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Company {
    protected ClientInformation clientInformation;
    protected Dates dates;
    protected Employees employees;
    protected Indicators indicators;
    protected PrintFlags printFlags;
}
