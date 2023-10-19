package com.example.compose_tflite.presentation.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.compose_tflite.R
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageScreen() {

     val imageUri = rememberSaveable { mutableStateOf("") }
     val painter = rememberImagePainter(
         if(imageUri.value.isNotEmpty()) {
             imageUri.value
         }
         else {
                R.drawable.leaves
         }
     )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        ) {uri: Uri? ->
            uri?.let {
                imageUri.value = it.toString()
            }
        }

    Column {
        Text(text = "Choose an image to classify",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 40.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .height(300.dp),

            ) {
            Image(painter = painter,
                contentDescription = "Leaves",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }

        val imageUri1 = rememberSaveable { mutableStateOf("") }
        val painter1 = rememberImagePainter(
            if(imageUri1.value.isNotEmpty()) {
                imageUri1.value
            }
            else {
                R.drawable.plantbottombar
            }
        )

        val launcher1 = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
        ) {uri: Uri? ->
            uri?.let {
                imageUri1.value = it.toString()
            }
        }

        OutlinedCard(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .height(300.dp),

            ) {
            Image(painter = painter1,
                contentDescription = "Leaves",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clickable { launcher1.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
    }
}