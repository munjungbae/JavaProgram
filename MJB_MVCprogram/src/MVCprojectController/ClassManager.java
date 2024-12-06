package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.ClassVO;

public class ClassManager {
	//=====정보통신 MANAGER================================================================================
	public static Scanner sc = new Scanner(System.in);

	public static void classShowList() throws SQLException {
		ArrayList<ClassVO> classList = new ArrayList<ClassVO>();
		ClassDAO classDao = new ClassDAO();
		classList = classDao.classAllSelect();
		if (classList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		System.out.println();
		printClassList(classList);
	}

	public static void classShowinfoList() throws SQLException {
		ArrayList<ClassVO> infoList = new ArrayList<ClassVO>();
		ClassDAO classDao = new ClassDAO();
		infoList = classDao.classMajorSelect();
		if (infoList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		System.out.println();
		printClassList(infoList);
	}
	
	public static void classShowChildList() throws SQLException {
		ArrayList<ClassVO> childList = new ArrayList<ClassVO>();
		ClassDAO classDao = new ClassDAO();
		childList = classDao.classChildSelect();
		if (childList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		System.out.println();
		printClassList(childList);
	}
	
	public static void classShowArchiList() throws SQLException {
		ArrayList<ClassVO> archiList = new ArrayList<ClassVO>();
		ClassDAO classDao = new ClassDAO();
		archiList = classDao.classArchiSelect();
		if (archiList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		System.out.println();
		printClassList(archiList);
	}
	
	
	public static void ClassInsertManager() throws SQLException {

		ClassDAO classDao = new ClassDAO();
		
		MajorManager.showList();
		System.out.println();
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ClassVO classVo = new ClassVO(num, name, grade);
		
		boolean classCheck = classDao.classCheck(classVo);
		if (classCheck == false) {
			System.out.println("이미 존재하고 있는 과목입니다.");
			return;
		} else {
			boolean successFlag = classDao.classInsert(classVo);
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
				System.out.println(classVo.print());
				System.out.println("=============================================================================");
			}
		}
	}
	public static void classDeleteManager() throws SQLException {
		ClassDAO classDao = new ClassDAO();

		ArrayList<ClassVO> classList = new ArrayList<ClassVO>();
		classList = classDao.classAllSelect();
		if (classList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		System.out.println();
		printClassList(classList);
		
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ClassVO classVo = new ClassVO();
		classVo.setNo(no);

		boolean successFlag = classDao.classDelete(classVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("삭제 실패. ");
		} else {
			System.out.println();
			System.out.println("삭제 성공했습니다. ");
		}
	}

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
