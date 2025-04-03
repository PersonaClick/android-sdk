package personaClick.demo_android.app.di

import androidx.navigation.NavController
import com.personaClick.demo_android.navigation.Navigator
import org.koin.dsl.module
import personaClick.demo_android.app.navigation.AppNavigator

val navigatorModule = module {
    single<Navigator> {
        (navController: NavController) ->
            AppNavigator(
                navController = navController
            )
    }
}
