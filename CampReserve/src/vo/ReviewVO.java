package vo;

public class ReviewVO 
{
	private int rno;
	private String title;
	private String contents;
	private String writer;
	private String regdate;
	private int hits;
	private int rpcount;
	private int score;
	
	public ReviewVO() {}
	


	public ReviewVO(int rno, String title, String contents, String writer, String regdate, int hits, int rpcount,
			int score) 
	{
		super();
		this.rno = rno;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.regdate = regdate;
		this.hits = hits;
		this.rpcount = rpcount;
		this.score = score;
	}



	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getRpcount() {
		return rpcount;
	}
	public void setRpcount(int rpcount) {
		this.rpcount = rpcount;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
