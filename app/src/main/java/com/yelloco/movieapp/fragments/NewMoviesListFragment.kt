package com.yelloco.movieapp.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.yelloco.kotlin_test_app.app_utils.GuiManager
import com.yelloco.kotlin_test_app.views.CustomProgressDialog
import com.yelloco.movieapp.adapters.MoviesAdapter
import com.yelloco.movieapp.databinding.FragmentNewMoviesListBinding
import com.yelloco.movieapp.retrofit.RetrofitClient
import com.yelloco.movieapp.retrofit.models.RequestModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewMoviesListFragment : Fragment() {

    private val classTag = this.javaClass.simpleName

    private var _binding: FragmentNewMoviesListBinding? = null

    private val binding get() = _binding!!

    private lateinit var activity: Activity
    private lateinit var customProgressDialog: CustomProgressDialog
    private var moviesAdapter: MoviesAdapter = MoviesAdapter()

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

        getMoviesList()
    }

    private fun initViews()
    {
        customProgressDialog = CustomProgressDialog(activity, binding.root)
        initRecyclerView()
    }

    private fun setListenerForViews()
    {
        binding.fragmentNewMoviesListBackButton.setOnClickListener {
            GuiManager.removeSubFragment()
        }
    }

    private fun initRecyclerView()
    {
        binding.fragmentNewMoviesListRecycleView.layoutManager = GridLayoutManager(activity, 2)
        binding.fragmentNewMoviesListRecycleView.adapter = moviesAdapter
    }

    private fun getMoviesList()
    {
        val moviesCall: Call<RequestModel> = RetrofitClient.getTopRatedMovies()
        moviesCall.enqueue(object : Callback<RequestModel> {
            override fun onResponse(call: Call<RequestModel>, response: Response<RequestModel>) {
                customProgressDialog.dismiss()
                if(response.isSuccessful)
                {
                    moviesAdapter.movies.addAll(response.body()!!.resultList)
                    moviesAdapter.notifyDataSetChanged()
                }
                else
                {
                    customProgressDialog.dismiss()
                    Toast.makeText(activity, "Failed to get movies", Toast.LENGTH_SHORT).show()
                    Log.e(classTag, "errorMessage: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<RequestModel>, t: Throwable) {
                t.printStackTrace()
                customProgressDialog.dismiss()
                Toast.makeText(activity, "Failed to get movies", Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }

}