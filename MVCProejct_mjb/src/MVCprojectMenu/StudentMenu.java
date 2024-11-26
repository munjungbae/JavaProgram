package MVCprojectMenu;

import java.util.Scanner;

import MVCprojectController.MajorManager;
import MVCprojectController.StudentManager;
import MVCprojectView.MVCprojectListMenu;
import MVCprojectView.MVCprojectMenu;
import MVCprojectView.MVCprojectStudentListMenu;

public class StudentMenu {
	public static Scanner sc = new Scanner(System.in);

	public static void studentMenu() {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MVCprojectMenu.studentMenuView();
				no = Integer.parseInt(sc.nextLine());
				switch (no) {
				case MVCprojectStudentListMenu.LIST:
					System.out.println();
					StudentManager.showList();
					break;
				case MVCprojectStudentListMenu.INSERT:
					System.out.println();
					StudentManager.studentInsertManager(); 
					break;
				case MVCprojectStudentListMenu.UPDATE:
					System.out.println();
					StudentManager.studentUpdateManager();
					break;
				case MVCprojectStudentListMenu.DELETE:
					System.out.println();
					StudentManager.studentDeleteManager();
					break;
				case MVCprojectStudentListMenu.MENU:
					System.out.println();
					System.out.println("메인화면으로 돌아갑니다.");
					exitFlag = true;
					break;
				default:
					System.out.println();
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		}

	}

}
