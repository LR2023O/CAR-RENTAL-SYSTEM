CARRENTAL Class
The CARRENTAL class represents a car in the rental system. It has properties for the car's license plate, model, and rental status.

Fields:

licensePlate: The license plate of the car.
model: The model of the car.
isRented: A boolean indicating whether the car is currently rented or not.
Constructor:

Initializes the car with a license plate and model, and sets isRented to false.
Methods:

getLicensePlate(): Returns the license plate of the car.
getModel(): Returns the model of the car.
isRented(): Returns whether the car is rented.
rentCar(): Marks the car as rented if it is not already rented. 
returnCar(): Marks the car as returned if it is currently rented.
Customer Class
The Customer class represents a customer in the rental system.

Fields:

name: The name of the customer.
driverLicense: The driver's license number of the customer.
Constructor:

Initializes the customer with a name and a driver's license.
Methods:

getName(): Returns the name of the customer.
getDriverLicense(): Returns the driver's license of the customer.
RentalAgency Class
The RentalAgency class manages the cars and customers in the rental system.

Fields:

cars: A list of CARRENTAL objects representing the cars available for rent.
customers: A list of Customer objects representing the customers.
Methods:

addCar(CARRENTAL car): Adds a car to the rental agency.
addCustomer(Customer customer): Adds a customer to the rental agency.
rentCarToCustomer(String licensePlate, String driverLicense): Rents a car to a customer based on the car's license plate and the customer's driver's license. 
returnCarFromCustomer(String licensePlate): Returns a car based on its license plate. 
getAvailableCars(): Returns a list of available (not rented) cars.
findCarByLicensePlate(String licensePlate): Finds and returns a car by its license plate, or null if not found.
findCustomerByDriverLicense(String driverLicense): Finds and returns a customer by their driver's license, or null if not found.
Main Class
The main class contains the main method, which is the entry point of the application. It demonstrates the functionality of the car rental system.

In the main method:
A RentalAgency object is created.
Two CARRENTAL objects and Two Customer objects are created and added to the rental agency.
An attempt is made to rent a car to a customer, and the status is printed.
The available cars are printed.
An attempt is made to return a car, and the status is printed.
The available cars are printed again.
