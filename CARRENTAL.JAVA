package carrental;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class CARRENTAL {
    private final String licensePlate;
    private final String model;
    private boolean isRented;

    public CARRENTAL(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        if (!isRented) {
            isRented = true;
        } else {
            throw new IllegalStateException("Car is already rented.");
        }
    }

    public void returnCar() {
        if (isRented) {
            isRented = false;
        } else {
            throw new IllegalStateException("Car is not rented.");
        }
    }
}

class Customer {
    private final String name;
    private final String driverLicense;

    public Customer(String name, String driverLicense) {
        this.name = name;
        this.driverLicense = driverLicense;
    }

    public String getName() {
        return name;
    }

    public String getDriverLicense() {
        return driverLicense;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RentalAgency {
    private final List<CARRENTAL> cars = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    public void addCar(CARRENTAL car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public CARRENTAL rentCarToCustomer(String licensePlate, String driverLicense) {
        CARRENTAL car = findCarByLicensePlate(licensePlate);
        if (car == null) {
            throw new IllegalArgumentException("Car not found.");
        }
        if (car.isRented()) {
            throw new IllegalStateException("Car is already rented.");
        }

        Customer customer = findCustomerByDriverLicense(driverLicense);
        if (customer == null) {
            throw new IllegalArgumentException("Customer not found.");
        }

        car.rentCar();
        return car;
    }

    public void returnCarFromCustomer(String licensePlate) {
        CARRENTAL car = findCarByLicensePlate(licensePlate);
        if (car == null) {
            throw new IllegalArgumentException("Car not found.");
        }

        car.returnCar();
    }

    public List<CARRENTAL> getAvailableCars() {
        return cars.stream().filter(car -> !car.isRented()).collect(Collectors.toList());
    }
    private CARRENTAL findCarByLicensePlate(String licensePlate) {
        return cars.stream().filter(car -> car.getLicensePlate().equals(licensePlate)).findFirst().orElse(null);
    }

    private Customer findCustomerByDriverLicense(String driverLicense) {
        return customers.stream().filter(customer -> customer.getDriverLicense().equals(driverLicense)).findFirst().orElse(null);
    }
}

public class main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();
        CARRENTAL car1 = new CARRENTAL("KDD123K", "Toyota Corolla");
        CARRENTAL car2 = new CARRENTAL("KDC123K", "Honda CRV");
        agency.addCar(car1);
        agency.addCar(car2);

        Customer customer1 = new Customer("John ", "3468221");
        Customer customer2 = new Customer("James ", "8970659");
        agency.addCustomer(customer1);
        agency.addCustomer(customer2);
        
        try {
            System.out.println("Renting car KDD123K to John ");
            agency.rentCarToCustomer("KDD123K", "3468221");
            System.out.println("Car KDD123K is now unavailable.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Available cars:");
        agency.getAvailableCars().stream().forEach((car) -> {
            System.out.println(car.getLicensePlate() + " - " + car.getModel());
        });

        try {
            System.out.println("Returning car KDD123K from John ");
            agency.returnCarFromCustomer("KDD123K");
            System.out.println("Car KDD123K is now available.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Available cars:");
        agency.getAvailableCars().stream().forEach((car) -> {
            System.out.println(car.getLicensePlate() + " - " + car.getModel());
        });
    }
}
