package jsonObjects;
import java.util.ArrayList;
import java.util.Collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import otherObjects.MorePrizes;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Laureates {
	private ArrayList<Laureate> laureates = new ArrayList<Laureate>();
	
	
	public int size() {
		return laureates.size();
	}
	
	
	public int countEconomy() {
		int counter = 0;
		
		for(int i = 0; i < laureates.size(); i++) {
			if (laureates.get(i).checkIfEconomyPrize()) counter++;
		}
		
		return counter;
	}
	
	
	public int countPrizeWinners() {
		int count = 0;
		
		for(int i = 0; i < laureates.size(); i++) {
			if (laureates.get(i).numberOfPrizes() > 0) count++;
		}
		
		return count;
	}
	
	
	public String economyLaureates() {
		String str = "";
		ArrayList<String> arrayOfLaureates = new ArrayList<String>();
		
		//creating array of laureates with surname and firstname
		for(int i = 0; i < laureates.size(); i++) {
			if (laureates.get(i).checkIfEconomyPrize()) {
				arrayOfLaureates.add(laureates.get(i).nameToString());
			}
		}
		
		//sorting names
		Collections.sort(arrayOfLaureates);
		
		//connecting array of laureates to one string
		for(int i = 0; i < arrayOfLaureates.size(); i++) {
			str+= arrayOfLaureates.get(i) + "\n";
		}
		
		return str;
	}
	
	
	public String laureatesWithMorePrizes() {
		String str = "";
		ArrayList<MorePrizes> arrayOfLaureates = new ArrayList<MorePrizes>();
		
		//creating array of laureates with names and their number of prizes
		for(int i = 0; i < laureates.size(); i++) {
			if (laureates.get(i).numberOfPrizes() > 1) {
				arrayOfLaureates.add(new MorePrizes(laureates.get(i).nameToString(), laureates.get(i).numberOfPrizes()));
			}
		}
		
		//sorting array of laureates by number of prizes (bubblesort)
		for(int i = 0; i < arrayOfLaureates.size()-1; i++) {
			for(int j = 0; j < arrayOfLaureates.size()-i-1; j++) {
				if(arrayOfLaureates.get(j).getCount() < arrayOfLaureates.get(j+1).getCount()) {
					MorePrizes temp = new MorePrizes(arrayOfLaureates.get(j));
					arrayOfLaureates.get(j).change(arrayOfLaureates.get(j+1));
					arrayOfLaureates.get(j+1).change(temp);
				}
			}
		}
		
		//connecting array of laureates to one string
		for(int i = 0; i < arrayOfLaureates.size(); i++) {
			str+= arrayOfLaureates.get(i).getName() + " " + arrayOfLaureates.get(i).getCount() + "\n";
		}
		
		return str;
	}
}
