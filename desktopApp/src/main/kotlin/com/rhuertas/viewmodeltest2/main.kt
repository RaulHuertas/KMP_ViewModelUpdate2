package com.rhuertas.viewmodeltest2

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rhuertas.viewmodeltest2.transactionsModule
import com.rhuertas.viewmodeltest2.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "ViewModelTest2",
    ) {
        App()
    }
}