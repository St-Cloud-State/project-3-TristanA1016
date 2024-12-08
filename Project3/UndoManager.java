import java.util.*;
public class UndoManager {
  private static Model model;
  private Stack history;
  private Stack redoStack;
  private Command currentCommand;
  public UndoManager() {
    history = new Stack();
    redoStack = new Stack();
  }
  public static void setModel(Model model) {
    UndoManager.model = model;
  }
  public void beginCommand(Command command) {
    if (currentCommand != null) {
      if (currentCommand.end()) {
        history.push(currentCommand);
      }
    }
    currentCommand = command;
    redoStack.clear();
    command.execute();
  }
  public void endCommand(Command command) {
    command.end();
    history.push(command);
    currentCommand = null;
    model.setChanged();
  }
  
  public void cancelCommand() {
    currentCommand = null;
    model.setChanged();
  }

  public void undo() {
    System.out.println("undoStack.size() = " + history.size());
    if (!(history.empty())) {
      Command command = (Command) (history.peek());
      System.out.println("undoing " + command);
      if (command.undo()) {
        System.out.println("Can undo " + command);
        history.pop();
        redoStack.push(command);
      }
    }
  }
  public void redo() {
    System.err.println("redoStack.size() = " + redoStack.size());
    if (!(redoStack.empty())) {
      Command command = (Command)(redoStack.peek());
      System.err.println("redoing " + command);
      if (command.redo()) {
        System.err.println("Can activate " + command);
        redoStack.pop();
        history.push(command);
      }
    }
  }
}