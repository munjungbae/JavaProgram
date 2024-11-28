package subjectMVCProgramcontroller;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import subjectMVCProgrammodel.LessonVO;
import subjectMVCProgrammodel.StudentVO;

public class LessonRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 전체 학생리스트를 출력요청
	public void SelectManager() {
		LessonDAO ldao = new LessonDAO();

		// 화면으로부터 데이터입력받기
		// 데이터베이스 요청
		LessonVO lvo = new LessonVO();
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);

		if (lessonList == null) {
			System.out.println("출력할 값이 존재하지 않습니다.");
			return;
		} else {
			printLessonList(lessonList);
		}
	}

	public static void insertManager() {
		LessonDAO ldao = new LessonDAO();
		//전체출력 요청
		LessonVO lvo = new LessonVO();
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);

		if (lessonList == null) {
			System.out.println("출력할 값이 존재하지 않습니다.");
			return;
		} else {
			printLessonList(lessonList);
		}

		System.out.println("O-운영체제, A-어셈블러, C-컴파일러, J-자료구조, P-\r\n" + "프로그래밍, D-데이터베이스, S-교육학이론\r\n" + "");
		System.out.print("입력 할 과목명 입력 >> ");
		String name = sc.nextLine().trim();
		System.out.print("입력 할 과목요약 입력 >> ");
		String abbre = sc.nextLine().trim();

		lvo = new LessonVO(abbre, name);
		boolean successFlag = ldao.lessonInsert(lvo);

		if (successFlag == true) {
			System.out.println(name+ "과목 입력이 완료 되었습니다.");
		} else {
			System.out.println("입력에 실패하였습니다. ");
		}
	}

	public static void updateManager() {
		LessonDAO ldao = new LessonDAO();
		//전체출력 요청
		LessonVO lvo = new LessonVO();
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);

		if (lessonList == null) {
			System.out.println("출력할 값이 존재하지 않습니다.");
			return;
		} else {
			printLessonList(lessonList);
		}
		
		System.out.print("수정하기위한 과목 번호를 입력 해 주세요 : ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("O-운영체제, A-어셈블러, C-컴파일러, J-자료구조, P-\r\n" + "프로그래밍, D-데이터베이스, S-교육학이론\r\n" + "");
		System.out.print("과목요약 입력 >> ");
		String abbre = sc.nextLine().trim();
		System.out.print("과목명 입력 >> ");
		String name = sc.nextLine().trim();

		lvo = new LessonVO(no, abbre, name);
		boolean successFlag = ldao.lessonUpdate(lvo);

		if (successFlag == true) {
			System.out.println(name+ "과목으로 수정이 완료 되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다. ");
		}
	}

	public static void deleteManager() {
		LessonDAO ldao = new LessonDAO();
		LessonVO lvo = new LessonVO();
		ArrayList<LessonVO> lessonList = ldao.lessonSelect(lvo);

		if (lessonList == null) {
			System.out.println("출력할 값이 존재하지 않습니다.");
		} else {
			printLessonList(lessonList);
		}
		
		System.out.print("삭제할 번호 >> ");
		int no = Integer.parseInt(sc.nextLine());
		
		lvo.setNo(no);
		boolean successFlag = ldao.lessonDelete(lvo);

		if (successFlag == true) {
			System.out.println(no + "번 삭제 완료 되었습니다.");
		} else {
			System.out.println("삭제 실패했습니다. ");
		}
	}

	public void selectSortManager() {
		LessonDAO ldao = new LessonDAO();

		// 화면으로부터 데이터입력받기
		// 데이터베이스 요청
		LessonVO lvo = new LessonVO();
		ArrayList<LessonVO> lessonList = ldao.lessonSelectSort(lvo);

		if (lessonList.size() != 0) {
			System.out.println("출력할 값이 존재하지 않습니다.");
		} else {
			printLessonList(lessonList);
		}
	}

	// 전체 화면 출력진행
	public static void printLessonList(ArrayList<LessonVO> lessonList) {
		System.out.println("============================================");
		for (LessonVO lvo : lessonList) {
			System.out.println(lvo.toString());
		}
		System.out.println("============================================");
	}
}
