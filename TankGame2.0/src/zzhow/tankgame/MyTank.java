package zzhow.tankgame;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 2024/5/3
 *
 * @author ZZHow
 * @version 2.0
 * 我方坦克
 */
public class MyTank extends Tank implements Runnable {
    //线程状态
    private boolean loop = true;

    public static final int BULLET_NUMBER_MAX = 5;
    public static final int TYPE = 0;
    public int currentBulletNumber = BULLET_NUMBER_MAX;
    private Bullet bullet = null;
    private final CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<>(); //使用线程安全的 CopyOnWriteArrayList
    private int move = -1;

    public MyTank() {
    }

    public MyTank(int x, int y) {
        super(x, y);
    }

    public MyTank(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    public void shootBullet() {
        --this.currentBulletNumber;
        //创建 Bullet 对象
        switch (this.getDirection()) {
            case MyPanel.UPWARD:
                bullet = new Bullet(this.getX() + 17, this.getY() - 3, this.getDirection());
                break;
            case MyPanel.DOWNWARD:
                bullet = new Bullet(this.getX() + 17, this.getY() + 57, this.getDirection());
                break;
            case MyPanel.LEFT:
                bullet = new Bullet(this.getX() - 3, this.getY() + 17, this.getDirection());
                break;
            case MyPanel.RIGHT:
                bullet = new Bullet(this.getX() + 57, this.getY() + 17, this.getDirection());
                break;
        }

        //启动 Bullet 线程
        new Thread(bullet).start();

        //放入 Vector 集合中
        bullets.add(bullet);
    }

    public CopyOnWriteArrayList<Bullet> getBullets() {
        return bullets;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop && isLive()) {
            switch (move) {
                case MyPanel.UPWARD -> moveUp();
                case MyPanel.DOWNWARD -> moveDown();
                case MyPanel.LEFT -> moveLeft();
                case MyPanel.RIGHT -> moveRight();
            }

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
