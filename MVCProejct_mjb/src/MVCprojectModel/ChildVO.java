package MVCprojectModel;

public class ChildVO {
	private int no;
	private String mNum;
	private String mName;
	private String iName;
	private int grade;

	public ChildVO() {
		super();
	}

	public ChildVO(int no, String mNum, String mName, String iName, int grade) {
		super();
		this.no = no;
		this.mNum = mNum;
		this.mName = mName;
		this.iName = iName;
		this.grade = grade;
	}

	public ChildVO(int no, String iName, int grade) {
		super();
		this.no = no;
		this.iName = iName;
		this.grade = grade;
	}

	public ChildVO(String mNum, String mName, String iName, int grade) {
		super();
		this.mNum = mNum;
		this.mName = mName;
		this.iName = iName;
		this.grade = grade;
	}

	public ChildVO(String mNum, String iName, int grade) {
		super();
		this.mNum = mNum;
		this.iName = iName;
		this.grade = grade;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getmNum() {
		return mNum;
	}

	public void setmNum(String mNum) {
		this.mNum = mNum;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getiName() {
		return iName;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return String.format("%-2s", "")+
				String.format("%10s", "전공번호 : ") + String.format("%-5s", mNum) +
			   String.format("%10s", "전공명 : ") + String.format("%-5s", mName)  +
			   String.format("%10s", "과목명 : ") + String.format("%-15s", iName)  +
			   String.format("%10s", "학점 : ") + String.format("%-5s", grade) +
			   String.format("%10s", "과목번호 : ") + String.format("%-5s", no)+"\n";
	}

	public String print() {
		return String.format("%-2s", "")+
				String.format("%10s", "전공번호 : ") + String.format("%-5s", mNum) +
				String.format("%10s", "과목명 : ") + String.format("%-15s", iName) +
				String.format("%10s", "학점 : ")+ String.format("%-5s", no)+"\n";
	}
}
