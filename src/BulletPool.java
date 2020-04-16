
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BulletPool {

    private static BulletPool instance;

    private List<Bullet> bulletlist;

    private int PoolSize = 8;

    private BulletPool() {
        bulletlist = new ArrayList<>();
        for (int i = 0; i <= PoolSize; i++) {
            bulletlist.add(new Bullet(0, 0, 0, 0));

        }
    }

    public static BulletPool getInstance() {
        if (instance == null) {
            instance = new BulletPool();
            return instance;
        }
        return instance;
    }

    public Bullet retrieveBulletAndDirection(int x, int y, int dx, int dy) {
        if (bulletlist.size() == 0) {
            for (int i = 0; i < 10; i++) {
                bulletlist.add(new Bullet(0, 0, 0, 0));
            }
        }
        Bullet bullet = bulletlist.remove(0);
        bullet.setX_Y(x, y);
        bullet.setDx_Dy(dx, dy);
        return bullet;
    }

    public void collectReusedBullet(Bullet bullet) {
        bulletlist.add(bullet);
    }
}