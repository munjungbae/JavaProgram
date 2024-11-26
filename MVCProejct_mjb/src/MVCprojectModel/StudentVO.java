package MVCprojectModel;

public class StudentVO {
	private int no;
	private String name;
	private String year;
	private int grade;
	private String birth;
	private String phone;
	private String mNum;
	private String mName;
	
	

	public StudentVO() {
		super();
	}
	
	public StudentVO(int no, String name, String year, int grade, String birth, String phone, String mNum,
			String mName) {
		super();
		this.no = no;
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.birth = birth;
		this.phone = phone;
		this.mNum = mNum;
		this.mName = mName;
	}

	public StudentVO(String name, String year, int grade, String birth, String phone, String mNum) {
		super();
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.birth = birth;
		this.phone = phone;
		this.mNum = mNum;
	}
	
	public StudentVO(String name, String year, int grade, String birth, String phone) {
		super();
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.birth = birth;
		this.phone = phone;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	@Override
	public String toString() {
		return  String.format("%-2s", "")+
				String.format("%8s", "학번 : ")+ String.format("%-6s", no) +
				String.format("%8s", "이름 : ") + String.format("%-6s", name) +
				String.format("%8s", "학년 : ") + String.format("%-9s", year) + 
				String.format("%8s", "총학점 : ") + String.format("%-9s", grade) +
				String.format("%8s", "생년월일 : ") + String.format("%-10s", birth) +
				String.format("%10s", "휴대폰번호 : ") + String.format("%-15s", phone) +
				String.format("%8s", "전공번호 : ") + String.format("%-6s", mNum) +
				String.format("%8s", "전공 : ") + String.format("%-9s", mName)+"\n";
	}

	public String print(){
		return String.format("%10s", "이름 : ") + String.format("%-10s", name) +
				String.format("%10s", "학년 : ") + String.format("%-10s", year) +
				String.format("%10s", "총학점 : ") + String.format("%-10s", grade) + 
				String.format("%10s", "생년월일 : ") + String.format("%-10s", birth) +
				String.format("%10s", "휴대폰번호 : ") + String.format("%-10s", phone) +
				String.format("%10s", "전공번호 : ") + String.format("%-10s", mNum)+"\n";
	}


}
