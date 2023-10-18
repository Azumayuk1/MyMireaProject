@file:Suppress("DEPRECATION")

package ru.mirea.mymireaproject.part2

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageInfo

class GetAppsList {
    companion object {
        fun getInstalledApps(
            getSystemPackages: Boolean,
            context: Context
        ): ArrayList<ru.mirea.mymireaproject.part2.PackageInfo> {
            @SuppressLint("QueryPermissionsNeeded")
            val packages: List<PackageInfo> = context.packageManager.getInstalledPackages(0)
            val resources = ArrayList<ru.mirea.mymireaproject.part2.PackageInfo>()

            for (packageIndex in packages.indices) {
                val pack = packages[packageIndex]
                if (!getSystemPackages) {
                    continue
                }

                val newInfo = PackageInfo(
                    pack.applicationInfo.loadLabel(context.packageManager).toString(),
                    pack.packageName,
                    pack.versionName,
                    pack.versionCode
                )

                resources.add(newInfo)
            }
            return resources
        }

        fun checkIfRemoteAccessInstalled(context: Context): Boolean {
            @SuppressLint("QueryPermissionsNeeded") val packs: List<PackageInfo> =
                context.packageManager.getInstalledPackages(0)
            for (i in packs.indices) {
                val p = packs[i]
                if (p.packageName == "com.anydesk.anydeskandroid") {
                    return true
                }
            }
            return false
        }
    }

}