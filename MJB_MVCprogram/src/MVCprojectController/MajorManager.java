package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.MajorVO;
import MVCprojectView.MVCprojectMainMenu;
import MVCprojectView.MVCprojectMenu;

public class MajorManager {
	public static Scanner sc = new Scanner(System.in);

	// 출력
	public static void showList() throws SQLException {
		ArrayList<MajorVO> majorList = new ArrayList<MajorVO>();
		MajorDAO mDao = new MajorDAO();
		majorList = mDao.MajorSelect();
		if (majorList == null) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		printMajorList(majorList);
	}

	// 입력
	public static void majorInsertManager() throws SQLException {

		String num;
		String name;

		System.out.println();
		
		ArrayList<MajorVO> majorList = new ArrayList<MajorVO>();
		MajorDAO mDao = new MajorDAO();
		majorList = mDao.MajorSelect();
		if (majorList == null) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		printMajorList(majorList);
		
		System.out.println();
		System.out.print("전공 번호를 입력 해 주세요 : ");
		num = sc.nextLine();
		System.out.print("전공 이름을 입력 해 주세요 : ");
		name = sc.nextLine();

		MajorVO mVo = new MajorVO(num, name);

		boolean successFlag = mDao.majorInsert(mVo);

		if (successFlag == false) {
			System.out.println("입력 실패");
			return;
		} else {
			System.out.println("입력이 완료 되었습니다.");
			System.out.println("입력된 정보");
			System.out.println("=============================================================================");
			System.out.println();
			System.out.println(mVo);
			System.out.println("=============================================================================");
		
		}
	}
	//수정
	public static void majorUpdateManager() throws SQLException {
		
		ArrayList<MajorVO> majorList = new ArrayList<MajorVO>();
		MajorDAO mDao = new MajorDAO();
		majorList = mDao.MajorSelect();
		if (majorList == null) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		printMajorList(majorList);
		
		System.out.println();
		System.out.print("수정할 전공의 번호를 입력하세요: ");
		String num = sc.nextLine();
		System.out.print("전공 이름을 입력하세요: ");
		String name = sc.nextLine();

		MajorVO mVo = new MajorVO(num, name);

		boolean successFlag = mDao.majorUpdate(mVo);

		if (successFlag == true) {
			System.out.println("정보 수정에 성공하였습니다 ");
			System.out.println("수정된 정보");
			System.out.println("=============================================================================");
			System.out.println();
			System.out.println(mVo);
			System.out.println("=============================================================================");
		} else {
			System.out.println("수정 실패 ");
		}
	}
	//삭제
	public static void majorDeleteManager() throws SQLException {
		
		ArrayList<MajorVO> majorList = new ArrayList<MajorVO>();
		MajorDAO mDao = new MajorDAO();
		majorList = mDao.MajorSelect();
		if (majorList == null) {
			System.out.println("데이터가 존재하지 않습니다");
			return;
		}
		printMajorList(majorList);
		
		System.out.println();
		System.out.print("삭제하고자 하는 전공의 번호를 입력하세요: ");
		String num = sc.nextLine();

		MajorVO mVo = new MajorVO();
		mVo.setmNum(num);

		boolean successFlag = mDao.majorDelete(mVo);

		if (successFlag == true) {
			System.out.println("삭제 성공했습니다. ");
		} else {
			System.out.println("삭제 실패 ");
		}
	}

	public static void printMajorList(ArrayList<MajorVO> majorList) {
		System.out.println("=============================================================================");
		System.out.println();
		for (MajorVO mvo : majorList) {
			System.out.println(mvo.toString());
		}
		System.out.println("=============================================================================");
	}
}
