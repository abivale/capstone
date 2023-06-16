package com.dicoding.dfruitz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.dicoding.dfruitz.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.image.setImageResource(R.drawable.your_image_resource) // Replace with your image resource

        binding.titles.text = args.title
        binding.detail.text = getString(R.string.detail_fragment_detail)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}