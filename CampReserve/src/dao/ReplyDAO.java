package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.OracleXEConnection;
import vo.ReplyVO;

public class ReplyDAO 
{
    StringBuffer sb = new StringBuffer();
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Connection conn = null;
    
    public ReplyDAO() 
    {
    	conn = OracleXEConnection.getInstance().getConnection();
	}
    
    public void insertReply(ReplyVO vo)
    {
    	sb.setLength(0);
    	sb.append("insert into reply ");
    	sb.append("values (reply_rpno_seq.nextval, ?, ?, sysdate, ?, ?, ?, ?, 0) ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getRno());
			pstmt.setInt(4, vo.getDepth());
			pstmt.setInt(5, vo.getReparent());
			pstmt.setInt(6, vo.getReorder());
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e)
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    // 대댓글 생성
    public void insertRereply(ReplyVO vo)
    {
    	//getReorder
//    	sb.setLength(0);
//    	sb.append("select reorder ");
//    	sb.append("from reply ");
//    	sb.append("where reorder = (select max(reorder) ");
//    	sb.append("                 from reply ");
//    	sb.append("                 where bundle = ? ");
//    	sb.append("                 and depth = ? ");
    	int reparent = vo.getRpno();
    	
    	boolean repeat = true;
    	boolean next = false;
    	while(repeat)
    	{
	    	sb.setLength(0);
	    	sb.append("select rpno, reorder ");
	    	sb.append("from reply ");
	    	sb.append("where reorder = (select max(reorder) ");
	    	sb.append("                 from reply ");
	    	sb.append("                 where reparent = ? )");
	    	
	    	try 
	    	{
	    		pstmt = conn.prepareStatement(sb.toString());
	    		pstmt.setInt(1, reparent);
	    		
	    		rs = pstmt.executeQuery();
		    	if(rs.next()) next=true;
		    	if(next)
		    	{	
		    		reparent = rs.getInt("rpno");
		    		vo.setReorder(rs.getInt("reorder"));
		    	}
		    	else 
		    	{
		    		repeat = false;
		    		break;
		    	}
		    	next=false;
			} 
	    	catch (SQLException e1) 
	    	{
				e1.printStackTrace();
			}
    	}

    	
    	///////////////////////////////////////////////////////////////////////
    	// reorder update
    	sb.setLength(0);
    	sb.append("update reply ");
    	sb.append("set reorder = reorder+1 ");
    	sb.append("where reorder > ? ");
    	
    	try 
    	{
    		pstmt = conn.prepareStatement(sb.toString());
    		pstmt.setInt(1, vo.getReorder());
    		pstmt.executeUpdate();
    	} 
    	catch (SQLException e) 
    	{
    		e.printStackTrace();
    	}
    	/////////////////////////////////////////////////////////////////
    	// insert
    	sb.setLength(0);
    	sb.append("insert into reply ");
    	sb.append("values (reply_rpno_seq.nextval, ?, ?, sysdate, ?, ?, ?, ?, 0) ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getRno());
			pstmt.setInt(4, vo.getDepth()+1);
			pstmt.setInt(5, vo.getRpno());
			pstmt.setInt(6, vo.getReorder()+1);
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e)
    	{
			e.printStackTrace();
		}
    }

    //reorder 값 받아오기
    public int getReorder(int rno)
    {
    	int reorder = 0;
    	
    	sb.setLength(0);
    	sb.append("select count(*) cnt from reply ");
    	sb.append("where rno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			rs.next();
			reorder = rs.getInt("cnt")+1;
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return reorder;
    }
    
        
    // 댓글 리스트 가져오기
	public ArrayList<ReplyVO> getAllReply(int rno)
	{
		ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
		
		sb.setLength(0);
		sb.append("select * from reply ");
		sb.append("where rno = ? ");
		sb.append("order by reorder asc ");
		
		try 
		{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				ReplyVO vo = new ReplyVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
											rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				list.add(vo);
			}

		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
    //데이터 한 건 조회 메소드
    public ReplyVO getData(int rpno)
    {
    	sb.setLength(0);
    	sb.append("select * from reply ");
    	sb.append("where rpno = ? ");
    	
    	ReplyVO vo = null;
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rpno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String id = rs.getString(2);
			String contents = rs.getString(3);
			String regdate = rs.getString(4);
			int rno = rs.getInt(5);
			int depth = rs.getInt(6);
			int bundle = rs.getInt(7);
			int reorder = rs.getInt(8);
			int is_deleted = rs.getInt(9);
			
			vo = new ReplyVO(rpno, id, contents, regdate, rno, depth, bundle, reorder, is_deleted);
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return vo;
    }
    
    public void modifyReply(ReplyVO vo)
    {
    	sb.setLength(0);
    	sb.append("update reply ");
    	sb.append("set contents = ? ");
    	sb.append("where rpno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getContents());
			pstmt.setInt(2, vo.getRpno());
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //댓글 삭제
    public void deleteData(int rpno)
    {
    	sb.setLength(0);
    	sb.append("update reply ");
    	sb.append("set is_deleted = ? ");
    	sb.append("where rpno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, rpno);
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
