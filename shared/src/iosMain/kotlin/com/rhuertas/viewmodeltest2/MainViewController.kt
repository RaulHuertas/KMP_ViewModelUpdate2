package com.rhuertas.viewmodeltest2

import androidx.compose.ui.window.ComposeUIViewController
import com.rhuertas.viewmodeltest2.di.initKoin

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}