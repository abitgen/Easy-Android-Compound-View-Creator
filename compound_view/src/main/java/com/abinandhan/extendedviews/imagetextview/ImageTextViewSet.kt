package com.abinandhan.extendedviews.imagetextview

import android.content.Context
import android.util.AttributeSet
import com.abinandhan.basecompoundview.MaterialCardViewCompoundViewBuilder
import com.abinandhan.basecompoundview.R

class ImageTextViewSet(context: Context, attrs:AttributeSet) : MaterialCardViewCompoundViewBuilder<ImageTextViewEnumSet>(context, attrs){
    override val layout: Int = R.layout.image_text_view
    override val styleable: IntArray = R.styleable.ImageTextViewSet
    override val params = ImageTextViewEnumSet.values()
    init{
        build()
    }
}