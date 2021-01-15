package com.rafaelirineu.exercicioapiaula35.category.view

import android.os.Bundle
import android.provider.MediaStore.Video.VideoColumns.CATEGORY
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rafaelirineu.exercicioapiaula35.R
import com.rafaelirineu.exercicioapiaula35.category.repository.CategoryRepository
import com.rafaelirineu.exercicioapiaula35.category.viewmodel.CategoryViewModel

class CategoryFragment : Fragment() {

    private lateinit var _categoryAdapter: CategoryAdapter
    private var _categoryList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryRecycler = view.findViewById<RecyclerView>(R.id.recyclerViewFragmentCategory)
        val viewManager = LinearLayoutManager(view.context)
        //val navControler = Navigation.findNavController(view)

        _categoryList = mutableListOf<String>()

//        _categoryAdapter = CategoryAdapter(_categoryList){
//            val bundle = bundleOf(CATEGORY to it)
//            navControler.navigate(R.id.action_categoryFragment_to_jokesFragment, bundle)
//        }

        categoryRecycler.apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = _categoryAdapter
        }

        val viewModel = ViewModelProvider(this,
            CategoryViewModel.CategoryViewModelFactory(CategoryRepository()))
            .get(CategoryViewModel::class.java)

        viewModel.obtainCategories().observe(viewLifecycleOwner) {
            _categoryList.addAll(it)
            _categoryAdapter.notifyDataSetChanged()
        }
    }
}