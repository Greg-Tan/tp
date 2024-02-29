package seedu.address.logic.commands;

import seedu.address.model.Model;
public class SayHiCommand extends Command {
    public static final String COMMAND_WORD = "hi";

    public static final String MESSAGE_SUCCESS = "Hi there!";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
