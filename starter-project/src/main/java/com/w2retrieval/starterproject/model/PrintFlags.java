package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class PrintFlags {
    protected String printAgency;
    protected String printAtVendor;
    protected String printClient;
    protected String printORS;
    protected String suppressCoverTrailerPages;
}
