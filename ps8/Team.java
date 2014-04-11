public class Team {
	// Fields to be used throughout the class
	private String teamname;
	private int size;
	private Player[] players;
	
	// Constructs a team given no parameters
	public Team() {
		players = new Player[100];
		size = 0;
	}
	
	// Constructs a team given the team name
	public Team(String iteamname){
		teamname = iteamname;
		size = 0;
		players = new Player [100];
	}
	
	// Add a blank player to the team
	public Player[] addPlayer(){
		players[size] = new Player();
		size++;
		return players;
	}
	
	// arguments to addPlayer method mean: jersey no, position, name,
    // height, weight, field goal shooting percentage, player status,
    // and date of birth in that order. A player position may be "F" for
    // a forward, "G" for a guard, or "C" for a center.  A player status
    // may be "S" for a starting member, "R" for a regular non-starting
    // member, or "D" for a player on the disabled list.
	public Player[] addPlayer(int ijersey, String iposition, String iname, String iheight,
			int iweight, double ifgsp, String istatus, String idob){
		players[size] = new Player(ijersey, iposition, iname, iheight,
				iweight, ifgsp, istatus, idob);
		size++;
		return players;
	}
	
	// Getters
	public String getTeamName(){
		return teamname;
	}
	public int getSize(){
		return size;
	}
	public Player[] getPlayers(){
		return players;
	}
	public Player getPlayer(int i){
		return players[i];
	}
	
	// Setters
	public void setTeamName(String nteamname){
		teamname = nteamname;
	}
	public void setSize(int nsize){
		size = nsize;
	}
	public void setPlayers(Player[] nplayers){
		players = nplayers;
	}
	public void setPlayer(int i, Player newi){
		players[i] = newi;
	}
	
	// A method to search for a specific player given their name
	public Player searchPlayer(String name){
		Player temp = new Player();
		for (int i = 0; i <= size; i++){
			temp = getPlayer(i);
			if ((temp.getName()).equals(name)){
				return temp;
			}
		}
		return players[size+1];
	}
	// shootingAverage() returns the field goal shooting average of
    // all the players on the team including the players on the disabled
    // list.
	public double shootingAverage(){
		double totalFGSP = 0;
		for (int i = 0; i < size; i++){
			totalFGSP = totalFGSP + players[i].getFGSP();
		}
		return totalFGSP/size;
	}

	// shootingAverageOfStarters() returns the shooting average of
    // the starting members only on the team.
	public double shootingAverageOfStarters(){
		double totalFGSP = 0;
		double starters = 0;
		for (int i =0; i < size; i++){
			if ((players[i].getStatus()).equals("S")){
				starters++;
				totalFGSP = totalFGSP + players[i].getFGSP();
			}
		}
		return totalFGSP/starters;
	}
	
	// heightAverage() returns the average height of all the players
    // on the team in number of feet and inches, e.g., "6-3" if it is
    // 6 feet 3 inches.
	public String heightAverage(){
		int totalInches = 0;
		for (int i = 0; i < size; i++){
			String height = players[i].getHeight();
			int inches = TeamTools.ftinToInches(height);
			totalInches = totalInches + inches;
		}
		int avgInches = (int)(totalInches/(size));
		String ftin = TeamTools.inchesToFtIn(avgInches);
		return ftin;
	}
	
	// returns the number of players with a specified status
	public int numberOfPlayers(String stat){
		int count = 0;
		for (int i = 0; i < size; i++){
			if ((players[i].getStatus()).equals(stat)){
				count++;
			}
		}
		return count;
	}
	
	// returns the number of players in a specified position
	public int numberOfPlayersInPosition(String pos){
		int count = 0;
		for (int i = 0; i < size; i++){
			if ((players[i].getPosition()).equals(pos)){
				count++;
			}
		}
		return count;
	}
	
	//returns the number of players above a certain age
	public int numberOfPlayersOlderThan(int age){
		int count = 0;
		for (int i = 0; i < size; i++){
			if ((players[i].getAge())>age){
				count++;
			}
		}
		return count;
	}

}
