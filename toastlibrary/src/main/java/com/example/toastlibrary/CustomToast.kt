package com.example.toastlibrary

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast

class CustomToast(context: Context?) : Toast(context) {

    companion object{

        public val TYPE_NORMAL = 0
        public val TYPE_RIGHT = 1
        public val TYPE_WARNING = 2
        public val TYPE_WRONG = 3

        public val SHORT_DURATION = Toast.LENGTH_SHORT
        public val LONG_DURATION = Toast.LENGTH_LONG

        public fun makeText(context: Context, message: String): CustomToast{
            return makeText(context,message, TYPE_NORMAL, SHORT_DURATION)
        }

        public fun makeText(context: Context, message: String, duration: Int): CustomToast{
            return makeText(context,message, TYPE_NORMAL, duration)
        }

        public fun makeText(context: Context, message: String, toastType: Int, duration: Int): CustomToast{

            val mCustomToast: CustomToast = CustomToast(context)
            val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = layoutInflater.inflate(R.layout.custom_toast_layout, null)
            val imageView: ImageView = view.findViewById(R.id.imageView)
            val textView: TextView = view.findViewById(R.id.textMessage)
            val mainLayout: RelativeLayout = view.findViewById(R.id.customToastLayout)

            when(toastType){

                TYPE_RIGHT -> {
                    mainLayout.background = context.getDrawable(R.drawable.shape_right)
                    imageView.setImageResource(R.drawable.ic_right)
                }
                TYPE_WARNING -> {
                    mainLayout.background = context.getDrawable(R.drawable.shape_warning)
                    imageView.setImageResource(R.drawable.ic_warning)
                }
                TYPE_WRONG -> {
                    mainLayout.background = context.getDrawable(R.drawable.shape_wrong)
                    imageView.setImageResource(R.drawable.ic_wrong)
                }

                else -> {}
            }

            textView.setText(message)

            mCustomToast.view = view
            mCustomToast.duration = duration

            return mCustomToast
        }
    }
}