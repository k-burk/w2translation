package com.w2retrieval.starterproject.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.w2retrieval.starterproject.model.W2;

public interface W2Repository extends MongoRepository<W2, String> {

    @Query("{'reportDefinition.report.companies.company.employees.employee.basicEmployeeInfo.taxIdInfo.socialSecurityNumber': ?0}")
    public W2 findBySocialSecurityNumber(String socialSecurityNumber);

    public long count();
}

