package com.example.repo_browser.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repo_browser.R
import com.example.repo_browser.fragments.RepoFragment

class RepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout,RepoFragment())
        fragmentTransaction.commit()
    }
}