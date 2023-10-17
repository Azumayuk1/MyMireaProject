package ru.mirea.mymireaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.mirea.mymireaproject.ui.screens.BasicActionsScreen
import ru.mirea.mymireaproject.ui.theme.MyMireaProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMireaProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyMireaProjectApp()
                }
            }
        }
    }
}

@Composable
fun MyMireaProjectApp() {
    MyMireaProjectTheme {
        BasicActionsScreen()
//        val navController = rememberNavController()
//
//        NavHost(navController = navController, startDestination = "welcome") {
//
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyMireaProjectPreview() {

}