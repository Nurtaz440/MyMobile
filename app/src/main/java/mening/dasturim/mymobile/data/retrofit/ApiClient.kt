package mening.dasturim.mymobile.data.retrofit

import retrofit2.Retrofit

class ApiClient {
    companion object{
        private var retrofit: Retrofit? = null

        fun restartRetrofit() {
            retrofit = null
        }
    }
}