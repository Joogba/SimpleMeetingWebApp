package meet;

public class Meet {
	private long meetid;
	private int bbsid;//나중에 bbs테이블에 meetid 추가
	private String date;
	private String title;
	private String place; // 장소
	private int count;
	private int maxcount;
	
	
	public long getMeetid() {
		return meetid;
	}
	public void setMeetid(long meetid) {
		this.meetid = meetid;
	}
	public int getBbsid() {
		return bbsid;
	}
	public void setBbsid(int bbsid) {
		this.bbsid = bbsid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMaxcount() {
		return maxcount;
	}
	public void setMaxcount(int maxcount) {
		this.maxcount = maxcount;
	}
	
	
}
