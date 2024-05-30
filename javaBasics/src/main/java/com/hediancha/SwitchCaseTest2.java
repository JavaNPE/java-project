package com.hediancha;/*
��д���򣺴Ӽ���������2019��ġ�month���͡�day����Ҫ��ͨ������������������Ϊ2019��ĵڼ��졣

2  15:  31 + 15

5 7: 31 + 28 + 31 + 30 + 7 

....

˵��:break��switch-case���ǿ�ѡ��
*/
import java.util.Scanner;
class SwitchCaseTest2 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("������2019���month��");
		int month = scan.nextInt();
		System.out.println("������2019���day��");
		int day = scan.nextInt();


		//����һ������������������
		int sumDays = 0;

		//��ʽһ������
		/*
		
		if(month == 1){
			sumDays = day;
		}else if(month == 2){
			sumDays = 31 + day;
		}else if(month == 3){
			sumDays = 31 + 28 + day;
		}else if(month == 4){
			sumDays = 31 + 28 + 31 + day;
		}
		//...
		else{//month == 12
			//sumDays = ..... + day;
		}

		*/

		//��ʽ��������
		/*
		switch(month){
		case 1:
			sumDays = day;
			break;
		case 2:
			sumDays = 31 + day;
			break;
		case 3:
			sumDays = 31 + 28 + day;
			break;
		...
		}
		*/

		switch(month){
		case 12:
			sumDays += 30;
		case 11:
			sumDays += 31;
		case 10:
			sumDays += 30;
		case 9:
			sumDays += 31;
		case 8:
			sumDays += 31;
		case 7:
			sumDays += 30;
		case 6:
			sumDays += 31;
		case 5:
			sumDays += 30;
		case 4:
			sumDays += 31;
		case 3:
			sumDays += 28;
		case 2:
			sumDays += 31;
		case 1:
			sumDays += day;
		}

		System.out.println("2019��" + month + "��" + day + "���ǵ���ĵ�" + sumDays + "��");
	}
}
