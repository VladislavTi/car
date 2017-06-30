package car;

public class Car {

	private int rashod;
	private int fuel;
	private boolean go;
	public final static int minFuelLevel = 10;
	
	public Car(int fuel) {
		this.fuel = fuel;
		this.rashod = 1;
	}
	
	public Car(int fuel, int rashod) {
		this.fuel = fuel;
		this.rashod = rashod;
	}
	
	
	public void start() {
		if (this.fuel > 0) {
			out("Car started");
			this.go = true;
		} else {
			out("Cannot start. To few fuel level!");
			this.go = false;
		}
	}
	
	public void stop() {
		this.go = false;
		out("Car stopped");
	}
	
	public void refuel(int fuel) {
		this.fuel += fuel;
		level();
	}
	
	private void level() {
		out("Your fuel level is " + this.fuel);
	}
	
	
	public int getFuelLevel() {
		long timeStart = System.currentTimeMillis();
		while (System.currentTimeMillis() - timeStart <= 1000);
		this.fuel-= rashod;
		level();
		return this.fuel;
	}
	
	public boolean isGoes(){
		if ((this.fuel > 0) && (this.go)) {
			return true;
		} else {
			return false;
		}
	}
	
	private void out(String s) {
		System.out.println(s);
	}
	
	
	public static void showMainMenu() {
        System.out.println("Choise:\n" +
                "1. start\n" +
                "2. stop\n" +
                "3. fill\n" +
                "4. going?\n" +
                "0. exit\n");
    }
	
	@Override
	public boolean equals(Object obj) {
		if( obj == null)
			return false;
		Car car = (Car) obj;
		return car.fuel == this.fuel && car.go == this.go && car.rashod == this.rashod;
		
	}
	
	
	
}
