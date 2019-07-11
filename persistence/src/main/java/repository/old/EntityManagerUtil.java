package repository.old;

public class EntityManagerUtil {
    private static EntityManagerUtil ourInstance = new EntityManagerUtil();

    public static EntityManagerUtil getInstance() {
        return ourInstance;
    }

    private EntityManagerUtil() {
    }
}
