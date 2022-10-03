package seedu.address.model.project;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Project's deadline.
 */
public class Deadline {

    public static final String MESSAGE_CONSTRAINTS =
            "Deadlines should be entered in yyyy-mm-dd date format";

    /*
     * The date must be entered in yyyy-mm-dd or yyyy-m-d
     */
    public static final String VALIDATION_REGEX = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

    private LocalDate projectDeadline;

    /**
     * Constructs a project Deadline.
     *
     * @param deadline A valid project deadline.
     */
    public Deadline(String deadline) {
        requireNonNull(deadline);
        checkArgument(isValidDeadline(deadline), VALIDATION_REGEX);
        projectDeadline = LocalDate.parse(deadline);
    }

    /**
     * Returns true if a given string is a valid deadline.
     */
    public static boolean isValidDeadline(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return projectDeadline.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }
}
