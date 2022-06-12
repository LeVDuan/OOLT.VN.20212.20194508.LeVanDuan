package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media  {

		private ArrayList<String> authors = new ArrayList<String>();
		
		// constructor
		public Book(String title, String author) {
			super(title);
			this.addAuthor(author);
		}
		public ArrayList<String> getAuthors() {
			return authors;
		}

		public void setAuthors(ArrayList<String> authors) {
			this.authors = authors;
		}
		
		public void addAuthor(String authorName) {
			if(!authors.contains(authorName))
				authors.add(authorName);
		}
		
		public void removeAuthor(String authorName) {
			if(authors.contains(authorName))
				authors.remove(authorName);
		}
		
}
