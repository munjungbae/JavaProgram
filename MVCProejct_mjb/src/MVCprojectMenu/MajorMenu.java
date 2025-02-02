package MVCprojectMenu;

import java.util.Scanner;

import MVCprojectController.ArchitectureManager;
import MVCprojectController.ChildManager;
import MVCprojectController.ImfomationManager;
import MVCprojectController.MajorManager;
import MVCprojectView.MVCprojectClassMenu;
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
					System.out.println();
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
		boolean classFlag = false;
		while (!classFlag) {
			try {
				MVCprojectMenu.majorClassMenuView();
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case MVCprojectListMenu.IMFOMATION:
					imfoMenu();
					break;
				case MVCprojectListMenu.CHILD:
					childMenu();
					break;
				case MVCprojectListMenu.ARCHI:
					archiMenu();
					break;
				case MVCprojectClassMenu.MENU:
					System.out.println();
					System.out.println("메인화면으로 돌아갑니다.");
					System.out.println();
					classFlag = true;
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

	private static void imfoMenu() {
		boolean infoFlag = false;
		while (!infoFlag) {
			try {
				MVCprojectMenu.InfoMenuView();
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case MVCprojectClassMenu.LIST:
					System.out.println();
					ImfomationManager.showList();
					break;
				case MVCprojectClassMenu.INSERT:
					System.out.println();
					ImfomationManager.infoInsertManager();
					break;
				case MVCprojectClassMenu.DELETE:
					System.out.println();
					ImfomationManager.infoDeleteManager();
					break;
				case MVCprojectClassMenu.MENU:
					System.out.println();
					System.out.println("메인화면으로 돌아갑니다.");
					System.out.println();
					infoFlag = true;
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
	
	private static void archiMenu() {
		boolean archiFlag = false;
		while (!archiFlag) {
			try {
				MVCprojectMenu.ArchiMenuView();
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case MVCprojectClassMenu.LIST:
					System.out.println();
					ArchitectureManager.showList();
					break;
				case MVCprojectClassMenu.INSERT:
					System.out.println();
					ArchitectureManager.archiInsertManager();;
					break;
				case MVCprojectClassMenu.DELETE:
					System.out.println();
					ArchitectureManager.archiDeleteManager();
					break;
				case MVCprojectClassMenu.MENU:
					System.out.println();
					System.out.println("메인화면으로 돌아갑니다.");
					System.out.println();
					archiFlag = true;
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
	
	private static void childMenu() {
		boolean childFlag = false;
		while (!childFlag) {
			try {
				MVCprojectMenu.ChildMenuView();
				int num = Integer.parseInt(sc.nextLine());
				switch (num) {
				case MVCprojectClassMenu.LIST:
					System.out.println();
					ChildManager.showList();
					break;
				case MVCprojectClassMenu.INSERT:
					System.out.println();
					ChildManager.childInsertManager();
					break;
				case MVCprojectClassMenu.DELETE:
					System.out.println();
					ChildManager.childDeleteManager();
					break;
				case MVCprojectClassMenu.MENU:
					System.out.println();
					System.out.println("메인화면으로 돌아갑니다.");
					System.out.println();
					childFlag = true;
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
}
