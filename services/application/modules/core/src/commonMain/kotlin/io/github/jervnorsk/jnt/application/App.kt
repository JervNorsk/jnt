package io.github.jervnorsk.jnt.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.jervnorsk.jnt.application.assets.*
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // Usa Column per allineare l'immagine e il testo verticalmente
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            ) {
                Image(
//                    painter = painterResource(resource = Res.drawable.jnt_brand_icon_0_2_1),
                    painter = getAppIcon(),
                    contentDescription = "JNT App Icon",
                    modifier = Modifier.size(200.dp)
                )
                // Aggiungi il testo sotto l'immagine
                Text(
                    text = "Benvenuto in JNT!",
                    fontSize = 24.sp, // Puoi cambiare la dimensione del testo
                    color = MaterialTheme.colorScheme.onBackground // Colore del testo
                )
            }
        }
    }
}

@Composable
fun getAppIcon(): Painter {
    return androidx.compose.ui.res.painterResource(id = R.mipmap.jnt_launcher_icon)
}