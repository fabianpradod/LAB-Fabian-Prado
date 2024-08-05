package com.example.laboratoriosfabianprado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratoriosfabianprado.ui.theme.LaboratoriosFabianPradoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratoriosFabianPradoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProjectScreen()
                }
            }
        }
    }
}

@Composable
fun ProjectScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .padding(0.dp)
            .background(Color.White, shape = CutCornerShape(8.dp))
            .border(8.dp, Color(0xFF4CAF50), shape = RoundedCornerShape(8.dp))
            .padding(32.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(150.dp))
            BasicText(
                text = "Universidad del Valle de Guatemala",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
            )

            Spacer(modifier = Modifier.height(30.dp))

            BasicText(
                text = "Programación de plataformas móviles, Sección 30",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                ),
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.align(Alignment.Start),
                horizontalArrangement = Arrangement.spacedBy(74.dp)
            ) {
                BasicText(
                    text = "INTEGRANTES",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                BasicText(
                    text = "Samuel Mejia Fabian Prado",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.align(Alignment.Start),
                horizontalArrangement = Arrangement.spacedBy(50.dp)
            ) {
                BasicText(
                    text = "CATEDRÁTICO",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                BasicText(
                    text = "Juan Carlos Durini",
                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 16.sp),
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                BasicText(text = "Fabian Prado")

            }

            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                BasicText(text = "23427")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProjectScreenPreview() {
    LaboratoriosFabianPradoTheme {
        ProjectScreen()
    }
}