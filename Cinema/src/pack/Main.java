package pack;

import java.util.Scanner;

public class Main {

	 static void menu(){
			System.out.println("<<<-------------->>\n��� ������ ����� - 1\n��� ������ ����� ������ - 2\n��� �������� ����� - 3\n��� �������� ����� ������ - 4\n�������� �� ������ - 5\n����� � �������� - 6\n<<<-------------->>");
		}
	 
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		while(true){
			menu();
			Scanner sca = new Scanner(System.in);
			int key = sca.nextInt();
			switch (key) {
			case 1:
				cinema.addMovie();
				break;
			case 2:
				cinema.addThisSeanse();
				break;
			case 3:
				cinema.removeMovie();
				break;
			case 4:
				cinema.removeThisSeanse();
				break;
			case 5:
				cinema.allMovie();
				break;
			case 6:
				System.exit(0);
				break;

			default:
				break;
			}			
		}		
	}
}
