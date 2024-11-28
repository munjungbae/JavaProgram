package subjectMVCProgramcontroller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import subjectMVCProgrammodel.StudentVO;
import subjectMVCProgrammodel.TraineeVO;
import subjectMVCProgrammodel.TraineeVO;


public class TraineeRegisterManager {
	public static Scanner sc = new Scanner(System.in); 
	//전체 학생리스트를 출력요청
	public static void totalSelectManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO();
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>();
		traineeList = tdao.traineeAllSelect(new TraineeVO());
		if(traineeList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printTraineeList(traineeList); 
	}
	
	public static void selectManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO();
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>();
		traineeList = tdao.traineeSelect(new TraineeVO());
		if(traineeList.size() <= 0) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		traineeAllList(traineeList); 
	}

	public static void insertManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO();
		// 3.statement
		//student 에 검색기능이 추가 되어야 함.
		//검색된 학생의 이름, 학번, 이메일 출력 
		StudentRegisterManager srm = new StudentRegisterManager();
		srm.selectNameManager();
		//상단에 출력된 값을 가지고 입력처리 (그냥보여주기용)
		System.out.print("학생 번호를 입력 해 주세요 : ");
		String s_num = (sc.nextLine()).trim();
		//lesson abbreviation 을 보여준다, 과목명 요약 및 과목명
		LessonRegisterManager lrm = new LessonRegisterManager();
		lrm.selectSortManager();
		System.out.println("괴목 요약을 입력 해 주세요 : ");
		String abbre = (sc.nextLine()).trim();
		System.out.print("전공, 부전공, 교양을 입력하세요 : ");
		String section = (sc.nextLine()).trim();

		TraineeVO tranieeVO = new TraineeVO(0, s_num, abbre, section, null);
		boolean successFlag = tdao.traineeInsert(tranieeVO);
		
		if(successFlag == true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public static void updateManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO();
		//Trainee테이블 전체 내용을 출력한다
		selectManager();
		
		System.out.print("수정 할 번호를 입력 해 주세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		//상단에 출력된 값을 가지고 입력처리 (그냥보여주기용)
		System.out.print("학생 번호를 입력 해 주세요 : ");
		String s_num = (sc.nextLine()).trim();
		//lesson abbreviation 을 보여준다, 과목명 요약 및 과목명
		LessonRegisterManager lrm = new LessonRegisterManager();
		lrm.selectSortManager();
		System.out.println("괴목 요약을 입력 해 주세요 : ");
		String abbre = (sc.nextLine()).trim();
		
		System.out.print("전공, 부전공, 교양을 입력하세요 : ");
		String section = (sc.nextLine()).trim();

		TraineeVO tranieeVO = new TraineeVO(no, s_num, abbre, section, null);
		boolean successFlag = tdao.traineeInsert(tranieeVO);
		
		if(successFlag == true) {
			System.out.println("수정처리 성공");
		}else {
			System.out.println("수정처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO();
		System.out.print("삭제할 수강신청 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		TraineeVO tvo = new TraineeVO();
		tvo.setNo(no);
		boolean successFlag = tdao.traineeDelete(tvo); 
		
		if(successFlag == true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void sortManager() throws SQLException {
		TraineeDAO tdao = new TraineeDAO();
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>();
		traineeList = tdao.traineeSort(new TraineeVO()); 
		if(traineeList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printTraineeList(traineeList);
	}

	//전체 학생리스트를 출력진행
	public static void printTraineeList(ArrayList<TraineeVO> traineeList) {
		System.out.println("============================================");
		for( TraineeVO tv :  traineeList) {
			System.out.println(tv.toString());
		}
		System.out.println("============================================");
	}
	
	public static void traineeAllList(ArrayList<TraineeVO> traineeList) {
		System.out.println("============================================");
		for(TraineeVO tv :  traineeList) {
			System.out.println(tv.toString());
		}
	}
}






