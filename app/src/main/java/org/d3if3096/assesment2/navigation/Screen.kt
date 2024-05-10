package org.d3if3096.assesment2.navigation

import org.d3if3096.assesment2.ui.theme.screen.KEY_ID_MOTOR

sealed class Screen (val route: String) {
    data object  Home: Screen("mainScreen")
    data object  FormBaru: Screen("detailScreen")
    data object  FormUbah: Screen("detailScreen/{$KEY_ID_MOTOR}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}