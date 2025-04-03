package com.personaClick.demo_android.ui.extensions

import androidx.fragment.app.Fragment

fun Fragment.backPressedInvoke() {
    requireActivity().onBackPressedDispatcher.onBackPressed()
}
