package com.abinandhan.basecompoundview

interface CompoundViewBuilderParams<T> where T:CompoundViewParams{
    val layout: Int
    val styleable: IntArray
    val params: Array<T>
}