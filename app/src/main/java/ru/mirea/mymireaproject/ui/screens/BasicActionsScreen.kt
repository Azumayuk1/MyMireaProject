package ru.mirea.mymireaproject.ui.screens

import android.content.ContentResolver
import android.provider.Settings
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mirea.mymireaproject.ui.theme.MyMireaProjectTheme

fun getAndroidId(contentResolver: ContentResolver): String {
    return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
}

@Composable
fun BasicActionsScreen() {
    MyMireaProjectTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                ButtonShowAndroidId(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun BasicActionsScreenPreview() {

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