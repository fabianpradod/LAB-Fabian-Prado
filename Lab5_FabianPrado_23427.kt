package com.example.laboratoriosfabianprado.ejercicios.layouts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratoriosfabianprado.R
import com.example.laboratoriosfabianprado.ui.theme.LaboratoriosFabianPradoTheme

/*
Fabian Prado Dluzniewski
23427
Programacion para Moviles
 */

@Composable
fun Lab5(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFf5f5f5))
    ) {
        Column(
            modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD0E8FF))
                    .padding(vertical = 8.dp, horizontal = 32.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    Text(
                        text = "Actualización disponible",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.whatsapp&pcampaignid=web_share"))
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            text = "Descargar",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Blue
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.size(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Viernes",
                        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 32.sp),
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "20 de diciembre",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
                Text(
                    text = "Terminar jornada",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF6200EE)),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .border(
                            BorderStroke(1.dp, Color.Gray),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                colors = androidx.compose.material3.CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF)
                )
            ) {
                Box(modifier = Modifier.padding(16.dp)) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Text(
                                text = "Hacienda Real",
                                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
                            )
                            IconButton(
                                onClick = {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/g7J9wKBCM1RTgVez6"))
                                    context.startActivity(intent)
                                },
                                modifier = Modifier
                                    .size(24.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "Navigate",
                                    tint = Color(0xFF6200EE)
                                )
                            }
                        }
                        Text(
                            text = "Km 15.5 CAES, Condado Concepcion",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                        Text(
                            text = "12:00PM 12:00AM",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.size(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Button(
                                onClick = {
                                    Toast.makeText(context, "Fabian Prado Dluzniewski", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 8.dp),
                                shape = RoundedCornerShape(8.dp),
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFF7043)
                                )
                            ) {
                                Text(
                                    text = "Iniciar",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            TextButton(
                                onClick = {
                                    Toast.makeText(context, "Carne, sopas, quesos y ensaladas\n$$$", Toast.LENGTH_SHORT).show()
                                },
                                modifier = Modifier.weight((1f))
                            ) {
                                Text(
                                    text = "Detalles",
                                    color = Color(0xFFFF7043),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewLab5() {
    LaboratoriosFabianPradoTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Lab5(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratoriosFabianPradoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Lab5(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
