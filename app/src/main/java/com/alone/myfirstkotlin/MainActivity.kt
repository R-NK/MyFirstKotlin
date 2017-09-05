package com.alone.myfirstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        if (savedInstanceState == null) {
            val rootFragment = RootFragment()
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.flContent, rootFragment)
                    .commit()
        }

        nvView.setNavigationItemSelectedListener{
            val fragment = when (it.itemId) {
                R.id.nav_root_fragment -> RootFragment()
                R.id.nav_first_fragment -> FirstFragment()
                R.id.nav_second_fragment -> SecondFragment()
                R.id.nav_third_fragment -> ThirdFragment()
                else -> null
            }
            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.flContent, fragment)
                        .commit()
            }

            drawerLayout.closeDrawers()
            true
        }
    }
}
