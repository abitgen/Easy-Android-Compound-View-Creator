package com.abinandhan.basecompoundview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

abstract class ConstraintLayoutCompoundViewBuilder<T>(context: Context, open val attrs:AttributeSet) :
    ConstraintLayout(context, attrs),
    CompoundViewBuilderParams<T> where T : CompoundViewParams{

    protected fun build() = buildParams(context, layout, attrs, styleable, params)
    fun get(paramName:T):T = getParamValue(paramName, params)
}