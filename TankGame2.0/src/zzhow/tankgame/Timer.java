package zzhow.tankgame;

/**
 * 2024/5/9
 *
 * @author ZZHow
 * 计时器
 */
public class Timer extends Thread{
    private boolean loop = true;
    private double time = 0.0;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public double getTime() {
        return time;
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            time += 0.01;
        }
    }
}
