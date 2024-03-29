package repository

import androidx.lifecycle.LiveData
import dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
}