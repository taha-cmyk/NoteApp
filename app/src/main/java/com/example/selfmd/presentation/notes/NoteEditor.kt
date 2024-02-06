package com.example.selfmd.presentation.notes

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteEditor() {

    var expendOptions by rememberSaveable { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    var value by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(AnnotatedString("")))
    }

    BasicTextField(
        modifier = Modifier.fillMaxSize(),
        value = value,
        onValueChange = {
            value = it

        },
        textStyle = TextStyle(lineHeight = 20.sp),
        decorationBox = { innerTextField ->
            Row(
                Modifier
                    .background(MaterialTheme.colorScheme.background)
            ) {

                Column {
                    Box(
                        modifier = Modifier
                            .navigationBarsPadding()
                    ) {
                        innerTextField()
                    }

                    Row {
                        SmallFloatingActionButton(
                            onClick = { expendOptions = !expendOptions },
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.secondary
                        ) {
                            Icon(Icons.Filled.KeyboardArrowRight, "Small floating action button.")
                        }
                        Spacer(modifier = Modifier.padding(0.5.dp))

                        if (expendOptions){
                        Row(modifier = Modifier
                            .horizontalScroll(scrollState)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .background(MaterialTheme.colorScheme.surface)
                        ) {
                            TextButton(
                                onClick = {expendOptions=false },

                                ) {
                                Text(text = "B")
                            }

                            TextButton(
                                onClick = { },

                                ) {
                                Text(text = "I")
                            }

                            TextButton(
                                onClick = { },

                            ) {
                                Text(text = "H1")
                            }

                            TextButton(
                                onClick = { },

                                ) {
                                Text(text = "H2")
                            }

                            TextButton(
                                onClick = { },

                                ) {
                                Text(text = "H3")
                            }

                            TextButton(
                                onClick = { },

                                ) {
                                Text(text = "H4")
                            }
                        } // end Row
                        } // end if

                    }


                }
            }
        }
    )

}


