package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        var newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
        )

        var newsHeadingArray = arrayOf(
            "No ID proof, requisition slip needed for exchange of Rs 2,000 notes: SBI",
            "I should take your autograph': US President Joe Biden, Australian PM Albanese heap praises on PM Modi",
            "Between bans and tax breaks, cinema is the loser",
            "Why DK Shivakumar 'is not happy' despite Congress's thumping victory in Karnataka",
            "MI vs SRH Live Score, IPL 2023: Akash Madhwal ends Mayank Agarwal's stay",
            "World’s first flight for Haj 2023 departs from Lucknow with 288 pilgrims: UP govt",
            "In a first for Hyderabad, 6,000-year-old neolithic tools fou found in Raidurg"
        )

        var newsContent = arrayOf(
            R.string.news_content.toString(),
            R.string.news_content.toString(),
            R.string.news_content.toString(),
            R.string.news_content.toString(),
            R.string.news_content.toString(),
            R.string.news_content.toString(),
            R.string.news_content.toString()
        )

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for( index in newsImageArray.indices) {
            val news = News(newsHeadingArray[index], newsImageArray[index], newsContent[index])
            newsArrayList.add(news)
        }

        var myAdapter = MyAdapter(newsArrayList, this)
        myRecyclerView.adapter = MyAdapter(newsArrayList, this)
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemclickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, NewsDetailActivity::class.java  )
                intent.putExtra("heading", newsArrayList[position].newsHeading)
                intent.putExtra("imageId", newsArrayList[position].newsImage)
                intent.putExtra("newscontent", newsArrayList[position].newsContent)
                startActivity(intent)
            }
        })
    }
}