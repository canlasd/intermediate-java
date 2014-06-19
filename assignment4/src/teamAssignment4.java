public class teamAssignment4<Player> extends MyAbstractList implements MyList {
	private final MyList<Player> playerlist; // ArrayList to hold the playerlist

	public teamAssignment4() {
		playerlist = new MyConcreteArrayList<Player>(); // create ArrayList
	}

	public void addPlayer(Player player) {
		playerlist.add(player); // add player to playerlist
	}

	@Override
	public String toString() {

		String teamplayerlist = "Team playerlist\n\n";
		// output String

		for (int i = 0; i < playerlist.size(); i++) // for each player in
													// playerlist
		{
			teamplayerlist = teamplayerlist + playerlist.get(i).toString()
					+ "\n";
			// add name to output

		}

		return teamplayerlist; // return output string

	}

	@Override
	public void remove(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
