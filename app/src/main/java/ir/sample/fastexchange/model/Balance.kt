package ir.sample.fastexchange.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class Balance(
    @PrimaryKey
    var type: Currency,
    var amount: Double
    )
