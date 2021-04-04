package com.github.weather.domain.usecase

interface UseCase<T> {
    suspend fun execute(): T
}

interface UseCaseWithParameter<P, T> {
    suspend fun execute(parameter: P): T
}