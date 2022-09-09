package assignment1;

public class GetCountryFactory {
	
	public Currency getCountry(String country) {
		if(country==null) {
			return null;
		}
		if(country.equalsIgnoreCase("INDIA")) {
			return new India();
		}
		else if(country.equalsIgnoreCase("Germany")) {
			return new Germany();
		}
		else if(country.equalsIgnoreCase("USA")) {
			return new USA();
		}
		return null;
	}
}
