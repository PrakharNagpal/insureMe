package com.example.insureme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

data class InsuranceCompany(
    val title: String,
    val description: String,
    val price: Double,
    val image: Int
)

class InsuranceCompanyAdapter(private val insuranceCompanies: List<InsuranceCompany>) :
    RecyclerView.Adapter<InsuranceCompanyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsuranceCompanyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.insurance_list_cards, parent, false)
        return InsuranceCompanyViewHolder(view)
    }

    override fun getItemCount() = insuranceCompanies.size

    override fun onBindViewHolder(holder: InsuranceCompanyViewHolder, position: Int) {
        val insuranceCompany = insuranceCompanies[position]
        holder.bindData(insuranceCompany)
    }
}

class InsuranceCompanyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.insurance_company_title)
    private val description = itemView.findViewById<TextView>(R.id.insurance_company_description)
    private val price = itemView.findViewById<TextView>(R.id.insurance_company_price)
    private val image = itemView.findViewById<ImageView>(R.id.insurance_company_image)

    fun bindData(insuranceCompany: InsuranceCompany) {
        title.text = insuranceCompany.title
        description.text = insuranceCompany.description
        price.text = insuranceCompany.price.toString()
        image.setImageResource(insuranceCompany.image)
    }
}

class InsuranceAdapter : AppCompatActivity() {

    private val insuranceCompanyList = listOf(
        InsuranceCompany("Insurance Company 1", "Description 1", 100.0, R.drawable.insurance1),
        InsuranceCompany("Insurance Company 2", "Description 2", 200.0, R.drawable.insurance1),
        InsuranceCompany("Insurance Company 3", "Description 3", 300.0, R.drawable.insurance1),
        InsuranceCompany("Insurance Company 4", "Description 4", 400.0, R.drawable.insurance1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insurance_list_cards)

        val insuranceCompanyListView = findViewById<RecyclerView>(R.id.insurance_company_list)
        insuranceCompanyListView.layoutManager = LinearLayoutManager(this)
        insuranceCompanyListView.adapter = InsuranceCompanyAdapter(insuranceCompanyList)
    }
}