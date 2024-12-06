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
	
	public StudentVO(int no, String name, String year, int grade, String birth, String phone) {
		super();
		this.no = no;
		this.name = name;
		this.year = year;
		this.grade = grade;
		this.birth = birth;
		this.phone = phone;
	}

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
				String.format("%8s", "학번 : ")+ String.format("%-8s", no) +
				String.format("%8s", "이름 : ") + String.format("%-14s", name) +
				String.format("%8s", "학년 : ") + String.format("%-5s", year) + 
				String.format("%8s", "총학점 : ") + String.format("%-5s", grade) + "\n" +
				String.format("%-4s", "")+
				String.format("%8s", "생년월일 : ") + String.format("%-6s", birth) +
				String.format("%10s", "휴대폰번호 : ") + String.format("%-11s", phone) +
				String.format("%8s", "전공번호 : ") + String.format("%-2s", mNum) +
				String.format("%8s", "전공 : ") + String.format("%-5s", mName)+"\n";
	}

	public String print(){
		return String.format("%-2s", "")+
				String.format("%8s", "이름 : ") + String.format("%-7s", name) +
				String.format("%8s", "학년 : ") + String.format("%-15s", year) + 
				String.format("%8s", "총학점 : ") + String.format("%-5s", grade) + "\n" +
				String.format("%-4s", "")+
				String.format("%8s", "생년월일 : ") + String.format("%-6s", birth) +
				String.format("%10s", "휴대폰번호 : ") + String.format("%-11s", phone) +
				String.format("%8s", "전공번호 : ") + String.format("%-2s", mNum)+ "\n";
	}
	
	public String updatePrint(){
		return String.format("%-2s", "")+
				String.format("%8s", "이름 : ") + String.format("%-7s", name) +
				String.format("%8s", "학년 : ") + String.format("%-15s", year) + 
				String.format("%8s", "총학점 : ") + String.format("%-5s", grade) + "\n" +
				String.format("%-4s", "")+
				String.format("%8s", "생년월일 : ") + String.format("%-6s", birth)+ "\n";
	}


}
