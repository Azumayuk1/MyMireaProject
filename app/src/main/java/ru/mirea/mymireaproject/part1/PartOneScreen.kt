package ru.mirea.mymireaproject.part1

import android.content.ContentResolver
import android.provider.Settings
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

fun getAndroidId(contentResolver: ContentResolver): String {
    return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
}

@Composable
fun ButtonShowAndroidId(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, getAndroidId(context.contentResolver), Toast.LENGTH_LONG ).show()
    },
        modifier = modifier) {
        Text(text = "Show Android ID", style = MaterialTheme.typography.labelMedium)
    }
}