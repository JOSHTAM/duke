public class ExitCommand extends Command {
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        return ui.bye();
    }
    public boolean isExit() {
        return true;
    }
}
