import java.util.ArrayList;

public class BulletPool {

    private static BulletPool instance;
    private static ArrayList<Bullet> bullets;

    private BulletPool() {
        bullets = new ArrayList<Bullet>();
        for (int i = 0; i < 10; i++) {
            bullets.add(new Bullet(0, 0, 0, 0));
        }
    }

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();
            return instance;
        }
        else {
            return instance;
        }
    }

    public Bullet getAvailableBulletWithDirection(int x, int y, int dx, int dy) {
        if (bullets.size() == 0) {
            for (int i = 0; i < 10; i++) {
                bullets.add(new Bullet(0, 0, 0, 0));
            }
        }
        Bullet bullet = bullets.remove(-1);
        return bullet;
    }

    public void collectBullet(Bullet bullet) {
        bullets.add(bullet);
        System.out.println(bullets);
    }

}