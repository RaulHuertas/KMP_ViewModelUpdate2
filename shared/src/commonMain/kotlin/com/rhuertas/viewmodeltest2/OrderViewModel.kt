package com.rhuertas.viewmodeltest2

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.koin.core.annotation.KoinViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

data class OrderUiState(
    val quantity: Int = 0,
    val price: String = "$0.00",
)

@KoinViewModel
class OrderViewModel : ViewModel() {
    val uiState : StateFlow<OrderUiState> field = MutableStateFlow(OrderUiState())

    fun setQuantity(n : Int){
        uiState.update{
            it.copy(quantity = n, price = "$${n *2.00}")
        }
    }

}

data class ItemOptions(
    val color : String = "RED",
    val withSwitches: Boolean = true
)

@KoinViewModel
class PersistentViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    val uiState : StateFlow<ItemOptions> field = MutableStateFlow(ItemOptions())

    fun setColor(c : String){
        uiState.update{
            it.copy(color = c)
        }
    }

    fun setSwitchesOn(s : Boolean){
        uiState.update{
            it.copy(withSwitches = s)
        }
    }
}

val transactionsModule = module {
    viewModelOf(::OrderViewModel)
    viewModelOf(::PersistentViewModel)
}
