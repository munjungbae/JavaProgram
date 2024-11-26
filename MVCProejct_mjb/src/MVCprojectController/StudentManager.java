package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.MajorVO;
import MVCprojectModel.StudentVO;

public class StudentManager {
	public static Scanner sc = new Scanner(System.in);

	// 출력
	public static void showList() throws SQLException {
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		StudentDAO sDao = new StudentDAO();
		studentList = sDao.studentSelect();
		if (studentList == null) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		printStudentList(studentList);
	}

	// 입력
	public static void studentInsertManager() throws SQLException {
		MajorDAO mDao = new MajorDAO();

		ArrayList<MajorVO> majorList = new ArrayList<MajorVO>();
		majorList = mDao.MajorSelect();
		if (majorList == null) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		MajorManager.printMajorList(majorList);
	
		StudentDAO sDao = new StudentDAO();
		
		System.out.println();
		
		System.out.print("이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학년을 입력 해 주세요 : ");
		String year = sc.nextLine();
		System.out.print("총 학점을 입력 해 주세요 : ");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.print("생일을 입력 해 주세요 : ");
		String birth = sc.nextLine();
		System.out.print("전화번호를 입력 해 주세요: ");
		String phone = sc.nextLine();
		System.out.print("전공 번호를 입력 해 주세요 : ");
		String mNum = sc.nextLine();
		

		StudentVO sVo = new StudentVO(name, year, grade, birth, phone, mNum);

		boolean successFlag = sDao.studentInsert(sVo);

		if (successFlag == false) {
			System.out.println("입력 실패");
			return;
		} else {
			System.out.println("입력이 완료 되었습니다.");
			System.out.println("입력된 정보");
			System.out.println("====================================================================================================================================");
			System.out.println();
			System.out.println(sVo.print());
			System.out.println();
			System.out.println("====================================================================================================================================");
		}
	}
	//수정
	public static void studentUpdateManager() throws SQLException {

		StudentDAO sDao = new StudentDAO();


		System.out.print("학생의 학번을 입력 해 주세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학년을 입력 해 주세요 : ");
		String year = sc.nextLine();
		System.out.print("총 학점을 입력 해 주세요 : ");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.print("생일을 입력 해 주세요 : ");
		String birth = sc.nextLine();
		System.out.print("전화번호를 입력 해 주세요: ");
		String phone = sc.nextLine();

		StudentVO sVo = new StudentVO (name, year, grade, birth, phone);

		boolean successFlag = sDao.studentUpdate(sVo);

		if (successFlag == true) {
			System.out.println("정보 수정에 성공하였습니다 ");
			System.out.print("수정된 정보");
			System.out.println("====================================================================================================================================");
			System.out.println();
			System.out.println(sVo.print());
			System.out.println();
			System.out.println("====================================================================================================================================");
		} else {
			System.out.println("수정 실패 ");
		}
	}
	//삭제
	public static void studentDeleteManager() throws SQLException {
		StudentDAO sDao = new StudentDAO();

		System.out.print("삭제하고자 하는 학생의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		StudentVO sVo = new StudentVO();
		sVo.setNo(no);

		boolean successFlag = sDao.studentDelete(sVo);

		if (successFlag == true) {
			System.out.println("삭제 성공했습니다. ");
		} else {
			System.out.println("삭제 실패 ");
		}
	}

	public static void printStudentList(ArrayList<StudentVO> studentList) {
		System.out.println("=================================================================================================================================================================");
		System.out.println();
		for (StudentVO svo : studentList) {
			System.out.println(svo.toString());
		}
		System.out.println("=================================================================================================================================================================");
	}
}
