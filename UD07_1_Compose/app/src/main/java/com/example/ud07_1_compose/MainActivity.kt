package com.example.ud07_1_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ud07_1_compose.ui.theme.UD07_1_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UD07_1_ComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier, names: List<String> = listOf("World", "Compose", "Sabela")){
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {

        Column(modifier = modifier.padding(5.dp)) {
            for(name in names)
                Greeting(name)
        }

    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(34.dp)) {
         Column(modifier = Modifier.weight(1f)) {
             Text(text = "Hello ")
             Text(text =name)

         }
         ElevatedButton(onClick = {  }) {
             Text(text = "Show more")
         }
        }
    }

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    UD07_1_ComposeTheme {
       // Greeting("sabela")
        MyApp()
    }
}