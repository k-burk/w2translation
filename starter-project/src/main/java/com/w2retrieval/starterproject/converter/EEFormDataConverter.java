package com.w2retrieval.starterproject.converter;

import com.w2retrieval.starterproject.model.EEFormData;

import com.w2retrieval.starterproject.model.EETaxData;
import com.w2retrieval.starterproject.model.StateInformation;
import com.w2retrieval.starterproject.model.LocalInformation;
import com.w2retrieval.starterproject.model.Box14;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.bson.Document;
import org.springframework.stereotype.Component;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Component
@ReadingConverter
public class EEFormDataConverter implements Converter<List<Document>, EEFormData> {

    @Override
    public EEFormData convert(List<Document> source) {
        System.out.println("EEFormDataConverter Called\n");

        // create new list to hold EETaxData objects
        List<EETaxData> EETaxDataList = new ArrayList<>();

        // for each Document in the source list
        for(Document x : source) {
            // extract the EETaxData document
            Document doc_EETaxData = x.get("eeTaxData", Document.class);

            // instantiate a new EETaxData object
            EETaxData obj = new EETaxData();

            // set all string attributes by pulling from the EETaxData Document
            obj.setAllocatedTips(doc_EETaxData.getString("allocatedTips"));
            obj.setDependentCareBenefits(doc_EETaxData.getString("dependentCareBenefits"));
            obj.setFederalIncomeTaxWithheld(doc_EETaxData.getString("federalIncomeTaxWithheld"));
            obj.setMedicareTaxWithheld(doc_EETaxData.getString("medicareTaxWithheld"));
            obj.setMedicareWagesAndTips(doc_EETaxData.getString("medicareWagesAndTips"));
            obj.setMsg(doc_EETaxData.getString("msg"));
            obj.setNonQualifiedPlans(doc_EETaxData.getString("nonQualifiedPlans"));
            obj.setRetirementIndicator(doc_EETaxData.getString("retirementIndicator"));
            obj.setSocialSecurityTaxWithheld(doc_EETaxData.getString("socialSecurityTaxWithheld"));
            obj.setSocialSecurityTips(doc_EETaxData.getString("socialSecurityTips"));
            obj.setSocialSecurityWages(doc_EETaxData.getString("socialSecurityWages"));
            obj.setStatutoryIndicator(doc_EETaxData.getString("statutoryIndicator"));
            obj.setThirdPartySickIndicator(doc_EETaxData.getString("thirdPartySickIndicator"));
            obj.setW2PrintIndicator(doc_EETaxData.getString("w2PrintIndicator"));
            obj.setWagesTipsOtherCompensation(doc_EETaxData.getString("wagesTipsOtherCompensation"));

            // get the box14 array from the EETaxData Document
            List<Document> doc_b14 = doc_EETaxData.getList("box14", Document.class);

            // if box14 array was found in EETaxData Document
            if(doc_b14 != null){
                // create a new list for Box14 objects
                List<Box14> b14 = new ArrayList<>();

                // for each Document in the box14 array
                for (Document z : doc_b14) {
                    // create a new Box14 object by pulling the attributes from the box14 Document and add it to list
                    b14.add(new Box14(z.getString("boxAmount"), z.getString("boxText")));
                }
                // set Box14 attribute for EETaxData object
                obj.setBox14(b14);
            }

            // get the stateInformation array from the EETaxData Document
            List<Document> stinfo = doc_EETaxData.getList("stateInformation", Document.class);

            // if stateInformation array was found in EETaxData Document
            if(stinfo != null) {
                // create a new list for StateInformation objects
                List<StateInformation> stateInfo = new ArrayList<>();

                // for each Document in the stateInformation array
                for(Document y : stinfo) {
                    // create a new StateInformation object
                    StateInformation s = new StateInformation();

                    // get the localInformation array from the stateInformation Document
                    List<Document> locinfo = doc_EETaxData.getList("localInformation", Document.class);

                    // create a new list for LocalInformation objects
                    List<LocalInformation> localInfo = new ArrayList<>();

                    // if localInformation array was found in Document
                    if(locinfo != null) {

                        // for each Document in the localInformation array
                        for(Document l : locinfo) {
                            // create a new LocalInformation object
                            LocalInformation loc = new LocalInformation();

                            // set all string attributes by pulling from Document
                            loc.setLocalIncomeTax(l.getString("localIncomeTax"));
                            loc.setLocalName(l.getString("localName"));
                            loc.setLocalWageTips(l.getString("localWageTips"));
                            //loc.setPennsylvaniaLiveSchoolDistrictCode(l.getString("pennsylvaniaLiveSchoolDistrictCode"));
                            //loc.setPennsylvaniaSchoolDistrictCode(l.getString("pennsylvaniaSchoolDistrictCode"));

                            // add LocalInformation object to list
                            localInfo.add(loc);
                        }
                    }
                    // set localInformation for StateInformation object
                    s.setLocalInformation(localInfo);

                    // set all string attributes by pulling from Document
                    s.setStateAbbreviation(y.getString("stateAbbreviation"));
                    s.setStateIdNumber(y.getString("stateIdNumber"));
                    s.setStateIncomeTax(y.getString("stateIncomeTax"));
                    s.setStateWagesTips(y.getString("stateWagesTips"));

                    // add StateInformation object to list
                    stateInfo.add(s);
                }
                // set StateInformation attribute for EETaxData object
                obj.setStateInformation(stateInfo);
            }

            // add fully assembled EETaxData object to list
            EETaxDataList.add(obj);
        }
        return new EEFormData(EETaxDataList);
    }
}


