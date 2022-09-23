package by.lexshi.rxjavaprojectexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import by.lexshi.rxjavaprojectexample.ui.RxJavaStartScreen
import by.lexshi.rxjavaprojectexample.ui.theme.RxJavaProjectExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RxJavaProjectExampleTheme {
                RxJavaStartScreen()
            }
        }
    }
}