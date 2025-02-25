package org.scesi.esqueleto
import android.app.Application

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        initDependencyInjection()
    }
}