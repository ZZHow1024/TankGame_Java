package zzhow.tankgame;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 2024/5/3
 *
 * @author ZZHow
 * @version 2.0
 * 敌方坦克
 */
public class EnemyTank extends Tank implements Runnable {
    //线程状态
    private boolean loop = true;

    public static final int BULLET_NUMBER_MAX = 5;
    public static final int TYPE = 1;
    public int currentBulletNumber = BULLET_NUMBER_MAX;
    private final CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<>();

    public EnemyTank() {
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }

    public CopyOnWriteArrayList<Bullet> getBullets() {
        return bullets;
    }

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void shootBullet() {
        if (this.currentBulletNumber > 0) {
            //当前子弹数减 1
            --this.currentBulletNumber;

            //创建 Bullet 对象
            Bullet bullet = switch (this.getDirection()) {
                case MyPanel.UPWARD -> new Bullet(this.getX() + 17, this.getY() - 3, this.getDirection());
                case MyPanel.DOWNWARD -> new Bullet(this.getX() + 17, this.getY() + 57, this.getDirection());
                case MyPanel.LEFT -> new Bullet(this.getX() - 3, this.getY() + 17, this.getDirection());
                case MyPanel.RIGHT -> new Bullet(this.getX() + 57, this.getY() + 17, this.getDirection());
                default -> null;
            };

            //启动子弹线程
            new Thread(bullet).start();
            //放入 CopyOnWriteArrayList 集合
            bullets.add(bullet);
        }
    }

    @Override
    public void run() {
        while (loop && isLive()) {
            //随机改变坦克方向 0、1、2、3
            Random random = new Random();
            setDirection(random.nextInt(4));

            //根据坦克的方向继续移动 30 步
            for (int i = 0; i < 30; i++) {
                //三十五分之一的概率随机射击
                if (random.nextInt(35) == 0)
                    this.shootBullet();

                if(getY() <= 0)
                    setDirection(MyPanel.DOWNWARD);
                else if (getY() + 60 >= 750)
                    setDirection(MyPanel.UPWARD);
                else if(getX() <= 0)
                    setDirection(MyPanel.RIGHT);
                else if (getX() + 60 >= 750)
                    setDirection(MyPanel.LEFT);

                switch (getDirection()) {
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
}
