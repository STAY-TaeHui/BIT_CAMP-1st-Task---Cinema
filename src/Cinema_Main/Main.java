package Cinema_Main;
import Cinema_Reservation.Cinema_Reservation;

public class Main {
    public static void main(String[] args){
//        cr.printSeat();
        Cinema_Reservation cr = new Cinema_Reservation();

while(true) {
    switch (cr.menuChoice()) {
        case 1: {
            System.out.println("case 1");
            cr.reserveSeatCheck();
            break;
        }
        case 2: {
            System.out.println("case 2");
            cr.printSeat();
            break;

        }
        case 3: {
            System.out.println("case 3");
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }
}

    }
}
