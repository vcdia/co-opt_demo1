package com.example.coopt1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.coopt1.ui.theme.CoOpt1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoOpt1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //FAB()
                    //ExtendedFAB()
                    ToggleFAB()
                }
            }
        }
    }
}

@Composable
fun FAB() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        FloatingActionButton(
            onClick = {Toast.makeText(context, "FAB Clicked", Toast.LENGTH_SHORT).show()} ,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}

@Composable
fun ExtendedFAB() {

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        ExtendedFloatingActionButton(
            onClick = { /* to add */ },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Extended FAB") },
        )
    }
}

@Composable
fun ToggleFAB() {
    val context = LocalContext.current
    var isAddMode by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = {
                isAddMode = !isAddMode
                Toast.makeText(context, if (isAddMode) "Add Mode" else "Edit Mode", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            if (isAddMode) {
                Icon(Icons.Filled.Add, "Add Mode")
            } else {
                Icon(Icons.Filled.Edit, "Edit Mode")
            }
        }
    }
}