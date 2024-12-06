package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.ImfomationVO;
import MVCprojectModel.MajorVO;

public class ImfomationManager {
	public static Scanner sc = new Scanner(System.in);

	public static void showList() throws SQLException {
		ArrayList<ImfomationVO> infoList = new ArrayList<ImfomationVO>();
		ImfomationDAO infoDao = new ImfomationDAO();
		infoList = infoDao.infomationSelect();
		if (infoList == null) {
			System.out.println();
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printInfoList(infoList);
	}

	public static void infoInsertManager() throws SQLException {

		ImfomationDAO infoDao = new ImfomationDAO();

		System.out.println("정보통신학과 전공 번호 : 01");
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ImfomationVO infoVo = new ImfomationVO(num, name, grade);

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

	// 삭제
	public static void infoDeleteManager() throws SQLException {
		ImfomationDAO infoDao = new ImfomationDAO();

		ArrayList<ImfomationVO> infoList = new ArrayList<ImfomationVO>();
		infoList = infoDao.infomationSelect();
		if (infoList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printInfoList(infoList);
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ImfomationVO infoVo = new ImfomationVO();
		infoVo.setNo(no);

		boolean successFlag = infoDao.infomationDelete(infoVo);

		if (successFlag == false) {
			System.out.println();
			System.out.println("삭제 실패. ");
		} else {
			System.out.println();
			System.out.println("삭제 성공했습니다. ");
		}
	}

	public static void printInfoList(ArrayList<ImfomationVO> infoList) {
		System.out.println("=============================================================================");
		System.out.println();
		for (ImfomationVO infoVO : infoList) {
			System.out.println(infoVO.toString());
		}
		System.out.println("=============================================================================");
	}
}
