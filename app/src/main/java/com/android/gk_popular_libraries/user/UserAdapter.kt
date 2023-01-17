package com.android.gk_popular_libraries.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.gk_popular_libraries.databinding.ItemUserBinding
import com.android.gk_popular_libraries.model.GithubUser

class UserAdapter(private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<UserAdapter.GithubUserViewHolder>() {

    var users: List<GithubUser> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {

        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GithubUserViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class GithubUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(githubUser: GithubUser) {
            ItemUserBinding.bind(itemView).apply {
                with(githubUser) {
                    tvUserLogin.text = githubUser.login
                    root.setOnClickListener {
                        onItemClickListener.onItemClick(this.id)
                    }
                }
            }
        }
    }
}