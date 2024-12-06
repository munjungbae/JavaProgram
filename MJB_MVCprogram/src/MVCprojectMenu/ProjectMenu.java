package MVCprojectMenu;

import java.util.Scanner;

import MVCprojectView.MVCprojectMainMenu;
import MVCprojectView.MVCprojectMenu;

public class ProjectMenu {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MVCprojectMenu.mainMenuView();
				no = Integer.parseInt(sc.nextLine());
				switch (no) {
				case MVCprojectMainMenu.MAJOR:
					MajorMenu.MajorMenu();
					break;
				case MVCprojectMainMenu.STUDENT:
					StudentMenu.studentMenu();
					break;
				case MVCprojectMainMenu.EXIT:
					System.out.println();
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true;
					break;
				default:
					System.out.println();
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				return;
			}
		}
	}

	

}
