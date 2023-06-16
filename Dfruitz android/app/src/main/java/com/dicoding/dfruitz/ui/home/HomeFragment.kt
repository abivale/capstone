package com.dicoding.dfruitz.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.dfruitz.ItemAdapter
import com.dicoding.dfruitz.R
import com.dicoding.dfruitz.data.Item
import com.dicoding.dfruitz.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        setupRecyclerView()

        return root
    }

    private fun setupRecyclerView() {
        val itemList = generateItemList()
        itemAdapter = ItemAdapter(itemList)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
        }
    }

    private fun generateItemList(): List<Item> {
        val imageArray = resources.obtainTypedArray(R.array.item_images)
        val titleArray = resources.getStringArray(R.array.item_titles)
        val dateArray = resources.getStringArray(R.array.item_dates)

        val itemList = mutableListOf<Item>()

        for (i in 0 until imageArray.length()) {
            val image = imageArray.getResourceId(i, 0)
            val title = titleArray[i]
            val date = dateArray[i]

            itemList.add(Item(image, title, date))
        }

        imageArray.recycle()

        return itemList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
