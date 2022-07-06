package `in`.kay.composeintro

import `in`.kay.composeintro.theme.BebasNue
import `in`.kay.composeintro.theme.Poppins
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroScreen(
    navController: NavController,
    scope: CoroutineScope,
    introItems: List<IntroData>,
    infiniteLoop: Boolean = false,
    primaryColor: Color = Color(0xfffFF6464),
    secondaryColor: Color = Color(0xfffBABABA),
    primaryFont: FontFamily = BebasNue(),
    secondaryFont: FontFamily = Poppins(),
    headerIcon: ImageVector
) {


    val pagerState = rememberPagerState(
        pageCount = introItems.size,
        initialOffscreenLimit = 2,
        initialPage = 0,
        infiniteLoop = infiniteLoop
    )
    BackHandler() {
        if (pagerState.currentPage > 0) {
            scope.launch {
                pagerState.animateScrollToPage(pagerState.currentPage - 1)
            }
            return@BackHandler
        }
        navController.navigate("splash")
    }


    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        val page = pagerState.currentPage
        HorizontalPager(state = pagerState) {
            BoxWithConstraints {
                ConstraintLayout(
                    introConstraintSet(),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Icon(
                        imageVector = headerIcon,
                        modifier = Modifier
                            .size(48.dp)
                            .layoutId("ivIcon"),
                        contentDescription = null,
                        tint = primaryColor
                    )
                    Text(
                        color = primaryColor,
                        fontFamily = primaryFont,
                        text = introItems[page].title,
                        fontSize = 56.sp, modifier = Modifier.layoutId("tvTitle")
                    )
                    Text(
                        text = introItems[page].description,
                        color = secondaryColor,
                        fontFamily = secondaryFont,
                        fontSize = 15.sp,
                        modifier = Modifier.layoutId("tvDesc")
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("btnContainer"),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        OutlinedButton(
                            border = if (page == 2) BorderStroke(
                                4.dp,
                                primaryColor
                            ) else BorderStroke(4.dp, secondaryColor),
                            onClick = {
                                navController.navigate("register") {
                                    popUpTo(0)
                                }
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .weight(1f),
                            enabled = page == 2
                        ) {
                            Text(
                                text = "REGISTER",
                                fontFamily = primaryFont,
                                fontSize = 18.sp,
                                color = if (page == 2) primaryColor else secondaryColor
                            )
                        }
                        Spacer(modifier = Modifier.width(24.dp))
                        Button(
                            onClick = {
                                scope.launch {
                                    navController.navigate("login") {
                                        popUpTo(0)
                                    }
                                }
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .weight(1f),
                            enabled = page == introItems.size - 1,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = primaryColor
                            )
                        ) {
                            Text(
                                text = "LOGIN",
                                fontFamily = primaryFont,
                                fontSize = 18.sp,
                                color = Color.White
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .height(56.dp)
                            .layoutId("viewPageNo"),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        when (page) {
                            in introItems.indices -> {
                                for (i in 1..introItems.size) {
                                    if (i == page + 1) {
                                        HighlightText(page = page + 1, primaryColor, primaryFont)
                                        Spacer(modifier = Modifier.width(8.dp))
                                        continue
                                    }
                                    UnhighlightText(page = i, secondaryColor, primaryFont)
                                    Spacer(modifier = Modifier.width(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HighlightText(page: Int, primaryColor: Color, primaryFont: FontFamily) {
    Text(
        text = page.toString(),
        color = primaryColor,
        fontFamily = primaryFont,
        fontSize = 40.sp,
        modifier = Modifier.fillMaxHeight()
    )
}

@Composable
fun UnhighlightText(page: Int, secondaryColor: Color, primaryFont: FontFamily) {
    Text(
        text = page.toString(),
        color = secondaryColor,
        fontFamily = primaryFont,
        fontSize = 20.sp
    )
}

fun introConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val icon = createRefFor("ivIcon")
        val tvTitle = createRefFor("tvTitle")
        val tvDesc = createRefFor("tvDesc")
        val btnContainer = createRefFor("btnContainer")
        val pageNo = createRefFor("viewPageNo")

        constrain(icon) {
            top.linkTo(parent.top, 48.dp)
            start.linkTo(parent.start, 24.dp)
        }
        constrain(tvTitle) {
            width = Dimension.fillToConstraints
            start.linkTo(parent.start, 24.dp)
            end.linkTo(parent.end, 24.dp)
            top.linkTo(icon.bottom, 40.dp)

        }
        constrain(tvDesc) {
            width = Dimension.fillToConstraints
            top.linkTo(tvTitle.bottom, 32.dp)
            start.linkTo(parent.start, 24.dp)
            end.linkTo(parent.end, 24.dp)
        }

        constrain(pageNo) {
            bottom.linkTo(btnContainer.top, 32.dp)
            start.linkTo(parent.start, 24.dp)
        }
        constrain(btnContainer) {
            bottom.linkTo(parent.bottom, 32.dp)
            start.linkTo(parent.start, 24.dp)
            end.linkTo(parent.end, 24.dp)
            width = Dimension.matchParent
        }
    }
}


data class IntroData(
    val description: String,
    val title: String
)

