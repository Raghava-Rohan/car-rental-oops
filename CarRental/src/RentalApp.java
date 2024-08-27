public class RentalApp {

	public static void main(String[] args) {
		CarRentalSystem rentalSystem = new CarRentalSystem();
		
		Car car1 = new Car("C01","Toyota", "Innova", "PETROL","WHITE", 85);
		Car car2 = new Car("C02", "TATA", "NEXON","EV","BLUE", 65);
		Car car3 = new Car("C03","MAHINDRA","THAR","DIESEL","RED", 95);
		Car car4 = new Car("C04","FORD","ENDEVOUR","DIESEL","BLACK",155);
		
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);
		rentalSystem.addCar(car4);
		
		rentalSystem.menu();

	}

}
