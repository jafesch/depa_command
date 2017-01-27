package logo;

import logo.commands.Command;
import logo.commands.turtle.CompositeCommand;
import logo.commands.turtle.TurtleCommand;

import java.awt.*;
import java.util.*;

public class StdMacroManager implements MacroManager {
	private final LogoInterpreter interpreter;
	private boolean isRecording = false;
	private Map<String, CompositeCommand> commands = new HashMap();
	String currentMacroName;

	public StdMacroManager(LogoInterpreter interpreter) {
		this.interpreter = interpreter;
	}

	/**
	 * Indicates whether a macro is currently being recorded.
	 */
	@Override
	public boolean isRecordingMacro() {
		// TODO return the respective state value
		return isRecording;
	}

	/**
	 * Adds a command to the current macro. If this method is invoked while no
	 * macro is being recorded, then a NullPointerException should be thrown.
	 */
	@Override
	public void addCommand(TurtleCommand command) {
		// TODO store the command provided by the parameter in the list of commands
		// to be executed by the macro
		if (!isRecording) throw new NullPointerException();
		commands.get(currentMacroName).add(command);
		interpreter.setColor(Color.red);
		command.execute();
		interpreter.setColor(Color.black);
	}

	/**
	 * Starts the recording of a new macro.
	 */
	@Override
	public void startMacro(String name) {
		// TODO generate a new data structure to store a sequence of TurtleCommands
		// as macro under the given name
		isRecording = true;
		currentMacroName = name;
		commands.put(name, new CompositeCommand(name));
	}

	/**
	 * Closes the recording of the current macro and registers the macro under its
	 * name.
	 */
	@Override
	public void endMacro() {
		// TODO store the recorded list of commands for instance in a map
		isRecording = false;
		interpreter.repaint();
	}

	/**
	 * Returns the macro command with a given name. If no macro can be found with
	 * this name, then a NotFoundCommand is returned.
	 */
	@Override
	public Command getCommand(String name) {
		// TODO retrieve the macro with the name provided from the store (e.g. a map)
		return commands.get(name);
	}
}
