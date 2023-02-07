package com.example.insureme
import android.content.Intent
import kotlinx.coroutines.launch

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insureme.ViewModel.CarInsuranceViewModel
import com.example.insureme.DataClasses.carinsurance_dataclass
import com.example.insureme.ViewModel.HealthInsuranceViewModel
import com.example.insureme.Views.adminLogin
import com.example.insureme.Views.healthinsurance_dataclass
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class HealthInsuranceAdapterDelete(private val Healthinsurances: List<healthinsurance_dataclass>) :
    RecyclerView.Adapter<HealthInsuranceAdapterDelete.HealthInsuranceViewHolder>() {
    private val apiService = Retrofit.Builder()
        .baseUrl("http://10.20.37.60:5000/healthInsurance/")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(ApiServiceDelete::class.java)
    class HealthInsuranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val image = itemView.findViewById<ImageView>(R.id.insurance_company_image)


        val title = itemView.findViewById<TextView>(R.id.deleteinsurance_company_title)
        val description = itemView.findViewById<TextView>(R.id.deleteinsurance_company_description)
        val price = itemView.findViewById<TextView>(R.id.deleteinsurance_company_price)
        val image=itemView.findViewById<ImageView>(R.id.deleteinsurance_company_image)


        fun bind(_id: String,apiService: ApiServiceDelete)
        {

            itemView.setOnClickListener {

                apiService.deleteData(_id)
                    .enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            if (response.isSuccessful) {
                                //startActivity(Intent(this, ChooseAddInsuranceType::class.java))

                                Log.d("SUCCESS","SUCCESSFULLY DELETED")


                                // remove the item from the RecyclerView data set
                            } else {
                                Log.d("Failed","Failed to delete")
                                // show an error message
                            }
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            print("FAILS")
                            // show an error message
                        }
                    })

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthInsuranceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deleteinsurance_list_cards, parent, false)
        return HealthInsuranceViewHolder(view)
    }
    override fun getItemCount() = Healthinsurances.size

    override fun onBindViewHolder(holder: HealthInsuranceViewHolder, position: Int) {
        val healthinsurance = Healthinsurances[position]
        holder.title.text = healthinsurance.companyName
        holder.description.text = healthinsurance.desc
        holder.price.text = "₹"+healthinsurance.price.toString()


        if (holder.title.text.equals("HDFC Life Insurance"))
        {
            holder.image.setImageResource(R.drawable.insurance1)
        }
        else if(holder.title.text.equals("SBI General Health Insurance"))
        {
            holder.image.setImageResource(R.drawable.sbigen)
        }
        else if(holder.title.text=="Bajaj Allianz")
        {
            holder.image.setImageResource(R.drawable.bajajlogo)
        }

        else if(holder.title.text.equals("Max Life Insurance"))
        {
            holder.image.setImageResource(R.drawable.maxlife)
        }

        else {
            holder.image.setImageResource(R.drawable.insurance2)
        }
        holder.bind(healthinsurance._id, apiService )

    }


}


class HealthInsuranceActivityDelete : AppCompatActivity() {
    private lateinit var viewModel: HealthInsuranceViewModel
    private lateinit var adapter: HealthInsuranceAdapterDelete
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.deleteinsurance_list_cards)
        val HealthinsuranceCompanyListViewNew = findViewById<RecyclerView>(R.id.deleteinsurance_company_list)
        viewModel = ViewModelProvider(this).get(HealthInsuranceViewModel::class.java)
        lifecycleScope.launch {

            viewModel.healthfetchInsurances()
        }
        viewModel.Healthinsurances.observe(this, Observer {
            adapter = HealthInsuranceAdapterDelete(it)
            HealthinsuranceCompanyListViewNew.adapter = adapter
        })

        HealthinsuranceCompanyListViewNew.layoutManager = LinearLayoutManager(this)


    }


}



