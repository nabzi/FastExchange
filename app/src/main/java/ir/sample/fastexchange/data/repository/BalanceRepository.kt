package ir.sample.fastexchange.data.repository

import ir.sample.fastexchange.data.db.BalanceDao
import ir.sample.fastexchange.model.Balance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BalanceRepositoryImpl(private val dbDataSource: BalanceDBDataSource) : BalanceRepository {
    override suspend fun addAll(balances: List<Balance>) = dbDataSource.addAll(balances)
    override fun getBalances(): Flow<List<Balance>> = dbDataSource.getBalances()
    override suspend fun clear() = dbDataSource.clear()
}

interface BalanceRepository {
    suspend fun addAll(balances: List<Balance>): Void
    fun getBalances(): Flow<List<Balance>>
    suspend fun clear(): Int
}

class BalanceDBDataSource(private val balanceDao: BalanceDao) {
    suspend fun addAll(balances: List<Balance>) =
        withContext(Dispatchers.IO) { balanceDao.addAll(balances) }

    suspend fun clear() = balanceDao.removeAll()
    fun getBalances(): Flow<List<Balance>> = balanceDao.getBalances()
}
