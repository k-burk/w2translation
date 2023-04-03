package com.w2retrieval.starterproject.model;
import java.util.List;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StateInformation {
    protected List<LocalInformation> localInformation;
    protected String stateAbbreviation;
    protected String stateIdNumber;
    protected String stateIncomeTax;
    protected String stateWagesTips;
}
