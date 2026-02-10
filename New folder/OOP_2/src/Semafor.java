
//package p2;
//
//public class Semafor {
//    private SemaphoreColor culoareSemafor = SemaphoreColor.RED;
//
//    public void schimbaCuloare() {
//        switch(culoareSemafor) {
//            case RED:
//                culoareSemafor = SemaphoreColor.GREEN;
//                break;
//            case GREEN:
//                culoareSemafor = SemaphoreColor.YELLOW;
//                break;
//            case YELLOW:
//                culoareSemafor = SemaphoreColor.RED;
//                break;
//        }
//    }
//
//    public String toString() {
//        return "Culoarea semaforului este " + culoareSemafor;
//    }
//
//    public static void main(String[] args) {
//        Semafor s = new Semafor();
//        for(int i = 1; i <= 10; i++) {
//            s.schimbaCuloare();
//            System.out.println(s);
//        }
//    }
//}