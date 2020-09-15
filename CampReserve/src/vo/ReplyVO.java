package vo;

public class ReplyVO 
{
	private int rpno;
	private String id;
	private	String contents;
	private String regdate;
	private int rno;
	private int depth;
	private int reparent;
	private int reorder;
	private int is_deleted;
	
	public ReplyVO() {}

	

	public ReplyVO(int rpno, String id, String contents, String regdate, int rno, int depth, int reparent, int reorder,
			int is_deleted) {
		super();
		this.rpno = rpno;
		this.id = id;
		this.contents = contents;
		this.regdate = regdate;
		this.rno = rno;
		this.depth = depth;
		this.reparent = reparent;
		this.reorder = reorder;
		this.is_deleted = is_deleted;
	}



	public int getRpno() {
		return rpno;
	}

	public void setRpno(int rpno) {
		this.rpno = rpno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getReparent() {
		return reparent;
	}

	public void setReparent(int reparent) {
		this.reparent = reparent;
	}

	public int getReorder() {
		return reorder;
	}

	public void setReorder(int reorder) {
		this.reorder = reorder;
	}

	public int getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(int is_deleted) {
		this.is_deleted = is_deleted;
	}
	
	
	
}
