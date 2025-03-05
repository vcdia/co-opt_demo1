package com.example.coopt1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    //ToggleFAB()
                    ExpandableFAB()
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
        SmallFloatingActionButton(
            onClick = {Toast.makeText(context, "Small FAB Clicked", Toast.LENGTH_SHORT).show()} ,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart),
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Favorite, "Floating action button.")
        }

        FloatingActionButton(
            onClick = {Toast.makeText(context, "FAB Clicked", Toast.LENGTH_SHORT).show()} ,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.LocationOn, "Floating action button.")
        }

        LargeFloatingActionButton(
            onClick = {Toast.makeText(context, "Large FAB Clicked", Toast.LENGTH_SHORT).show()} ,
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
            onClick = { /* TO DO */ },
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Compose") },
        )
    }
}

@Composable
fun ToggleFAB() {
    val context = LocalContext.current
    var isAddMode by remember { mutableStateOf(false) } // tracks the state/ current mode
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = {
                isAddMode = !isAddMode // sets state value to the opposite
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

@Composable
fun ExpandableFAB() {
    val context = LocalContext.current
    var isExpanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Show additional FABs when expended
        if (isExpanded) {
            // Additional button 1
            SmallFloatingActionButton(
                onClick = { Toast.makeText(context, "Action 1 clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = (-80).dp), // position the button above the main FAB
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Filled.Face, contentDescription = "Action 1")
            }

            // Additional button 2
            SmallFloatingActionButton(
                onClick = { Toast.makeText(context, "Action 2 clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = (-160).dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Filled.Email, contentDescription = "Action 2")
            }

            // Additional FAB 3
            SmallFloatingActionButton(
                onClick = { Toast.makeText(context, "Action 3 clicked", Toast.LENGTH_SHORT).show() },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
                    .offset(y = (-240).dp),
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Filled.Send, contentDescription = "Action 3")
            }
        }

        // Main FAB to toggle expand/collapse
        FloatingActionButton(
            onClick = { isExpanded = !isExpanded },  // Toggle expand/collapse state
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(Icons.Filled.Share, contentDescription = "Main FAB")
        }
    }
}
