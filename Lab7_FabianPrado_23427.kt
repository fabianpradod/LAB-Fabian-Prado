package com.example.laboratoriosfabianprado.ejercicios.layouts

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratoriosfabianprado.ui.theme.LaboratoriosFabianPradoTheme
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbarDemo(
    modifier: Modifier = Modifier
) {
    val dateFormat = SimpleDateFormat("d MMM • h:mm a", Locale("es", "ES"))

    Column(modifier) {
        TopAppBar(
            title = {
                Text("Notificaciones")
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            ),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Text(
                text = "Tipo de Notificaciones",
                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 16.sp),
                fontWeight = FontWeight.Bold
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                FilterChip(
                    selected = true,
                    onClick = { /*TODO*/ },
                    label = { Text("General") }
                )
            }
            item {
                FilterChip(
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Post") }
                )
            }
            item {
                FilterChip(
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Mensaje") }
                )
            }
            item {
                FilterChip(
                    selected = false,
                    onClick = { /*TODO*/ },
                    label = { Text("Like") }
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(Color.White)
                .padding(8.dp)
        ) {
            items(generateFakeNotifications()) { item ->
                val formattedDate = dateFormat.format(item.sendAt)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 16.sp),
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = formattedDate,
                                style = MaterialTheme.typography.headlineSmall.copy(fontSize = 10.sp),
                                color = Color.Gray,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = item.body,
                            style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp),
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

enum class NotificationType {
    GENERAL,
    NEW_POST,
    NEW_MESSAGE,
    NEW_LIKE
}

data class Notification(
    val id: Int,
    val title: String,
    val body: String,
    val sendAt: Date,
    val type: NotificationType
)

fun LocalDateTime.toDate(): Date {
    return Date.from(this.atZone(java.time.ZoneId.systemDefault()).toInstant())
}

fun generateFakeNotifications(): List<Notification> {
    val notifications = mutableListOf<Notification>()
    val titles = listOf(
        "Nueva versión disponible",
        "Nuevo post de Juan",
        "Mensaje de Maria",
        "Te ha gustado una publicación"
    )
    val bodies = listOf(
        "La aplicación ha sido actualizada a v1.0.2. Ve a la PlayStore y actualízala!",
        "Te han etiquetado en un nuevo post. ¡Míralo ahora!",
        "No te olvides de asistir a esta capacitación mañana, a las 6pm, en el Intecap.",
        "A Juan le ha gustado tu publicación. ¡Revisa tu perfil!"
    )
    val types = NotificationType.values()

    val currentDate = LocalDate.now()
    for (i in 1..50) {
        val daysAgo = (0..10).random()
        val hoursAgo = (0..23).random()
        val minutesAgo = (0..59).random()
        val sendAt = LocalDateTime.of(currentDate.minusDays(daysAgo.toLong()), LocalTime.of(hoursAgo, minutesAgo)).toDate()
        notifications.add(
            Notification(
                id = i,
                title = titles.random(),
                body = bodies.random(),
                sendAt = sendAt,
                type = types.random()
            )
        )
    }
    return notifications
}


@Preview
@Composable
private fun PreviewTopAppbarDemo() {
    LaboratoriosFabianPradoTheme {
        Surface {
            TopAppbarDemo(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

class Lab7_FabianPrado_23427 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaboratoriosFabianPradoTheme {
                Surface {
                    TopAppbarDemo(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
