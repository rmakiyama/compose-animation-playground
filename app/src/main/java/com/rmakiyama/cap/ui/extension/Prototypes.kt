package com.rmakiyama.cap.ui.extension

import androidx.annotation.StringRes
import com.rmakiyama.cap.R
import com.rmakiyama.cap.model.BasicAnimatedContent
import com.rmakiyama.cap.model.BasicAnimatedVisibility
import com.rmakiyama.cap.model.Prototype

val Prototype.title: Int
    @StringRes
    get() = when (this) {
        BasicAnimatedVisibility -> R.string.prototype_title_bav
        BasicAnimatedContent -> R.string.prototype_title_bac
    }
