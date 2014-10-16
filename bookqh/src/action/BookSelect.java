package action;

import java.sql.*;
import java.put.*;
import po.book;
import po.author;
12345
import com.opensymphony.xwork2.ActionSupport;
import database.DbCtrl;

public class BookSelect extends ActionSupport {
	private book book = new book();
	private author author = new author();
	private String BookID;
	private DbCtrl dbCtrl;
	private Connection conn;
	
	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String sql1 = new String();
			ResultSet result, result1 = null;
			dbCtrl=new DbCtrl();
			conn=dbCtrl.getConnection();
			String sql = "select * from Book where ISBN='" + BookID + "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			result = ps.executeQuery();
			while (result.next()) {
				book.setISBN(result.getString(1));
				book.setTitle(result.getString(2));
				book.setAuthorID(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishDate(result.getString(5));
				book.setPrice(result.getString(6));
				sql1 = "select * from Author where AuthorID='"
						+ result.getString("AuthorID") + "'";
				
			}
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			result1 = ps1.executeQuery();
			while (result1.next()) {
				author.setAuthorID(result1.getString(1));
				author.setName(result1.getString(2));
				author.setAge(result1.getString(3));
				author.setCountry(result1.getString(4));
				ret = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ret = ERROR;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
				}
			}
		}
		return ret;
	}

	public book getBook() {
		return book;
	}

	public void setBook(book book) {
		this.book = book;
	}

	public author getAuthor() {
		return author;
	}

	public void setAuthor(author author) {
		this.author = author;
	}

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String BookID) {
		this.BookID = BookID;
	}
}
