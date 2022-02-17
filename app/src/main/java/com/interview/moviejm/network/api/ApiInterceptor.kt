package com.interview.moviejm.network.api

import okhttp3.Interceptor
import okhttp3.Response

object ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("api_key", "274f828ad283bd634ef4fc1ee4af255f")
                .build()
        )
}