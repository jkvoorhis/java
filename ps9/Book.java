public class Book {
	// The possible fields for a book object
	private String author;
	private String title;
	private String isbn;
	private int pages;
	private double price;
	private int call;
	private String genre;

	// A constructor for a book object with no parameters
	public Book() {
		author = "";
		title = "";
		isbn = "";
		pages = 0;
		price = 0.0;
		genre = "";
		call = -1;
	}

	// A constructor for a book object with given parameters
	public Book(String iauthor, int ipages,double iprice, String ititle, String igenre,  String iisbn) {
		author = iauthor;
		title = ititle;
		isbn = iisbn;
		pages = ipages;
		price = iprice;
		genre = igenre;
		call = -1;
	}

	// Getters for each field
	public String getGenre(){
		return genre;
	}
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
	public int getCall(){
		return call;
	}

	// Setters for each field
	public void setGenre(String ngenre){
		genre = ngenre;
	}
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
	public void setCall(int ncall){
		call = ncall;
	}

	// A method to determine if a book is interesting (ie contains the word
	// "Java" in the title)
	public boolean isInteresting() {
		return (title.length() >= 20) && contains(title.split(" "), "Java");
	}

	public boolean contains(String[] words, String word) {
		for (int i = 0; i < words.length; i++) {
			if (word.equals(words[i])) {
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
		return
				"(" +
				author + ", " +
				pages + ", " +
				price + ", " +
				title + ", " +
				genre + ", " +
				isbn + ", " +
				call + ")";
		    }
	
}
