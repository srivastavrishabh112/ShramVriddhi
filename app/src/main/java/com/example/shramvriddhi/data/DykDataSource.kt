package com.example.shramvriddhi.data

import com.example.shramvriddhi.R
import com.example.shramvriddhi.model.DYK

class DykDataSource {
    fun loadDyk(): List<DYK>{
        return listOf<DYK>(
            DYK(R.string.dyk1,R.drawable.dyk),
            DYK(R.string.dyk1,R.drawable.dyk),
            DYK(R.string.dyk2,R.drawable.edli),
            DYK(R.string.dyk1,R.drawable.dyk),

        )

    }

}