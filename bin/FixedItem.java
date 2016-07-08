import java.util.*;
import java.io.*;


public class FixedItem extends Item{
	public FixedItem(String name, String description, int weight){
		super(name, description, weight);
		this.setFixed(true);
	}

}