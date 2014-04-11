public class Book {
	// The possible fields for a book object
	private String author;
	private String title;
	private String isbn;
	private int pages;
	private double price;

	// A constructor for a book object with no parameters
	public Book() {
		author = "";
		title = "";
		isbn = "";
		pages = 0;
		price = 0.0;
	}

	// A constructor for a book object with given parameters
	public Book(String iauthor, String ititle, String iisbn, int ipages,
			double iprice) {
		author = iauthor;
		title = ititle;
		isbn = iisbn;
		pages = ipages;
		price = iprice;
	}

	// Getters for each field
	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}

	public String getISBN() {
		return isbn;
	}

	public int getPages() {
		return pages;
	}

	public double getPrice() {
		return price;
	}

	// Setters for each field
	public void setAuthor(String nauthor) {
		author = nauthor;
	}

	public void setTitle(String ntitle) {
		title = ntitle;
	}

	public void setISBN(String nisbn) {
		isbn = nisbn;
	}

	public void setPages(int npages) {
		pages = npages;
	}

	public void setPrice(double nprice) {
		price = nprice;
	}

	// A method to determine if a book is interesting (ie contains the word
	// "Java" in the title)
	public boolean isInteresting() {
		String[] titleArray = title.split("[ ]");
		for (int j = 0; j < titleArray.length; j++) {
			if (titleArray[j].equals("Java") && title.length() >= 23) {
				return true;
			}
		}
		return false;
	}

	// A method that prints the state information of the current book
	public void print() {
		System.out.println("\nAuthor: " + author + "\nTitle: " + title
				+ "\nISBN: " + isbn + "\nPages: " + pages
				+ "\nPrice (in dollars): " + price);
	}

	// A toString method which determines the format for printing a book
	public String toString() {
		return "\nAuthor: " + author + "\nTitle: " + title
				+ "\nISBN: " + isbn + "\nPages: " + pages
				+ "\nPrice (in dollars): " + price;
	}
}
