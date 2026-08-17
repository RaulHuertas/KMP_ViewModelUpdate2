package com.rhuertas.viewmodeltest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rhuertas.viewmodeltest2.transactionsModule
import com.rhuertas.viewmodeltest2.di.initKoin
import android.util.Log
import org.koin.core.context.GlobalContext
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MainActivity", "onCreate called")
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        if (GlobalContext.getOrNull() == null) {
        initKoin(){
            //androidContext(this@MainActivity)
        }
        }
        setContent {
            App()
       }
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy called")
        super.onDestroy()
    }

    override fun onStop() {
        Log.d("MainActivity", "onStop called")
        super.onStop()
    }

    override fun onResume() {
        Log.d("MainActivity", "onResume called")
        super.onResume()
    }

    override fun onRestart() {
        Log.d("MainActivity", "onRestart called")
        super.onRestart()
    }

    override fun onStart() {
        Log.d("MainActivity", "onStart called")
        super.onStart()
    }

    override fun onPause() {
        Log.d("MainActivity", "onPause called")
        super.onPause()
    }


}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}