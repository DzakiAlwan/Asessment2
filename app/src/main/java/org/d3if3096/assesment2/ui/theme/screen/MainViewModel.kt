package org.d3if3096.assesment2.ui.theme.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3096.assesment2.database.MotorDao
import org.d3if3096.assesment2.model.Motor

class MainViewModel(dao: MotorDao) : ViewModel() {

    val data: StateFlow<List<Motor>> = dao.getMotor().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}