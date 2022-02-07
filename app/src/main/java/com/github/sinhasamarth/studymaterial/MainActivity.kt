package com.github.sinhasamarth.studymaterial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.sinhasamarth.studymaterial.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            startKoin {
                androidContext(this@MainActivity)
                modules(appModules)
            }
        }
        catch (e:Exception){}
    }
}
