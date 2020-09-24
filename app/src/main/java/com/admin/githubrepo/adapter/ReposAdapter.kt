package com.admin.githubrepo.adapter
import android.content.Intent
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.admin.githubrepo.model.Repo


/**
 * Adapter for the list of repositories.
 */
class ReposAdapter(private val cellClickListener: CellClickListene) : ListAdapter<
        Repo,
        androidx.recyclerview.widget.RecyclerView.ViewHolder>
    (
         REPO_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        return RepoViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: androidx.recyclerview.widget.RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)

        if (repoItem != null) {
            (holder as RepoViewHolder).bind(repoItem,cellClickListener)
        }else{

        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                    oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                    oldItem == newItem
        }
    }
}
