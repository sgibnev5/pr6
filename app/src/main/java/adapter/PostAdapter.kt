package adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.praktika.R
import com.example.praktika.databinding.CardPostBinding
import dto.Post

typealias OnLikeListener = (post: Post) -> Unit

class PostsAdapter(
    private val onLikeListener: OnLikeListener
) : ListAdapter<Post, PostViewHolder>(PostViewHolder.PostDiffCallback()), android.widget.ListAdapter {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class PostViewHolder(
    private val binding: CardPostBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            textView2.text = post.textView2
            textView4.text = post.textView4
            textView.text = post.textView
            imageButton17.setImageResource(
                if (post.likedByMe) {
                    imageButton17?.setImageResource(R.drawable.heart_red)
                }
                        textView5?.text = post.likes.toString()

                        root.setOnClickListener {
                    Log.d("stuff", "stuff")
                }

                        imageView.setOnClickListener {
                    Log.d("stuff", "avatar")
                }

                        imageButton17?.setOnClickListener {
                    Log.d("stuff", "like")
                    post.likedByMe = !post.likedByMe
                    imageButton17.setImageResource(
                        if (post.likedByMe) R.drawable.heart_red else R.drawable.heart_ser
                    )
                    if (post.likedByMe) post.likes++ else post.likes--
                    textView5?.text = post.likes.toString()
                }
                        binding.apply {
                    textView2.text = post.textView2
                    textView4.text = post.textView4
                    textView.text = post.textView
                    if (post.shareByMe) {
                        imageButton15?.setImageResource(com.example.praktika.R.drawable.ic_menu_share)
                    }
                    textView6?.text = post.share.toString()

                    root.setOnClickListener {
                        android.util.Log.d("stuff", "stuff")
                    }

                    imageView.setOnClickListener {
                        android.util.Log.d("stuff", "avatar")
                    }
                    imageButton15?.setOnClickListener {
                        android.util.Log.d("stuff", "share")
                        post.shareByMe = !post.shareByMe
                        imageButton17.setImageResource(
                            if (post.shareByMe) com.example.praktika.R.drawable.ic_menu_share else com.example.praktika.R.drawable.ic_menu_share
                        )
                        if (post.shareByMe) post.share++ else post.share--
                        textView6?.text = post.share.toString()
                    }
                }

    }
}


class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }
}
}
