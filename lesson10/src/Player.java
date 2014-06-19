public class Player implements Comparable<Player> {
	private final int number;
	private final String name;
	private final char position;
	private final double avgPoints;
	private final double avgRebounds;
	private final double avgAssists;
	private final double avgMins;

	public Player(String pName, int pNbr, char pPos, double pPoints,
			double pRebounds, double pAssists, double pMins) {
		name = pName;
		number = pNbr;
		position = pPos;
		avgPoints = pPoints;
		avgRebounds = pRebounds;
		avgAssists = pAssists;
		avgMins = pMins;
	}

	@Override
	public String toString() {
		return "Player: " + name + "\n   Number:        " + number
				+ "\n   Position:      " + position + "\n   Points/Game:   "
				+ avgPoints + "\n   Rebounds/Game: " + avgRebounds
				+ "\n   Assists/Game:  " + avgAssists + "\n   Minutes/Game:  "
				+ avgMins;
	}

	public String toFile() {
		return name + " " + number + " " + position + " " + avgPoints + " "
				+ avgRebounds + " " + avgAssists + " " + avgMins;
	}

	public String getName() {
		return name;
	}

	public int getNum() {
		return number;
	}

	public String getPosition() {
		if (position == 'C') {
			return "Center";
		}
		if (position == 'F') {
			return "Forward";
		}
		if (position == 'G') {
			return "Guard";
		}
		if (position == 'P') {
			return "Point Guard";
		}
		return "Invalid Position";
	}

	public double getAvgPoints() {
		return avgPoints;
	}

	public double getAvgRebounds() {
		return avgRebounds;
	}

	public double getAvgAssists() {
		return avgAssists;
	}

	public double getAvgMins() {
		return avgMins;
	}

	@Override
	public int compareTo(Player p) {
		if (number > p.number) {
			return 1;
		} else if (number < p.number) {
			return -1;
		} else {
			return 0;
		}
	}
}
