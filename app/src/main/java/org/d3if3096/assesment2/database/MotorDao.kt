package org.d3if3096.assesment2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3096.assesment2.model.Motor

@Dao
interface MotorDao {

    @Insert
    suspend fun insert(motor: Motor)

    @Update
    suspend fun update(motor: Motor)

    @Query("SELECT * FROM motor ORDER BY nama_pengguna DESC")
    fun getMotor() : Flow<List<Motor>>
}