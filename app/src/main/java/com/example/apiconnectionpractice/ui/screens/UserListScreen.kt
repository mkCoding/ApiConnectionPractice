package com.example.apiconnectionpractice.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apiconnectionpractice.data.model.products.Products
import com.example.apiconnectionpractice.data.model.products.ProductsItemModel
import com.example.apiconnectionpractice.data.model.user.DataModel
import com.example.apiconnectionpractice.data.model.user.UsersModel


@Composable
fun UsersListScreen(
    usersData:UsersModel?=null, // only pass in state in composable screens not viewModel
    productData: List<ProductsItemModel>? = null){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).padding(top = 20.dp),
    ){
        Text("User Data", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.ExtraBold))
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(usersData?.data ?: emptyList()) { user ->
                Text(
                    text = user?.firstName ?: "No Name",
                    fontSize = 30.sp
                )
            }
        }



        Spacer(modifier = Modifier.height(20.dp))
        Text("Product Data", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.ExtraBold))

        LazyColumn {
            items(productData ?: emptyList()) { product ->
                Text(
                    text = product?.title ?:"No Product",
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

    val productsData = listOf(
        ProductsItemModel(category = "", title = "Basketball"),
        ProductsItemModel(category = "", title = "iPhone"),
        ProductsItemModel(category = "", title = "Socks"),
        ProductsItemModel(category = "", title = "Crayons"),
    )

    UsersListScreen(
        usersData = userData,
        productData = productsData

    )
}