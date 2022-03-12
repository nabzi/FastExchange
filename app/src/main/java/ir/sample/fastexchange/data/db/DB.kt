package ir.sample.fastexchange.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.sample.fastexchange.data.db.Converters
import ir.sample.fastexchange.model.Balance

@Database(
    entities = [Balance::class],
    version = 1,
    exportSchema = false
)
@TypeConverters (Converters::class)
abstract class DB : RoomDatabase() {

    abstract fun balanceDao(): BalanceDao

    companion object {
        private var instance: DB? = null

        @Synchronized
        fun get(context: Context): DB {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java, "AppDatabase"
                )
                    .build()
            }
            return instance!!
        }
    }
}
