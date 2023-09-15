package com.abyaz.coffeemasters

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.abyaz.coffeemasters.pages.Category
import com.abyaz.coffeemasters.pages.ItemInCart
import com.abyaz.coffeemasters.pages.Product
import kotlinx.coroutines.launch

class DataManager(app: Application) : AndroidViewModel(app) {
    var menu: List<Category> by mutableStateOf(listOf())
    var cart: List<ItemInCart> by mutableStateOf(listOf())

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            menu = API.menuService.fetchMenu()
        }
    }

    fun addToCart(product: Product) {
        var found = false
        cart.forEach {
            if (product.id == it.product.id) {
                it.quantity++
                found = true
            }
        }
        if (!found) {
            cart = listOf(*cart.toTypedArray(), ItemInCart(product, 1))
        }
    }

    fun removeFromCart(product: Product) {
        var aux = cart.toMutableList()
        aux.removeAll { productToRemoved ->
            productToRemoved.product.id == product.id
        }
        cart = listOf(*aux.toTypedArray())
    }

    fun clearCart() {
        cart = listOf()
    }
}