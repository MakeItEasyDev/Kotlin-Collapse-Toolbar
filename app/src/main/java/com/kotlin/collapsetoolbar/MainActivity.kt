package com.kotlin.collapsetoolbar

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.title = resources.getString(R.string.user_name)
        dynamicToolbarColor()
        toolbarTextAppearance()
    }

    private fun toolbarTextAppearance() {
        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.collapsedappbar)
        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.expandedappbar)
    }

    @SuppressLint("ResourceAsColor")
    private fun dynamicToolbarColor() {
        val bitmap = profile_id.background.toBitmap()

        Palette.from(bitmap).generate { palette ->
            collapsing_toolbar.setContentScrimColor(palette!!.getMutedColor(R.color.colorPrimary))
            collapsing_toolbar.setStatusBarScrimColor(palette.getMutedColor(R.color.colorPrimaryDark))

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = palette.getMutedColor(R.color.colorPrimaryDark)
            }
        }
    }
}













