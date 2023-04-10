package com.example.composefour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composefour.ui.theme.ComposeFourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeFourTheme {
                var task by remember {
                    mutableStateOf("")
                }
                var tasks by remember {
                    mutableStateOf(listOf<String>())
                }
               var checkedState by remember {
                    mutableStateOf(false)
                }


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                )
                {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = task,
                            onValueChange = { text ->
                                task = text
                            },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if (task.isNotBlank()) {
                                tasks = tasks + task
                                task = ""
                            }
                        }) {
                            Text(text = "Add Task")
                        }
                    }
                    LazyColumn {
                        items(tasks) { currentTask ->
                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = currentTask,
                                    color = Color.Blue,
                                    modifier = Modifier.weight(1f)
                                )
                                Checkbox(
                                    checked = checkedState,
                                    onCheckedChange = { checkedState = it }
                                )
                            }
                            Divider()
                        }
                    }





/* LazyColumn {
items(tasks) { currentTask ->
Text(
text = currentTask,
modifier = Modifier
    .fillMaxWidth()
    .padding(16.dp)
)
Divider()
}
} */
}
}
}
}
}














