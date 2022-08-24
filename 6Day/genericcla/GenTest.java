package genericcla;

public class GenTest<T> {
		T var;
		GenTest(T var){
			this.var=var;
		}
		T display() {
			return var; 
		}
}
