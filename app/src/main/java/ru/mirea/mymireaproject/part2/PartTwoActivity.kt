package ru.mirea.mymireaproject.part2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import ru.mirea.mymireaproject.part2.GetAppsList.Companion.getInstalledApps
import ru.mirea.mymireaproject.part2.ui.theme.MyMireaProjectTheme

class PartTwoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyMireaProjectTheme {
                val apps: List<PackageInfo> =
                    getInstalledApps(true, LocalContext.current)

                val applicationAndPackagesList = mutableListOf<Pair<String, String>>()
                for (app in apps) {
                    applicationAndPackagesList.add(
                        Pair(app.appName, app.packageName)
                    )
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PartTwoScreen(applicationAndPackagesList.toList())
                }
            }
        }
    }
}





