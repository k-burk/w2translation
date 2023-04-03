package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class ClientInformation {
    protected AddressInformation addressInformation;
    protected String branchNumber;
    protected String clientNumber;
    protected String companyName;
    protected String consolidatedClientInd;
    protected String contactEmail;
    protected PreparerInformation preparerInformation;
    @Field("taxIdInfo")
    protected TaxIdInfoClientInfo taxIdInfoClientInfo;
    protected String w2DeliveryCode;
    protected W2MailingAddress w2MailingAddress;
}
