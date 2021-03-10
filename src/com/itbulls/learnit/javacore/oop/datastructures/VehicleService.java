package com.itbulls.learnit.javacore.oop.datastructures;

public class VehicleService {
	
	public void moveVehicle(Vehicle vehicle) {
		if (vehicle instanceof ElectricCar) {
			// get electric engine, get wheels and move wheels
		}
		
		if (vehicle instanceof PetrolCar) {
			// get petrol engine, get wheels and move wheels
		}
		
		if (vehicle instanceof Motorcycle) {
			// get motorcycle engine, get two wheels and move wheels
		}
	}
	
	public void startVehicleEngine(Vehicle vehicle) {
		if (vehicle instanceof ElectricCar) {
			// get electric engine and start it
		}
		
		if (vehicle instanceof PetrolCar) {
			// get petrol engine and start it
		}
		
		if (vehicle instanceof Motorcycle) {
			// get motorcycle's engine and start it
		}
	}

}



