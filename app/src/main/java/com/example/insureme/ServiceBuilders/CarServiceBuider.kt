package com.example.insureme


    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    object ServiceBuilder {
        private const val URL ="http://10.20.37.60:5000/carInsurance/"
        //CREATE HTTP CLIENT
//        private val okHttp =OkHttpClient.Builder()

        //retrofit builder
        private val builder =Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create()).baseUrl(URL)
//            .client(okHttp.build())

        //create retrofit Instance
        private val retrofit = builder.build()

        //we will use this class to create an anonymous inner class function that
        //implements Country service Interface


        fun <T> buildService (serviceType :Class<T>):T{
            return retrofit.create(serviceType)
        }

    }
