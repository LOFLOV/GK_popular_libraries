package com.android.gk_popular_libraries.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.gk_popular_libraries.GeekBrainsApp
import com.android.gk_popular_libraries.core.OnBackPressedListener
import com.android.gk_popular_libraries.databinding.FragmentUsersListBinding
import com.android.gk_popular_libraries.model.GithubUser
import com.android.gk_popular_libraries.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(), UserView, OnBackPressedListener, OnItemClickListener {

    companion object {
        fun getInstance(): UserFragment {
            return UserFragment()
        }
    }

    private lateinit var viewBinding: FragmentUsersListBinding

    private val adapter = UserAdapter(this)

    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(GithubRepositoryImpl(), GeekBrainsApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentUsersListBinding.inflate(inflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            rvGithubUsers.layoutManager = LinearLayoutManager(requireContext())
            rvGithubUsers.adapter = adapter
        }
    }

    override fun initList(list: List<GithubUser>) { adapter.users = list }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun onItemClick(id: Long) = presenter.onItemClicked(id)
}