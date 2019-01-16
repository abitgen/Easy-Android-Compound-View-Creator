package com.abinandhan.basecompoundview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

fun <T> ViewGroup.buildParams(context: Context, layout:Int, attrs: AttributeSet, styleable:IntArray, params:Array<T>) where T:CompoundViewParams{
    View.inflate(context, layout, this)
    val typedArray = context.obtainStyledAttributes(attrs, styleable)

    params.forEachIndexed { index, param ->
        run {
            param.parentView = this
            param.typedArray = typedArray
            param.setProperty(param.getValue())
        }
    }
    typedArray.recycle()
}

fun <T> ViewGroup.getParamValue(paramName: T, params: Array<T>):T{
    return params.first { it==paramName }
}