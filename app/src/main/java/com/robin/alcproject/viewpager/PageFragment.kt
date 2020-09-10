package com.robin.alcproject.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.robin.alcproject.MainActivityViewModel
import com.robin.alcproject.R
import com.robin.alcproject.adapters.IQRecyclerAdapter
import com.robin.alcproject.adapters.SkillRcyclerAdapter
import com.robin.alcproject.models.IQItem
import com.robin.alcproject.models.SkillItem

/**
 * @author robin
 * Created on 9/9/20
 */

class PageFragment : Fragment() {
    private var index : Int = -1
    private lateinit var recyclerView : RecyclerView
    private lateinit var skillRecycler : SkillRcyclerAdapter
    private lateinit var recyclerIQ : IQRecyclerAdapter
    private var skillItems : List<SkillItem> = listOf()
    private var iqItems : List<IQItem> = listOf()

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
        val model: MainActivityViewModel by activityViewModels()


        when(index){
            1 -> {
                skillRecycler = SkillRcyclerAdapter(skillItems, requireContext())
                recyclerView.adapter = skillRecycler
                model.observableLearningHours.observe(viewLifecycleOwner, {
                    if (it.getResult() != null) {
                        skillItems = it.getResult()!!
                        skillRecycler.updateAdapter(skillItems)
                    } else {
                        it.getError()?.printStackTrace()
                    }
                })
            }
            2 -> {
                recyclerIQ = IQRecyclerAdapter(iqItems, requireContext() )
                recyclerView.adapter = recyclerIQ
                model.observableSkillIQ.observe(viewLifecycleOwner, {
                    if (it.getResult() != null ){
                        iqItems = it.getResult()!!
                        recyclerIQ.updateAdapter(iqItems)
                    }else{
                        it.getError()?.printStackTrace()
                    }
                    recyclerIQ.notifyDataSetChanged()
                })
            }
            else-> throw IllegalArgumentException("Pager was not initialized with correct index")
        }
    }
}
