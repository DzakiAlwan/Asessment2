package org.d3if3096.assesment2.ui.theme.screen

import androidx.lifecycle.ViewModel
import org.d3if3096.assesment2.model.Motor

class MainViewModel : ViewModel() {

    val data = getDataDummy()

    private fun getDataDummy(): List<Motor> {
        val data = mutableListOf<Motor>()
        data.add(
            Motor(
                1,"Dzaki Alwan Firjatullah",
                "c1234567",
                "Honda",
                "Vario 125"


            )
        )
        data.add(
            Motor(
                2,
                "Jonathan Jeheskiel Tewal",
                "c1234567",
                "Yamaha",
                "Aerox 155"
            )
        )
        data.add(
            Motor(
                3,
                "Syaidina Arafhan",
                "c1234567",
                "Kawasaki",
                "Klx 150"
            )
        )


        return data
    }
}