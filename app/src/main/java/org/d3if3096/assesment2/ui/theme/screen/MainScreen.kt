package org.d3if3096.assesment2.ui.theme.screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.d3if3096.assesment2.R
import org.d3if3096.assesment2.model.Motor
import org.d3if3096.assesment2.ui.theme.Assesment2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){

    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context , R.string.tambah_error, Toast.LENGTH_SHORT).show() }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(id = R.string.tambah_motor),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    ) {padding ->

        ScreenContent(Modifier.padding(padding))

    }
}

@Composable
fun ScreenContent(modifier: Modifier){
    val viewModel: MainViewModel= viewModel()
    val data = viewModel.data
    val context = LocalContext.current
    if (data.isEmpty()){
        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = stringResource(id = R.string.list_kosong))
        }
    }
    else {

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 84.dp)

        ) {
            items(data) {
                ListItem(motor = it){
                    val pesan = context.getString(R.string.diklik,it.nama_pengguna)
                    Toast.makeText(context, pesan, Toast.LENGTH_SHORT).show()
                }
                Divider()
            }
        }
    }
}

@Composable
fun ListItem(motor: Motor, onClick: () -> Unit){
    Column (
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = motor.nama_pengguna,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = motor.merk,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = motor.jenis  ,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assesment2Theme {
        MainScreen()
    }
}