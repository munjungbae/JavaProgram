package MVCprojectView;

public class MVCprojectMenu {
	
	public static void mainMenuView() {
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-16s", "1. 전공 정보"));
		System.out.print(String.format("%-16s", "2. 학생 정보"));
		System.out.println(String.format("%-16s", "3. 프로그램 종료"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}

	//String.format("%-5s", )
	public static void studentMenuView() {
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "1. 학생 정보 목록"));
		System.out.print(String.format("%-15s", "2. 학생 정보 입력"));
		System.out.println(String.format("%-15s", "3. 학생 정보 수정"));
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "4. 학생 정보 삭제"));
		System.out.println(String.format("%-16s", "5. 메인 메뉴"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}

	public static void majorMenuView() {
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "1. 전공 정보 목록"));
		System.out.print(String.format("%-23s", "2. 전공 정보 입력"));
		System.out.println(String.format("%-15s", "3. 전공 정보 수정"));
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "4. 전공 정보 삭제"));
		System.out.print(String.format("%-22s", "5. 전공 별 수강 과목 목록"));
		System.out.println(String.format("%-15s", "6. 메인 메뉴"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}
	
	public static void majorClassMenuView() {
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-10s", "1. 정보통신학과"));
		System.out.print(String.format("%-5s", "01"));
		System.out.print(String.format("%-10s", "2. 유아교육과"));
		System.out.print(String.format("%-5s", "02"));
		System.out.print(String.format("%-10s", "3. 건축학과"));
		System.out.print(String.format("%-5s", "03"));
		System.out.println(String.format("%-10s", "4. 뒤로가기"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}
	
	public static void majorManagerMenuView() {
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-10s", "1. 정보통신학과"));
		System.out.print(String.format("%-5s", "01"));
		System.out.print(String.format("%-10s", "2. 유아교육과"));
		System.out.print(String.format("%-5s", "02"));
		System.out.print(String.format("%-10s", "3. 건축학과"));
		System.out.println(String.format("%-5s", "03"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
	}
	
	public static void InfoMenuView() {
		System.out.println();
		System.out.println("===== 정보통신학과 =============================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "1. 수강 과목 목록"));
		System.out.print(String.format("%-15s", "2. 수강 과목 입력"));
		System.out.print(String.format("%-15s", "3. 수강 과목 삭제"));
		System.out.println(String.format("%-15s", "4. 뒤로가기"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}
	
	public static void ChildMenuView() {
		System.out.println();
		System.out.println("===== 유아교육과 ===============================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "1. 수강 과목 목록"));
		System.out.print(String.format("%-15s", "2. 수강 과목 입력"));
		System.out.print(String.format("%-15s", "3. 수강 과목 삭제"));
		System.out.println(String.format("%-15s", "4. 뒤로가기"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}
	
	public static void ArchiMenuView() {
		System.out.println();
		System.out.println("===== 건축공학과 ===============================================================");
		System.out.println();
		System.out.print(String.format("%-5s", ""));
		System.out.print(String.format("%-15s", "1. 수강 과목 목록"));
		System.out.print(String.format("%-15s", "2. 수강 과목 입력"));
		System.out.print(String.format("%-15s", "3. 수강 과목 삭제"));
		System.out.println(String.format("%-15s", "4. 뒤로가기"));
		System.out.println();
		System.out.println("=============================================================================");
		System.out.println();
		System.out.print("번호를 선택 해 주세요 : ");
	}
	

}
