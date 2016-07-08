import java.util.*;
import java.io.*;

public class Environment{
	private ArrayList<FixedItem> fixedItems = new ArrayList<FixedItem>();//this is kinda stoo, there should be some polymorphic behavior here
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Portal> portals = new ArrayList<Portal>();
	private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	private ArrayList<Npc> npcs = new ArrayList<Npc>();
	private String name;
	private int id;
	String baseDescription = "";
	//default constructer
	public Environment(String s){
		name = s;
	}

	public Environment(String s, ArrayList<FixedItem> f, ArrayList<Item> i, ArrayList<Portal> p, ArrayList<Vehicle> v, ArrayList<Npc> n){
		items = i;
		fixedItems = f;
		portals = p; 
		vehicles = v;
		npcs = n;
		name = s;
	}

	public void setBaseDescription(String s){
		baseDescription += "You are in the " + this.name + "\n";
		baseDescription += s;
	}

	public void setName(String s){
		name = s;
	}

	public String getName() {
		return name;
	}
	public String description(){
		String s = "";
		s += baseDescription + "\n";
		s += "You see ";

		//items
		for(Item i : items){
			s += i.getName() + ", "; //getName() comes with a/an/the article
		}

		//and and signle item list processing
		s = s.substring(0, s.lastIndexOf(","));
		s = s.substring(0, s.lastIndexOf(",")) + " and " + s.substring(s.lastIndexOf(",") + 2);
		if(s.charAt(s.length()-1) == ' '){
			s = s.substring(0, s.lastIndexOf("and") - 1);
		}
		s += "\n";

		s += "You see ";
		for(FixedItem i : fixedItems){
			s += i.getName() + ", "; //getName() comes with a/an/the article
		}

		//and and signle item list processing
		s = s.substring(0, s.lastIndexOf(","));
		s = s.substring(0, s.lastIndexOf(",")) + " and " + s.substring(s.lastIndexOf(",") + 2);
		if(s.charAt(s.length()-1) == ' '){
			s = s.substring(0, s.lastIndexOf("and") - 1);
		}
		s += "\n";

		s += "You see ";
		for(Vehicle i : vehicles){
			s += i.getName() + ", "; //getName() comes with a/an/the article
		}

		//and and signle item list processing
		s = s.substring(0, s.lastIndexOf(","));
		s = s.substring(0, s.lastIndexOf(",")) + " and " + s.substring(s.lastIndexOf(",") + 2);
		if(s.charAt(s.length()-1) == ' '){
			s = s.substring(0, s.lastIndexOf("and") - 1);
		}
		s += "\n";


		s += "You see ";
		for(Portal i : portals){
			s += i.getName() + " to the " + i.getCardinal()  + ", "; //getName() comes with a/an/the article
		}

		//and and signle item list processing
		s = s.substring(0, s.lastIndexOf(","));
		s = s.substring(0, s.lastIndexOf(",")) + " and " + s.substring(s.lastIndexOf(",") + 2);
		if(s.charAt(s.length()-1) == ' '){
			s = s.substring(0, s.lastIndexOf("and") - 1);
		}
		s += "\n";

		s += "You see ";
		for(Npc i : npcs){
			s += i.getName() + ", "; //getName() comes with a/an/the article
		}

		//and and signle item list processing
		s = s.substring(0, s.lastIndexOf(","));
		s = s.substring(0, s.lastIndexOf(",")) + " and " + s.substring(s.lastIndexOf(",") + 2);
		if(s.charAt(s.length()-1) == ' '){
			s = s.substring(0, s.lastIndexOf("and") - 1);
		}
		s += "\n";

		return s;
	}


	//returns the GameObject request(param s is assumed to be pulled straight from the UI), null if not there
	public GameObject getGameObject(String s){
		for(Item i: items){
			if(i.getName().equalsIgnoreCase(s)){

				return i;
			}

		}

		for(FixedItem i: fixedItems){
			if(i.getName().equalsIgnoreCase(s)){

				return i;
			}

		}

		for(Portal i: portals){
			if(i.getName().equalsIgnoreCase(s)){

				return i;
			}

		}

		for(Vehicle i: vehicles){
			if(i.getName().equalsIgnoreCase(s)){

				return i;
			}

		}

		for(Npc i: npcs){
			if(i.getName().equalsIgnoreCase(s)){

				return i;
			}

		}
		return null;

	}

	public void setCardEnv(String cardinal, Environment e, String name){
		for(Portal p: portals){
			if(p.getCardinal().equalsIgnoreCase(cardinal)){
				portals.remove(p);
			}
		}

		this.addPortal(new Portal(name, cardinal, e));

	}
	public Environment go(String cardinal){
		for(Portal p: portals){
			if(p.getCardinal().equalsIgnoreCase(cardinal)){
				return p.getOtherSide();
			}

		}

		return null;

	}

	public Environment enterVehicle(String vehicle){
		for(Vehicle v: vehicles){
			if(v.getName().equalsIgnoreCase(vehicle)){
				return v.getVehicleEnvironment();
			}
		}

		return null;

	}

	public void addPortal(Portal p){
		portals.add(p);
	}

	public Portal getPortal(){//returns the first portal in portals, made for vehicles
		return portals.get(0);
	}

	public void removePortal(){//removes the first portal, made for vehicles
		portals.remove(0);
	}
	public void addVehicleExit(Portal p){
		portals.add(0, p); //adds the vehicle exit, built for vehicles
	}
	public void addVehicle(Vehicle v){
		vehicles.add(v);
	}

	public void removeVehicle(Vehicle other){
		Iterator<Vehicle> it = vehicles.iterator();
		while(it.hasNext()){
			if(it.next().equals(other)){
				it.remove();
			}
		}

	}

	public void addItem(Item i){
		items.add(i);
	}

	public void addFixedItem(FixedItem i){
		fixedItems.add(i);
	}
	//runs when you enter an environment
	public void load(){
		System.out.println(this.description());

	}


}