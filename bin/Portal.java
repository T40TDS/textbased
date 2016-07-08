import java.util.*;
import java.io.*;

public class Portal implements GameObject{
	private String name;
	private Environment otherSide;
	private String description;
	private String cardinal;

	public Portal(String n, String c, Environment e){
		name = n;
		cardinal = c;
		otherSide = e;
	}

	public Portal(String n, String c, Environment e, String d){
		name = n;
		cardinal = c;
		otherSide = e;
		description = d;
	}
	
	public void setName(String n){
		name = n;
	}

	public String getCardinal(){
		return cardinal;
	}

	public Environment getOtherSide(){
		return otherSide;
	}

	public void setOtherSide(Environment e){
		setEnvironment(e);
	}
	public void setDescription(String d){
		description = d;
	}

	public String getName(){
		return name;
	}

	public Environment getEnvironment(){
		return otherSide;
	}

	public void setEnvironment(Environment e){
		otherSide = e;
	}

	public String description(){
		return description;

	}

}