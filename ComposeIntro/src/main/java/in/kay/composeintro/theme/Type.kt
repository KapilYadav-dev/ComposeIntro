package `in`.kay.composeintro.theme

import `in`.kay.composeintro.R
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    h1 = TextStyle(fontFamily = BebasNue(), fontWeight = FontWeight.Normal, fontSize = 64.sp, color = Color(0xfffFF6464)),
    defaultFontFamily = Poppins()
)


fun Poppins() = FontFamily(
    Font(R.font.font_poppins_light, FontWeight.Light),
    Font(R.font.font_poppins_regular, FontWeight.Normal),
    Font(R.font.font_poppins_semibold, FontWeight.SemiBold),
)


fun BebasNue() = FontFamily(
    Font(R.font.font_bebas_neue, FontWeight.Normal)
)
