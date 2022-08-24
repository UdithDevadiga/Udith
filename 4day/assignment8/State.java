package assignment8;

import java.util.ArrayList;
import java.util.List;

public class State {
	String stateName;
	List<String> l=new ArrayList<String>();
	public void setStateName(String stateName) {
		this.stateName=stateName;
	}
	public String getStateName() {
		return stateName;
	}
	public List<String> getCities() {
		return l;
	}
}
