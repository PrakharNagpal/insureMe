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

class InsuranceAdapterNew(private val insurances: List<insurance_dataclass>) :
    RecyclerView.Adapter<InsuranceAdapterNew.InsuranceViewHolder>() {

    class InsuranceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // val image = itemView.findViewById<ImageView>(R.id.insurance_company_image)
        val title = itemView.findViewById<TextView>(R.id.insurance_company_title)
        val description = itemView.findViewById<TextView>(R.id.insurance_company_description)
        val price = itemView.findViewById<TextView>(R.id.insurance_company_price)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.insurance_list_cards, parent, false)
        return InsuranceViewHolder(view)
    }
    override fun getItemCount() = insurances.size

    override fun onBindViewHolder(holder: InsuranceViewHolder, position: Int) {
        val insurance = insurances[position]
        holder.title.text = insurance.companyName
        holder.description.text = insurance.desc
        holder.price.text = insurance.price.toString()
        // Use Picasso or Glide library to load the image from the URL
        // Picasso.get().load(insurance.image).into(holder.image)
    }
}
class InsuranceActivityNew : AppCompatActivity() {
    private lateinit var viewModel: InsuranceViewModel
    private lateinit var adapter: InsuranceAdapterNew
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.insurance_list_cards)
        val insuranceCompanyListViewNew = findViewById<RecyclerView>(R.id.insurance_company_list)
        viewModel = ViewModelProvider(this).get(InsuranceViewModel::class.java)
        lifecycleScope.launch {

            viewModel.fetchInsurances()
        }
        viewModel.insurances.observe(this, Observer {
            adapter = InsuranceAdapterNew(it)
            insuranceCompanyListViewNew.adapter = adapter
        })

        insuranceCompanyListViewNew.layoutManager = LinearLayoutManager(this)
    }
}

