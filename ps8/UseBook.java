public class UseBook {
	
	// Creates book objects and manipulates them as directed
	public static void main (String[] args){
		Book mybook = new Book();
		System.out.println("The book's title: " + mybook.getTitle());
		System.out.println("The book's author: " + mybook.getAuthor());
		System.out.println("The book's ISBN: " + mybook.getISBN());
		System.out.println("The number of pages in the book: " + mybook.getPages());
		System.out.println("The book's price (in dollars): " + mybook.getPrice());
		
		mybook.setAuthor("J. D. Salinger");
		mybook.setTitle("The Catcher in the Rye");
		mybook.setISBN("0-316-76917-7");
		mybook.setPages(277);
		mybook.setPrice(13.95);
		
		System.out.println("\n");
		System.out.println("The book's title: " + mybook.getTitle());
		System.out.println("The book's author: " + mybook.getAuthor());
		System.out.println("The book's ISBN: " + mybook.getISBN());
		System.out.println("The number of pages in the book: " + mybook.getPages());
		System.out.println("The book's price (in dollars): " + mybook.getPrice());
		
		Book yourbook = new Book("Colum McCann", "Let the Great World Spin", "978-0-8129-7399-0", 349, 15.00);
		System.out.println("\n");
		System.out.println("The book's title: " + yourbook.getTitle());
		System.out.println("The book's author: " + yourbook.getAuthor());
		System.out.println("The book's ISBN: " + yourbook.getISBN());
		System.out.println("The number of pages in the book: " + yourbook.getPages());
		System.out.println("The book's price (in dollars): " + yourbook.getPrice());
		
		yourbook.setTitle("Introduction to Computer Science Using Java");
		System.out.println("\nIt is " + yourbook.isInteresting() + " that " + yourbook.getTitle() + " is an interesting book.");
		System.out.println("\nIt is " + mybook.isInteresting() + " that " + mybook.getTitle() + " is an interesting book.");
		
		mybook.print();
		System.out.println(mybook.toString());
		
		Book[] books = new Book[5];
		books[0] = mybook;
		books[1] = yourbook;
		books[2] = new Book("David Benioff", "City of Thieves", "978-0-452-29529-2", 258, 15.00);
		books[3] = new Book("Alan Lightman", "Einstein's Dreams", "0-679-41646-3", 179, 17.00);
		books[4] = new Book("Joseph Campbell", "Myths to Live By", "0-14-019461-4", 266, 16.00);
		
		for (int i=0; i < books.length; i++){
			books[i].print();
		}
		
		for (int i=0; i < books.length; i++){
			System.out.println(books[i].toString());
		}
		
		for (int i=0; i < books.length; i++){
			if (books[i].isInteresting()){
				System.out.println(books[i].toString());
			}
		}
	}
}
