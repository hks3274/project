package movieReservation;

public class MovieVO {
	private String mid;
	private String pwd;
	private String name;
	private String socialNum;
	private String phoneNum;
	private String gender;
	private String birthDate;
	private String title;
	private String titlePoster;
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSocialNum() {
		return socialNum;
	}
	public void setSocialNum(String socialNum) {
		this.socialNum = socialNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitlePoster() {
		return titlePoster;
	}
	public void setTitlePoster(String titlePoster) {
		this.titlePoster = titlePoster;
	}
	@Override
	public String toString() {
		return "MovieVO [mid=" + mid + ", pwd=" + pwd + ", name=" + name + ", socialNum=" + socialNum + ", phoneNum="
				+ phoneNum + ", gender=" + gender + ", birthDate=" + birthDate + ", title=" + title + ", titlePoster="
				+ titlePoster + "]";
	}
	
	
}
