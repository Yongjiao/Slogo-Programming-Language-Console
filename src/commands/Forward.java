package commands;

public class Forward extends Move {

	public Forward(int steps) {
		super.changeLocation(steps);
	}

	public Forward(String str) {
		int steps = super.checkStr(str);
		super.changeLocation(steps);
	}

}
