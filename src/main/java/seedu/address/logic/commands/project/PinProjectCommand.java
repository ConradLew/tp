package seedu.address.logic.commands.project;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.project.Project;
import seedu.address.model.project.ProjectId;
import seedu.address.ui.Ui;

public class PinProjectCommand extends ProjectCommand {

    public static final String COMMAND_FLAG = "-p";

    public static final String MESSAGE_SUCCESS = "Project pinned: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " " + COMMAND_FLAG
            + ": Pins the project identified by the project id \n"
            + "Parameters: PROJECT_ID (must be a positive integer) "
            + "Example: " + COMMAND_WORD + " "
            + COMMAND_FLAG + " 1";

    public ProjectId toPinProjectId;

    public PinProjectCommand(ProjectId toPinProjectId) {
        this.toPinProjectId = toPinProjectId;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @param ui
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model, Ui ui) throws CommandException {
        Project toPinProject = model.getProjectById(this.toPinProjectId.getIdInt());
        toPinProject.togglePin();
        model.sortProjectsByPin();
        return new CommandResult(String.format(MESSAGE_SUCCESS, toPinProject));
    }
}
