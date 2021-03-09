package jsonObjects;
import java.util.ArrayList;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prize {
	private String year;
	private String category;
	private String share;
	private String motivation;
	private ArrayList<Affiliation> affiliations;
	
	String getCategory() {
		return category;
	}
}