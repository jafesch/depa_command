package logo;


import logo.commands.Command;
import logo.commands.turtle.TurtleCommand;

public interface MacroManager{
	public boolean isRecordingMacro();
	public void addCommand(TurtleCommand command);
	public void startMacro(String name);
	public Command getCommand(String name);
	public void endMacro();
}

