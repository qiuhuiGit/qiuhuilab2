package action;
import java.get.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import database.DbCtrl;
import po.book;
1234
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private List<book> booklist = new ArrayList<book>();
	private DbCtrl dbCtrl;
	private Connection conn;
	private String authorname;
	

	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {
			String sql1 = new String();
			ResultSet result,result1=null;		
			dbCtrl=new DbCtrl();
			conn=dbCtrl.getConnection();
			String sql = "select AuthorID from Author where Name='"+authorname+"'";
			PreparedStatement ps = conn.prepareStatement(sql);
			result= ps.executeQuery();
			while(result.next())
			{
				sql1 = "select * from Book where AuthorID='"+result.getString("AuthorID")+"'";
			}
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			result1 = ps1.executeQuery();
			while (result1.next()) {
				book tmp = new book();
				tmp.setISBN(result1.getString(1));
				tmp.setTitle(result1.getString(2));
				tmp.setAuthorID(result1.getString(3));
				tmp.setPublisher(result1.getString(4));
				tmp.setPublishDate(result1.getString(5));
				tmp.setPrice(result1.getString(6));
				booklist.add(tmp);
				ret = "success";
			}
			booklist.toArray();

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

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public List<book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<book> booklist) {
		this.booklist = booklist;
	}
}
