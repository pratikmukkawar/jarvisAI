package Spree.Address.Contries;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="country_iso")
	public Object[][] iso_name(){
		// Two dimensional object
	    return new Object[][] {

	            {"usa","UNITED STATES","USA"},
	            {"ind","INDIA","IND"},
	            {"pak","PAKISTAN","PAK"},
	            {"gb","UNITED KINGDOM","GBR"},
	            {"afg","AFGHANISTAN","AFG"}
	            };
	}
	@DataProvider(name="BadAddresses")
	public Object[][] badAddresses(){
		return new Object[][] {
			{"", "N1", "100 1st St", "Dallas", "75001","1", "TX", "US", "emptyFirstname"},
			{"Minh1", "", "100 1st St", "Dallas", "75001","1", "TX", "US", "emptyLastname"},
			{"Minh1", "N1", "", "Dallas", "75001","1", "TX", "US", "emptyAddress1"},
			{"Minh1", "N1", "100 1st St", "", "75001","1", "TX", "US", "emptyCity"},
			{"Minh1", "N1", "100 1st St", "Dallas", "","1", "TX", "US", "emptyZipcode"},
			{"Minh1", "N1", "100 1st St", "Dallas", "75001","", "TX", "US", "emptyPhoneNumber"},
			{"Minh1", "N1", "100 1st St", "Dallas", "75001","1", "", "US", "emptyState"},
			{"Minh1", "N1", "100 1st St", "Dallas", "75001","1", "TX", "", "emptyCountry"}	
		};
	}}