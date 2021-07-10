package responsi.com.data;

import androidx.room.RoomDatabase;

import responsi.com.model.User;

@androidx.room.Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();

}
