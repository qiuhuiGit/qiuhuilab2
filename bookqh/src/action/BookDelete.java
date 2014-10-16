package action;
import java.get.*;
import java.sql.*;
import com.opensymphony.xwork2.ActionSupport;
import database.DbCtrl;
1234
public class BookDelete extends ActionSupport {
	private String bkID = new String();
	private DbCtrl dbCtrl;
	private Connection conn;
	
	public String execute() {
		String ret = ERROR;
		Connection conn = null;
		try {		
			//System.out.println(bkID);
			
			dbCtrl=new DbCtrl();
			conn=dbCtrl.getConnection();
			String sql = "delete from Book  where ISBN = '" + bkID + "'";
			//System.out.println(sql);
			PreparedStatement preparestatement = conn.prepareStatement(sql);
			preparestatement.executeUpdate();
			ret = SUCCESS;
			
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

	public String getBkID() {
		return bkID;
	}

	public void setBkID(String bkID) {
		this.bkID = bkID;
	}
}
