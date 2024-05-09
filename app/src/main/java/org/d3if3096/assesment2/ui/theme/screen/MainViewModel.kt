package org.d3if3096.assesment2.ui.theme.screen

import androidx.lifecycle.ViewModel
import org.d3if3096.assesment2.model.Motor

class MainViewModel : ViewModel() {

    val data = getDataDummy()
    private fun getDataDummy(): List<Motor>{
        val data = mutableListOf<Motor>()
        for (i in 29 downTo 20){
            data.add(
                Motor(
                    i.toLong(),
                    "Dzaki Alwan",
                    "yamaha",
                    "nmax"
                )
            )
        }
        return data
    }
}