package duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {

    protected LocalDateTime endTime;

    /**
     * Constructs a new Deadline instance.
     *
     * @param description The description of the deadline task.
     * @param endTime     The end time of the deadline task.
     */
    public Deadline(String description, LocalDateTime endTime) {
        super(description);
        this.endTime = endTime;
    }

    /**
     * Returns the string representation of the deadline task,
     * including the description and end time which is formatted as "MMM dd yyyy".
     *
     * @return A string representation of the deadline task.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return "D |" + super.toString().substring(1) + "| " + endTime.format(formatter);
    }

    /**
     * Parses a string representing a date and time into a LocalDateTime object.
     *
     * @param dateTimeStr The string to be parsed, expected to be in the format "d/M/yyyy HHmm".
     * @return A LocalDateTime object representing the date and time, or else it will null if the string is not parsable.
     * @throws DateTimeParseException if the text cannot be parsed.
     */
    public LocalDateTime parseDateTime(String dateTimeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            return LocalDateTime.parse(dateTimeStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use d/M/yyyy HHmm");
            return null;
        }
    }

    /**
     * Gets the end time of the deadline task.
     *
     * @return The end time of the deadline task.
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }
}
