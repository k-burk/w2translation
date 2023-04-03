package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class BasicEmployeeInfo {
    protected String deptNbr;
    protected EmployeeAddressInformation employeeAddressInformation;
    protected String employeeId;
    protected EmployeeName employeeName;
    protected String internalEmployeeNumber;
    protected TaxIdInfo taxIdInfo;
    protected String workerPk;
}
