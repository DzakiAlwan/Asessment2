package org.d3if3096.assesment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "motor")
data class Motor(
    @PrimaryKey(autoGenerate = true)
    val id :Long =0L,
    val nama_pengguna: String,
    val plat : String,
    val merk: String,
    val jenis : String
)