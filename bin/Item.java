import java.util.*;
import java.io.*;

public class Item implements GameObject{
	private String name;
	private String description;
	private int weight;
	private boolean interactables; //probably an interface b/c fixed and non-fixed can be interactable //These last 4 have no bearing on the actual code of "Item", 
	private boolean wearable;							                                           //rather they serve as a framework for future classes 
	private boolean craftable;
	private boolean fixed = false;

	public Item(String n, String d, int w){
		name = n;
		description = d;
		weight = w;
	}

	public void setFixed(boolean f){
		fixed = f;
	}

	public int getWeight(){
		return weight;
	}
	public void setWeight(int w){
		weight = w;
	}

	public void setName(String s){
		name = s;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String s){
		description = s;
	}

	public String description(){
		return description;
	}


}