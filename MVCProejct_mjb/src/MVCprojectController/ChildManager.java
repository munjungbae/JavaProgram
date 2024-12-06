package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.ChildVO;

public class ChildManager {
	public static Scanner sc = new Scanner(System.in);

	public static void showList() throws SQLException {
		ArrayList<ChildVO> childList = new ArrayList<ChildVO>();
		ChildDAO childDao = new ChildDAO();
		childList = childDao.childSelect();
		if (childList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printChildList(childList);
	}

	public static void childInsertManager() throws SQLException {

		ChildDAO childDao = new ChildDAO();

		System.out.println("유아교욱과 전공 번호 : 02");
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ChildVO childVo = new ChildVO(num, name, grade);

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

	

	// 삭제
	public static void childDeleteManager() throws SQLException {
		ChildDAO childDao = new ChildDAO();

		ArrayList<ChildVO> childList = new ArrayList<ChildVO>();
		childList = childDao.childSelect();
		if (childList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printChildList(childList);
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ChildVO childVo = new ChildVO();
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
	


	public static void printChildList(ArrayList<ChildVO> childList) {
		System.out.println("=============================================================================");
		System.out.println();
		for (ChildVO childVO : childList) {
			System.out.println(childVO.toString());
		}
		System.out.println("=============================================================================");
	}

}
