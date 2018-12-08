package com.example.silvioallgayertrindade.avaliacaodev.presentation.ui.components

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.silvioallgayertrindade.avaliacaodev.R

class ProgressIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    LinearLayout(context, attrs, defStyleAttr) {

    init {
        init(attrs, defStyleAttr)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate()

        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.ProgressIndicator, defStyle, 0
        )
        val text = typedArray.getString(R.styleable.ProgressIndicator_text)

        val message = findViewById<TextView>(R.id.message)
        if (!TextUtils.isEmpty(text)) {
            message.text = text
        }

        typedArray.recycle()
    }

    private fun inflate() {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        inflater.inflate(R.layout.progress_indicator, this, true)
    }
}