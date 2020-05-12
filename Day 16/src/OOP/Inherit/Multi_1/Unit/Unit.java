package OOP.Inherit.Multi_1.Unit;

public abstract class Unit {
	protected String name;
	protected String character;
	protected String command;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getCommand() {
		return this.command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public Unit(String name, String character) {
		this.name = name;
		this.character = character;
	}

	abstract public void attack();

	abstract public void move();
}