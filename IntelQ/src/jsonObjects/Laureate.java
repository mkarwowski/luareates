package jsonObjects;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Laureate {
	private String id;
	private String firstname;
	private String surname;
	private String born;
	private String died;
	private String bornCountry;
	private String bornCountryCode;
	private String bornCity;
	private String diedCountry;
	private String diedCountryCode;
	private String diedCity;
	private String gender;
	private ArrayList<Prize> prizes;
	
	
	public boolean checkIfEconomyPrize() {
		for(int i = 0; i < prizes.size(); i++) {
			if(prizes.get(i).getCategory().equals("economics")) return true;
		}
		return false;
	}
	
	public int numberOfPrizes() {
		return prizes.size();
	}
	
	public String nameToString() {
		if (surname != null) {
			return surname + " " + firstname;
		}
		return firstname;
	}
}
