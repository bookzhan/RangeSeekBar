package com.jaygoo.demo.fragments

import android.view.View
import com.jaygoo.demo.R
import com.jaygoo.widget.*
import java.util.ArrayList

/**
//                       _ooOoo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                       O\ = /O
//                   ____/`---'\____
//                 .   ' \\| |// `.
//                  / \\||| : |||// \
//                / _||||| -:- |||||- \
//                  | | \\\ - /// | |
//                | \_| ''\---/'' | |
//                 \ .-\__ `-` ___/-. /
//              ______`. .' /--.--\ `. . __
//           ."" '< `.___\_<|>_/___.' >'"".
//          | | : `- \`.;`\ _ /`;.`/ - ` : | |
//            \ \ `-. \_ __\ /__ _/ .-` / /
//    ======`-.____`-.___\_____/___.-`____.-'======
//                       `=---='
//
//    .............................................
//             佛祖保佑             永无BUG
 * =====================================================
 * 作    者：JayGoo
 * 创建日期：2019-06-13
 * 描    述:
 * =====================================================
 */
class VerticalSeekBarFragment: BaseFragment() {
	lateinit var sb_vertical_1: RangeSeekBar
	lateinit var sb_vertical_2: RangeSeekBar
	lateinit var sb_vertical_3: RangeSeekBar
	lateinit var sb_vertical_4: RangeSeekBar
	lateinit var sb_vertical_5: RangeSeekBar
	lateinit var sb_vertical_6: RangeSeekBar
	lateinit var sb_vertical_7: RangeSeekBar
	lateinit var sb_vertical_8: RangeSeekBar
	lateinit var sb_vertical_9: RangeSeekBar
	override fun getLayoutId(): Int {
		return R.layout.fragment_vertical
	}

	override fun initView(view: View) {
		sb_vertical_1 = view.findViewById(R.id.sb_vertical_1)
		sb_vertical_2 = view.findViewById(R.id.sb_vertical_2)
		sb_vertical_3 = view.findViewById(R.id.sb_vertical_3)
		sb_vertical_4 = view.findViewById(R.id.sb_vertical_4)
		sb_vertical_5 = view.findViewById(R.id.sb_vertical_5)
		sb_vertical_6 = view.findViewById(R.id.sb_vertical_6)
		sb_vertical_7 = view.findViewById(R.id.sb_vertical_7)
		sb_vertical_8 = view.findViewById(R.id.sb_vertical_8)
		sb_vertical_9 = view.findViewById(R.id.sb_vertical_9)

		sb_vertical_2?.setIndicatorTextDecimalFormat("0.0")
		sb_vertical_2?.setProgress(0f, 100f)
		changeSeekBarThumb(sb_vertical_2.leftSeekBar, sb_vertical_2.leftSeekBar.progress)
		changeSeekBarThumb(sb_vertical_2.rightSeekBar, sb_vertical_2.rightSeekBar.progress)
		sb_vertical_2?.setOnRangeChangedListener(object : OnRangeChangedListener {
			override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
				changeSeekBarThumb(rangeSeekBar.leftSeekBar, leftValue)
				changeSeekBarThumb(rangeSeekBar.rightSeekBar, rightValue)
			}

			override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

			override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

		})

		sb_vertical_3?.setIndicatorTextDecimalFormat("0")
		sb_vertical_4?.setIndicatorTextDecimalFormat("0")
		sb_vertical_4?.setIndicatorTextStringFormat("%s%%")
		sb_vertical_4?.setProgress(30f, 60.6f)

		sb_vertical_6?.setProgress(30f)

		sb_vertical_7?.setProgress(40f, 80f)

		sb_vertical_8?.setIndicatorTextDecimalFormat("0.0")

		val stepsDrawables = ArrayList<Int>()
		stepsDrawables.add(R.drawable.step_1)
		stepsDrawables.add(R.drawable.step_2)
		stepsDrawables.add(R.drawable.step_3)
		stepsDrawables.add(R.drawable.step_1)
		sb_vertical_9?.setStepsDrawable(stepsDrawables)
		changeSeekBarIndicator(sb_vertical_9.leftSeekBar, sb_vertical_9.leftSeekBar.progress)
		changeSeekBarIndicator(sb_vertical_9.rightSeekBar, sb_vertical_9.rightSeekBar.progress)
		sb_vertical_9?.setOnRangeChangedListener(object : OnRangeChangedListener {
			override fun onRangeChanged(rangeSeekBar: RangeSeekBar, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
				changeSeekBarIndicator(rangeSeekBar.leftSeekBar, leftValue)
				changeSeekBarIndicator(rangeSeekBar.rightSeekBar, rightValue)
			}

			override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

			override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {

			}

		})
	}

	private fun changeSeekBarThumb(seekbar: SeekBar, value: Float){
		if (value < 33){
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorAccent)
			seekbar.setThumbDrawableId(R.drawable.thumb_green, seekbar.thumbWidth, seekbar.thumbHeight)
		}else if (value < 66){
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorProgress)
			seekbar.setThumbDrawableId(R.drawable.thumb_yellow, seekbar.thumbWidth, seekbar.thumbHeight)
		}else{
			seekbar.indicatorBackgroundColor = Utils.getColor(activity, R.color.colorRed)
			seekbar.setThumbDrawableId(R.drawable.thumb_red, seekbar.thumbWidth, seekbar.thumbHeight)
		}
	}


	private fun changeSeekBarIndicator(seekbar: SeekBar, value: Float){
		seekbar.showIndicator(true)
		if (Utils.compareFloat(value, 0f, 3) == 0 || Utils.compareFloat(value, 100f, 3) == 0){
			seekbar.setIndicatorText("smile")
		}else if (Utils.compareFloat(value, 100/3f, 3) == 0){
			seekbar.setIndicatorText("naughty")
		}else if (Utils.compareFloat(value, 200/3f, 3) == 0){
			seekbar.setIndicatorText("lovely")
		}else{
			seekbar.showIndicator(false)
		}
	}
}