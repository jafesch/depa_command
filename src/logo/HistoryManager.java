package logo;

import logo.commands.turtle.TurtleCommand;

public interface HistoryManager {
	public void addCommand(TurtleCommand command);
	public void clear();
	public void undo();
	public void redo();
	public Iterable<TurtleCommand> getCommands();
}
