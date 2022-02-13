package com.interview.moviejm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.interview.moviejm.App.Navigation.navigatorHolder
import com.interview.moviejm.App.Navigation.router
import com.interview.moviejm.ui.main.MainFragment
import com.interview.moviejm.ui.main.MainScreen

class MainActivity : AppCompatActivity() {

    private val navigator = AppNavigator(this, android.R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        savedInstanceState ?: router.newRootScreen(MainScreen)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}