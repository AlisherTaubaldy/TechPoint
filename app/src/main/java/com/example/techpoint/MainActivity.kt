package com.example.techpoint

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.techpoint.fragments.*
import com.ismaeldivita.chipnavigation.ChipNavigationBar


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chipNavigationBar = findViewById<ChipNavigationBar>(R.id.bottom_nav)
        chipNavigationBar.setItemSelected(R.id.home, true)

        chipNavigationBar.setOnItemSelectedListener {
            when (it) {
                R.id.home -> {
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, homeFragment).commit()
                }
                R.id.library -> {
                    val libraryFragment = LibraryFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, libraryFragment).commit()
                }
                R.id.classroom -> {
                    val classroomFragment = ClassroomFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, classroomFragment).commit()
                }
                R.id.notifications -> {
                    val notificationFragment = NotificationFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, notificationFragment).commit()
                }
                R.id.profile -> {
                    val privateOfficeFragment = PrivateOfficeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, privateOfficeFragment).commit()
                }
            }
        }
    }
}