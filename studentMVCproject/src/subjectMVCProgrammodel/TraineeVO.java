package subjectMVCProgrammodel;

import java.sql.Date;

public class TraineeVO {
	// T.NO, T.SECTION, S.NUM, S.NAME, L.ABBRE, L.NAME
	private int no; // --pk seq
	private String s_num; // --student(fk) 학생번호
	private String abbre; // --lesson(fk) 과목요약
	private String section; // --전공,부전공,교양
	private Date registDate; // --수강신청일
	// Student join
	private String s_name;
	// lesson join
	private String l_name;

	public TraineeVO() {
		super();
	}
	
	
	public TraineeVO(int no, String s_num, String abbre, String section, Date registDate) {
		super();
		this.no = no;
		this.s_num = s_num;
		this.abbre = abbre;
		this.section = section;
		this.registDate = registDate;
	}
	
	public TraineeVO(int no, String abbre, String s_name) {
		super();
		this.no = no;
		this.abbre = abbre;
		this.s_name = s_name;
	}



	//join명령어를 나타내기 위한 생성자
	public TraineeVO(int no, String s_num, String abbre, String section, Date registDate, String s_name,
			String l_name) {
		super();
		this.no = no;
		this.s_num = s_num;
		this.abbre = abbre;
		this.section = section;
		this.registDate = registDate;
		this.s_name = s_name;
		this.l_name = l_name;
	}

	
	
	public TraineeVO(String s_num, String abbre, String section) {
		super();
		this.s_num = s_num;
		this.abbre = abbre;
		this.section = section;
	}
	
	
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getS_num() {
		return s_num;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public String getAbbre() {
		return abbre;
	}

	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	@Override
	public String toString() {
		return "TraineeVO [no=" + no + ", s_num=" + s_num + ", abbre=" + abbre + ", section=" + section
				+ ", registDate=" + registDate + "]";
	}

}
