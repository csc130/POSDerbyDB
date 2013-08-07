
public class FoodItem {

	private String name, catagory;
	private double smallPrice, medPrice, largePrice;
	
	public FoodItem(String name){
		this.setName(name);
	}
	
	public FoodItem(String name, String catagory, double smallPrice, double medPrice, double largePrice){
		this.setName(name);
		this.setCatagory(catagory);
		this.setSmallPrice(smallPrice);
		this.setMedPrice(medPrice);
		this.setLargePrice(largePrice);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public double getSmallPrice() {
		return smallPrice;
	}

	public void setSmallPrice(double smallPrice) {
		this.smallPrice = smallPrice;
	}

	public double getMedPrice() {
		return medPrice;
	}

	public void setMedPrice(double medPrice) {
		this.medPrice = medPrice;
	}

	public double getLargePrice() {
		return largePrice;
	}

	public void setLargePrice(double largePrice) {
		this.largePrice = largePrice;
	}
}
