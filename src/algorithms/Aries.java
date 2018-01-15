package algorithms;

import java.util.Timer;
import java.util.TimerTask;

public class Aries {

    public static void main(String... args) {
        new Timer().schedule(new Task(), 0, 5000);
    }
}

class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println("call");
    }
}