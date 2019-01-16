package com.abinandhan.extendedviews.imagetextview

import android.content.res.TypedArray
import android.view.View
import com.abinandhan.basecompoundview.CompoundViewParams
import com.abinandhan.basecompoundview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.image_text_view.view.*

enum class ImageTextViewEnum: CompoundViewParams {
    IMAGE() {
        override var typedArray: TypedArray? = null
        override var parentView: View? = null
        override fun getValue(): Int? = typedArray?.getResourceId(R.styleable.ImageTextView_image_src,0)
        override fun setProperty(value: Any?): Any? = Glide.with(parentView?.context!!).load(value as Int).transition(DrawableTransitionOptions.withCrossFade()).into(parentView?.aivImage!!)
    },
    TEXT() {
        override var typedArray: TypedArray? = null
        override var parentView: View? = null
        override fun getValue(): String? = typedArray?.getString(R.styleable.ImageTextView_text_str)
        override fun setProperty(value: Any?)= value?.let { parentView?.aivText?.setText(it.toString())}
    },
    BACKGROUND(){
        override var parentView: View?=null
        override var typedArray: TypedArray?=null
        override fun getValue(): Any? = typedArray?.getInt(R.styleable.ImageTextView_bg_color, 0)
        override fun setProperty(value: Any?): Any? =
            parentView?.cardParent?.setCardBackgroundColor(when(value as Int) {
                0-> R.color.white
                1-> R.color.dark_transparent
                2->R.color.black
                else->R.color.white
            })
    }
}

