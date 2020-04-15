import java.util.Stack;

public class BulletPool {

    private static BulletPool instance;
    private static Stack<Bullet> bullets;

    private BulletPool() {
        bullets = new Stack<>();
        for (int i = 0; i < 10; i++) {
            bullets.push(new Bullet(0, 0, 0, 0));
        }
    }

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();
            return instance;
        } else {
            return  instance;
        }
    }

    public Bullet getAvailableBulletWithDirection(int x, int y, int dx, int dy) {
        if (bullets.size() == 0) {
            for (int i = 0; i < 10; i++) {
                bullets.push(new Bullet(0, 0, 0, 0));
            }
        }
        Bullet bullet = bullets.pop();
        bullet.set_X_Y(x, y);
        bullet.set_Dx_Dy(dx, dy);
        return bullet;
    }

    public void collectBullet(Bullet bullet) {
        bullets.push(bullet);
    }

}