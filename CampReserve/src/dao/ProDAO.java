package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.OracleXEConnection;
import vo.ProVO;

public class ProDAO {
    StringBuffer sb = new StringBuffer();
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Connection conn = null;
    
    public ProDAO() 
    {
    	conn = OracleXEConnection.getInstance().getConnection();
	}
	
	
	public void insertMember(ProVO vo) {
		sb.setLength(0);
		sb.append("insert into member ");
		sb.append("values(?, ?, ?, ?, sysdate) ");
	
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
		
			
			pstmt.executeUpdate();
			System.out.println(vo.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}// insert�� ��
	
	public boolean checkLogin(ProVO vo)
	{
		sb.setLength(0);
		sb.append("SELECT * FROM member ");
		sb.append("where id = ? and pw = ? ");
		
		try 
		{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} 
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;		
	}
	
	
	
	
	public int findMember(String id) {
		sb.setLength(0);
		sb.append("select id from member ");
		sb.append("where id = ? ");
		Boolean isDu = false;
		int chk = 0;
	    try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			    // rs.next�� true ��� = ������ �ִ�
			    isDu = true;
			    
			    
			    
			}
			   
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	    if(isDu) {
	    	//���̵� �ߺ�
	        chk=0;
	      
	    } else {
	       //���̵� �ߺ�x
	    	chk=1;
	              
	    }  
	   return chk;     
	 } 

	
	
	
	// 해당하는 회원의 모든 정보 가져오기
	public ProVO getOneData(String id) {
		ProVO vo = new ProVO();
		sb.setLength(0);
		sb.append("select * from member ");
		sb.append("where id = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(3));
				vo.setPhone(rs.getString(4));			
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
}





