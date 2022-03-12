package ir.sample.fastexchange.data.repository

import ir.sample.fastexchange.data.db.BalanceDao
import ir.sample.fastexchange.model.Balance
import kotlinx.coroutines.flow.Flow
import java.util.*
import kotlin.collections.ArrayList

class BalanceRepositoryImpl(private val dbDataSource: BalanceDBDataSource) : BalanceRepository {

}

interface BalanceRepository {
    fun loadBalanceList(): ArrayList<Balance> {
        return arrayListOf(
            Balance(Currency.getInstance("EUR"), 1000.0),
            Balance(Currency.getInstance("USD"), 0.0),
            Balance(Currency.getInstance("BGP"), 0.0)
        )
    }
}

class BalanceDBDataSource(private val balanceDao: BalanceDao) {
    suspend fun update(result: List<Balance>) {
        //BalanceDao.addList(result)
    }

    suspend fun clear() {
        // BalanceDao.removeAll()
    }

//    fun getBalances(search: String): Flow<List<Balance>> {
//        //return BalanceDao.getBalancesFlow("$search%")
//    }
}
