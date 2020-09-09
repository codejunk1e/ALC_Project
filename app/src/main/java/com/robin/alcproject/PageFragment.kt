package com.robin.alcproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

/**
 * @author robin
 * Created on 9/9/20
 */

class PageFragment() : Fragment() {
    private var index : Int = -1
    private lateinit var recyclerView : RecyclerView
    private lateinit var skillRecycler : SkillRcyclerAdapter
    private lateinit var recyclerIQ : IQRecyclerAdapter
    private lateinit var items : List<BoardItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_INDEX) }?.apply {
            index = getInt(ARG_INDEX)
        }
        recyclerView = view.findViewById(R.id.page_recyclerView)
        items = loadDummyData()
        skillRecycler = SkillRcyclerAdapter(items)
        recyclerIQ = IQRecyclerAdapter(items)

        when(index){
            1 -> {
                recyclerView.adapter = skillRecycler
            }
            2 -> recyclerView.adapter = recyclerIQ
            else-> throw IllegalArgumentException("Pager was not initialized with correct index")
        }

    }

    private fun loadDummyData(): List<BoardItem> {
        return listOf(
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy)),
                BoardItem(getString(R.string.name_dummy), getString(R.string.scores_dummy))
        )
    }
}
