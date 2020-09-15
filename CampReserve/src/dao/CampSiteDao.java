package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.OracleXEConnection;
import vo.campSiteVo;

public class CampSiteDao {
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
	   
	public CampSiteDao() {
		conn = OracleXEConnection.getInstance().getConnection();   
	}
	
	// 캠프 정보 가져오기 - getData()
	public campSiteVo getData(String siteCode) {
	   sb.setLength(0);
	   sb.append("select * ");
	   sb.append("from campsite ");
	   sb.append("where sitecode = ? ");

	   campSiteVo vo = new campSiteVo();
	   try {
		   	pstmt = conn.prepareStatement(sb.toString());
		   	pstmt.setString(1, siteCode);
		   	rs = pstmt.executeQuery();
	        
		   	rs.next();
		   	
		   	vo = new campSiteVo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));		   	
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return vo;
	} //available() end

}
