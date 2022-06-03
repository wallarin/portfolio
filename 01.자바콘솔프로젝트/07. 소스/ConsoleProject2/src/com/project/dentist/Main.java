package com.project.dentist;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import com.project.dentist.admin.AdminMain;
import com.project.dentist.dataClass.Patient;

/**
 * 첫 메인화면 입니다.
 * 회원가입과 로그인을 통해 관리자 페이지, 환자 페이지로의 흐름을 결정합니다.
 * @author 고민지
 * @author 고수경
 * @author 김승연
 * @author 김시현
 * @author 백재민
 * @author 정혜인
 *
 */
public class Main {

	public static int loginTry = 0;
	public static void main(String[] args) { //로고 및 회원가입 로그인 화면
		
		Data.load();
		
		

		Login login = new Login();
		Sign sign = new Sign();
		AdminMain aaa = new AdminMain();
		resetPw reset = new resetPw();

		boolean loop = true;

		
		
		while (loop) {
			System.out.println("🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷");
			System.out.println("==================================================================================="); 
			System.out.println("\r\n"
                    + "                             ⣼⠗⠂⡤⢄⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀                     ⠀⠀ ⢠⣿⠁⢀⠃⠆⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⣼⡇⠀⡈⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀   ⣠⠤⠒⠒⠒⠒⠒⠤⠴⡒⠒⠒⠒⠢⡄⠀  ⢸⡏⠐⠲⠁⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀  ⢠⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠈⠳⡀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "      ⡇ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢣⠀⢸⡇⠀		▄  ▄▄▄▄   ▄▄▄  ▄ ▄▄▄▄ ▄⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀  ⡇⠀⠀⠀⠀ ⢶⡦⠀⠀⠀⠀⣶⡦⠀⠀⠀  ⢸⣀⡼⠓⣦	   █  █ █  ▄▄▄█  ▄▄▄▄▄ █  ▄ █ █ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀\r\n"
                    + "     ⠀⢇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀ ⡎ ⣤⠒⠁	   █▄▄█ █▄ █▄▄▄   ▄▀▄  █  █ ▀ █▄ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀⢘⡄⠀⠀⠀⠀ ⠀⠂⠤⠤⠂⠀⠀⠀⠀ ⡰⠗ ⣹⡏⠀⠀	   █  █ █ ▄▄▄▄▄▄ ▀   ▀ █ ▀▀▀▀ █ ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀  ⡼⠈⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⡜⠁⢰⣿⠁⠀	   ▀▀▀▀ █ ▄            █      █⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \r\n"
                    + "   ⢠⠁ ⡰⠙⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀ ⢸⠀⠀⣾  	          ▀▀▀▀▀▀⠀⠀                     \r\n"
                    + " ⠀⠀⣇⡔⠁⠀ ⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⢸⠀⢰⡿⠀⠀⠀⠀  ╭────────────╮   ╭────────────╮   ╭─────────────╮⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀⠀  ⡇⠀⠀⠀⠀⡠⠊⠳⡄ ⠀⠀⠀⡼⠀⣾⠇⠀⠀⠀⠀⠀   1. 회원가입         2.로그인           0.프로그램종료⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀ ⠀⠀⠀ ⢣⠀⠀⠀⢠⠃⠀⠀⢸⠀⠀⠀⢀⡇⠼⡟⠀⠀⠀⠀⠀⠀⠀╰────────────╯   ╰────────────╯   ╰─────────────╯⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀ ⠀⠀  ⠈⢆⠀⠀⡜⠀⠀⠀⠀⢇⠀⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "⠀⠀⠀⠀⠀⠀ ⠀⠀ ⠈⠓⠚⠀⠀⠀⠀⠀⠈⠓⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
                    + "");
			System.out.println("==================================================================================="); 
			System.out.println("🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷🦷");

			Scanner scan = new Scanner(System.in);
			System.out.print("번호✎ > ");
			String input = scan.nextLine();
			System.out.println();

			if (input.equals("1")) {
				sign.sign();
				
	         } else if (input.equals("2")) {
	        	 ArrayList<String> id = new ArrayList<String>();
	     		
	     		for(Patient p : Data.plist) {
	     			id.add(p.getId());
	     		}
	            System.out.print("아이디 입력 > ");
	            String log = scan.nextLine();
	           
	            if(id.contains(log)) {
	            	System.out.print("비밀번호 입력 > ");
	            	String pw = scan.nextLine();
	            	Login.login(log, pw);
	            } else if (log.equals("admin")) {
	            	System.out.println("🦷관리자 모드로 로그인 성공하였습니다!!🦷");
	            	System.out.println();
		            AdminMain.main();
		  	         
		  	    } 
	            else {
	            	System.out.println("아이디가 올바르지 않습니다.");
	            }
	            
	             
	            
	            if (loginTry == 5) {
	            	resetPw.main();
	            
	            }
	         }  else if(input.equals("0")){
	        	 System.out.println("프로그램을 종료합니다. 이용해 주셔서 감사합니다. ");
	            loop = false;
	         } else {
	        	 System.out.println("잘못된 번호입니다 다시 입력해주세요.");
	         }
			
			
		}

	}

}