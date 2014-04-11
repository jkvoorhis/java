public class UseTeam {

	// A method to create and initialize team objects for the Lakers
	// and the Heat
    private static Team buildTeam (String teamName) {

        Team tm = new Team(teamName);

        if (teamName.equals("Lakers")) {
            tm.addPlayer( 9, "F", "Matt Barnes", "6-7", 226, 40.12, "R", "3/9/1980");
            tm.addPlayer( 5, "G", "Steve Blake", "6-3", 172, 43.54, "R", "2/26/1980");
            tm.addPlayer(24, "G", "Kobe Bryant", "6-6", 205, 48.65, "S", "8/23/1978");
            tm.addPlayer(17, "C", "Andrew Bynum", "7-0", 285, 47.65, "R", "10/27/1987");
            tm.addPlayer( 3, "F", "Devin Ebanks", "6-9", 215, 38.9, "D", "10/28/1989");
            tm.addPlayer(88, "F", "Christian Eyenga", "6-7", 210, 37.7, "R", "6/22/1989");
            tm.addPlayer(16, "C", "Pau Gasol", "7-0", 250, 50.34, "S", "7/6/1980");
            tm.addPlayer(0, "G", "Andrew Goudelock", "6-3", 200, 40.14, "R", "12/7/1988");
            tm.addPlayer(27, "C", "Jordan Hill", "6-10", 235, 40.34, "R", "7/27/1987");
            tm.addPlayer(6, "F", "Josh McRoberts", "6-10", 240, 39.43, "R", "2/28/1987");
            tm.addPlayer(1, "G", "Darius Morris", "6-4", 190, 41.33, "R", "1/3/1991");
            tm.addPlayer(14, "C", "Troy Murphy", "6-11", 245, 40.43, "R", "5/2/1980");
            tm.addPlayer(7, "G", "Ramon Sessions", "6-3", 190, 39.12, "R", "4/11/1986");
            tm.addPlayer(15, "F", "Metta World Peace", "6-7", 260, 42.34, "S", "11/13/1979");
        }
        else if (teamName.equals("Heat")) {
            tm.addPlayer(50, "C", "Joel Anthony", "6-9", 245, 42.63, "S", "8/9/1982");
            tm.addPlayer(31, "F", "Shane Battier", "6-8", 225, 48.14, "S", "9/9/1978");
            tm.addPlayer(1, "F", "Chris Bosh", "6-11", 235, 39.55, "S", "3/24/1984");
            tm.addPlayer(15, "G", "Mario Chalmers", "6-2", 190, 47.62, "S", "5/19/1986");
            tm.addPlayer(30, "G", "Norris Cole", "6-2", 175, 54.94, "R", "10/13/1988");
            tm.addPlayer(34, "C", "Eddy Curry", "7-0", 295, 50.54, "R", "12/5/1982");
            tm.addPlayer(14, "G", "Terrel Harris", "6-4", 190, 38.73, "R", "8/10/1987");
            tm.addPlayer(40, "F", "Udonis Haslem", "6-8", 235, 43.73, "R", "6/9/1980");
            tm.addPlayer(5, "F", "Juwan Howard", "6-9", 250, 49.94, "R", "2/7/1973");
            tm.addPlayer(6, "F", "LeBron James", "6-8", 250, 54.65, "S", "12/30/1984");
            tm.addPlayer(22, "G", "James Jones", "6-8", 215, 50.66, "R", "10/4/1980");
            tm.addPlayer(13, "F", "Mike Miller", "6-8", 210, 45.37, "R", "2/19/1980");
            tm.addPlayer(45, "C", "Dexter Pittman", "6-11", 285, 40.29, "R", "3/2/1988");
            tm.addPlayer(21, "C", "Ronny Turiaf", "6-10", 245, 42.45, "D", "1/13/1983");
            tm.addPlayer(3, "G", "Dwyane Wade", "6-4", 220, 43.34, "D", "1/17/1982");
 
        }
        else {
            System.out.println(teamName + " is not supported yet.");
            return null;
        }
        return tm;
    }

    public static void main (String[] args) {
        
        Team lakers = buildTeam("Lakers");
        Team heat = buildTeam("Heat");

        // Lakers information
        Player p = lakers.searchPlayer("Kobe Bryant");

        System.out.println("Info on Kobe Bryant is: " + p);

        System.out.println("\nKobe Bryant is " + p.getAge() + " years old.");

        System.out.println("\nShooting average of Lakers is: "
                           + lakers.shootingAverage());
        
        System.out.println("Shooting average of Lakers' starters is: "
                           + lakers.shootingAverageOfStarters());
        
        System.out.println("\nAverage height of Lakers players is: "
                           + lakers.heightAverage());
        
        
        System.out.println("\nNumber of starters on the Lakers team is: "
                           + lakers.numberOfPlayers("S"));
        System.out.println("Number of regular non-starters on the Lakers team is: "
                           + lakers.numberOfPlayers("R"));
        System.out.println("Number of players on the disabled list on the Lakers team is: "
                           + lakers.numberOfPlayers("D"));
        

        System.out.println("\nNumber of guards on the Lakers team is: "
                           + lakers.numberOfPlayersInPosition("G"));
        System.out.println("Number of centers on the Lakers team is: "
                           + lakers.numberOfPlayersInPosition("C"));
        System.out.println("Number of forwards on the Lakers team is: "
                           + lakers.numberOfPlayersInPosition("F"));

        System.out.println("\nNumber of players older than 30 on the Lakers team is: "
                           + lakers.numberOfPlayersOlderThan(30));
        
        // Heat information
        Player h = heat.searchPlayer("LeBron James");

        System.out.println("\n\nInfo on LeBron James is: " + h);

        System.out.println("\nLeBron James is " + h.getAge() + " years old.");

        System.out.println("\nShooting average of Heat is: "
                           + heat.shootingAverage());
        
        System.out.println("Shooting average of Heat's starters is: "
                           + heat.shootingAverageOfStarters());
        
        System.out.println("\nAverage height of Heat players is: "
                           + heat.heightAverage());
        
        
        System.out.println("\nNumber of starters on the Heat team is: "
                           + heat.numberOfPlayers("S"));
        System.out.println("Number of regular non-starters on the Heat team is: "
                           + heat.numberOfPlayers("R"));
        System.out.println("Number of players on the disabled list on the Heat team is: "
                           + heat.numberOfPlayers("D"));
        

        System.out.println("\nNumber of guards on the Heat team is: "
                           + heat.numberOfPlayersInPosition("G"));
        System.out.println("Number of centers on the Heat team is: "
                           + heat.numberOfPlayersInPosition("C"));
        System.out.println("Number of forwards on the Heat team is: "
                           + heat.numberOfPlayersInPosition("F"));

        System.out.println("\nNumber of players older than 30 on the Heat team is: "
                           + heat.numberOfPlayersOlderThan(30));
    }

}