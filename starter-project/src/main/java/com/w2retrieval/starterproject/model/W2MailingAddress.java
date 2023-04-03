package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class W2MailingAddress {
    protected String country;
    protected String countryCode;
    protected String extended;
    protected String foreignAddressIndicator;
    protected String locality;
    protected String mailingName;
    protected String postalCode;
    protected String region;
    protected String street;
}
