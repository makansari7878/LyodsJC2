package com.example.lyodsjc2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lyodsjc2.ui.theme.LyodsJC2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column( modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
                verticalArrangement = Arrangement.Top

            ) {
                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.Green)
                    .padding(all = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                    ){
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = "Hello Ansari")
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Welcome")
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Yellow),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                    ){
                    Spacer(modifier = Modifier.height(30.dp))
                    myView()
                }
                Spacer(modifier = Modifier.height(30.dp))
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Cyan),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(modifier = Modifier.height(30.dp))
                    myLogin()

                }
            }
        }
    }
}

@Composable
fun myView(){
    val imgRes = painterResource(id = R.drawable.road )
    Image(painter = imgRes, contentDescription = "my road image",
        modifier = Modifier
            .height(100.dp)
            .width(100.dp))
}

@Composable
fun myLogin(){
    var inputText by remember {mutableStateOf("")}
    val context = LocalContext.current
    TextField(value = inputText,
        onValueChange = {inputText = it} )
    Button(onClick = {
       android.widget.Toast.makeText(context, "result is : $inputText", Toast.LENGTH_LONG).show()
       // var myIntent = Intent(context,NormalActivity::class.java)
       // context.startActivity(myIntent)

    }) {
        Text(text = "SUBMIT")
    }
}

