package com.umain.home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.umain.theme.MiddleText
import com.umain.theme.margin5Dp
import com.umain.theme.margin70Dp

@Composable
fun LoadingView() {
    Column(
        modifier = Modifier.fillMaxSize()
            .testTag(TagLoadingView),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            color = MiddleText,
            modifier = Modifier
                .width(margin70Dp)
                .height(margin70Dp),
            strokeWidth = margin5Dp
        )
    }
}

const val TagLoadingView = "TagLoadingView"
