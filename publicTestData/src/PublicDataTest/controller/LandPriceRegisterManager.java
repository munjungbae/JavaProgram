package PublicDataTest.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import LandPriceVO.LandPriceVO;
import PublicDataTest.PublicDataAPITest;

public class LandPriceRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	public static void insertManager() {
		LandPriceDAO ldao = new LandPriceDAO();
		boolean successFlag = false;
		// 네트워크로부터 데이터를 입력 받는다
		ArrayList<LandPriceVO> landpriceList = PublicDataAPITest.apiDataLoad();
		for (LandPriceVO lvo : landpriceList) {
			int count = ldao.landPriceCheckNodeNOSelect(lvo);

			if (count <= 0) {
				successFlag = ldao.landPriceInsert(lvo);
			} else {
				successFlag = ldao.landPriceUpdate(lvo);
			}
		}

		if (successFlag == true) {
			System.out.println("데이터 입력 또는 수정이 완료 되었습니다.");
		} else {
			System.out.println("데이터 입력 또는 수정이 실패 하였습니다.");
		}
	}

	public void selectManager() {
		LandPriceDAO ldao = new LandPriceDAO();

		LandPriceVO lvo = new LandPriceVO();
		ArrayList<LandPriceVO> list = ldao.landPriceSelect();

		if (list.size() != 0) {
			printLandPriceList(list);
		} else {
			System.out.println("출력 할 데이터가 없습니다.");
		}
	}

	public static void updateManager() {
		LandPriceDAO ldao = new LandPriceDAO();

		ArrayList<LandPriceVO> list = ldao.landPriceSelect();

		if (list == null) {
			System.out.println("출력할 값이 존재하지 않습니다.");
			return;
		} else {
			printLandPriceList(list);
		}

		System.out.print("수정할 번호 입력 >> ");
		int nodeno = Integer.parseInt(sc.nextLine());
		System.out.print("수정할 위도 입력 >> ");
		Double gpslati = Double.parseDouble(sc.nextLine());
		System.out.print("수정할 경도 입력 >> ");
		Double gpslong = Double.parseDouble(sc.nextLine());
		System.out.print("수정 할 아이디 입력 >> ");
		String nodeid = sc.nextLine().trim();
		System.out.print("수정 할 정류소 이름 입력 >> ");
		String nodenm = sc.nextLine().trim();
		
		LandPriceVO lvo = new LandPriceVO();

		lvo = new LandPriceVO(nodeno, gpslati, gpslong, nodeid, nodenm);
		boolean successFlag = ldao.landPriceUpdate(lvo);

		if (successFlag == true) {
			System.out.println("수정이 완료 되었습니다.");
		} else {
			System.out.println("수정에 실패하였습니다. ");
		}
	}

	public static void deleteManager() {
		LandPriceDAO ldao = new LandPriceDAO();

		ArrayList<LandPriceVO> list = ldao.landPriceSelect();
		if (list == null) {
			System.out.println("출력할 값이 존재하지 않습니다.");
		} else {
			printLandPriceList(list);
		}

		System.out.print("삭제할 번호 >> ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.println("no = " + no);

		LandPriceVO lvo = new LandPriceVO();
		lvo.setNodeno(no);
		boolean successFlag = ldao.landPriceDelete(lvo);

		if (successFlag == true) {
			System.out.println(no + "번 삭제 완료 되었습니다.");
		} else {
			System.out.println("삭제 실패했습니다. ");
		}
	}


	public static void printLandPriceList(ArrayList<LandPriceVO> List) {
		System.out.println("============================================");
		for (LandPriceVO lvo : List) {
			System.out.println(lvo.toString());
		}
		System.out.println("============================================");
	}
}
