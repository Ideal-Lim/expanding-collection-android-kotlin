package com.example.uitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.uitest.databinding.ActivityMainBinding
import com.ramotion.expandingcollection.ECBackgroundSwitcherView
import com.ramotion.expandingcollection.ECCardData
import com.ramotion.expandingcollection.ECPagerView
import splitties.activities.start
import splitties.toast.toast

// URL : https://github.com/Ramotion/expanding-collection-android

class MainActivity : AppCompatActivity() {

    private lateinit var ecPagerView: ECPagerView
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewBinding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activityMainBinding = binding

        //ec_pager_element / ecBgSwitcherElement view 가져오기
        ecPagerView = binding.ecPagerElement
        val ecBgSwitcherElement = binding.ecBgSwitcherElement
        // CardData 생성
        val dataset : List<ECCardData<String>> = CardDataImpl.generateExampleData()
        // ECPagerViewAdapter 생성
        val ecPagerViewAdapter =  ECPagerViewAdapter(applicationContext, dataset, binding)
        // EcPageView 에 Adapter 설정
        ecPagerView.setPagerViewAdapter(ecPagerViewAdapter)
        // EcPagerView 에 BackgroundSwitcherView 설정
        ecPagerView.setBackgroundSwitcherView(ecBgSwitcherElement)


//        dataset.toMutableList().removeAt(2)
        ecPagerViewAdapter.notifyDataSetChanged()

    }

    override fun onBackPressed() {
        if(!ecPagerView.collapse())
        super.onBackPressed()
    }

}