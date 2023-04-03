package com.w2retrieval.starterproject.model;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class EETaxData {
    protected String allocatedTips;
    protected List<Box14> box14;
    protected String dependentCareBenefits;
    protected String federalIncomeTaxWithheld;
    protected String medicareTaxWithheld;
    protected String medicareWagesAndTips;
    protected String msg;
    protected String nonQualifiedPlans;
    protected String retirementIndicator;
    protected String socialSecurityTaxWithheld;
    protected String socialSecurityTips;
    protected String socialSecurityWages;
    protected List<StateInformation> stateInformation;
    protected String statutoryIndicator;
    protected String thirdPartySickIndicator;
    protected String w2PrintIndicator;
    protected String wagesTipsOtherCompensation;
}
