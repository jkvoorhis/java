/**
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The range of
 * the clock is 00:00 (midnight) to 23:59 (one minute before midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute and
 * reacts by incrementing the display. This is done in the usual clock fashion:
 * the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2001.05.26
 * @version 2012.04.15, Art Lee
 */

// the clock can also display in non-military time, displays and tracks the day
// of the week, and has a changeable alarm
// with a 10 min snooze option

public class ClockDisplay {

	private NumberDisplay hours;
	private NumberDisplay minutes;
	private boolean isMilitary;
	private Days day;
	private int dotColon = 1; // used to switch between '.' and ':' for
								// displaying time
	private int alarmHour; // used to set and clear the alarm
	private int alarmMin;

	/**
	 * Constructor for ClockDisplay objects. This constructor creates a new
	 * clock set at 00:00.
	 */
	public ClockDisplay() {
		hours = new NumberDisplay(24);
		minutes = new NumberDisplay(60);
		isMilitary = true;
		day = new Days();
		alarmHour = -1;
		alarmMin = -1;
	}

	/**
	 * Constructor for ClockDisplay objects. This constructor creates a new
	 * clock set at the time specified by the parameters.
	 */
	public ClockDisplay(int hour, int minute) {
		hours = new NumberDisplay(24);
		minutes = new NumberDisplay(60);
		setTime(hour, minute);
		isMilitary = true;
		day = new Days();
		alarmHour = -1;
		alarmMin = -1;
	}

	// Constructor for CLockDisplay objects. Creates a new clock
	// set to the specified time, display format (military or not), and day
	public ClockDisplay(int hour, int minute, boolean isMilitary, String day) {
		hours = new NumberDisplay(24);
		minutes = new NumberDisplay(60);
		setTime(hour, minute);
		this.isMilitary = isMilitary;
		this.day = new Days(day);
		alarmHour = -1;
		alarmMin = -1;
	}

	/**
	 * This method should get called once every minute - it makes the clock
	 * display go one minute forward.
	 */
	// Updates the day and hour as needed, and sets off the alarm when a new
	// minutes passes (note: NOT when it is requested to be displayed. Will
	// display before then) if it is the specified time, and then clears the
	// alarm
	public void timeTick() {
		minutes.increment();
		if (minutes.getValue() == 0) { // it just rolled over!
			hours.increment(); // new hour
		}
		if (hours.getValue() == 0 && minutes.getValue() == 0) { // rolled over
																// to new day
			day.setValue(day.getValue() + 1);
			day.setDay(day.getValue());
		}
		dotColon++; // used to switch between '.' and ':' for displaying time
		if (hours.getValue() == alarmHour && minutes.getValue() == alarmMin) { // sets
																				// off
																				// alarm
			System.out.println("Time to wake up ...");
			alarmHour = -1; // clears alarm
			alarmMin = -1;
		}
	}

	/**
	 * Set the time of the display to the specified hour and minute.
	 */
	public void setTime(int hour, int minute) {
		hours.setValue(hour);
		minutes.setValue(minute);
	}

	// Set the time of the display to the specified hour and minute, and set the
	// day the the specified day
	public void setTime(int hour, int minute, String d) {
		hours.setValue(hour);
		minutes.setValue(minute);
		day.setDay(d);
	}

	// Set the day of the week to a specified day
	public void setDay(String d) {
		day.setDay(d);
	}

	// Set whether or not to display the time in military time
	public void setIsMilitary(boolean tf) {
		isMilitary = tf;
	}

	// Set the alarm to the specified hour and minute (in military time)
	public void setAlarm(int hour, int min) {
		alarmHour = hour;
		alarmMin = min;
	}

	// Clear the alarm
	public void clearAlarm() {
		alarmHour = -1;
		alarmMin = -1;
	}

	// Snooze the alarm by 10 min for one instance
	public void snooze() {
		if (minutes.getValue() < 50) {
			alarmMin = 10 + minutes.getValue();
			alarmHour = hours.getValue();
		} else {
			alarmHour = hours.getValue() + 1;
			alarmMin = (10 - (60 - minutes.getValue()));
		}
	}

	/**
	 * Return the current time of this display in the format HH:MM Day in either
	 * military or non-military form.
	 */
	public String getTime() {
		String swap = ":"; // switch between a colon and a period on
		if (dotColon % 2 == 0) { // consecutive timeTicks
			swap = ".";
		}
		// displays military time
		if (isMilitary == true) {
			return hours.getDisplayValue() + swap + minutes.getDisplayValue()
					+ " " + day.getDay();
		}
		// displays non-military time
		else {
			String amPm = "AM";
			int h = hours.getValue();
			if (hours.getValue() > 12) { // changes hours if needed
				h = h - 12;
			}
			if (hours.getValue() == 0) { // displays midnight hour as 12 instead
											// of 0
				h = 12;
			}
			if (hours.getValue() > 11) { // determines and sets AM/PM display
				amPm = "PM";
			}
			return h + swap + minutes.getDisplayValue() + amPm + " "
					+ day.getDay();
		}
	}

}