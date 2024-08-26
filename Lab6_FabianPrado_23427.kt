package com.example.laboratoriosfabianprado.ejercicios.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratoriosfabianprado.ui.theme.LaboratoriosFabianPradoTheme

@Composable
fun CounterApp() {
    var counter by remember { mutableStateOf(0) }
    var increments by remember { mutableStateOf(0) }
    var decrements by remember { mutableStateOf(0) }
    var maxValue by remember { mutableStateOf(0) }
    var minValue by remember { mutableStateOf(0) }
    var totalChanges by remember { mutableStateOf(0) }
    val history = remember { mutableStateListOf<Pair<Int, Boolean>>() }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Button(
                onClick = {
                    counter = 0
                    increments = 0
                    decrements = 0
                    maxValue = 0
                    minValue = 0
                    totalChanges = 0
                    history.clear()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3F51B5)
                )
            ) {
                Text("Reiniciar", color = Color.White)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Fabian Prado",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                IconButton(onClick = {
                    counter--
                    decrements++
                    totalChanges++
                    history.add(Pair(counter, false))
                    if (counter < minValue) minValue = counter
                },
                    modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                )  {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(24.dp))

                Text(
                    text = "$counter",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(24.dp))

                IconButton(onClick = {
                    counter++
                    increments++
                    totalChanges++
                    history.add(Pair(counter, true))
                    if (counter > maxValue) maxValue = counter
                },
                    modifier = Modifier
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(Color.Blue)
                ) {
                    Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
                }
            }

            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Total incrementos:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Total decrementos:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Valor máximo:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Valor mínimo:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Total cambios:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "$increments",
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "$decrements",
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "$maxValue",
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "$minValue",
                        fontSize = 18.sp,
                    )
                    Text(
                        text = "$totalChanges",
                        fontSize = 18.sp,
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(history.chunked(5)) { row ->
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        items(row) { (value, isIncrement) ->
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        color = if (isIncrement) Color.Green else Color.Red,),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$value",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCounterApp() {
    CounterApp()
}

class Lab6_FabianPrado_23427 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratoriosFabianPradoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CounterApp()
                }
            }
        }
    }
}
