public class UseLibrary{

    public static void main(String[] args){
        
        Library honnold = new Library("Honnold");
        
        Book n1 = new Book("Dan Brown",      // author
                           200,              // pages
                           10.34,            // price
                           "Da Vinci Code",  // title
                           "Romance",        // genre
                           "23GHA2");        // ISBN
        Book n2 = new Book("A. Camp",
                           400,
                           13.45,
                           "An Open Life",
                           "Philosophy",
                           "HSA234");
        Book n3 = new Book("James Jones",
                           140,
                           12.11,
                           "Oh, Java Yeah!",
                           "Science Fiction",
                           "SDF213");
        Book n4 = new Book("J. Campbell",
                           250,
                           32.45,
                           "An Open Life",
                           "Science",
                           "JH45");
        Book n5 = new Book("Mary Kennedy",
                           230,
                           56.32,
                           "Intro to CS Using Java as the Language",
                           "Science",
                           "USN123");
        Book n6 = new Book("Don Knuth",
                           290,
                           23.45,
                           "The Art of Programming with Java",
                           "Engineering",
                           "HG456");
        honnold.add(n1);
        honnold.add(n2);
        honnold.add(n3);
        honnold.add(n4);
        honnold.add(n5);
        honnold.add(n6);
        
        System.out.println("1. Library contains: \n" + honnold);
        
        System.out.println("2. The number of books in Honnold: " +
                           honnold.getNumberOfBooks());

        System.out.println("3. " + honnold.searchByCallNumber(n1.getCall()) +
                           " is in honnold: ");
                           
        honnold.remove(n1);

        System.out.println("4. Library contains: \n" + honnold);
        
        Book found = honnold.searchByCallNumber(n2.getCall());
        if (found != null) {
            System.out.println("5. " + found.getTitle() +" is in Honnold.");
        }
        
        System.out.println("6. The number of books in Honnold: " +
                           honnold.getNumberOfBooks());

        Book[] founds = honnold.searchByTitle("An Open Life");
        System.out.println("7. The books found in Honnold: ");
        for (int i = 0; i < founds.length; i++) {
            System.out.println("   " + founds[i]);
        }

        System.out.println("8. honnold is empty (T/F): " + honnold.isEmpty());

        System.out.println("9. The number of books in Honnold: "
                           + honnold.getNumberOfBooks());

        found = honnold.checkOut(n3.getCall());
        System.out.println("10. A checked out book is found in Honnold: ");
        if (found != null) {
            System.out.println("    " + found.getTitle() +" is checked out.");
        }

        System.out.println("11. The number of books in Honnold: "
                           + honnold.getNumberOfBooks());

        honnold.checkIn(found);
        System.out.println("12. The number of books in Honnold: "
                           + honnold.getNumberOfBooks());
        
        
    }
}