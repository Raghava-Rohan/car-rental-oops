public class Car {
	private String carId;
	private String brand;
	private String model;
	private String type;
	private String color;
	private double basePricePerDay;
	private boolean isAvailable;

	public Car(String carId, String brand,  String model,String type,String color, double basePricePerDay) {
		this.carId = carId;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.color = color;
		this.basePricePerDay = basePricePerDay;
		this.isAvailable = true;
	}

	public String getCarId() {
		return carId;
	}


	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getBasePricePerday() {
		return basePricePerDay;
	}

	public double calculatePrice(int rentalDays) {
		return rentalDays * basePricePerDay;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	public void rent() {
		 isAvailable = false; 
	}
	
	public void returnCar() {
		isAvailable = true;
	}

}
