package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.campSiteVo;
import vo.reserveVo;

public class reserveDAO {
   StringBuffer sb = new StringBuffer();
   ResultSet rs = null;
   PreparedStatement pstmt = null;
   Connection conn = null;
   
   public reserveDAO() {
      conn = OracleXEConnection.getInstance().getConnection();   
   }
   
   // 예약 가능한 날짜 검색 메소드 - available()
   public ArrayList<campSiteVo> available(reserveVo vo) {
	   ArrayList<campSiteVo> list = new ArrayList<campSiteVo>();
	   sb.setLength(0);
	   sb.append("select c.* ");
	   sb.append("from CAMPSITE c left join RESERVATION r on c.siteCode=r.siteCode ");
	   sb.append("where (r.stddate >= ? ");
	   sb.append("or r.enddate <= ? ");
	   sb.append("or r.stddate is null) ");
	   sb.append("and maxppl >= ? ");
	   
	   try {
		   	pstmt = conn.prepareStatement(sb.toString());
		   	pstmt.setString(1, vo.getEndDate());
		   	pstmt.setString(2, vo.getStdDate());
		   	pstmt.setInt(3, vo.getTotal_p());
	         
		   	rs = pstmt.executeQuery();
	         
		   	while(rs.next()) {
		   		list.add(new campSiteVo(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
		   	}
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }
	   return list;
   } //available() end
   

	// 예약 번호 생성하기 -createNoRes()
	public String createNoRes() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String noRes = format.format(new java.util.Date());
		
		sb.setLength(0);
		sb.append("select count(nores) ");
		sb.append("from reservation ");
		
		try {
		   	pstmt = conn.prepareStatement(sb.toString());
		   	rs = pstmt.executeQuery();
	        
		   	rs.next();
		   	
		   	noRes += String.format("%04d", rs.getInt(1)+1);	
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return noRes;
	}
   
	
	

   

   // 예약 정보 넣기 - insertData()
   public void insertData(reserveVo vo) {
	   	sb.setLength(0); 
		sb.append("Insert into reservation ");
		sb.append("values (?, ?, ?, ?, ?, ?, ?) ");

		try {
			pstmt = conn.prepareStatement(sb.toString()); 
			pstmt.setString(1, vo.getNoRes()); 
			pstmt.setString(2, vo.getId()); 
			pstmt.setString(3, vo.getSiteCode()); 
			pstmt.setInt(4, vo.getTotal_p()); 
			pstmt.setInt(5, vo.getsPrice()); 
			pstmt.setDate(6, Date.valueOf(vo.getStdDate())); 
			pstmt.setDate(7, Date.valueOf(vo.getEndDate()));

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터 추가 실패");
		}
   } //available() end
   
   /*
   CREATE SEQUENCE reservation_nores_SEQ
   START WITH 1
   INCREMENT BY 1
   NOMAXVALUE
   MINVALUE 1
   NOCACHE
   NOORDER
   NOCYCLE; */
   
//   public static void main(String[] args) {
//	   String date = "2020-06-01";
//	   Date d = Date.valueOf(date);
//	   System.out.println(d);
//	   
//	   java.util.Date utilDate = new java.util.Date();
//	   java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//	   System.out.println("utilDate:" + utilDate);
//	   System.out.println("sqlDate:" + sqlDate);
//	   
//   }

}