public class UseClockDisplay {

    public static void main (String[] args) {

    	// Create a clock object that is set to 11:58PM on Sunday.
    	// It will display in non-military time.
        ClockDisplay myclock = new ClockDisplay(23, 58, false, "Sunday");

        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        // set an alarm for 12:03AM
        myclock.setAlarm(0, 3);
        myclock.timeTick();
        // snooze the alarm, it should go off again at 12:13AM
        myclock.snooze();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
        myclock.timeTick();
        System.out.println("Current time: " + myclock.getTime());
    }

}