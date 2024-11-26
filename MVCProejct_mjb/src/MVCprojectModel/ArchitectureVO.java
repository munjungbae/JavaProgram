package MVCprojectModel;

public class ArchitectureVO {
	private int no;
	private String mNum;
	private String mName;
	private String iName;
	private int grade;

	public ArchitectureVO() {
		super();
	}

	public ArchitectureVO(int no, String mNum, String mName, String iName, int grade) {
		super();
		this.no = no;
		this.mNum = mNum;
		this.mName = mName;
		this.iName = iName;
		this.grade = grade;
	}

	public ArchitectureVO(int no, String iName, int grade) {
		super();
		this.no = no;
		this.iName = iName;
		this.grade = grade;
	}

	public ArchitectureVO(String mNum, String mName, String iName, int grade) {
		super();
		this.mNum = mNum;
		this.mName = mName;
		this.iName = iName;
		this.grade = grade;
	}

	public ArchitectureVO(String mNum, String iName, int grade) {
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

	public String toString() {
		return String.format("%-2s", "")+
				String.format("%7s", "전공번호 : ") + String.format("%-5s", mNum) +
			   String.format("%7s", "전공명 : ") + String.format("%-5s", mName)  +
			   String.format("%7s", "과목명 : ") + String.format("%-15s", iName)  +
			   String.format("%7s", "학점 : ") + String.format("%-5s", grade) +
			   String.format("%7s", "과목번호 : ") + String.format("%-5s", no)+"\n";
	}

	public String print() {
		return String.format("%-2s", "")+
				String.format("%7s", "전공번호 : ") + String.format("%-5s", mNum) +
				String.format("%7s", "과목명 : ") + String.format("%-15s", iName) +
				String.format("%7s", "학점 : ")+ String.format("%-5s", no)+"\n";
	}

}
