package com.ajaythakur.stayhook

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.stayhook.dashboard.RecentlyAddedAdapter
import com.project.stayhook.dashboard.RecommendedHouseAdapter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var location:TextView
    private lateinit var searchValue: EditText
    private lateinit var searchBtn:ImageView
    private lateinit var allRecommendation: TextView
    private lateinit var recommendationRV: RecyclerView
    private lateinit var allRecentlyAdded:TextView
    private lateinit var recentlyAddedRV:RecyclerView
    private lateinit var findFlat: CardView
    private lateinit var findApartment:CardView
    private lateinit var findPrivateRoom:CardView
    private lateinit var findSharedRoom:CardView
    private lateinit var findHouse:CardView
    private lateinit var findVilla:CardView
    private lateinit var findKothi:CardView
    private lateinit var findPG:CardView
    private lateinit var findCoLiving:CardView
    private val list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        initView(view)

        val recommedationHouseAdapter = RecommendedHouseAdapter(list, requireContext())
        recommendationRV.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        recommendationRV.adapter = recommedationHouseAdapter

        getRecommendationList()
        recommedationHouseAdapter.notifyDataSetChanged()

        val recentlyAddedAdapter=RecentlyAddedAdapter(list,requireContext())
        recentlyAddedRV.layoutManager=LinearLayoutManager(this.context)
        recentlyAddedRV.adapter=recentlyAddedAdapter
        getRecentlyAddedList()
        recentlyAddedAdapter.notifyDataSetChanged()


        allRecommendation.setOnClickListener {
            val intent = Intent(this.context, HouseListActivity::class.java)
            intent.putExtra("houseType", "Recommendation")
            startActivity(intent)
        }

        allRecentlyAdded.setOnClickListener {
            val intent=Intent(this.context,HouseListActivity::class.java)
            intent.putExtra("houseType","RecentlyAdded")
            startActivity(intent)
        }

        return view
    }

    private fun getRecommendationList() {
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }

    fun getRecentlyAddedList(){
        list.add("2 Rooms Available")
        list.add("1 Room Available")
        list.add("Full House Available")
        list.add("2 Rooms Available")
        list.add("1 Room Sharing Available")
        list.add("1 Room Available")
    }



    private fun initView(view: View) {
        allRecommendation = view.findViewById(R.id.allRecommendations)
        recommendationRV = view.findViewById(R.id.recommendationRV)
        allRecentlyAdded=view.findViewById(R.id.allRecentlyAdded)
        recentlyAddedRV=view.findViewById(R.id.recentlyAddedRV)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
