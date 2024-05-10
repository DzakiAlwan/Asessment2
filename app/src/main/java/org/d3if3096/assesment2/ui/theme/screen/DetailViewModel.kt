package org.d3if3096.assesment2.ui.theme.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3096.assesment2.database.MotorDao
import org.d3if3096.assesment2.model.Motor


class DetailViewModel(private val dao: MotorDao) : ViewModel() {


    fun insert(nama: String,plat: String, merk: String, jenis: String) {
        val motor = Motor(
            nama_pengguna = nama,
            plat   = plat,
            merk = merk,
            jenis = jenis
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(motor)
        }
    }

    suspend fun getMotor(id: Long): Motor? {
        return dao.getMotorById(id)
    }

    fun update(id: Long,nama: String,plat: String, merk: String, jenis: String) {
        val motor = Motor(
            id      = id,
            nama_pengguna = nama,
            plat  = plat,
            merk = merk,
            jenis = jenis
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(motor)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}