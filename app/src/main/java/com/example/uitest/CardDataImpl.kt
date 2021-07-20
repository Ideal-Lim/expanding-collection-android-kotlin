package com.example.uitest

import com.ramotion.expandingcollection.ECCardData
import java.util.*
import kotlin.collections.ArrayList

class CardDataImpl(cardTitle: String,
                   mainBackgroundResource: Int,
                   headBackgroundResource: Int,
                   listItems: ArrayList<String>)
    : ECCardData<String> {

    private val cardTitle: String = cardTitle
    private val mainBackgroundResource: Int = mainBackgroundResource
    private val headBackgroundResource: Int = headBackgroundResource
    private val listItems: ArrayList<String> = listItems


    override fun getMainBackgroundResource(): Int {
        return mainBackgroundResource
    }

    override fun getHeadBackgroundResource(): Int {
        return headBackgroundResource
    }

    override fun getListItems(): MutableList<String> {
        return listItems
    }

    fun getCardTitle(): String {
        return cardTitle
    }

    companion object {
        fun  generateExampleData(): ArrayList<ECCardData<String>> {
            val list = arrayListOf<ECCardData<String>>()
            list.add(CardDataImpl("Card1", R.drawable.young_woman, R.drawable.young_woman,createItemsList("Card 1")),)
            list.add(CardDataImpl("Card2", R.drawable.wave, R.drawable.wave,createItemsList("Card 2")))
            list.add(CardDataImpl("Card3", R.drawable.beach, R.drawable.beach,createItemsList("Card 3")))
            return list
        }

        private fun createItemsList(cardName: String): ArrayList<String> {
            val list = arrayListOf<String>()
            list.addAll(arrayListOf(
                "$cardName - Item 1",
                "$cardName - Item 2",
                "$cardName - Item 3",
                "$cardName - Item 4",
                "$cardName - Item 5",
                "$cardName - Item 6",
                "$cardName - Item 7",
            ))
            return list
        }


    }
}
