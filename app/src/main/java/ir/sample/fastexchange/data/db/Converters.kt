package ir.sample.fastexchange.data.db

import androidx.room.TypeConverter
import java.util.*
class Converters {
    @TypeConverter
    fun StringFromCurrency(currency: Currency?): String? = currency?.currencyCode

    @TypeConverter
    fun currencyFromString(code: String): Currency? = Currency.getInstance(code)
}