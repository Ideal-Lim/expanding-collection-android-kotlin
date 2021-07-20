package com.example.uitest

import android.content.Context
import android.graphics.Color
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.TextView

import com.example.uitest.databinding.ActivityMainBinding
import com.ramotion.expandingcollection.ECCardData
import com.ramotion.expandingcollection.ECPagerView
import com.ramotion.expandingcollection.ECPagerViewAdapter

import splitties.activities.start
import splitties.toast.toast


class ECPagerViewAdapter(app: Context, data: List<ECCardData<String>>,binding: ActivityMainBinding)
    : ECPagerViewAdapter(app, data) {
    private val binding = binding
    private val applicationContext = app
    override fun instantiateCard(
        layoutInflater: LayoutInflater?,
        head: ViewGroup?,
        list: ListView?,
        data: ECCardData<*>?
    ) {
        val cardData: CardDataImpl = data as CardDataImpl
        val ecPagerView = binding.ecPagerElement
        val listItems = cardData.listItems
        val listItemAdapter = CardListItemAdapter(applicationContext, listItems)

        list?.adapter = listItemAdapter
        list?.setBackgroundColor(Color.WHITE)

        //cardTitle 을 추가합니다
        val cardTitle: TextView = TextView(applicationContext)
        cardTitle.text = cardData.getCardTitle()
        cardTitle.setTextSize(COMPLEX_UNIT_DIP, 20F)
        val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
        layoutParams.gravity = Gravity.CENTER
        head?.addView(cardTitle, layoutParams)
        head?.setOnClickListener {
            ecPagerView.toggle()
        }
    }

}