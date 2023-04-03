package com.w2retrieval.starterproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("paychexmock1")
@Setter
@Getter
@ToString
@AllArgsConstructor
public class W2 {
    @Id
    protected String id;
    //protected String _class;
    //protected Header header;
    //protected Report report;
    //protected ReportOptions reportOptions;

    protected ReportDefinition reportDefinition;

    public String getFEID() {
        return reportDefinition.report.companies.company.clientInformation.taxIdInfoClientInfo.getEinNumber();
    }

    public String getName1() {
        return reportDefinition.report.companies.company.clientInformation.getCompanyName();
    }

    public String getAddr1() {
        return reportDefinition.report.companies.company.clientInformation.addressInformation.getStreet();
    }

    public String getEmployerCity() {
        return reportDefinition.report.companies.company.clientInformation.addressInformation.getLocality();
    }

    public String getEmployerState() {
        return reportDefinition.report.companies.company.clientInformation.addressInformation.getRegion();
    }

    public String getEmployerPostal() {
        return reportDefinition.report.companies.company.clientInformation.addressInformation.getPostalCode();
    }
    public String getSSN() {
        return reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.taxIdInfo.getSocialSecurityNumber();
    }
    public String getAdr1() {
        return reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeAddressInformation.getAddress1();
    }
    public String getCity() {
        String str = reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeAddressInformation.getAddress2();
        String delimSpace = " ";
        String[] arr1  = str.split(delimSpace);
        return arr1[0];
    }
    public String getState() {
        String str = reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeAddressInformation.getAddress2();
        String delimSpace = " ";
        String[] arr1  = str.split(delimSpace);
        return arr1[1];
    }
    public String getZip() {
        String str = reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeAddressInformation.getAddress2();
        String delimSpace = " ";
        String[] arr1  = str.split(delimSpace);
        return arr1[2];
    }
    public String getFirstName() {
        return reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeName.getFirstName();
    }
    public String getLastName() {
        return reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeName.getLastName();
    }
    public String getMiddleInt() {
        String str = reportDefinition.report.companies.company.employees.employee.get(0).basicEmployeeInfo.employeeName.getMiddleInitial();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            String str1 = "<MIDDLENAME>" + str + "</MIDDLENAME>\n";
            return str1;
        }
    }


    public String getWages() {
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getWagesTipsOtherCompensation();
    }

    public String getFedTaxWh() {
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getFederalIncomeTaxWithheld();
    }

    public String getSSWages(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getSocialSecurityWages();
    }
    public String getSSTaxWH(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getSocialSecurityTaxWithheld();
    }
    public String getMedCareWages(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getMedicareWagesAndTips();
    }
    public String getMedCareTaxWH(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getMedicareTaxWithheld();
    }
    public String getSSTips(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getSocialSecurityTips();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<SSTIPS>" + str + "</SSTIPS>\n";
        }
    }

    public String getAllocatedTips(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getAllocatedTips();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<ALLOCATEDTIPS>"+ str +"</ALLOCATEDTIPS>\n";
        }
    }

//    public String getAdvEIC(){
//        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).;
//        if(Objects.equals(str, "")){
//            return "";
//        }
//        else {
//            return "<ADVANCEDEIC>"+ str +"</ADVANCEDEIC>\n";
//        }
//    }

    public String getDepCareBene(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getDependentCareBenefits();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<DEPCAREBENEFIT>"+ str +"</DEPCAREBENEFIT>\n";
        }
    }

    public String getNonQualPlan(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getNonQualifiedPlans();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<NONQUALPLAN>"+ str +"</NONQUALPLAN>\n";
        }
    }

    public String getStatutory(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getStatutoryIndicator();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<STATUTORY>"+ str +"</STATUTORY>\n";
        }
    }

    public String getRetirementPlan(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getRetirementIndicator();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<RETIREMENTPLAN>"+ str +"</RETIREMENTPLAN>\n";
        }
    }

    public String getTPSickPay(){
        String str = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).getThirdPartySickIndicator();
        if(Objects.equals(str, "")){
            return "";
        }
        else {
            return "<THIRDPARTYSICKPAY>"+ str +"</THIRDPARTYSICKPAY>\n";
        }
    }

    public String getStateCode(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).getStateAbbreviation();
    }

    public String getESID(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).getStateIdNumber();
    }

    public String getStateWages(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).getStateWagesTips();
    }

    public String getStateTaxWH(){
        return reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).getStateIncomeTax();
    }

    public String getLocalInfo(){
        String str = "<LOCALINFO>\n";
        String str5 = "</LOCALINFO>\n";
        String str1 = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).localInformation.get(0).getLocalName();
        String str2 = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).localInformation.get(0).getLocalWageTips();
        String str3 = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).localInformation.get(0).getLocalIncomeTax();
        String str4 = reportDefinition.report.companies.company.employees.employee.get(0).eeFormData.eeTaxData.get(0).stateInformation.get(0).localInformation.get(0).getLocalName();
        if(Objects.equals(str1, "")){
            if(Objects.equals(str2, "")){
                if(Objects.equals(str3, "")){
                    if(Objects.equals(str4, "")){
                        return "";
                    }
                    else{
                        str4 = "<LOCALITYSTATE>" + str4 + "</LOCALITYSTATE>\n";
                    }
                }
                else{
                    str3 = "<LOCALTAXWH>" + str3 + "</LOCALTAXWH>\n";
                }
            }
            else{
                str2 = "<LOCALWAGES>" + str2 + "</LOCALWAGES>\n";
            }
        }
        else{
            str1 = "<LOCALITY>" + str1 + "</LOCALITY>\n";
        }
        return str + str1 + str2 + str3 + str4 + str5;
    }

}
