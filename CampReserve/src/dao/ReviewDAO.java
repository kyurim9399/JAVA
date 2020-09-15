package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connection.OracleXEConnection;
import vo.ReviewVO;

public class ReviewDAO 
{
    StringBuffer sb = new StringBuffer();
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Connection conn = null;
    
    public ReviewDAO() 
    {
    	conn = OracleXEConnection.getInstance().getConnection();    	
	}
    
    public void addData(ReviewVO vo)
    {
    	sb.setLength(0);
    	sb.append("insert into review ");
    	sb.append("values (review_rno_seq.nextval, ?, ?, sysdate, 0, ?, 0, ? ) ");
    	
		try 
		{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getScore());
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    // 총 게시물 파악 메소드
    public int getTotalCount()
    {
    	sb.setLength(0);
    	sb.append("select count(*) cnt ");
    	sb.append("from review ");
    	
    	int cnt = 0;
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return cnt;
    }

    
    //전체 게시글 조회 - getAllData() - 페이징 처리를 위해 시작번호, 끝 번호가 필요
    public ArrayList<ReviewVO> getAllData(int startNo, int endNo, int pageOrder)
    {
    	ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
    	
    	sb.setLength(0);
	    sb.append("select * from ");
	    sb.append("(select rownum rn, rno, title, contents, regdate, hits, id, rpcount, score from ");
	    sb.append("(select * from review ");
	    if(pageOrder == 0){
	    	sb.append("order by rno desc) ");
	    }
	    else if(pageOrder == 1){
	    	sb.append("order by hits desc) ");
	    }
	    else if(pageOrder == 2){
	    	sb.append("order by score desc) ");
	    }
	    sb.append("where rownum <= ?) ");
	    sb.append("where rn >= ? ");
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, endNo);
			pstmt.setInt(2, startNo);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				int rno = rs.getInt("rno");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String writer = rs.getString("id");
				Date regdate = rs.getDate("regdate");
				int hits = rs.getInt("hits");
				int rpcount = rs.getInt("rpcount");
				int score = rs.getInt("score");
				
				ReviewVO vo = new ReviewVO(rno, title, contents, writer, format.format(regdate),
						hits, rpcount, score);
				
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

    
    //데이터 한 건 조회 메소드 - 게시글 번호 - getData()
    public ReviewVO getData(int rno)
    {
    	sb.setLength(0);
    	sb.append("select * from review ");
    	sb.append("where rno = ? ");
    	
    	ReviewVO vo = null;
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rno);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String title = rs.getString(2);
			String contents = rs.getString(3);
			String regdate = rs.getString(4);
			int hits = rs.getInt(5);
			String writer = rs.getString(6);
			int rpcount = rs.getInt(7);
			int score = rs.getInt(8);
			
			vo = new ReviewVO(rno, title, contents, writer, regdate, hits, rpcount, score);
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return vo;
    }
    
    // 조회수 증가 메소드
    public void raiseHits(int rno) 
    {
    	sb.setLength(0);
    	sb.append("update review ");
    	sb.append("set hits = hits+1 ");
    	sb.append("where rno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rno);
			pstmt.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }// raiseHits() end


    //게시글 수정 - (제목, 내용) - ㅡmodifyData()
    public void modifyData(ReviewVO vo)
    {
    	sb.setLength(0);
    	sb.append("update review ");
    	sb.append("set title = ?, contents = ?, score = ? ");
    	sb.append("where rno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setInt(3, vo.getScore());
			pstmt.setInt(4, vo.getRno());
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //게시글 삭제
    public void deleteData(int rno)
    {
    	sb.setLength(0);
    	sb.append("delete review ");
    	sb.append("where rno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, rno);
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //댓글 개수 업데이트
    public int updateReplyCount(int rno)
    {
    	int replyCount=0;
    	
    	sb.setLength(0);
    	sb.append("update review ");
    	sb.append("set rpcount = (select count(*) cnt ");
    	sb.append("               from reply ");
    	sb.append("               where rno = ? ");
    	sb.append("               and is_deleted = 0) ");
    	sb.append("where rno = ? ");
    	
    	try 
    	{
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, rno);
			pstmt.setInt(2, rno);
			
			pstmt.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return replyCount;
    }

}
