package ru.mirea.mymireaproject

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.mirea.mymireaproject.part2.ui.PartTwoScreen
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
        val navController = rememberNavController()
        val context = LocalContext.current

        NavHost(navController = navController, startDestination = "basicactionsscreen") {
            composable("basicactionsscreen") {
                BasicActionsScreen {
                    navController.navigate("parttwoscreen")
                }
            }

            composable("parttwoscreen") {
                PartTwoScreen {
                    (context as? Activity)?.finish()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyMireaProjectPreview() {

}