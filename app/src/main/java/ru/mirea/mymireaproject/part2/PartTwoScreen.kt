package ru.mirea.mymireaproject.part2

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.mirea.mymireaproject.ui.theme.MyMireaProjectTheme

@Composable
fun PartTwoScreen(dataList: List<Pair<String, String>>) {
    MyMireaProjectTheme {
        var shouldShowAnydeskAlertDialog by remember {
            mutableStateOf(true)
        }

        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                val context = LocalContext.current
                Text(
                    text = "App list:",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(4.dp)
                )
                AppList(dataList = dataList)

                val anyDeskInstalled =
                    GetAppsList.checkIfRemoteAccessInstalled(context)

                if (anyDeskInstalled && shouldShowAnydeskAlertDialog) {
                    AlertDialogAnyDeskPresent(
                        onDismissRequest = {
                            showBeAwareToast(context)
                            shouldShowAnydeskAlertDialog = false
                        },
                        onConfirmation = {
                            showBeAwareToast(context)
                            shouldShowAnydeskAlertDialog = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun AlertDialogAnyDeskPresent(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String = "Обнаружен AnyDesk",
    dialogText: String = "Приложение удалённого доступа" +
            " может быть использовано хакерами для кражи ваших данных.",
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Продолжить")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Игнорировать")
            }
        }
    )
}

fun showBeAwareToast(context: Context) {
    Toast.makeText(context, "Соблюдайте осторожность.", Toast.LENGTH_LONG).show()
}

@Composable
fun AppList(dataList: List<Pair<String, String>>) {
    LazyColumn {
        itemsIndexed(dataList) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(

                ) {
                    Text(
                        text = item.first + ":" + item.second,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(4.dp)
                    )
                }

            }
        }
    }
}

@Preview
@Composable
fun PartTwoScreenPreview() {
}