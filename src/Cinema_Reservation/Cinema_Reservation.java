package Cinema_Reservation;

import java.util.Scanner;

public class Cinema_Reservation {
    private static final int row=4;
    private static final int col=5;

    public static Scanner sc = new Scanner(System.in);
    private static String [][] seat=new String [row][col];

    public Cinema_Reservation(){              //생성자를 통해 좌석 초기화
        for(int i=0; i< row; i++){
            for(int j=0; j<col; j++){
                seat[i][j] = (i+1)+"-"+(j+1);
            }
        }
    }


    public static int menuChoice(){
        System.out.println("*********************************");
        System.out.println("**********영화예매 시스템**********");
        System.out.println("*********************************");

        System.out.println(" 1. 예매하기");
        System.out.println(" 2. 예매조회");
        System.out.println(" 3. 예매취소");

        int menu=0;

        do{
            try {
                menu =  sc.nextInt();
                if (menu < 1 || menu > 3) {
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
        return menu;

    }

    public void reserveSeatCheck(){//좌석 예매되어있는지 체크
        int input_Row=0;
        int input_Col=0;

        sc.nextLine();
        while(true){
        System.out.println("좌석을 선택해주세요. 예) 1-1");
        System.out.println("이미 예약된 좌석은 \"예매\"라고 표시됩니다.");



            String seatNum = sc.nextLine();
            try{
                String [] row_col = seatNum.split("-");
                input_Row = Integer.parseInt(row_col[0]);
                input_Col = Integer.parseInt(row_col[1]);
                throw new Exception();
            }
            catch(Exception e){
                System.out.println("좌석번호를 확인하고 입력해주세요...");
//                continue;
            }


//            input_Row = Integer.parseInt(seatNum.split("-")[0]);
//            input_Col = Integer.parseInt(seatNum.split("-")[1]);


            System.out.println(input_Row + " " + input_Col);
            try{
                if ((row < 1 || row > 4) || (col < 1 || col > 5)) {
                    System.out.println("올바른 좌석번호를 입력해주세요.");
                }
                else{
                    if(seat[input_Row-1][input_Col-1].equals(input_Row+"-"+input_Col)) {
                        System.out.println("예약좌석 아님!!!!");

                        if(reserveMenuChoice(input_Row, input_Col)==2){
                            continue;
                        }
                        else if(reserveMenuChoice(input_Row, input_Col)==3)
                        {break;}
                    }
                    else{
                        System.out.println("이미 예약되어있는 좌석입니다.");
                    }
                }
            }
            catch(Exception e){
                System.out.println("좌석을 다시 선택해 주세요요");
            }
        }

    }
    public static  int reserveMenuChoice(int input_Row, int input_Col){

            int reserve_Option=0;
            System.out.println("예약 가능합니다. 예매하시겠습니까?");
            System.out.println("네(1), 아니오(2), 초기화면(0)중 하나를 입력해주세요.");
            reserve_Option = sc.nextInt();
            try{
                if(reserve_Option>=0 && reserve_Option<=2){
                    switch (reserve_Option){
                        case 1 :{
                            reserveSeat(input_Row,input_Col);//좌석 예매하기
                            break;
                        }
                        case 2: {
                            System.out.println("좌석선택 화면으로 돌아갑니다.");
                            return 2;
                        }
                        case 3 : {
                            System.out.println("초기화면으로 돌아갑니다.");
                            return 3;
                        }
                    }
                }
                else{
                    throw new Exception("올바른 번호를 입력해주세요.");
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        return 0;
    }
    public static void reserveSeat(int input_Row,int input_Col){
        System.out.println("RESERVESEAT잉ㅂ니다");
    }
    public static void printSeat(){//좌석 조회
        for(int i=0; i< row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("[%s] ",seat[i][j]);
            }
            System.out.println();
        }
    }



}
