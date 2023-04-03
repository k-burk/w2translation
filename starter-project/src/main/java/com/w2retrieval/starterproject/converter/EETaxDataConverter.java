package com.w2retrieval.starterproject.converter;
//import com.w2retrieval.starterproject.model.*;

import com.w2retrieval.starterproject.model.Box14;
import com.w2retrieval.starterproject.model.EETaxData;
import com.w2retrieval.starterproject.model.StateInformation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.bson.Document;
import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

@Component
@ReadingConverter
public class EETaxDataConverter implements Converter<Document, EETaxData>{
    @Override
    public EETaxData convert(Document source) {
        EETaxData obj = new EETaxData();
        obj.setAllocatedTips(source.getString("allocatedTips"));
        obj.setBox14(source.getList("box14", Box14.class));
        obj.setDependentCareBenefits(source.getString("dependentCareBenefits"));
        obj.setFederalIncomeTaxWithheld(source.getString("federalIncomeTaxWithheld"));
        obj.setMedicareTaxWithheld(source.getString("medicareTaxWithheld"));
        obj.setMedicareWagesAndTips(source.getString("medicareWagesAndTips"));
        obj.setMsg(source.getString("msg"));
        obj.setNonQualifiedPlans(source.getString("nonQualifiedPlans"));
        obj.setRetirementIndicator(source.getString("retirementIndicator"));
        obj.setSocialSecurityTaxWithheld(source.getString("socialSecurityTaxWithheld"));
        obj.setSocialSecurityTips(source.getString("socialSecurityTips"));
        obj.setSocialSecurityWages(source.getString("socialSecurityWages"));
        obj.setStateInformation(source.getList("stateInformation", StateInformation.class));
        obj.setStatutoryIndicator(source.getString("statutoryIndicator"));
        obj.setThirdPartySickIndicator(source.getString("thirdPartySickIndicator"));
        obj.setW2PrintIndicator(source.getString("w2PrintIndicator"));
        obj.setWagesTipsOtherCompensation(source.getString("wagesTipsOtherCompensation"));
        System.out.println("EETaxDataConverter Called\n");

        return obj;
    }
}
