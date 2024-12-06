package MVCprojectModel;

public class MajorVO {
	private String name;
	private String mNum;

	public MajorVO() {
		super();
	}

	public MajorVO(String mNum, String name) {
		super();
		this.mNum = mNum;
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
				String.format("%10s", "전공번호 : ") + String.format("%-5s", mNum)+
				String.format("%10s", "전공명 : ") + String.format("%-5s", name)+"\n";
	}

}
