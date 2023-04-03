package com.w2retrieval.starterproject.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LocalInformation {
    protected String localIncomeTax;
    protected String localName;
    protected String localWageTips;
    protected String pennsylvaniaLiveSchoolDistrictCode;
    protected String pennsylvaniaSchoolDistrictCode;
}
