package MVCprojectController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MVCprojectModel.ArchitectureVO;
import MVCprojectModel.ImfomationVO;
import MVCprojectModel.MajorVO;

public class ArchitectureManager {
	public static Scanner sc = new Scanner(System.in);

	public static void showList() throws SQLException {
		ArrayList<ArchitectureVO> infoList = new ArrayList<ArchitectureVO>();
		ArchitectureDAO archiDao = new ArchitectureDAO();
		infoList = archiDao.architectureSelect();
		if (infoList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printarchiList(infoList);
	}

	public static void archiInsertManager() throws SQLException {

		ArchitectureDAO archiDao = new ArchitectureDAO();

		System.out.println("건축공학과 전공 번호 : 03");
		System.out.print("해당 과목 전공 번호를 입력 해 주세요 : ");
		String num = sc.nextLine();
		System.out.print("과목 이름을 입력 해 주세요 : ");
		String name = sc.nextLine();
		System.out.print("학점을 입력 해 주세요( 1 ~ 4 ) : ");
		int grade = Integer.parseInt(sc.nextLine());

		ArchitectureVO archiVo = new ArchitectureVO(num, name, grade);

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
	

	// 삭제
	public static void archiDeleteManager() throws SQLException {
		ArchitectureDAO archiDao = new ArchitectureDAO();

		ArrayList<ArchitectureVO> archiList = new ArrayList<ArchitectureVO>();
		archiList = archiDao.architectureSelect();
		if (archiList == null) {
			System.out.println("수강 과목이 존재하지 않습니다");
			return;
		}
		printarchiList(archiList);
		System.out.println();
		System.out.print("삭제하고자 하는 과목의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		ArchitectureVO archiVo = new ArchitectureVO();
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

	public static void printarchiList(ArrayList<ArchitectureVO> archiList) {
		System.out.println("=============================================================================");
		System.out.println();
		for (ArchitectureVO archiVO : archiList) {
			System.out.println(archiVO.toString());
		}
		System.out.println("=============================================================================");
	}
}
