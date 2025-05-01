package com.example.demo1.presentation.navigation


sealed class Screen(val route: String) {
    object HomeScreen : Screen("HomeScreen")
    object UserList: Screen("userList")
    object UserDetail : Screen("userDetail/{userId}")
    object CatDetail: Screen("CatDetail")

}