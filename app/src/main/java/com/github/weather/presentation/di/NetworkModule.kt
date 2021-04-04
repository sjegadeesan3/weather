package com.github.weather.presentation.di

import com.github.weather.presentation.constants.AppConstants.APP_BASE_URL
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { getOkHttpClient() }
    single { getRetrofit(get()) }
}

private fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(APP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

private fun getOkHttpClient(): OkHttpClient {
    val hostname = "*.openweathermap.org"

    val certificatePinner = CertificatePinner.Builder()
        .add(hostname, "sha256/axmGTWYycVN5oCjh3GJrxWVndLSZjypDO6evrHMwbXg=")
        .build()

    return OkHttpClient.Builder()
        .certificatePinner(certificatePinner)
        .build()
}


//➜  Desktop openssl s_client -servername www.openweathermap.org -connect www.openweathermap.org:443 | openssl x509 -pubkey -noout | openssl pkey -pubin -outform der | openssl dgst -sha256 -binary | openssl enc -base64
//
//depth=2 C = US, ST = New Jersey, L = Jersey City, O = The USERTRUST Network, CN = USERTrust RSA Certification Authority
//verify return:1
//depth=1 C = GB, ST = Greater Manchester, L = Salford, O = Sectigo Limited, CN = Sectigo RSA Domain Validation Secure Server CA
//verify return:1
//depth=0 CN = *.openweathermap.org
//verify return:1
//axmGTWYycVN5oCjh3GJrxWVndLSZjypDO6evrHMwbXg=