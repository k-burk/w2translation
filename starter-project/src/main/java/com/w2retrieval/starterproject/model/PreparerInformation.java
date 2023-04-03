package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class PreparerInformation {
    protected String officerName;
    protected String officerTitle;
    protected PhoneNumber phoneNumber;
    protected String preparerEin;
    protected String preparerName;
    protected String preparerProduct;
    protected ReferenceCopyText referenceCopyText;
    protected String signaturePath;
}
