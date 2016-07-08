import java.util.*;
import java.io.*;

public class Npc implements GameObject{
	String name;
	String description;
	String gender; //gotta keep it Pc, so a string
	public Npc(String n, String g){
		name = n;
		gender = g;
	}

	public Npc(String n, String g, String d){
		name = n;
		gender = g;
		description = d;
	}

	public void setDescription(String d){
		description = d;
	}

	public String description(){
		String s = "";
		s += "You see a " + gender + "person.\n";
		s+= description;
		return s;
	}

	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

}