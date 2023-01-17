package com.android.gk_popular_libraries.details

import android.os.Build.ID
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.gk_popular_libraries.GeekBrainsApp
import com.android.gk_popular_libraries.core.OnBackPressedListener
import com.android.gk_popular_libraries.databinding.FragmentDetailsBinding
import com.android.gk_popular_libraries.model.GithubUser
import com.android.gk_popular_libraries.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailsFragment : MvpAppCompatFragment(), DetailsView, OnBackPressedListener {

    companion object {
        @JvmStatic
        fun getInstance(id: Long): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putLong(ID, id)
                }
            }
        }
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private val presenter: DetailsPresenter by moxyPresenter {
        DetailsPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getLong(ID)?.let {
            presenter.loadUser(it)
        }

    }

    override fun onBackPressed() = presenter.onBackPressed()
    override fun show(user: GithubUser) {
        binding.apply {
            tvUserLogin.text = user.login
        }
    }
}