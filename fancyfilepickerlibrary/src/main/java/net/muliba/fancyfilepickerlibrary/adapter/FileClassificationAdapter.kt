package net.muliba.fancyfilepickerlibrary.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import net.muliba.fancyfilepickerlibrary.R
import net.muliba.fancyfilepickerlibrary.ext.inflate
import net.muliba.fancyfilepickerlibrary.model.DataSource

/**
 * Created by fancy on 2017/4/26.
 */

abstract class FileClassificationAdapter(val items: ArrayList<DataSource>) : RecyclerView.Adapter<FileViewHolder>() {

    override fun onBindViewHolder(holder: FileViewHolder, position: Int) {
        when (items[position]) {
            is DataSource.Main -> {
                val main = items[position] as DataSource.Main
                bindMain(holder, main, position)
                holder.convertView.setOnClickListener { v -> clickMain(v, main, position) }
            }
            is DataSource.File -> {
                val file = items[position] as DataSource.File
                bindFile(holder, file, position)
                holder.convertView.setOnClickListener { v ->  clickFile(v, file, position) }

            }
            is DataSource.PictureFolder -> {
                val folder = items[position] as DataSource.PictureFolder
                bindPictureFolder(holder, folder, position)
                holder.convertView.setOnClickListener { v -> clickPictureFolder(v, folder, position) }
            }
            is DataSource.Picture -> {
                val picture = items[position] as DataSource.Picture
                bindPicture(holder, picture, position)
                holder.convertView.setOnClickListener { v ->  clickPicture(v, picture, position) }
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileViewHolder {
        return when (viewType) {
            0 -> FileViewHolder(parent.inflate(R.layout.item_file_classification_picker_main))
            1 -> FileViewHolder(parent.inflate(R.layout.item_file_classification_picker_picture_folder))
            2 -> FileViewHolder(parent.inflate(R.layout.item_file_classification_picker_picture))
            else -> FileViewHolder(parent.inflate(R.layout.item_file_classification_picker_file))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DataSource.Main -> 0
            is DataSource.PictureFolder -> 1
            is DataSource.Picture -> 2
            else -> -1
        }
    }

    abstract fun bindMain(holder: FileViewHolder, main: DataSource.Main, position: Int)
    abstract fun clickMain(v: View, main: DataSource.Main, position: Int)
    abstract fun bindFile(holder: FileViewHolder, file:DataSource.File, position: Int)
    abstract fun clickFile(v: View, file: DataSource.File, position: Int)
    abstract fun bindPictureFolder(holder: FileViewHolder, folder: DataSource.PictureFolder, position: Int)
    abstract fun clickPictureFolder(v: View, folder: DataSource.PictureFolder, position: Int)
    abstract fun bindPicture(holder: FileViewHolder, picture: DataSource.Picture, position: Int)
    abstract fun clickPicture(v: View, picture: DataSource.Picture, position: Int)

}