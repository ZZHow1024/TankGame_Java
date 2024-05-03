package zzhow.tankgame;

/**
 * 2024年4月27日
 *
 * @author ZZHow
 * @version 1.0
 * 敌方坦克
 */
public class EnemyTank extends Tank{
    public static final int TYPE = 1;

    public EnemyTank() {
    }

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public EnemyTank(int x, int y, int direction, int speed) {
        super(x, y, direction, speed);
    }
}
