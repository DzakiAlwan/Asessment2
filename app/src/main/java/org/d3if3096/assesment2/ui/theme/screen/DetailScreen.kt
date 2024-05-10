package org.d3if3096.assesment2.ui.theme.screen

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3096.assesment2.R
import org.d3if3096.assesment2.ui.theme.Assesment2Theme

const val KEY_ID_MOTOR = "idMOTOR"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id: Long? = null){
    val viewModel: DetailViewModel = viewModel()

    var nama by remember {
        mutableStateOf("")
    }
    var plat by remember {
        mutableStateOf("")
    }
    var merk by remember {
        mutableStateOf("")
    }
    var jenis by remember {
        mutableStateOf("")
    }

    if (id != null){
        val data = viewModel.getMotor(id)
        nama = data.nama_pengguna
        plat = data.plat
        merk = data.merk
        jenis = data.jenis
    }

    Scaffold (
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.kembali),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    if (id == null)
                        Text(text = stringResource(id = R.string.penitipan_motor))
                    else
                        Text(text = stringResource(id = R.string.edit_motor))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.Check,
                            contentDescription = stringResource(id = R.string.simpan),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ){ padding ->
        FormMotor(
            nama = nama,
            onNamaChange =  {nama = it},
            plat = plat,
            onPlatChange = {plat = it},
            merk = merk,
            onMerkChange = {merk = it},
            modifier = Modifier.padding(padding),
            jenis = jenis,
            onJenisChange = {jenis = it}
        )
    }
}

@Composable
fun FormMotor(
    nama: String, onNamaChange: (String) -> Unit,
    plat: String, onPlatChange: (String) -> Unit,
    merk: String, onMerkChange: (String) -> Unit,
    jenis: String, onJenisChange: (String) -> Unit,
    modifier: Modifier
) {
    val merkMotor = listOf("Yamaha", "Honda", "Suzuki", "Kawasaki", "Ducati")
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = nama,
            onValueChange = {onNamaChange(it) },
            label = { Text(text = stringResource(id = R.string.nama))},
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = plat,
            onValueChange = {onPlatChange(it) },
            label = { Text(text = stringResource(id = R.string.plat))},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Column (
            modifier = Modifier
                .padding(vertical = 8.dp)
                .border(1.dp, Color.Gray)
                .fillMaxWidth()
        ) {
            merkMotor.forEach { namaMotor ->
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 2.dp)
                ) {
                    RadioButton(
                        selected = ( merk == namaMotor),
                        onClick = { onMerkChange(namaMotor) },
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    )
                    Text(
                        text = namaMotor,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        OutlinedTextField(
            value = jenis,
            onValueChange = {onJenisChange(it) },
            label = { Text(text = stringResource(id = R.string.jenis))},
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {
    Assesment2Theme {
        DetailScreen(rememberNavController() )
    }
}