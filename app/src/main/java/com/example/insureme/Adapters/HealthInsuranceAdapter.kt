package com.example.insureme
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.insureme.ViewModel.HealthInsuranceViewModel
import com.example.insureme.Views.healthinsurance_dataclass

class HealthInsuranceAdapterNew(private val Healthinsurances: List<healthinsurance_dataclass>) :
    RecyclerView.Adapter<HealthInsuranceAdapterNew.HealthInsuranceViewHolder>() {

    class HealthInsuranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // val image = itemView.findViewById<ImageView>(R.id.insurance_company_image)
        val title = itemView.findViewById<TextView>(R.id.healthinsurance_company_title)
        val description = itemView.findViewById<TextView>(R.id.healthinsurance_company_description)
        val price = itemView.findViewById<TextView>(R.id.healthinsurance_company_price)
        val image=itemView.findViewById<ImageView>(R.id.healthinsurance_company_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthInsuranceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.healthinsurance_list_cards, parent, false)
        return HealthInsuranceViewHolder(view)
    }
    override fun getItemCount() = Healthinsurances.size

    override fun onBindViewHolder(holder: HealthInsuranceViewHolder, position: Int) {
        val insurance = Healthinsurances[position]
        holder.title.text = insurance.companyName
        holder.description.text = insurance.desc
        holder.price.text = insurance.price.toString()

            holder.image.setImageResource(R.drawable.insurance1)

//        else
//        {
//            holder.image.setImageResource(R.drawable.insurance2)
//        }
        // Use Picasso or Glide library to load the image from the URL
        // Picasso.get().load(insurance.image).into(holder.image)
    }
}
class HealthInsuranceActivityNew : AppCompatActivity() {
    private lateinit var viewModel: HealthInsuranceViewModel
    private lateinit var adapter: HealthInsuranceAdapterNew
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.healthinsurance_list_cards)
        val HealthinsuranceCompanyListViewNew = findViewById<RecyclerView>(R.id.healthinsurance_company_list)
        viewModel = ViewModelProvider(this).get(HealthInsuranceViewModel::class.java)
        lifecycleScope.launch {

            viewModel.healthfetchInsurances()
        }
        viewModel.Healthinsurances.observe(this, Observer {
            adapter = HealthInsuranceAdapterNew(it)
            HealthinsuranceCompanyListViewNew.adapter = adapter
        })

        HealthinsuranceCompanyListViewNew.layoutManager = LinearLayoutManager(this)
    }
}

