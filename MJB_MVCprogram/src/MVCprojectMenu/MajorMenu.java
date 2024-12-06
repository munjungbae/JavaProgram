package MVCprojectMenu;

import java.util.Scanner;

import MVCprojectController.ClassManager;
import MVCprojectController.MajorManager;
import MVCprojectModel.ClassVO;
import MVCprojectView.MVCprojectListMenu;
import MVCprojectView.MVCprojectMenu;

public class MajorMenu {
	public static Scanner sc = new Scanner(System.in);

	public static void MajorMenu() {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MVCprojectMenu.majorMenuView();
				no = Integer.parseInt(sc.nextLine());
				switch (no) {
				case MVCprojectListMenu.LIST:
					System.out.println();
					MajorManager.showList();
					break;
				case MVCprojectListMenu.INSERT:
					MajorManager.majorInsertManager();
					break;
				case MVCprojectListMenu.UPDATE:
					System.out.println();
					MajorManager.majorUpdateManager();
					break;
				case MVCprojectListMenu.DELETE:
					System.out.println();
					MajorManager.majorDeleteManager();
					break;
				case MVCprojectListMenu.CLASS:
					System.out.println();
					classMenu();
					break;
				case MVCprojectListMenu.MENU:
					System.out.println();
					System.out.println("메인화면으로 돌아갑니다.");
					exitFlag = true;
					break;
				default:
					System.out.println();
					System.out.println("해당 메뉴 번호만 입력하세요.");
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println("\n입력에 오류가 있습니다.");
				break;
			}
		}

	}
	
	private static void classMenu() {
		ClassVO cvo = new ClassVO();
		boolean classFlag = false;
		while (!classFlag) {
			try {
				MVCprojectMenu.majorClassMenuView();
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case MVCprojectListMenu.IMFOMATION:
					ClassManager.classShowinfoList();
					break;
				case MVCprojectListMenu.CHILD:
					ClassManager.classShowChildList();
					break;
				case MVCprojectListMenu.ARCHI:
					ClassManager.classShowArchiList();
					break;
				case MVCprojectListMenu.CLASSINSERT:
					ClassManager.ClassInsertManager();
					break;
				case MVCprojectListMenu.CLASSDELETE:
					ClassManager.classDeleteManager();
					break;
				case MVCprojectListMenu.ALL:
					ClassManager.classShowList();
					break;
				case MVCprojectListMenu.BACK:
					classFlag = true;
					break;
				default:
					System.out.println();
					System.out.println("해당 메뉴 번호만 입력하세요.");
					System.out.println();
				}
			} catch (Exception e) {
				System.out.println();
				System.out.println("\n입력에 오류가 있습니다.(class)");
				break;
			}
		}
	}
}
