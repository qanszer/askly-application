package com.example.askly.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.askly.data.viewmodel.AsklyViewModel
import com.example.askly.ui.theme.AsklyDimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfessorDashboardScreen (
    navController: NavController,
    classModel: AsklyViewModel
) {
    val dimensions = AsklyDimensions.current
    val context = LocalContext.current;

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        // Custom Top Bar
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CompositionLocalProvider(
                    LocalMinimumInteractiveComponentEnforcement provides false
                ) {
                    IconButton(
                        onClick = { navController.navigate("menu") },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.CheckBoxOutlineBlank,
                            contentDescription = "Select",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "Settings",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }

        // Content Area
        Column(
            modifier = Modifier.padding(horizontal = dimensions.screenPadding)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Prof. Sapit",
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Classrooms",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 4.dp),
                verticalArrangement = Arrangement.Top,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Sort Button
                    Button(
                        border = BorderStroke(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                                alpha = 0.2f
                            )
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = Color.Black
                        ),
                        onClick = {  },
                        contentPadding = PaddingValues(vertical = 0.dp, horizontal = 20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Sort",
                            tint = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Newest",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                    Text(
                        text = "1 Total",
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        fontSize = 14.sp
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(classModel.classroomList) {
                            classList ->

                        Card (
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.onSurface,
                            ),
                            modifier = Modifier.clickable (
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) {
                                navController.navigate("professorClass")
                            },
                            shape = RoundedCornerShape(24.dp),
                            border = BorderStroke(1.dp,
                                MaterialTheme.colorScheme.onSurfaceVariant.copy( alpha = 0.2f )),
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(horizontal = 26.dp, vertical = 32.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text(
                                        text = classList.classroomName,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.onSurface
                                    )
                                    Text(
                                        text = "Sir Amado Sapit",
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                Text(
                                    text = classList.joinCode,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }

            // Bottom Bar
            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                onClick = { navController.navigate("professorCreate") }
            ) {
                Text(
                    text = "+   New classroom",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer( modifier = Modifier.height(20.dp))
        }
    }
}