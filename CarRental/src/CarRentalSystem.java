import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;

	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void rentCar(Car car, Customer customer, int days) {
		if (car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, customer, days));
		} else {
			System.out.println("...CAR IS NOT AVAILABLE FOR RENT...");
		}
	}

	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove = null;
		for (Rental rental : rentals) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}
		if (rentalToRemove != null) {
			rentals.remove(rentalToRemove);
			System.out.println("\n CAR RETURNED SUCCESSFULLY");
		} else {
			System.out.println("\n CAR WAS NOT RENTED");
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n ------Welcome To Zing Car Rentals------ \n");
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the leftover newline

			if (choice == 1) {
				// Rent a Car process
				System.out.println("\n---Rent a Car---\n");
				System.out.println("Enter your name :");
				String customer_name = scanner.nextLine();

				System.out.println("Enter your Phone Number :");
				String phone_number = scanner.nextLine();

				System.out.println("\nAvailable Cars :");
				for (Car car : cars) {
					if (car.isAvailable()) {
						System.out.println(car.getCarId() + "  " + car.getBrand() + "  " + car.getModel() + "  "
								+ car.getType() + "  " + car.getColor() + "  " + car.getBasePricePerday());
					}
				}

				System.out.println("\nEnter Car ID to Rent :");
				String car_Id = scanner.nextLine();

				System.out.println("\nEnter number of days for rental :");
				int rentalDays = scanner.nextInt();
				scanner.nextLine(); // Consume the leftover newline

				// Check if customer already exists
				Customer existingCustomer = null;
				for (Customer customer : customers) {
					if (customer.getCustomer_name().equals(customer_name)
							&& customer.getPhone_number().equals(phone_number)) {
						existingCustomer = customer;
						break;
					}
				}

				Customer newCustomer = existingCustomer;
				if (newCustomer == null) {
					newCustomer = new Customer("CUS" + (customers.size() + 1), customer_name, phone_number);
					addCustomer(newCustomer);
				}

				Car selectedCar = null;
				for (Car car : cars) {
					if (car.getCarId().equalsIgnoreCase(car_Id) && car.isAvailable()) {
						selectedCar = car;
						break;
					}
				}

				if (selectedCar != null) {
					double totalPrice = selectedCar.calculatePrice(rentalDays);
					System.out.println("\n ----Rental Information---- \n");
					System.out.println(" Customer ID : " + newCustomer.getCustomer_id());
					System.out.println(" Customer Name : " + newCustomer.getCustomer_name());
					System.out.println(" Customer Phone Number : " + newCustomer.getPhone_number());
					System.out.println(" Car : " + selectedCar.getCarId() + " " + selectedCar.getBrand() + " "
							+ selectedCar.getModel() + " " + selectedCar.getType() + " " + selectedCar.getColor());
					System.out.println(" Rental Days : " + rentalDays);
					System.out.println(" Total Price : " + totalPrice);

					System.out.print("\nConfirm rental (Y/N): ");
					String confirm = scanner.nextLine();

					if (confirm.equalsIgnoreCase("Y")) {
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("\nCar rented successfully.");
					} else {
						System.out.println("\nRental canceled.");
					}
				} else {
					System.out.println("\nInvalid car selection or car not available for rent.");
				}
			} else if (choice == 2) {
				// Return Car process
				System.out.println("\n ---Return Car --- \n");
				System.out.println("Enter Id of Car to Return :");
				String car_Id = scanner.nextLine();

				Car carToReturn = null;
				for (Car car : cars) {
					if (car.getCarId().equalsIgnoreCase(car_Id) && !car.isAvailable()) {
						carToReturn = car;
						break;
					}
				}

				if (carToReturn != null) {
					Customer customer = null;
					for (Rental rental : rentals) {
						if (rental.getCar().equals(carToReturn)) {
							customer = rental.getCustomer();
							break;
						}
					}

					if (customer != null) {
						returnCar(carToReturn);
						System.out.println("\n Car Returned Successfully by " + customer.getCustomer_name() + "  "
								+ customer.getPhone_number());
					} else {
						System.out.println("\n Car was not Rented");
					}
				} else {
					System.out.println("\n Invalid Car ID or car not Rented");
				}
			} else if (choice == 3) {
				break;
			} else {
				System.out.println("\n Invalid Option Chosen -- Please enter a Valid Option");
			}
		}

		System.out.println("Thank You For Choosing Zing Car Rentals");
		scanner.close();
	}
}
