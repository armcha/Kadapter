package io.github.armcha.recyclerviewkadapter.kadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 *
 * Created by Arman Chatikyan on 08 Dec 2017
 */

infix fun ViewGroup.inflate(layoutResId: Int): View =
        LayoutInflater.from(context).inflate(layoutResId, this, false)