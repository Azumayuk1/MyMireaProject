package ru.mirea.mymireaproject.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mirea.mymireaproject.part1.ButtonShowAndroidId
import ru.mirea.mymireaproject.ui.theme.MyMireaProjectTheme


@Composable
fun BasicActionsScreen(
    navigateToPartTwoScreen: () -> Unit
) {
    MyMireaProjectTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                ButtonShowAndroidId(modifier = Modifier.padding(4.dp))
                ButtonNavigateToPartTwo(modifier = Modifier.padding(4.dp), navigateToPartTwoScreen)
            }
        }
    }
}

@Preview
@Composable
fun BasicActionsScreenPreview() {
    BasicActionsScreen() {  }
}

@Composable
fun ButtonNavigateToPartTwo(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(modifier = modifier, onClick = onClick) {
        Text("Navigate to Part Two (App list)", style = MaterialTheme.typography.labelMedium)
    }
}

