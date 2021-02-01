package Cinema_Reservation;

import java.util.Scanner;

public class Cinema_Reservation {

    Scanner sc = new Scanner(System.in);

    private String [][] seat=new String [4][5];

    public Cinema_Reservation(){                //생성자를 통해 좌석 초기화
        for(int i=0; i< seat.length; i++){
            for(int j=0; j<seat[i].length; j++){
                this.seat[i][j] = (i+1)+"-"+(j+1);
            }
        }
    }


    public int optionChoice(){

        System.out.println("*********************************");
        System.out.println("**********영화예매 시스템**********");
        System.out.println("*********************************");

        System.out.println(" 1. 예매하기");
        System.out.println(" 2. 예매조회");
        System.out.println(" 3. 예매취소");


        int option;

        do{
            try {
                option =  sc.nextInt();
                if (option < 1 || option > 3) {
                    throw new Exception("메뉴의 선택 번호가 잘못되었습니다.");
                }
                else{
                    break;
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("메뉴 1~3번까지 입력해주세요.");
            }
        }
        while (true);
        return option;

    }
    public void reseveSeatCheck(){
        int row=0;
        int col=0;

        System.out.println("좌석을 선택해주세요. 예) 1-1");
        System.out.println("이미 예약된 좌석은 \"예매\"라고 표시됩니다.");
        sc.nextLine();

        do {
            String seatNum = sc.nextLine();
            row = Integer.parseInt(seatNum.split("-")[0]);
            col = Integer.parseInt(seatNum.split("-")[1]);


            System.out.println(row + " " + col);
            try{
                if ((row < 1 || row > 4) || (col < 1 || col > 5)) {
                    throw new Exception("올바른 좌석번호를 입력해주세요.");
                }
                else break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println("좌석번호 선택 오류");
                ;
            }

        }while(true);

        if(this.seat[row][col].equals(row+"-"+col)){
            System.out.println("예약 가능합니다. 예매하시겠습니까?");
            System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");



        }
        else{
            System.out.println("이미 예약되어있는 좌석입니다.");
        }

    }
    public void reserveSeat(){

    }
    public void printSeat(){//좌석 조회
        for(int i=0; i< seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                System.out.printf("[%s] ",this.seat[i][j]);
            }
            System.out.println();
        }
    }



}
