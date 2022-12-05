package meet;

public class Meet {
	private long meetid;
	private int bbsid;//나중에 bbs테이블에 meetid 추가
	private String meetDate;
	private String meetTitle;
	private String meetPlace; // 장소
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
	public String getMeetDate() {
		return meetDate;
	}
	public void setMeetDate(String meetDate) {
		this.meetDate = meetDate;
	}
	public String getMeetTitle() {
		return meetTitle;
	}
	public void setMeetTitle(String meetTitle) {
		this.meetTitle = meetTitle;
	}
	public String getMeetPlace() {
		return meetPlace;
	}
	public void setMeetPlace(String meetPlace) {
		this.meetPlace = meetPlace;
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
