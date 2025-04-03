package personaClick.demo_android.feature.cart.presentation.view.button

import android.content.Context
import android.util.AttributeSet
import com.personaClick.demo_android.ui.button.view.BaseButton
import com.personaClick.ui.R

open class ContinueShoppingButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : BaseButton(
    context = context,
    attrs = attrs,
    defStyleAttr = defStyleAttr,
    textRes = personaClick.demo_android.R.string.continue_shopping,
    backgroundColorRes = R.color.text_color_opposite_primary,
    textColorRes = R.color.text_color_primary
)
