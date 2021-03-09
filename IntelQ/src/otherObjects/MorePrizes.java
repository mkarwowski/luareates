package otherObjects;

public class MorePrizes {
	private String name;
	private int count;
	
	public MorePrizes(String name, int number) {
		this.name = name;
		this.count = number;
	}
	
	public MorePrizes(MorePrizes mp) {
		this.name = mp.getName();
		this.count = mp.getCount();
	}
	
	public void change(MorePrizes mp) {
		this.name = mp.getName();
		this.count = mp.getCount();
	}
	
	public int getCount() {
		return count;
	}
	
	public String getName() {
		return name;
	}
}
