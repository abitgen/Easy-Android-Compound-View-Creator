package com.abinandhan.extendedviews.imagetextview

import android.content.res.TypedArray
import android.view.View
import androidx.core.content.ContextCompat
import com.abinandhan.basecompoundview.CompoundViewParamsSet
import com.abinandhan.basecompoundview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.image_text_view.view.*

enum class ImageTextViewEnumSet : CompoundViewParamsSet {
    IMAGE_SET() {
        override var parentView: View? = null
        override var typedArray: TypedArray? = null
        override fun getValues(): HashMap<*, *> {
            return hashMapOf<Int, Any?>().apply {
                this[R.styleable.ImageTextViewSet_image_src] = typedArray?.getResourceId(R.styleable.ImageTextViewSet_image_src, 0)
                this[R.styleable.ImageTextViewSet_image_crossfade] = typedArray?.getBoolean(R.styleable.ImageTextViewSet_image_crossfade, false)
            }
        }
        override fun setProperties(values: HashMap<*,*>): Any? {
            if (parentView?.isInEditMode == true)
                parentView?.aivImage?.setImageDrawable(ContextCompat.getDrawable(parentView?.context!!, values[R.styleable.ImageTextViewSet_image_src] as Int))
            else Glide.with(parentView?.context!!).load(values[R.styleable.ImageTextViewSet_image_src] as Int)
                .transition(DrawableTransitionOptions.withCrossFade(if (values[R.styleable.ImageTextViewSet_image_src] == false) 0 else 100))
                .into(parentView?.aivImage!!)
            return true
        }
        override fun getValue(): Any? = getValues()
        override fun setProperty(value: Any?): Any? = setProperties(value as HashMap<*,*>)
    },

    TEXT_SET(){
        override var parentView: View? = null
        override var typedArray: TypedArray? = null
        override fun getValues(): HashMap<*, *> {
            return hashMapOf<Int, Any?>().apply {
                this[R.styleable.ImageTextViewSet_text_str] = typedArray?.getString(R.styleable.ImageTextViewSet_text_str)
                this[R.styleable.ImageTextViewSet_android_textColor] = typedArray?.getColor(R.styleable.ImageTextViewSet_android_textColor, 0)
            }
        }
        override fun setProperties(values: HashMap<*, *>): Any? {
            return parentView?.aivText.apply {
                this?.text = values[R.styleable.ImageTextViewSet_text_str].toString()
                this?.setTextColor(values[R.styleable.ImageTextViewSet_android_textColor] as Int)
            }
        }
        override fun getValue(): Any? = getValues()
        override fun setProperty(value: Any?): Any? = setProperties(value as HashMap<*,*>)
    },

    CARD_SET(){
        override var parentView: View? = null
        override var typedArray: TypedArray? = null
        override fun getValues(): HashMap<*, *> {
            return hashMapOf<Int, Any?>().apply {
                this[R.styleable.ImageTextViewSet_bg_color] = typedArray?.getInt(R.styleable.ImageTextViewSet_bg_color, 0)
            }
        }
        override fun setProperties(values: HashMap<*, *>): Any? {
            return parentView?.cardParent.apply {
                values[R.styleable.ImageTextViewSet_bg_color]?.let { this?.setCardBackgroundColor(
                    ContextCompat.getColor(parentView?.context!!, when(it as Int) {
                    0-> R.color.white
                    1-> R.color.dark_transparent
                    2->R.color.black
                    else->R.color.white
                }))}
            }
        }
        override fun getValue(): Any? = getValues()
        override fun setProperty(value: Any?): Any? = setProperties(value as HashMap<*,*>)
    }
}