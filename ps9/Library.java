public class Library {
	private String name;
	private int numBooks;
	private Book[] books = new Book[20];
	private Book[] checkedOut = new Book[20];
	private int numOut;
	private static int callNumGen = 0;

	public Library() {
		name = "";
		numBooks = 0;
		numOut = 0;
	}

	public Library(String name) {
		this.name = name;
		numBooks = 0;
		numOut = 0;
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getNumberOfBooks() {
		return numBooks;
	}

	// Setter
	public void setName(String nname) {
		name = nname;
	}

	// checks if the library is full and returns true if it is full
	public boolean isFull() {
		if (numBooks - 1 == 20) {
			return true;
		}
		return false;
	}

	// checks if the library is empty (has NO books in its catalog)
	public boolean isEmpty() {
		if (numBooks == 0) {
			return true;
		}
		return false;
	}

	// returns the index of the specified book in the array of books for
	// the library
	// returns -1 if book is not in the array
	public int getSlot(Book a) {
		for (int i = 0; i < numBooks; i++) {
			if (books[i].equals(a)) {
				return i;
			}
		}
		return -1;
	}

	// adds a specified book to the array of books for the library if it is not
	// full
	public void add(Book a) {
		if (this.isFull() == false) {
			books[numBooks] = a;
			a.setCall(callNumGen);
			callNumGen++;
			numBooks++;
		} else {
			System.out.println("Book could not be added, the library is full.");
		}
	}

	// removes a specified book from the array of books for the library
	public void remove(Book a) {
		int slot = getSlot(a);
		for (int i = slot; i < numBooks - 1; i++) {
			books[i] = books[i + 1];
		}
		books[numBooks] = null;
		numBooks--;
	}

	// searches for a book by its call number
	public Book searchByCallNumber(int callNum) {
		Book test = new Book();
		for (int i = 0; i < numBooks; i++) {
			if (books[i].getCall() == (callNum)) {
				test = books[i];
			}
		}
		return test;
	}

	// searches for a book by its title and return an array of Books with that
	// title
	public Book[] searchByTitle(String searchTitle) {
		int size = 0;
		for (int i = 0; i < numBooks; i++) {
			if (books[i].getTitle().equals(searchTitle)) {
				size++;
			}
		}
		Book[] test = new Book[size];
		int j = 0;
		for (int i = 0; i < numBooks; i++) {
			if (books[i].getTitle().equals(searchTitle)) {
				test[j] = books[i];
				j++;
			}
		}
		return test;
	}

	// checks in a books to the library after checking if it is checked out
	public void checkIn(Book a) {
		if (isOut(a) == true) {
			for (int i = 0; i < numOut; i++) {
				if (checkedOut[i].equals(a)) {
					for (int j = i; j < numOut - 1; j++) {
						checkedOut[j] = checkedOut[j + 1];
					}
					checkedOut[numOut] = null;
				}
			}
			numOut--;
		} else {
			System.out.println("Book is not checked out.");
		}
	}

	// checks if a book is checked out
	public boolean isOut(Book a) {
		for (int i = 0; i < numOut; i++) {
			if (checkedOut[i].equals(a)) {
				return true;
			}
		}
		return false;
	}

	// checks out a book from the library using its call number, after
	// determining if it is available
	// to check out, and adds it to the checked out list
	public Book checkOut(int callNum) {
		Book a = new Book();
		a = searchByCallNumber(callNum);
		if (isOut(a) == false) {
			checkedOut[numOut] = a;
			numOut++;
			return a;
		}
		return a = null;
	}

	// Determines how a library object should be displayed when printed
	public String toString() {
		String temp = "";
		for (int i = 0; i < numBooks; i++) {
			temp = temp + books[i].toString() + "\n";
		}
		return temp;
	}
}
