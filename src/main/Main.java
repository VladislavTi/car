package main;

import car.Car;
import models.Lorry;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;



public class Main {

	
	private static Scanner in;


	private static class MainTask extends TimerTask {

		Car car;
		Lorry lorry;
		private boolean flagLorry;

		MainTask(Car car) {
			this.car = car;
			this.flagLorry = false;
			run();
		}
		
		MainTask(Lorry lorry) {
			this.lorry = lorry;
			this.flagLorry = true;
			run();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (this.flagLorry) {
				if (lorry.isGoes()){
					if (lorry.getFuelLevel() <= Car.minFuelLevel) {
						lorry.stop();
					}
				}
			} else {
				if (car.isGoes()){
					if (car.getFuelLevel() <= Car.minFuelLevel) {
						car.stop();
					}
				}
			}	
		}
		
	}
	
	private static int dozapravka() {
		in = new Scanner(System.in);
		
		System.out.println("How many liters do you want to fill?");
		int fuel = 0;
		try {
			fuel = in.nextInt();
			return fuel;
		} catch (Exception e) {
			System.out.println("Enter number");
		}
		return fuel;
		
		
	}
	
	
	private static void process(Object obj, Car car, Lorry lorry) {
		
		String whatToDo = new String();
		in = new Scanner(System.in);
		
		if (obj.equals(car)) {
			Car.showMainMenu();
			exit:	while (true) {
					
					Timer tim = new Timer();
			        tim.schedule(new MainTask(car), 0, TimeUnit.SECONDS.toMillis(1));
					
					whatToDo = in.next();
					
					switch (whatToDo.toLowerCase()) {
					case "start":
						car.start();
					break;
					case "1":
						car.start();
					break;
					
					case "stop":
						car.stop();
					break;
					case "2":
						car.stop();
					break;
					
					case "fill":
						car.refuel(dozapravka());
					break;
					case "3":
						car.refuel(dozapravka());
					break;
					
					case "going?":
						System.out.println(car.isGoes());
					break;
					case "4":
						System.out.println(car.isGoes());
					break;
					
					case "exit":
						tim.cancel();
						break exit;
					case "0":
						tim.cancel();
						break exit;
						
					default:
						System.out.println("Unknown command");
						
					}

					 tim.cancel();

				}
		} else if (obj.equals(lorry)) {
			Car.showMainMenu();
			exit2:	while (true) {
				
				Timer timer = new Timer();
		        timer.schedule(new MainTask(lorry), 0, TimeUnit.SECONDS.toMillis(1));
				
				whatToDo = in.next();
				
				switch (whatToDo.toLowerCase()) {
				case "start":
					lorry.start();
				break;
				case "1":
					lorry.start();
				break;
				
				case "stop":
					lorry.stop();
				break;
				case "2":
					lorry.stop();
				break;
				
				case "fill":
					lorry.refuel(dozapravka());
				break;
				case "3":
					lorry.refuel(dozapravka());
				break;
				
				case "going?":
					System.out.println(car.isGoes());
				break;
				case "4":
					System.out.println(car.isGoes());
				break;
				
				case "exit":
					timer.cancel();
					break exit2;
				case "0":
					timer.cancel();
					break exit2;
					
				default:
					System.out.println("Unknown command");
					
				}

				 timer.cancel();

			}
		}
	}
	

	public static void main(String[] args) {
		
		
		Car car = new Car(0);
		Lorry lorry = new Lorry(0, 5);
		
		
	exit:	while (true) {
		
			in = new Scanner(System.in);
			System.out.println("Choise transport:\n"
					+ "1. Ford focus\n"
					+ "2. Lorry\n"
					+ "0. Exit");
			int choice = 0;
			try {
				choice = in.nextInt();
			}catch (Exception e) {
				System.err.println("Enter correct number");
				continue exit;
			}
			
			switch (choice) {
			case 1:
				process(car, car, lorry);
			break;
			case 2:
				process(lorry, car, lorry);
			break;
			case 0:
				break exit;
			default:
				System.out.println("Wrong command! Please enter number");
			}
		
		}
		
		
		
		
		
	}

}
