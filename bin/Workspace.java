public class Workspace{
	CommandInterface commands = new CommandInterface()//arguments?? who knows //or maybe this is just behavior in the workspace class?
	Environment working;
	Player player;
	int exitCode = -1;

	public Workspace(String playerName){ //more arugments, who knows

		player = new Player(playerName);
		ArrayList<Items> items= new ArrayList<Items>();
		items.add(new Item("a cardigan", "This is a red cardigan outfitted with brown buttons. It looks rather comfortable.", 1));
		items.add(new Item(("a straweberry", "This is a juicy red straweberry.", 1)));
		working = new Environment("The Testing Room", new ArrayList<FixedItems>(), items, 
			new ArrayList<Portals>(), new ArrayList<Vehicles>(), new ArrayList<Npc>() );

	}

	public runGame(){
		while(exitCode == -1){
			commands.setWorkspace(this);
			exitCode = commands.runInput();
		}
	}


}