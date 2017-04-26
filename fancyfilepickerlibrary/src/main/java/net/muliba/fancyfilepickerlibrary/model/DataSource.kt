package net.muliba.fancyfilepickerlibrary.model

import net.muliba.fancyfilepickerlibrary.R

/**
 * Created by fancy on 2017/4/26.
 */

sealed class DataSource {

    class Main(var nameRes: Int = R.string.item_classification_picture,
               var imageRes: Int = R.drawable.category_icon_image,
               var count: Int = 0): DataSource()

    class File(var path: String,
               var file: java.io.File): DataSource()


}