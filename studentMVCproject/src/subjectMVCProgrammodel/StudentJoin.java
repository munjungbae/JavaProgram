package subjectMVCProgrammodel;

import java.sql.Date;

public class StudentJoin {
	private int no; // --pk, seq
	private String num; // --학번(년도학과번호)
	private String name; // --이름
	private String id; // --아이디
	private String passwd; // --패스워드
	private String s_num; // --학과번호(fk) (SUBJECT S_NUM)
	private String birthday; // --생년월일
	private String phone; // --전화번호
	private String address; // --주소
	private String email; // --이메일
	private Date sdate; // --등록일
	private String subName; // -- 학과이름 (subject s_name)

	public StudentJoin(int no, String num, String name, String id, String passwd, String s_num, String subName,
			String birthday, String phone, String address, String email, Date sdate) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.s_num = s_num;
		this.subName = subName;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.sdate = sdate;

	}

	@Override
	public String toString() {
		return no + ", " + num + ", " + name + ", " + id + ", " + passwd
				+ ", " + s_num + ", " + subName + ", " + birthday + ", " + phone
				+ ", " + address + ", " + email + ", " + sdate + "]";
	}

}