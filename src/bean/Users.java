package bean;

public class Users {
 
	private int uid;
	private String nickname;
	private int sex;
	private String password;
	
	// 构造方法绝对不允许修改，只允许增加
	public Users() {
		
	}
	
	public Users(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}
	
	public Users(int uid, String nickname, int sex, String password) {
		this.uid = uid;
		this.nickname = nickname;
		this.sex = sex;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
