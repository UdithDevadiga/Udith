package assignment2;

public class CarFactory {
	public CarType buildCar(CarType model) {
		if(model.toString()==null) {
			return null;
		}
		if(model.toString().equalsIgnoreCase("small")) {
			Car c= new SmallCar();
			c.setModel(model);
			return c.getModel();
		}
		else if(model.toString().equalsIgnoreCase("sedan")){
			Car c= new SmallCar();
			c.setModel(model);
			return c.getModel();
		}
		else if(model.toString().equalsIgnoreCase("luxury")) {
			Car c= new SmallCar();
			c.setModel(model);
			return c.getModel();
		}
		return null;
	}
}
