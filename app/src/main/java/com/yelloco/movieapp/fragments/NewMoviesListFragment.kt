package com.yelloco.movieapp.fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yelloco.kotlin_test_app.app_utils.GuiManager
import com.yelloco.kotlin_test_app.views.CustomProgressDialog
import com.yelloco.movieapp.databinding.FragmentNewMoviesListBinding

class NewMoviesListFragment : Fragment() {

    private val classTag = this.javaClass.simpleName

    private var _binding: FragmentNewMoviesListBinding? = null

    private val binding get() = _binding!!

    private lateinit var activity: Activity
    private lateinit var customProgressDialog: CustomProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        activity = getActivity()!!

        _binding = FragmentNewMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        setListenerForViews()

        customProgressDialog.show()
    }

    private fun initViews()
    {
        customProgressDialog = CustomProgressDialog(activity, binding.root)
    }

    private fun setListenerForViews()
    {
        binding.fragmentNewMoviesListBackButton.setOnClickListener {
            GuiManager.removeSubFragment()
        }
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }

}