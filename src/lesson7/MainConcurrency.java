package lesson7;

/**
 * Vovik
 * 2/17/2019
 */

public class MainConcurrency {
    public static void main(String[] args) {
/*        for(int i = 1; i<10; i++){
            new Thread(){
                @Override
                public void run() {
                    System.out.println(this.getName());;
                }
            }.start();
        }*/

        for(int i = 1; i<10; i++){
            int finalI = i;
            new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(finalI);
                }
            }).start();
        }

    }
}
