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
import com.example.insureme.Views.adminLogin
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class CarInsuranceAdapterDelete(private val insurances: List<carinsurance_dataclass>) :
    RecyclerView.Adapter<CarInsuranceAdapterDelete.InsuranceViewHolder>() {
    private val apiService = Retrofit.Builder()
        .baseUrl("http://10.20.37.60:5000/carInsurance/")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(ApiServiceDelete::class.java)
    class InsuranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deleteinsurance_list_cards, parent, false)
        return InsuranceViewHolder(view)
    }
    override fun getItemCount() = insurances.size

    override fun onBindViewHolder(holder: InsuranceViewHolder, position: Int) {
        val insurance = insurances[position]
        holder.title.text = insurance.companyName
        holder.description.text = insurance.desc
        holder.price.text = "₹"+insurance.price.toString()

        if (holder.title.text.equals("HDFC"))
        {
            holder.image.setImageResource(R.drawable.insurance1)
        }
        else if (holder.title.text.equals("MAX"))
        {
            holder.image.setImageResource(R.drawable.maxlife)
        }
        else if(holder.title.text.equals(("ICICI Lombard")))
        {
            holder.image.setImageResource(R.drawable.icici)
        }
        else if(holder.title.text.equals(("TATA AIG")))
        {
            holder.image.setImageResource(R.drawable.tata)
        }
        else if(holder.title.text.equals(("Reliance General Insurance")))
        {
            holder.image.setImageResource(R.drawable.reliance)
        }
        else
        {
            holder.image.setImageResource(R.drawable.insurance2)
        }
        holder.bind(insurance._id, apiService )

        }


    }


class InsuranceActivityDelete : AppCompatActivity() {
    private lateinit var viewModel: CarInsuranceViewModel
    private lateinit var adapter: CarInsuranceAdapterDelete
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.deleteinsurance_list_cards)
        val insuranceCompanyListViewNew = findViewById<RecyclerView>(R.id.deleteinsurance_company_list)
        viewModel = ViewModelProvider(this).get(CarInsuranceViewModel::class.java)
        lifecycleScope.launch {

            viewModel.fetchInsurances()
        }
        viewModel.insurances.observe(this, Observer {
            adapter = CarInsuranceAdapterDelete(it)
            insuranceCompanyListViewNew.adapter = adapter
        })

        insuranceCompanyListViewNew.layoutManager = LinearLayoutManager(this)


        }


}



