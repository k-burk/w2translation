package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Setter
@Getter
@ToString
public class ReportDefinition {
    protected Header header;
    protected ReportOptions reportOptions;
    protected Report report;
}
