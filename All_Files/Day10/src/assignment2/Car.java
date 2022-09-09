package assignment2;

public abstract class Car {
	CarType model;
	public Car(CarType model) {
		this.model=model;
	}
	protected abstract void construct();
	
	public void setModel(CarType model){
		this.model=model; 
		
	}
	public CarType getModel(){
		return model;
	}
}
