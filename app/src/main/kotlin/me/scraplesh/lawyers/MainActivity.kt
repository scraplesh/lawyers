package me.scraplesh.lawyers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import me.scraplesh.lawyers.features.authorization.Authorization
import me.scraplesh.lawyers.features.greeting.Greeting
import me.scraplesh.lawyers.features.passwordrecovery.PasswordRecovery
import me.scraplesh.lawyers.ui.theme.LawyersTheme

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LawyersApp()
        }
    }
}

@ExperimentalPagerApi
@Composable
fun LawyersApp() {
    LawyersTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = AppDestinations.GREETING) {
            composable(route = AppDestinations.GREETING) {
                Greeting { navController.navigate(AppDestinations.AUTHORIZATION) }
            }
            composable(route = AppDestinations.AUTHORIZATION) {
                Authorization(
                    navigateBack = { navController.navigateUp() },
                    openPasswordRecovery = { navController.navigate(AppDestinations.PASSWORD_RECOVERY) }
                )
            }
            composable(route = AppDestinations.PASSWORD_RECOVERY) {
                PasswordRecovery { navController.navigateUp() }
            }
        }
    }
}

object AppDestinations {
    const val GREETING = "greeting"
    const val AUTHORIZATION = "authorization"
    const val PASSWORD_RECOVERY = "password_recovery"
}
