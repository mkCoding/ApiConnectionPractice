package com.example.apiconnectionpractice.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apiconnectionpractice.data.model.user.DataModel
import com.example.apiconnectionpractice.data.model.user.UsersModel


@Composable
fun UsersListScreen(
    usersData:UsersModel?=null // only pass in state in composable screens not viewModel
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).padding(top = 20.dp),
    ){

        LazyColumn {
            items(usersData?.data ?: emptyList()) { user ->
                Text(
                    text = user?.firstName ?: "No Name",
                    fontSize = 30.sp
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewUsersListScreen(){
    val userData = UsersModel(
        data = listOf(
            DataModel(firstName = "Emily"),
            DataModel(firstName = "Sarah"),
            DataModel(firstName = "John"),
            DataModel(firstName = "Nona")

        )
    )
    UsersListScreen(usersData = userData)
}