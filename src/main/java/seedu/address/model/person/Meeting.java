package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a Client's meeting time in the address book.
 * Guarantees: immutable; is always valid
 */
public class Meeting implements Comparable<Meeting> {
    private String name;
    public static final String MESSAGE_CONSTRAINTS =
            "Meeting MUST be a valid date and time in yyyy-MM-dd HH:mm format,"
                    + " and it should be AFTER the current day and time.";
    // The VALIDATION_REGEX for meeting time
    public static final String VALIDATION_REGEX = "^(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2})$";
    public final String value;
    public final LocalDateTime meeting;

    /**
     * Constructs an {@code Meeting}.
     */
    public Meeting(String meeting) {
        requireNonNull(meeting);
        this.value = meeting;
        this.meeting = stringToDateTime(meeting);
    }

    public LocalDateTime getMeeting() {
        return meeting;
    }

    /**
     * Returns true if a given string is a valid meeting.
     */
    public static boolean isValidMeeting(String test) {
        try {
            return test.matches(VALIDATION_REGEX) && stringToDateTime(test).isAfter(LocalDateTime.now());
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /**
     * This method converts a string into a LocalDateTime object.
     * The string must be in the format "yyyy-MM-dd HH:mm".
     *
     * @param dateTime The string to be converted into a LocalDateTime object.
     * @return A LocalDateTime object that represents the date and time specified by the input string.
     */
    private static LocalDateTime stringToDateTime(String dateTime) {
        if (dateTime.length() != 16) {
            throw new IllegalArgumentException("The date and time must be in the format yyyy-MM-dd HH:mm");
        }
        try {
            return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Ensure a valid date and time, in the format yyyy-MM-dd HH:mm");
        }
    }

    public boolean isFutureMeeting() {
        return this.meeting.isAfter(LocalDateTime.now()) ||
            this.meeting.isEqual(LocalDateTime.now());
    }
    
    
    public void setName(String finalName) {
        this.name = finalName;
    }

    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        return meeting.format(DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm"));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Meeting)) {
            return false;
        }

        Meeting otherMeeting = (Meeting) other;
        return meeting.equals(otherMeeting.meeting);
    }

    @Override
    public int hashCode() {
        return meeting.hashCode();
    }

    @Override
    public int compareTo(Meeting o) {
        return this.meeting.compareTo(o.meeting);
    }
}
