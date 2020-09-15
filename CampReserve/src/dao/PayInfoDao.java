package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.OracleXEConnection;
import vo.PayInfoVO;
import vo.reserveVo;

public class PayInfoDao {
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	Connection conn = null;
   
	public PayInfoDao() {
		conn = OracleXEConnection.getInstance().getConnection();   
	}

	// 결제 정보 넣기 - insertData()
	public void insertData(PayInfoVO vo) {
	   	sb.setLength(0); 
		sb.append("Insert into payinfo ");
		sb.append("values (payinfo_pno_seq.NEXTVAL, ?, ?, ?, sysdate, ?) ");

		try {
			pstmt = conn.prepareStatement(sb.toString()); 
			pstmt.setString(1, vo.getNoRes()); 
			pstmt.setInt(2, vo.getpPrice()); 
			pstmt.setString(3, vo.getpMethod());
			pstmt.setString(4, vo.getpState());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터 추가 실패");
		}
   } //available() end
	
}
