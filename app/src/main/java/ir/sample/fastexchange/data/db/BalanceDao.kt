package ir.sample.fastexchange.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.sample.fastexchange.model.Balance
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BalanceDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    abstract suspend fun add(vararg balance: Balance):Void
//
////    @Insert(onConflict = OnConflictStrategy.REPLACE)
////    abstract suspend fun addList(list: List<Balance>)
//
//    @Query("SELECT * FROM balance" )
//    abstract fun getBalances(): Flow<List<Balance>>//List<Balance>

//    @Query("SELECT * FROM balance " )
//    abstract fun getBalanceFlow(): List<Balance>

//    @Query("Delete From balance" )
//    abstract suspend fun removeAll() : Int
}