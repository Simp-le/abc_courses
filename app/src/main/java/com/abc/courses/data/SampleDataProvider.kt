package com.abc.courses.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.abc.courses.R
import com.abc.courses.model.Topic

class TopicDataProvider : PreviewParameterProvider<Topic> {
    override val values = sequenceOf(
        Topic(
            nameId = R.string.photography, availableCourses = 321, imageId = R.drawable.photography
        )
    )
}

class TopicListDataProvider : PreviewParameterProvider<List<Topic>> {
    override val values = sequenceOf(DataSource.topics)
}