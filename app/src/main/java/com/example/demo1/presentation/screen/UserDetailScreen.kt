package com.example.demo1.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.example.demo1.R
import com.example.demo1.data.model.User
import com.example.demo1.presentation.viewmodel.UserDetailViewModel
import org.w3c.dom.Text
import java.nio.file.WatchEvent

@Composable
fun UserDetailScreen(userDetailViewModel: UserDetailViewModel= hiltViewModel(),userid: String){
    val userDetail = userDetailViewModel.userDetail.collectAsState().value

    LaunchedEffect(userid) {
        userDetailViewModel.getUserDetail(userid.toInt())
    }

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        TopSection(userDetail)
    }
}

@Composable
fun TopSection(userDetails:User?){
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Blue),
        contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "${userDetails?.name}",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "${userDetails?.company?.name}",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(10.dp))

        }
    }

    Spacer(modifier = Modifier.height(16.dp))
    userDetails?.let {
        ContactInfo(icon = Icons.Default.Email, info = it.email,"Email")
        ContactInfo(icon = Icons.Default.Phone, info = it.phone,"Phone")
        ContactInfo(icon = Icons.Default.Info, info = it.company.name,"Company")
        ContactInfo(icon = Icons.Default.Home, info =  "${it.address.street}, ${it.address.city} , ${it.address.zipcode}","Address")
    }

}

@Composable
fun ContactInfo(icon: ImageVector, info: String,type:String) {
    Row(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){

        Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(24.dp))

        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = type,
                modifier = Modifier.padding(start = 10.dp),
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold)

            Text(text = info, modifier = Modifier.padding(start = 10.dp))

        }


    }

}


@Preview(showBackground = true)
@Composable
fun LoadPreview(){
}

