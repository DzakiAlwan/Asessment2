package org.d3if3096.assesment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3096.assesment2.model.Motor

class MotorDb {
    @Database(entities = [Motor::class], version = 1, exportSchema = false)
    abstract class MotorDb : RoomDatabase() {

        abstract val dao: MotorDao
    }

    companion object {
        @Volatile
        private var INSTANCE: MotorDb? = null
        fun getInstance(context: Context): MotorDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MotorDb::class.java,
                        "mahasiswa.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}