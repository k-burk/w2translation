package com.w2retrieval.starterproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.w2retrieval.starterproject.model.W2;
import com.w2retrieval.starterproject.repository.W2Repository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.bson.Document;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

import java.nio.file.Files;

import java.io.FileInputStream;

@SpringBootApplication
//@RestController
public class StarterProjectApplication implements CommandLineRunner {

	private W2Repository w2repository;

	@Autowired
	public StarterProjectApplication(W2Repository w2repository) {
		this.w2repository = w2repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StarterProjectApplication.class, args);
	}

//	@GetMapping("/ofxtranslation")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s!", name);
//	}

	@Override
	public void run(String... args) throws Exception {

		//System.out.println("W-2 found with findBySocialSecurityNumber(\"130217924\"):");
		//W2 w2 = w2repository.findBySocialSecurityNumber("130217924");
		System.out.println("W-2 found with findBySocialSecurityNumber(\"219466820\"):");
		W2 w2 = w2repository.findBySocialSecurityNumber("219466820");

		System.out.println(w2);

		String w2_id = w2.getId();
		System.out.println(w2_id);

		/*System.out.println("W2s found with findAll():");
		System.out.println("-------------------------------");
		for (W2 w2 : w2repository.findAll()) {
			System.out.println(w2);
		}
		System.out.println();*/

		//System.out.println("W-2 found with findByID(\"63d831d093e6ebbc1f938c77\"):");
		//System.out.println("--------------------------------");
		//System.out.println(w2repository.findById("63ce0834eb364fc81a43b662"));
		try {
			File myObj = new File(w2_id + ".ofx");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter ofxFile = new FileWriter(w2_id + ".ofx");
			//OFX Headers
			ofxFile.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
					"<?OFX OFXHEADER=\"200\" VERSION=\"202\" SECURITY=\"NONE\" OLDFILEUID=\"NONE\" NEWFILEUID=\"NONE\"?>");
			ofxFile.write("<OFX>\n" +
					"    <SIGNONMSGSRSV1>\n" +
					"        <SONRS>\n" +
					"            <STATUS>\n" +
					"                <CODE>0</CODE>\n" +
					"                <SEVERITY>INFO</SEVERITY>\n" +
					"                <MESSAGE>Successful Login</MESSAGE>\n" +
					"            </STATUS>\n" +
					"            <DTSERVER>39210131000000</DTSERVER>\n" +
					"            <LANGUAGE>ENG</LANGUAGE>\n" +
					"            <FI>\n" +
					"                <ORG>fiName</ORG>\n" +
					"                <FID>fiId</FID>\n" +
					"            </FI>\n" +
					"        </SONRS>\n" +
					"    </SIGNONMSGSRSV1>\n" +
					"    <TAXW2MSGSRSV1>\n" +
					"        <TAXW2TRNRS>\n" +
					"            <TRNUID>_GUID_</TRNUID>\n" +
					"            <STATUS>\n" +
					"                <CODE>0</CODE>\n" +
					"                <SEVERITY>INFO</SEVERITY>\n" +
					"                <MESSAGE>SUCCESS</MESSAGE>\n" +
					"            </STATUS>");
			ofxFile.write("<TAXW2RS>\n");
			ofxFile.write("<TAXW2_V200>\n");

			ofxFile.write("<TAXYEAR>2023</TAXYEAR>\n");
			ofxFile.write("<CNTRLNO> </CNTRLNO>\n");
			// 3.2.9 EMPLOYER
			ofxFile.write("<EMPLOYER>\n");
			ofxFile.write("<FEDIDNUMBER>" + w2.getFEID() + "</FEDIDNUMBER>\n");
			ofxFile.write("<NAME1>" + w2.getName1() + "</NAME1>\n");
			ofxFile.write("<ADDR1>" + w2.getAddr1() + "</ADDR1>\n");
			ofxFile.write("<CITY>" + w2.getEmployerCity() + "</CITY>\n");
			ofxFile.write("<STATE>" + w2.getEmployerState() + "</STATE>\n");
			ofxFile.write("<POSTALCODE>" + w2.getEmployerPostal() + "</POSTALCODE>\n");
			ofxFile.write("</EMPLOYER>\n");
			// 3.2.10 EMPLOYEE
			ofxFile.write("<EMPLOYEE>\n");
			ofxFile.write("<SSN>" + w2.getSSN() + "</SSN>\n");
			ofxFile.write("<FIRSTNAME>" + w2.getFirstName() +"</FIRSTNAME>\n");
			ofxFile.write(w2.getMiddleInt());
			ofxFile.write("<LASTNAME>" + w2.getLastName() +"</LASTNAME>\n");
			ofxFile.write("<ADDR1>" + w2.getAdr1() + "</ADDR1>\n");
			ofxFile.write("<CITY>" + w2.getCity() + "</CITY>\n");
			ofxFile.write("<STATE>" + w2.getState() + "</STATE>\n");
			ofxFile.write("<POSTALCODE>" + w2.getZip() + "</POSTALCODE>\n");
			ofxFile.write("</EMPLOYEE>\n");

			ofxFile.write("<WAGES>" + w2.getWages() + "<WAGES/>\n");
			ofxFile.write("<FEDTAXWH>" + w2.getFedTaxWh() + "</FEDTAXWH>\n");
			ofxFile.write("<SSWAGES>" + w2.getSSWages() + "</SSWAGES>\n");
			ofxFile.write("<SSTAXWH>" + w2.getSSTaxWH() + "</SSTAXWH>\n");
			ofxFile.write("<MEDICAREWAGES>" + w2.getMedCareWages() + "</MEDICAREWAGES>\n");
			ofxFile.write("<MEDICARETAXWH>" + w2.getMedCareTaxWH() + "</MEDICARETAXWH>\n");
			ofxFile.write(w2.getSSTips());
			ofxFile.write(w2.getAllocatedTips());
			ofxFile.write(w2.getDepCareBene());
			//MAY NEED ADVANCEDEIC ofxFile.write(w2.getAdvEIC());
			ofxFile.write( w2.getNonQualPlan());
			ofxFile.write(w2.getStatutory());
			ofxFile.write(w2.getRetirementPlan());
			ofxFile.write(w2.getTPSickPay());

			ofxFile.write("<STATEINFO>\n");
			ofxFile.write("<STATECODE>"+ w2.getStateCode() +"</STATECODE>\n");
			ofxFile.write("<EMPLOYERSTID>"+ w2.getESID() +"</EMPLOYERSTID>\n");
			ofxFile.write("<STATEWAGES>"+ w2.getStateWages() +"</STATEWAGES>\n");
			ofxFile.write("<STATETAXWH>"+ w2.getStateTaxWH() +"</STATETAXWH>\n");
			ofxFile.write("</STATEINFO>\n");

			//ofxFile.write(w2.getLocalInfo());

			ofxFile.write("</TAXW2_V200>\n");
			ofxFile.write("</TAXW2RS>\n");
			ofxFile.write("</TAXW2TRNRS>\n");
			ofxFile.write("</TAXW2MSGSRSV1>\n");
			ofxFile.write("</OFX>");
			ofxFile.close();
			System.out.println("Successfully wrote to the file.");
			FileInputStream ofx = new FileInputStream(w2_id + ".ofx");
			int ofxFileLength = (int) new File(w2_id + ".ofx").length();
			byte Bytes[] = new byte[ofxFileLength];
			System.out.println(ofx.read(Bytes));
			String finalOFX = new String(Bytes);
			System.out.println(finalOFX);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
