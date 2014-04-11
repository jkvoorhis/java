
public class test {

	public static void main (String[] args){
		/*Player n = new Player();
		n.setDOB("06/23/1978");
		System.out.println(n.getAge());*/
		
		Team t = new Team();
		t.addPlayer(6, "iposition", "iname", "6-1",
				139, 10., "istatus", "idob");
		t.addPlayer(7, "position", "name", "6-2",
				139, 20., "status", "dob");
		System.out.println(t.getPlayer(0));
		System.out.println(t.getPlayer(1));
		/*Player p = t.searchPlayer("iname");
		System.out.println(p);
		System.out.println(TeamTools.ftinToInches("6-1"));
		System.out.println(TeamTools.inchesToFtIn(73));
		System.out.println(Integer.toString(73));
		String height = "";
		System.out.println(height);
		String ft = Integer.toString(6);
		System.out.println(ft);
		String in = Integer.toString(1);
		System.out.println(in);
		String nheight = height.concat(ft);
		nheight = nheight.concat("-");
		nheight = nheight.concat(in);
		System.out.println(nheight);*/
		System.out.println(t.heightAverage());
		System.out.println(t.shootingAverage());
	}
}
