package com.rhuertas.viewmodeltest2

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import viewmodeltest2.shared.generated.resources.Res
import viewmodeltest2.shared.generated.resources.compose_multiplatform
import androidx.lifecycle.viewmodel.compose.viewModel

import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.dsl.koinConfiguration
import org.koin.compose.KoinApplication
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.KoinApplication
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.annotation.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.koinConfiguration
import org.koin.mp.KoinPlatform

@Composable
@Preview
fun App(
    viewModel: OrderViewModel = viewModel{OrderViewModel()},
) {
    KoinApplication(
        configuration = koinConfiguration {
            modules()
        },
    )
    {
        MaterialTheme {
            var showContent by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Button(onClick = {
                    //showContent = !showContent
                    viewModel.setQuantity((1..10).random())

                }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    val greeting = remember { Greeting().greet() }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
                Text(
                    "Quantity: ${viewModel.uiState.collectAsState().value.quantity}"
                )
                Text(
                    "Price: ${viewModel.uiState.collectAsState().value.price}"
                )
            }
        }
    }
}