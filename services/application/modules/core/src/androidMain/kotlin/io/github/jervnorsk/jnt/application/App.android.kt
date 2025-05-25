package io.github.jervnorsk.jnt.application

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun getAppIcons(): Painter {
    return painterResource(id = R.mipmap.jnt_launcher_icon)
}