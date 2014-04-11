public class UseIphone {

    public static void main (String[] args) {

        Iphone ip1 = new Iphone("Jim",   // name
                                110,     // price
                                6.5,     // screen size
                                4,       // number of gigs
                                true,    // has compass or not
                                "White", // color of phone
                                true);   // has Siri or not
        ip1.leaveMessage();
        ip1.leaveMessage();

        Iphone ip2 = new Iphone("Amy", 100, 6.5, 4, false, "White", false);
        ip2.leaveMessage();
        ip2.leaveMessage();
        ip2.leaveMessage();

        Iphone ip3 = new Iphone("Art", 150, 6.5, 8, true, "Black", true);
        ip3.leaveMessage();

        Iphone ip4 = new Iphone("Ken", 200, 6.5, 16, false, "White", true);
        ip4.leaveMessage();
        ip4.leaveMessage();
        ip4.leaveMessage();
        ip4.leaveMessage();

        Iphone ip5 = new Iphone("Jan", 250, 6.5, 16, true, "Black", false);
        ip5.leaveMessage();

        Iphone.print("All iPhones: ");
        System.out.println("The total number of messages: " +
                           Iphone.getTotalNumberOfMessages());

        Iphone.remove(ip3);
        Iphone.print("All iPhones: ");
        System.out.println("The total number of messages: " +
                           Iphone.getTotalNumberOfMessages());

        Iphone.remove(ip1);
        Iphone.print("All iPhones: ");
        System.out.println("The total number of messages: " +
                           Iphone.getTotalNumberOfMessages());

        Iphone.remove(ip5);
        Iphone.print("All iPhones: ");
        System.out.println("The total number of messages: " +
                           Iphone.getTotalNumberOfMessages());
    }
}