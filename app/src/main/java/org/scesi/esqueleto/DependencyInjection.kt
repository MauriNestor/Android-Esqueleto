package org.scesi.esqueleto

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.ksp.generated.module
import org.scesi.data.DataModule
import org.scesi.usecases.UseCasesModule

fun Application.initDependencyInjection() {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initDependencyInjection)
        modules(AppModule().module, DataModule().module, UseCasesModule().module)
    }
}
@Module
@ComponentScan
class AppModule