package gbb;

import java.awt.Graphics;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GBBonFrame extends JFrame {
//속성(필드, 변수나 배열-값을 저장)
    MyPanel mypanel = new MyPanel();
    String msgs[] = {"","","",""};

//생성자 메소드 - 객체를 생성하는 방법, 객체의 초기값 등
	//반드시 클래스 이름과 같게 만들어야 한다, 여러 개를 만들 수 있음, 반환값 없음
    GBBonFrame() {
        setTitle("가위바위보 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setContentPane(mypanel);
        setVisible(true);

        game();
    }

    void game() {
        Scanner sc = new Scanner(System.in);

        int num = 0;	//가위바위보 게임 횟수  
        
        while (num < 3) {
            int i;
            String gbb_computer;
            String gbb_user;
            Random r = new Random();
            i = r.nextInt(3);

            if (i == 0)
                gbb_computer = "가위";
            else if (i == 1)
                gbb_computer = "바위";
            else
                gbb_computer = "보";
            
            System.out.print("컴퓨터와 가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요>> ");
            gbb_user = sc.next();
            
            if(!(gbb_user.equals("가위") || gbb_user.equals("바위") || gbb_user.equals("보"))) {
            	System.out.println("가위, 바위, 보 중에서 입력해주세요.");
            	continue;
            }	// 가위, 바위, 보 이외 문자열을 입력할 경우 에러 처리

            if (gbb_computer.equals("가위")) {
                if (gbb_user.equals("가위")) {
                    msgs[num] = "사용자 = 가위, 컴퓨터 = 가위 :: 비겼습니다.";
                } else if (gbb_user.equals("바위")) {
                    msgs[num] = "사용자 = 바위, 컴퓨터 = 가위 :: 사용자가 이겼습니다.";
                } else if (gbb_user.equals("보")){
                    msgs[num] = "사용자 = 보, 컴퓨터 = 가위 :: 사용자가 졌습니다.";
                }

            } else if (gbb_computer.equals("바위")) {
                if (gbb_user.equals("가위")) {
                    msgs[num] = "사용자 = 가위, 컴퓨터 = 바위 :: 사용자가 졌습니다.";
                } else if (gbb_user.equals("바위")) {
                    msgs[num] = "사용자 = 바위, 컴퓨터 = 바위 :: 비겼습니다.";
                } else if (gbb_user.equals("보")){
                    msgs[num] = "사용자 = 보, 컴퓨터 = 바위 :: 사용자가 이겼습니다.";
                }

            } else if (gbb_computer.equals("보")) {
                if (gbb_user.equals("가위")) {
                    msgs[num] = "사용자 = 가위, 컴퓨터 = 보 :: 사용자가 이겼습니다.";
                } else if (gbb_user.equals("바위")) {
                    msgs[num] = "사용자 = 바위, 컴퓨터 = 보 :: 사용자가 졌습니다.";
                } else if (gbb_user.equals("보")) {
                    msgs[num] = "사용자 = 보, 컴퓨터 = 보 :: 비겼습니다.";
                }
            }
            num++;
        }
        System.out.println("게임이 종료되었습니다.");
        msgs[3] = "게임이 종료되었습니다.";
        repaint();
    }

//동작(method: 기능, 함수)

    class MyPanel extends JPanel {    	
        public void paintComponent(Graphics g) {      	
        	        	
            super.paintComponent(g);
            g.drawString("자바 게임을 시작합니다.", 5, 10);
            
            for (int i = 0; i < msgs.length; i++) {
                g.drawString(msgs[i], 5, 15 * (i + 2)); 	//게임 결과 출력
            }
        }
    }

    public static void main(String[] args) {
        GBBonFrame gbbFrame = new GBBonFrame();
    }
}