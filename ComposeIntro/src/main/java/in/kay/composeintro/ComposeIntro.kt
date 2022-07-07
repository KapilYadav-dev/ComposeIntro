package `in`.kay.composeintro

import `in`.kay.composeintro.theme.BebasNue
import `in`.kay.composeintro.theme.Poppins
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroScreen(
    items: List<IntroData>,
    infiniteLoop: Boolean = false,
    /*
     * These are the color which will shape the color of UI
     */
    headerIconTint: Color = Color(0xfffFF6464),
    primaryColor: Color = Color(0xfffFF6464),
    secondaryColor: Color = Color(0xfffBABABA),
    /*
     * These are the fonts which will shape the fonts of UI
     */
    primaryFont: FontFamily = BebasNue(),
    secondaryFont: FontFamily = Poppins(),
    /*
     * This is the header drawable
     */
    headerIcon: ImageVector,
    /*
     * These are callbacks or high order function which will help to interact with buttons
     */
    onRightButtonClick: () -> Unit,
    onLeftButtonClick: () -> Unit,
    onBackPress: () -> Unit,
    currentPage:(Int) -> Unit,
    /*
     * These are the text of the buttons
     */
    leftButtonText: String = "REGISTER",
    rightButtonText: String = "LOGIN",
    /*
     * These are the units of various text and views
     */
    headerIconSize: Dp = 48.dp,
    primaryFontSize: TextUnit = 56.sp,
    secondaryFontSize: TextUnit = 15.sp,
    highlightFontSize: TextUnit = 40.sp,
    unhighlightFontSize: TextUnit = 20.sp,
    buttonFontSize: TextUnit = 18.sp,
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        pageCount = items.size,
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
        onBackPress()
    }

    currentPage(pagerState.currentPage)
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
                            .size(headerIconSize)
                            .layoutId("ivIcon"),
                        contentDescription = null,
                        tint = headerIconTint
                    )
                    Text(
                        color = primaryColor,
                        fontFamily = primaryFont,
                        text = items[page].title,
                        fontSize = primaryFontSize,
                        modifier = Modifier.layoutId("tvTitle")
                    )
                    Text(
                        text = items[page].description,
                        color = secondaryColor,
                        fontFamily = secondaryFont,
                        fontSize = secondaryFontSize,
                        modifier = Modifier.layoutId("tvDesc")
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .layoutId("btnContainer"),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        OutlinedButton(
                            border = if (page == items.size - 1) BorderStroke(
                                4.dp,
                                primaryColor
                            ) else BorderStroke(4.dp, secondaryColor),
                            onClick = {
                                onLeftButtonClick()
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .weight(1f),
                            enabled = page == 2
                        ) {
                            Text(
                                text = leftButtonText,
                                fontFamily = primaryFont,
                                fontSize = buttonFontSize,
                                color = if (page == 2) primaryColor else secondaryColor
                            )
                        }
                        Spacer(modifier = Modifier.width(24.dp))
                        Button(
                            onClick = {
                                scope.launch {
                                    onRightButtonClick()
                                }
                            },
                            modifier = Modifier
                                .height(40.dp)
                                .weight(1f),
                            enabled = page == items.size - 1,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = primaryColor
                            )
                        ) {
                            Text(
                                text = rightButtonText,
                                fontFamily = primaryFont,
                                fontSize = buttonFontSize,
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
                            in items.indices -> {
                                for (i in 1..items.size) {
                                    if (i == page + 1) {
                                        HighlightText(
                                            page = page + 1,
                                            primaryColor,
                                            primaryFont,
                                            highlightFontSize
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        continue
                                    }
                                    UnhighlightText(
                                        page = i,
                                        secondaryColor,
                                        primaryFont,
                                        unhighlightFontSize
                                    )
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
fun HighlightText(
    page: Int,
    primaryColor: Color,
    primaryFont: FontFamily,
    highlightFontSize: TextUnit
) {
    Text(
        text = page.toString(),
        color = primaryColor,
        fontFamily = primaryFont,
        fontSize = highlightFontSize,
        modifier = Modifier.fillMaxHeight()
    )
}

@Composable
fun UnhighlightText(
    page: Int,
    secondaryColor: Color,
    primaryFont: FontFamily,
    unhighlightFontSize: TextUnit
) {
    Text(
        text = page.toString(),
        color = secondaryColor,
        fontFamily = primaryFont,
        fontSize = unhighlightFontSize
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

