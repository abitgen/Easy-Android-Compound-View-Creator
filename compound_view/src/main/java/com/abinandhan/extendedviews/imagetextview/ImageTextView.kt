package com.abinandhan.extendedviews.imagetextview

import android.content.Context
import android.util.AttributeSet
import com.abinandhan.basecompoundview.MaterialCardViewCompoundViewBuilder
import com.abinandhan.basecompoundview.R

class ImageTextView(context: Context, attrs:AttributeSet) : MaterialCardViewCompoundViewBuilder<ImageTextViewEnum>(context, attrs){
    override val layout: Int = R.layout.image_text_view
    override val styleable: IntArray = R.styleable.ImageTextView
    override val params = ImageTextViewEnum.values()
    init{
        build()
    }
}