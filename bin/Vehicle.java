import java.util.*;
import java.io.*;



public class Vehicle extends Portal{
	private ArrayList<Environment> destinationList = new ArrayList<Environment>();
	private Environment vehicleEnvironment = new Environment("placeholder"); //thid doesn't point to the right thing unless you make it!!!!!!!!!!!! ~It's bad but live with it 
	private int locationIndex;												 //a vehicle environment must have it's 0th portal be the exit at all times
	private int id;
	public Vehicle(String name, String cardinal, Environment currentEnvironment){
		super(name, cardinal, new Environment("placeholder"));
		vehicleEnvironment = new Environment(name + " interior");
		vehicleEnvironment.addPortal(new Portal(name + " exit", "left", currentEnvironment));
		this.setInteriorEnvironment(vehicleEnvironment);
		id = this.getName().hashCode();
	}

	public Vehicle(String name, String cardinal, Environment currentEnvironment, ArrayList<Environment> destinations){
		super(name, cardinal, new Environment("placeholder"));
		destinationList = destinations;
		vehicleEnvironment = new Environment(name + " interior");
		vehicleEnvironment.addPortal(new Portal(name + " exit", "left", currentEnvironment));
		this.setInteriorEnvironment(vehicleEnvironment);
		id = this.getName().hashCode();
	}
	private Environment getInteriorEnvironment(){
		return this.getEnvironment();
	}

	public Environment getVehicleEnvironment(){
		return this.getInteriorEnvironment();
	}
	public void setExitDescription(String s){
		vehicleEnvironment = this.getInteriorEnvironment();
		vehicleEnvironment.getPortal().setDescription(s);
	}

	public void addDestination(Environment e){
		destinationList.add(e);
	}

	public void removeDesitnation(Environment e){ //ByName
		Iterator<Environment> it = destinationList.iterator();
		while(it.hasNext()){
			if(it.next().getName().equals(e.getName())){
				it.remove();
			}
		}
	}

	public boolean equals(Vehicle other){
		if(other.id == this.id){
			return true;
		}
		return false;
	}

	public void travelBack(){
		Environment oldDestination = destinationList.get(locationIndex);
		if(locationIndex == destinationList.size() - 1){
			locationIndex = 0;
		}else{
			locationIndex--;
		}

		vehicleEnvironment = this.getInteriorEnvironment();
		Portal p = vehicleEnvironment.getPortal();
		p.setOtherSide(destinationList.get(locationIndex));
		vehicleEnvironment.removePortal();
		vehicleEnvironment.addVehicleExit(p); // this might start throwing exceptions because arraylists are stooooooo with gaps
		oldDestination.removeVehicle(this);
		destinationList.get(locationIndex).addVehicle(this);
	}


	public void travel(){
		Environment oldDestination = destinationList.get(locationIndex);
		if(locationIndex == destinationList.size() - 1){
			locationIndex = 0;
		}else{
			locationIndex++;
		}

		vehicleEnvironment = this.getInteriorEnvironment();
		Portal p = vehicleEnvironment.getPortal();
		p.setOtherSide(destinationList.get(locationIndex));;
		vehicleEnvironment.removePortal();
		vehicleEnvironment.addVehicleExit(p); // this might start throwing exceptions because arraylists are stooooooo with gaps
		oldDestination.removeVehicle(this);
		destinationList.get(locationIndex).addVehicle(this);
	}

	public void setInteriorDescription(String s){
		vehicleEnvironment = this.getInteriorEnvironment();
		vehicleEnvironment.setBaseDescription(s);
	}

	private void setInteriorEnvironment(Environment e){//yeah it's stoo just live with it
	this.setEnvironment(e);
}


}