package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.ClassVO;

public class ClassManager {
	//=====정보통신 MANAGER================================================================================
	public static Scanner sc = new Scanner(System.in);

	public static void infoshowList() throws SQLException {
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		ClassDAO classDao = new ClassDAO();
		infoList = classDao.infomationSelect();
		if (infoList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printClassList(infoList);
	}
	public static void infoInsertManager() throws SQLException {

		ClassDAO infoDao = new ClassDAO();

		System.out.println("정보통신학과 전공 번호 : 01");
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ClassVO infoVo = new ClassVO(num, name, grade);

		boolean successFlag = infoDao.infomationInsert(infoVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("입력 실패");
			return;
		} else {
			System.out.println("입력이 완료 되었습니다.");
			System.out.println("입력된 정보");
			System.out.println();
			System.out.println("=============================================================================");
			System.out.println();
			System.out.println(infoVo.print());
			System.out.println("=============================================================================");
		}
	}
	public static void infoDeleteManager() throws SQLException {
		ClassDAO infosDao = new ClassDAO();

		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		infoList = infosDao.infomationSelect();
		if (infoList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printClassList(infoList);
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ClassVO infoVo = new ClassVO();
		infoVo.setNo(no);

		boolean successFlag = infosDao.infomationDelete(infoVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("삭제 실패. ");
		} else {
			System.out.println();
			System.out.println("삭제 성공했습니다. ");
		}
	}
	//==유아교육 MANAGER========================================================================================
	public static void childshowList() throws SQLException {
		ArrayList<ClassVO> childList = new ArrayList<ClassVO>();
		ClassDAO childDao = new ClassDAO();
		childList = childDao.childSelect();
		if (childList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printClassList(childList);
	}
	public static void childInsertManager() throws SQLException {

		ClassDAO childDao = new ClassDAO();

		System.out.println("유아교욱과 전공 번호 : 02");
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ClassVO childVo = new ClassVO(num, name, grade);

		boolean successFlag = childDao.childInsert(childVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("입력 실패");
			return;
		} else {
			System.out.println("입력이 완료 되었습니다.");
			System.out.println("입력된 정보");
			System.out.println();
			System.out.println("=============================================================================");
			System.out.println();
			System.out.println(childVo.print());
			System.out.println("=============================================================================");
		}
	}
	public static void childDeleteManager() throws SQLException {
		ClassDAO childDao = new ClassDAO();

		ArrayList<ClassVO> childList = new ArrayList<ClassVO>();
		childList = childDao.childSelect();
		if (childList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printClassList(childList);
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ClassVO childVo = new ClassVO();
		childVo.setNo(no);

		boolean successFlag = childDao.childDelete(childVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("삭제 실패. ");
		} else {
			System.out.println();
			System.out.println("삭제 성공했습니다. ");
		}
	}
	//==건축공학 MANAGER==========================================================================================
	public static void archishowList() throws SQLException {
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		ClassDAO archiDao = new ClassDAO();
		infoList = archiDao.architectureSelect();
		if (infoList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printClassList(infoList);
	}
	public static void archiInsertManager() throws SQLException {

		ClassDAO archiDao = new ClassDAO();

		System.out.println("건축공학과 전공 번호 : 03");
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ClassVO archiVo = new ClassVO(num, name, grade);

		boolean successFlag = archiDao.architectureInsert(archiVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("입력 실패");
			return;
		} else {
			System.out.println("입력이 완료 되었습니다.");
			System.out.println("입력된 정보");
			System.out.println();
			System.out.println("=============================================================================");
			System.out.println();
			System.out.println(archiVo.print());
			System.out.println("=============================================================================");
		}
	}
	public static void archiDeleteManager() throws SQLException {
		ClassDAO archiDao = new ClassDAO();

		ArrayList<ClassVO> archiList = new ArrayList<ClassVO>();
		archiList = archiDao.architectureSelect();
		if (archiList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printClassList(archiList);
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ClassVO archiVo = new ClassVO();
		archiVo.setNo(no);

		boolean successFlag = archiDao.architectureDelete(archiVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("삭제 실패. ");
		} else {
			System.out.println();
			System.out.println("삭제 성공했습니다. ");
		}
	}
	//==== 수강과목 전체출력 ==================================================================================
//	public static void ClassAll() {
//		ArrayList<ClassVO> classList = new ArrayList<ClassVO>();
//		ClassDAO classDao = new ClassDAO();
//		classList = classDao.ClassAllSelect();
//		if (classList == null) {
//			System.out.println();
//			System.out.println("수강 과목이 존재하지 않습니다");
//			return;
//		}
//		printClassList(classList);
//	}
	
	//==Class 출력문========================================================================================
	public static void printClassList(ArrayList<ClassVO> classList) {
		System.out.println("=============================================================================");
		System.out.println();
		for (ClassVO classVO : classList) {
			System.out.println(classVO.toString());
		}
		System.out.println("=============================================================================");
	}

}
