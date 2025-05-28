package com.chepsi.home.application.activity

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager

fun isAppDefaultHome(context: Context): Boolean {
    val packageManager = context.packageManager
    val intent = Intent(Intent.ACTION_MAIN)
    intent.addCategory(Intent.CATEGORY_HOME)
    intent.addCategory(Intent.CATEGORY_DEFAULT) // Important for matching

    val resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)

    // If resolveInfo is null, no activity can handle the intent
    if (resolveInfo == null || resolveInfo.activityInfo == null) {
        return false
    }

    // The component name of the default home activity
    val defaultHomeComponentName = resolveInfo.activityInfo

    // Your app's package name
    val myPackageName = context.packageName

    // Check if the package name of the default home app matches your app's package name
    return defaultHomeComponentName.packageName == myPackageName
}