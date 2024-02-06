package com.example.selfmd.presentation.shared.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScafforldLayout(topBar :@Composable () -> Unit,floatingActionButton :@Composable () -> Unit = {} ,ui : @Composable () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
          topBar()
        },
        floatingActionButton = {
            floatingActionButton()
        }


    ) { innerPadding ->

          Column(modifier = Modifier.padding(innerPadding)) {
              ui()
          }
        }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title : @Composable ()->Unit,navigationIcon : @Composable ()->Unit = {},actions: @Composable ()->Unit = {}) {

    CenterAlignedTopAppBar(
        modifier = Modifier.clip(RoundedCornerShape(20.dp)),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            title()

        },
        navigationIcon = {
            navigationIcon()
        },

        actions = {
           actions()
        }
    )
}

@Composable
fun FloatingActionButtonContent(content:@Composable ()->Unit) {
    content()
}

