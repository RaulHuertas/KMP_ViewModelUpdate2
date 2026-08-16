package com.rhuertas.viewmodeltest2.di

import com.rhuertas.viewmodeltest2.transactionsModule
import org.koin.core.context.startKoin
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication {
    return startKoin {
        includes(config)
        modules(
            transactionsModule,
        )
    }
}

